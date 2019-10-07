package br.com.alelo.qa.features.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.alelo.qa.data.dao.LoginDao;
import br.com.alelo.qa.data.entity.Login;
import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.HomeActions;
import br.com.alelo.qa.web.actions.LoginActions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class LoginSteps extends ParentSteps {

	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	LoginActions loginActions;
	HomeActions homeActions;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();


	@Quando("^preencho o formulario de login$")
	public void preencho_o_formulario_de_login() throws Throwable {
		String scenario = cache.get("scenario").toString(); 
		System.out.println(scenario);
		LoginDao loginData = new LoginDao();
		Login login = loginData.massaLoginAtivo(scenario);
		loginActions.preencherForm(login.getCpf(), login.getSenha(), login.getDatanascimento());
	}

	@Quando("^clico no botao Ok$")
	public void clico_no_botão_Ok() throws Throwable {
		loginActions.clickLogin();
	}

	@Entao("^visualizo mensagem de erro: \"([^\"]*)\"$")
	public void visualizo_mensagem_de_erro(String msg) throws Throwable {
		loginActions.validaMensagemDeErro(msg);
	}

	@Entao("^acesso a pagina inicial$")
	public void acesso_a_pagina_inicial() throws Throwable {
		homeActions = new HomeActions(webdriver);
		logger.info("Homepage da Aplicação");
	}
	
	@Dado("^que estou na tela de Login$")
	public void que_estou_na_tela_de_Login() throws Throwable {
		webdriver.get(baseurl);
		loginActions = new LoginActions(webdriver);
		loginActions.aguardarFormularioDeLoginCarregar();
		logger.info("Pagina de login do Portal PME");
	}

}
