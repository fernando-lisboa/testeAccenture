package br.com.alelo.qa.features.steps;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.ControllerAdviceBean;

import com.google.common.base.CharMatcher;

import br.com.alelo.integrations.vsts.controllers.RunController;
import br.com.alelo.integrations.vsts.entities.Test;
import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.utils.DriverAnonimo;
import br.com.alelo.utils.PropertiesFile;
import br.com.alelo.utils.ResultsFileStorage;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CommonSteps extends ParentSteps {
	protected Test test = new Test();
	private static final Logger logger = LoggerFactory.getLogger(CommonSteps.class);
	Scenario scenario = null;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();
	String atualizaVsts;

	@Before
	public void beforeScenario(Scenario scenario) throws IOException {
		System.out.println("Portal EC WEB..");

		props = new PropertiesFile();
		String tags = scenario.getSourceTagNames().toString();
		atualizaVsts = props.getValor("atualizaVsts");
		// String[] scenarioId = scenario.getName().split("-");
		// cache.put("scenario", scenarioId[0].trim());
		String[] arrScenario = scenario.getName().split("-");

		CharMatcher ASCII_DIGITS = CharMatcher.inRange('0', '9').precomputed();

		try {
			RunController run = new RunController();
			if (atualizaVsts.equals("sim")) {
				test = run.startRunTestCase(test);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		webdriver.manage().window().maximize();

	}

	@After
	public void afterScenario(Scenario scenario) throws IOException {
		test.setOutcome(scenario.getStatus());
		// Limpa cookies do browser para testes em massa
		System.out.println("Limpando cookies");
		webdriver.manage().deleteAllCookies();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) webdriver;
		jsExecutor.executeScript("localStorage.clear();");
		jsExecutor.executeScript("window.sessionStorage.clear();");

		// Limpa cookies do browser anonimo para testes em massa

			test.setOutcome(scenario.getStatus());
			DriverAnonimo.getDriver().manage().deleteAllCookies();
			JavascriptExecutor jsExecutorAnonimous = (JavascriptExecutor) DriverAnonimo.getDriver();
			jsExecutorAnonimous.executeScript("localStorage.clear();");
			jsExecutorAnonimous.executeScript("window.sessionStorage.clear();");

		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Cenario: " + scenario.getName());
		System.out.println("Suite ID:" + test.getSuiteId());
		System.out.println("Status: " + scenario.getStatus());
		System.out.println("-------------------------------------------------------------------------------");

		RunController run = new RunController();
		// Slack
		ResultsFileStorage.saveResult("\n" + scenario.getName() + ";" + scenario.getStatus() + ";");
		if (atualizaVsts.equals("sim")) {
			// ResultsSupport.contador(scenario.getStatus());
			run.completeRunTestCase(test);
		}

	}

}
