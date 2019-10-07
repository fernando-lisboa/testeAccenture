package br.com.alelo.integrations.vsts.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.common.base.CharMatcher;
import com.google.gson.JsonObject;

import br.com.alelo.integrations.vsts.entities.Run;
import br.com.alelo.integrations.vsts.entities.Test;
import br.com.alelo.integrations.vsts.entities.Vsts;
import br.com.alelo.utils.PropertiesFile;
import br.com.alelo.utils.SimpleCacheManager;

public class RunController {
	private Vsts vsts = new Vsts();
	private Run run = new Run();
	private String path;
	private VstsController connVsts = new VstsController();
	private PropertiesFile props;
	private SimpleCacheManager cache = SimpleCacheManager.getInstance();
	JsonObject testInfoJson = null;
	private String runId;

	public RunController() throws IOException {
		props = new PropertiesFile();
		vsts.setProjeto(props.getValor("projeto"));
		path = "https://alelo.visualstudio.com/" + props.getValor("projeto") + "/_apis/test/runs";
		run.setPlanId(props.getValor("planid"));

	}

	public RunController(String name) throws IOException {
		props = new PropertiesFile();
		vsts.setProjeto(props.getValor("projeto"));
		path = "https://alelo.visualstudio.com/" + props.getValor("projeto") + "/_apis/test/runs";
		run.setName(name);
		run.setPlanId(props.getValor("planid"));
	}

	public void startRunTests() throws IOException {

		System.out.println(run.createJson());
		JsonObject runData = connVsts.sendRequest("POST", path, run.createJson().getBytes());
		// Dados para subir os cenarios rodados no Run correto
		cache.put("runid", runData.get("id"));
		cache.put("runname", runData.get("name"));
		cache.put("runurl", runData.get("url"));
		runId = runData.get("id").toString();

	}

	public void completedRunTests() throws MalformedURLException {
		run.setRunId(runId);
		connVsts.sendRequest("PATCH", path + "/" + run.getRunId(), run.updateRun().getBytes());
	}

	public Test startRunTestCase(Test test) {
		JsonObject testStarted = null;

		String json = this.obtainTestInformation(test.getTestId(), test.getSuiteId()).replaceAll("\\s", "");
		int value = json.indexOf("pointAssignments");
		String idPoint = json.substring(value + 25, value + 30);

		String pathSendTestRun = path + "/" + cache.get("runid") + "/results";
		test.setTestPoint(idPoint);

		try {
			testStarted = connVsts.sendRequest("POST", pathSendTestRun, test.createJson().getBytes());
			String returnData = testStarted.toString();
			String[] arrData = returnData.split(",");
			CharMatcher ASCII_DIGITS = CharMatcher.inRange('0', '9').precomputed();
			String idTestRun = ASCII_DIGITS.retainFrom(arrData[1]);
			test.setTestRunId(idTestRun);
			return test;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return test;
	}

	public void completeRunTestCase(Test test) {
		// PATCH
		// https://vsclt.dev.azure.com/fabrikam/_apis/clt/testruns/{testRunId}?api-version=5.1
		String updateTestCase = path + "/" + cache.get("runid") + "/results";
		Date dataHoraInicio = new Date();

		String json = "[{" + "\"id\":" + test.getTestRunId() + ", \"state\": \"Completed\", " + "\"completedDate\": \""
				+ new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(dataHoraInicio) + "\", " + "\"outcome\": \""
				+ test.getOutcome() + "\" }]";
		try {
			connVsts.sendRequest("PATCH", updateTestCase, json.getBytes());
			/**
			 * Gerando o Zip do Report
			 */
			
			ZipController zipFile = new ZipController();
			zipFile.compressDirectory( Paths.get("target", "cluecumber-report").toUri().getPath(), "TestsResult.zip");
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public String obtainTestInformation(String testId, String suiteId) {

		String pathTestData = "https://alelo.visualstudio.com/" + props.getValor("projeto") + "/_apis/testplan/Plans/"
				+ cache.get("planid") + "/Suites/" + suiteId + "/TestCase/" + testId + "?api-version=5.1-preview.2";
		return connVsts.sendGetRequest(pathTestData);

	}

}
