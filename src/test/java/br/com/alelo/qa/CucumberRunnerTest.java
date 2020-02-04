package br.com.alelo.qa;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import br.com.alelo.integrations.vsts.controllers.RunController;
import br.com.alelo.utils.PropertiesFile;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = false, features = { "src/test/resources/features" }, plugin = {
		"json:target/cluecumber-report/cucumber.json" }, glue = {
				"classpath:br.com.alelo.qa.features.steps" }, tags = { "@VouReceber" })
public class CucumberRunnerTest {

	private static RunController newRun = null;
	private static SimpleCacheManager cache = SimpleCacheManager.getInstance();
	private static Date dataHoraInicio = new Date();

	@BeforeClass
	public static void setup() throws IOException {
		PropertiesFile props = new PropertiesFile();
		System.out.println("------------------------------");
		System.out.println("CARREGANDO DADOS DA EXECUÇÃO");
		props.configFile();
		System.out.println("------------------------------");
		String atualizaVsts = props.getValor("atualizaVsts");
		
		if (atualizaVsts.equals("sim")) {
			PropertiesFile.createTempFile();
			newRun = new RunController("[AUT] " + cache.get("titulo") + " - "
					+ new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataHoraInicio));

			try {
				newRun.startRunTests();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println(
				"Data e hora de inicio: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataHoraInicio));
	}

	@AfterClass
	public static void teardown() throws IOException {
		Date dataHoraFim = new Date();
		PropertiesFile props = new PropertiesFile();

		try {
			String atualizaVsts = props.getValor("atualizaVsts");
			if (atualizaVsts.equals("sim")) {
				newRun.completedRunTests();
			}
			System.out.println(
					"Ciclo de testes encerrado as: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataHoraFim));
			String diff = new SimpleDateFormat("HH:mm:ss")
					.format(new Date(dataHoraFim.getTime() - dataHoraInicio.getTime()));
//			String message = CreateMessage.statusExecutionMessage(diff, props.getValor("passed"),
//					props.getValor("failed"), props.getValor("skipped"), props.getValor("undefined"));
//			SlackIntegration.sendMessage(message);
		} catch (MalformedURLException e) {
			e.printStackTrace();

		}
	}

}
