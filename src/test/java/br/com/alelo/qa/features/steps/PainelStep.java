/**
  * Autor: Fernando Lisboa
 * Empresa: Taking
 * Data: 12/12/2019
 * Caminho: Portal Estabelecimento Comercial  --> Painel
 */

package br.com.alelo.qa.features.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.HomeActions;
import br.com.alelo.qa.web.actions.LoginActions;
import br.com.alelo.qa.web.actions.OfertaAtivaActions;
import br.com.alelo.qa.web.actions.PainelActions;
import br.com.alelo.qa.web.actions.SairActions;
import br.com.alelo.qa.web.page.LoginPage;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PainelStep extends ParentSteps {

	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	LoginActions login;
	SairActions sair;
	PainelActions painel;
	OfertaAtivaActions oferta;
	HomeActions home;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();

	@Dado("^que estou na logado no portal EC \"([^\"]*)\", \"([^\"]*)\"$")
	public void que_estou_na_logado_no_portal_EC(String user, String senha) throws Throwable {
		webdriver.get(baseurl); // Abre url
		login = new LoginActions(webdriver);
		login.loginGeral(user, senha);
		System.out.println("logado..");
	}

	@Quando("^acesso o painel no menu$")
	public void acesso_o_painel_no_menu() throws Throwable {
		painel.validarPainel();
	}

	@E("^seleciono um CNPJ diferente no combo Estabelecimento$")
	public void seleciono_um_CNPJ_diferente_no_combo_Estabelecimento() throws Throwable {
		painel.alterarEstabelecimento();
	}

	@E("^seleciono um CNPJ diferente que tenha ARV no combo Estabelecimento$")
	public void seleciono_um_CNPJ_diferente_com_Arv_no_combo_Estabelecimento() throws Throwable {
		painel.alterarEstabelecimentoArv();
	}

	@E("^seleciono um CNPJ diferente que tenha plano e sem saldo no combo Estabelecimento$")
	public void seleciono_um_CNPJ_diferente_com_plano_no_combo_Estabelecimento() throws Throwable {
		painel.alterarEstabelecimentoPlano();
	}

	@E("^seleciono um CNPJ diferente que tenha plano e com saldo no combo Estabelecimento$")
	public void seleciono_um_CNPJ_diferente_com_plano_com_saldo_no_combo_Estabelecimento() throws Throwable {
		painel.alterarEstabelecimentoPlanoSaldo();
	}

	@E("^seleciono um CNPJ diferente que nao tenha plano ou saldo no combo Estabelecimento$")
	public void seleciono_um_CNPJ_diferente_sem_plano_sem_saldo_no_combo_Estabelecimento() throws Throwable {
		painel.alterarEstabelecimentoSemPlanoSemSaldo();
	}

	@Entao("^o painel carrega as informacoes respectivas ao CNPJ selecionado$")
	public void o_painel_carrega_as_informacoes_respectivas_ao_CNPJ_selecionado() throws Throwable {
		painel.validarCNPJPainel();
		sair.sairGeral();
	}

	@E("^clico no banner superior$")
	public void clico_no_banner_superior() throws Throwable {
		painel.clicarBannerSuperior();
	}

	@Entao("^o sistema redireciona para a tela marketing cadastrada superior$")
	public void o_sistema_redireciona_para_a_tela_marketing_cadastrada_superior() throws Throwable {
		painel.validaLinkBannerSuperior();
	}

	@E("^clico nos banners inferiores$")
	public void clico_nos_banners_inferiores() throws Throwable {
		painel.clicarBannerInferior();
	}

	@Entao("^o sistema redireciona para a tela marketing cadastrada inferior$")
	public void o_sistema_redireciona_para_a_tela_marketing_cadastrada_inferior() throws Throwable {
		painel.validaLinkBannerInferiores();
	}

	@E("^clico na imagem correspondente ao Twitter$")
	public void clico_na_imagem_correspondente_ao_Twitter() throws Throwable {
		painel.clicaTwitter();
	}

	@Entao("^o sistema redireciona para a url da Alelo no Twitter$")
	public void o_sistema_redireciona_para_a_url_da_Alelo_no_Twitter() throws Throwable {
		painel.validaURLTwitter();
	}

	@E("^clico na imagem correspondente ao Facebook$")
	public void clico_na_imagem_correspondente_ao_Facebook() throws Throwable {
		painel.clicaFacebook();
	}

	@Entao("^o sistema redireciona para a url da Alelo no Facebook$")
	public void o_sistema_redireciona_para_a_url_da_Alelo_no_Facebook() throws Throwable {
		painel.validaURLFacebook();
	}

	@E("^clico na imagem correspondente ao Linkedin$")
	public void clico_na_imagem_correspondente_ao_Linkedin() throws Throwable {
		painel.clicaLinkedin();
	}

	@Entao("^o sistema redireciona para a url da Alelo no Linkedin$")
	public void o_sistema_redireciona_para_a_url_da_Alelo_no_Linkedin() throws Throwable {
		painel.validaURLLinkedin();
	}

	@Entao("^o sistema apresenta o sidekick de ARV$")
	public void o_sistema_apresenta_o_sidekick_de_ARV() throws Throwable {
		painel.validaSidekickArv();
	}

	@Entao("^o sistema apresenta o sidekick de Planos$")
	public void o_sistema_apresenta_o_sidekick_de_Planos() throws Throwable {
		painel.validaSidekickPlano();
	}

	@Entao("^o sistema nao apresenta o sidekick$")
	public void o_sistema_nao_apresenta_o_sidekick() throws Throwable {
		painel.validaNaoAparicaoSidekick();
	}

}
