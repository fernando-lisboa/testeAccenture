package br.com.alelo.integrations.teams;

import static io.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

import br.com.alelo.utils.PropertiesFile;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SendTestResultTeams {

	static File file;
	static String fileName = "results.dat";
	private static PropertiesFile props;
	private static double passed;
	private static double failed;
	private static double skipped;
	private static double pending;

	public static String listFailedTests() {

		return "";
	}

	public static String executionResult(String time, String projeto) throws Exception {
		file = new File(fileName);
		String icon, farolProjeto;
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setMinimumIntegerDigits(1);

		passed = countWord("passed", file);
		failed = countWord("failed", file);
		skipped = countWord("skipped", file);
		pending = countWord("pending", file);
		double undefined = countWord("undefined", file);
		double total = passed + failed + skipped + undefined;
		double percent_passed = passed / total;
		double percent_failed = failed / total;
		double percent_skipped = skipped + pending / total;
		double percent_undefined = undefined / total;

		// creatteChart();
		return "{\"@type\":\"MessageCard\",\"@context\":\"http://schema.org/extensions\",\"themeColor\":\"0076D7\","
				+ "\"summary\":\"Status Report - Execuçao dos testes Automatizados\""
				+ ",\"sections\":[{\"activityTitle\":\"Status Report - Execuçao dos testes Automatizados\",\"activitySubtitle\":"
				+ "\"Projeto: " + projeto + "\",\"facts\":" + "[{\"name\":\"Total de Cenarios:\",\"value\":\""
				+ (int) total + "\"}," + "{\"name\":\"Executados com Sucesso:\",\"value\":\"" + (int) passed + "("
				+ percent.format(percent_passed) + ")" + "\"}," + "{\"name\":\"Executados com Falha:\",\"value\":\""
				+ (int) failed + "(" + percent.format(percent_failed) + ")" + "\"},"
				+ "{\"name\":\"Pendentes:\",\"value\":\"" + (int) skipped + "(" + percent.format(percent_skipped) + ")"
				+ "\"}," + "{\"name\":\"Não Executados:\",\"value\":\"" + (int) undefined + "("
				+ percent.format(percent_undefined) + ")" + "\"}],\"arkdown\":true}]}";

	}

	public static void sendMessage(String str_message) {
		String request = "https://outlook.office.com/webhook/c19c3811-45dd-4efb-be9c-1302572f3084@1778ae9f-6f4a-44ca-930b-327c29104576/IncomingWebhook/bce453a0ef0b4f6181efe190bccdab97/94067c10-b877-4b14-8e77-530dbfc6e712";

		Response response = given().contentType(ContentType.JSON).body(str_message).when().post(request).then()
				.extract().response();

		response.prettyPrint();
	}

	public static int countWord(String word, File fis) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(fis));
		String readLine = "";
		int count = 0;
		while ((readLine = in.readLine()) != null) {
			String[] words = readLine.split(" ");
			for (String s : words) {
				if (s.contains(word))
					count++;
			}
		}
		return count;
	}
}
