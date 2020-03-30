package br.com.alelo.qa.features.steps;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.LoginArvNaCentralActions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;

public class LoginArvNaCentralSteps extends ParentSteps {

	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();
	LoginArvNaCentralActions actions;



	@Dado("^que eu acesse o portal Arv na central_$")
	public void que_eu_acesse_o_portal_Arv_na_central_() throws Throwable {
		webdriver.get("https://meuestabelecimento-frontend-arv-central-hml.siteteste.inf.br/");
	}

	@Dado("^preencha o formulario de login e clique no botao entrar_ \"([^\"]*)\", \"([^\"]*)\"$")
	public void preencha_o_formulario_de_login_e_clique_no_botao_entrar_(String userARV, String passwordARV)
			throws Throwable {
		actions = new LoginArvNaCentralActions(webdriver);
		actions.loginArvNaCentral(userARV, passwordARV);

	}

	@Entao("^eu devo validar que o acesso foi feito com sucesso_ \"([^\"]*)\", \"([^\"]*)\"$")
	public void eu_devo_validar_que_o_acesso_foi_feito_com_sucesso_(String mensagem, String status) throws Throwable {
		actions.validarLoginSucesso(status);
	}

}
