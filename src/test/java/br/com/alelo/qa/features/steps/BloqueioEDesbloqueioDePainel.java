package br.com.alelo.qa.features.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.LoginActions;
import br.com.alelo.qa.web.actions.PainelActions;
import br.com.alelo.qa.web.actions.SairActions;
import br.com.alelo.utils.SimpleCacheManager;
import br.com.alelo.utils.setupTestes.actions.CommonsActions;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;

public class BloqueioEDesbloqueioDePainel  extends ParentSteps {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	SairActions sair;
	PainelActions actions;
	LoginActions login;
	CommonsActions comm = new CommonsActions();
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();

	@Dado("^enviar uma planilha de bloqueio de painel \"([^\"]*)\", \"([^\"]*)\"$")
	public void enviar_uma_planilha_de_bloqueio_de_painel(String path, String nomeArquivo) throws Throwable {
		comm.prepararBancoParaInicioDosTestesBloqueio();
		actions = new PainelActions(webdriver);
		actions.bloqueiaEc(path, nomeArquivo);
	}


	@Entao("^devo verificar que o ec foi bloqueado \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void devo_verificar_que_o_ec_foi_bloqueado(String statusEsperado, String user, String password, String cnpj) throws Throwable{
		webdriver.get(baseurl); // Abre url
		login = new LoginActions(webdriver);
		login.loginGeral(user,password);
		actions.alterarEstabelecimentoBloq(cnpj);
		actions.consultarStatusContratacaoPainel();
	}
	
	@Entao("^devo verificar que o ec foi Desbloqueado \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void devo_verificar_que_o_ec_foi_Desbloqueado(String statusEsperado, String user, String password, String cnpj) throws Throwable {
		webdriver.get(baseurl); // Abre url
		login = new LoginActions(webdriver);
		login.loginGeral(user,password);
		actions.alterarEstabelecimentoDesbloq(cnpj);
		actions.consultarStatusDesbloqueio(statusEsperado);
	}

}
