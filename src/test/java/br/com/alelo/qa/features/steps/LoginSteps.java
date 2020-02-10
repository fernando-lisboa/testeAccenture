
/**
  * Autor: Fernando Lisboa
 * Empresa: Taking
 * Data: 12/12/2019
 * Caminho: Portal Estabelecimento Comercial  --> Login
 */

package br.com.alelo.qa.features.steps;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.HomeActions;
import br.com.alelo.qa.web.actions.LoginActions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.PendingException;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;

public class LoginSteps extends ParentSteps {

	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	LoginActions login;
	HomeActions home;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();

	@Dado("^que estou na logado no portal EC \"([^\"]*)\", \"([^\"]*)\"$")
	public void que_estou_na_logado_no_portal_EC(String user, String senha) throws Throwable {
		webdriver.get(baseurl); // Abre url
		login = new LoginActions(webdriver);
		login.loginGeral(user, senha);
		System.out.println("logando..");
	}

	@Dado("^que esteja na tela inicial do portal$")
	public void que_esteja_na_tela_inicial_do_portal() throws Throwable {
		Thread.sleep(2000);
		webdriver.get(baseurl);
	}

	@Quando("^preencher o formulario de login \"([^\"]*)\", \"([^\"]*)\"$")
	public void preencher_o_formulario_de_login(String user, String senha) throws Throwable {
		login = new LoginActions(webdriver);
		login.preencherLogin(user, senha);
		System.out.println("Aguardando carregar tela inicial...");
	}

	@Entao("^devo visualizar a tela do painel$")
	public void devo_visualizar_a_tela_do_painel() throws Throwable {
		login.paginaInicial();
		System.out.println("LOGADO...");
	}

	@Entao("^devo receber msg de erro no acesso$")
	public void devo_receber_msg_de_erro_no_acesso() throws Throwable {
		login.erroLogin();
	}
	
	@Dado("^que estou na logado no portal webadmim EC \"([^\"]*)\", \"([^\"]*)\"$")
	public void que_estou_na_logado_no_portal_webadmim_EC(String user, String password) throws Throwable {
		webdriver.get(baseurlAdm); // Abre url
		login = new LoginActions(webdriver);
		login.loginGeralWebAdmin(user, password);
		
		
	}

}
