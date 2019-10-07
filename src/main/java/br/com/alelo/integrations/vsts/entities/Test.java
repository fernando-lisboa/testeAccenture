package br.com.alelo.integrations.vsts.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.alelo.utils.SimpleCacheManager;

public class Test {
	
	private String testId;
	private String suiteId;
	private String testPoint;
	private String testName;
	private String outcome;
	private String testRunId;
	private String error;
	private String errorMessage;
	private SimpleCacheManager cache = SimpleCacheManager.getInstance();
	
	
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName.trim();
	}
	public String getOutcome() {
		return outcome;
	}
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	
	public String createJson(){
		Date dataHoraInicio = new Date();	
		String json = "[{"
				+ "\"testCaseId\": "+"\""+testId+"\", "
				+ "\"TestPointId\": "+"\""+testPoint+"\", "
				+ "\"testCaseRevision\":"+"1, "
				+ "\"testCaseTitle\": "+"\""+testName+"\", "
				+ "\"revision\": 1, "
				+ "\"planid\": " + cache.get("planid") + ", "
				+ "\"startedDate\": \""+new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(dataHoraInicio)+"\", "
				+ "\"testCase\": { "
				+ "\"id\": "+"\""+testId+"\", "
				+ "\"name\": "+"\""+testName+"\"  }, "
				+ "\"testPlan\": { "
				+ "\"id\": " + cache.get("planid")
				+ " }, "
		        + "\"testRun\": { "
		        + "\"id\": "+cache.get("runid")+", "
		        + "\"name\": "+cache.get("runname")+", "
		        + "\"url\": "+cache.get("runurl")+" "
		        + "}, "  
		        + "\"testSuite\": { "
		        + "\"id\": "+suiteId+" }, "
		         + "\"testPoint\": {"
		 		        + "\"id\": "+testPoint+" } "	
				+ "}]";
		System.out.println(json);
		return json;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getTestPoint() {
		return testPoint;
	}
	public void setTestPoint(String testPoint) {
		this.testPoint = testPoint;
	}
	public String getSuiteId() {
		return suiteId;
	}
	public void setSuiteId(String suiteId) {
		this.suiteId = suiteId;
	}
	public String getTestRunId() {
		return testRunId;
	}
	public void setTestRunId(String testRunId) {
		this.testRunId = testRunId;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	

}
