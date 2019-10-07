package br.com.alelo.qa.features.steps;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.CharMatcher;

import br.com.alelo.integrations.vsts.controllers.RunController;
import br.com.alelo.integrations.vsts.entities.Test;
import br.com.alelo.qa.data.dao.LoginDao;
import br.com.alelo.qa.data.entity.Login;
import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.features.support.ResultsSupport;
import br.com.alelo.qa.web.actions.HomeActions;
import br.com.alelo.qa.web.actions.LoginActions;
import br.com.alelo.qa.web.actions.MenuActions;
import br.com.alelo.utils.PropertiesFile;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;

public class CommonSteps extends ParentSteps {
	
	
	private static final Logger logger = LoggerFactory.getLogger(CommonSteps.class);
	Scenario scenario = null;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();
	protected Test test = new Test();
	String atualizaVsts;
	LoginActions loginActions;
	HomeActions homeActions;
		
	@Dado("^que estou logado no Portal PME$")
	public void que_estou_logado_no_Portal_PME() throws Throwable {
		webdriver.get(baseurl);
		loginActions = new LoginActions(webdriver);
		String scenario = cache.get("scenario").toString(); 
		System.out.println(scenario);
		LoginDao loginData = new LoginDao();
		Login login = loginData.massaLoginAtivo(scenario);
		loginActions.preencherForm(login.getCpf(), login.getSenha(), login.getDatanascimento());
		loginActions.clickLogin();
	}
	
	@Dado("^acesso a tela de Novo Pedido$")
	public void acesso_a_tela_de_Novo_Pedido() throws Throwable {
	    homeActions = new HomeActions(webdriver);
	    MenuActions menuActions = new MenuActions(webdriver);
	    menuActions.acessarNovoPedido();
	}
	
	@Before
	public void beforeScenario(Scenario scenario) throws IOException {
		props = new PropertiesFile();
		String tags = scenario.getSourceTagNames().toString();
		atualizaVsts = props.getValor("atualizaVsts");
		String[] scenarioId = scenario.getName().split("-");  
		cache.put("scenario", scenarioId[0].trim());
		String[] arrScenario = scenario.getName().split("-");

		CharMatcher ASCII_DIGITS = CharMatcher.inRange('0', '9').precomputed();
		String suiteId = ASCII_DIGITS.retainFrom(tags);

		RunController run = new RunController();

		test.setTestId(arrScenario[0].trim());
		test.setTestName(arrScenario[1].trim());
		test.setSuiteId(suiteId);

		
		if (atualizaVsts.equals("sim")) {
			test = run.startRunTestCase(test);
		}
		
		webdriver.manage().window().maximize();

	}

	@After
	public void afterScenario(Scenario scenario) throws IOException {
		test.setOutcome(scenario.getStatus());
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Cenario: " + scenario.getName());
		System.out.println("Suite ID:" + test.getSuiteId());
		System.out.println("Status: " + scenario.getStatus());
		System.out.println("-------------------------------------------------------------------------------");
		
		RunController run = new RunController();
		
		if (atualizaVsts.equals("sim")) {
//			ResultsSupport.contador(scenario.getStatus());
			run.completeRunTestCase(test);
		}

	}


}
