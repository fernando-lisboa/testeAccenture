package br.com.alelo.integrations.slack;

import java.text.NumberFormat;

public class CreateMessage {


	public static String statusExecutionMessage(String time, String strPassed, String strFailed, String strNotRun, String strDevelop) {
		String farolProjeto;
		String icon;
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setMinimumIntegerDigits(1);
		
		int passed = Integer.parseInt(strPassed);
		int failed = Integer.parseInt(strFailed);
		int notRun = Integer.parseInt(strNotRun);
		int develop = Integer.parseInt(strDevelop);

		double total = passed + failed + notRun;
		double percent_passed = passed / total;
		double percent_failed = failed / total;
		double percent_notRun = notRun / total;

		System.out.println(total + " " + percent_passed + " " + percent_failed + " " + percent_notRun);

		if (failed > 0)
			icon = "https://cdn4.iconfinder.com/data/icons/security-overcolor/512/bug-512.png";
		else
			icon = "https://help.quavermusic.com/wp-content/uploads/sites/2/2017/04/pass-icon.png";

		if (percent_passed > 0.95)
			farolProjeto = "#22ff22";
		else if (percent_passed > 0.75)
			farolProjeto = "#ffff22";
		else
			farolProjeto = "#ff2222";

		System.out.println("TEMPO " + System.currentTimeMillis() / 1000);

		return " {\"text\": \"**Regressão Automática**\",\"attachments\": "
				+ "[{\"fallback\": \"Status report de execução de testes\"," + "\"color\": \"" + farolProjeto + "\","
				+ "\"author_name\": \"[Equipe de Testes]\"," + "\"author_icon\": \"" + icon + "\","
				+ "\"title\": \"Resumo de Execução\","
				+ "\"title_link\": \"https://alelo.visualstudio.com/PME/Aprov_QA/_dashboards/Aprov_QA/5399b89b-bc54-4878-b286-eb5faae17a1c\","
				+ "\"fields\": [" + "{\"title\": \"Executados com Sucesso\",\"value\": \""
				+ percent.format(percent_passed) + "\"}," + "{\"title\": \"Executados com Falha\",\"value\": \""
				+ percent.format(percent_failed) + "\"}," + "{\"title\": \"Não executados\"," + "\"value\": \""
				+ percent.format(percent_notRun) + "\"}]" + "}," + "{\"fallback\": \"Status de Construção\","
				+ "\"color\": \"#889988\"," + "\"fields\":[" + "{\"title\": \"Construídos\",\"value\": \"" + (int) total
				+ "\"}," + "{\"title\": \"Em construção \",\"value\": \"" + develop + "\"}]" + ",\"ts\": \""
				+ System.currentTimeMillis() / 1000 + "\"}]}";
	}

}
