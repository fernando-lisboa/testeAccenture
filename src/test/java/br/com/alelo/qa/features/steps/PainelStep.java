/**
  * Autor: Fernando Lisboa
 * Empresa: Taking
 * Data: 12/12/2019
 * Caminho: Portal Estabelecimento Comercial  --> Painel
 */

package br.com.alelo.qa.features.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import basePages.SairPage;
import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.HomeActions;
import br.com.alelo.qa.web.actions.OfertaAtivaActions;
import br.com.alelo.qa.web.page.LoginPage;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PainelStep extends ParentSteps {

	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	OfertaAtivaActions oferta;
	HomeActions homeActions;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();
	

	@Dado("^que estou na logado no portal EC$")
	public void que_estou_na_logado_no_portal_EC() throws Throwable {
		LoginPage.loginGeral();
	}

	@Quando("^acesso o painel no menu$")
	public void acesso_o_painel_no_menu() throws Throwable {
		validarPainel();
	}

	@E("^seleciono um CNPJ diferente no combo Estabelecimento$")
	public void seleciono_um_CNPJ_diferente_no_combo_Estabelecimento() throws Throwable {
		alterarEstabelecimento();
	}

	@E("^seleciono um CNPJ diferente que tenha ARV no combo Estabelecimento$")
	public void seleciono_um_CNPJ_diferente_com_Arv_no_combo_Estabelecimento() throws Throwable {
		alterarEstabelecimentoArv();
	}
	
	@E("^seleciono um CNPJ diferente que tenha plano e sem saldo no combo Estabelecimento$")
	public void seleciono_um_CNPJ_diferente_com_plano_no_combo_Estabelecimento() throws Throwable {
		alterarEstabelecimentoPlano();
	}
	
	@E("^seleciono um CNPJ diferente que tenha plano e com saldo no combo Estabelecimento$")
	public void seleciono_um_CNPJ_diferente_com_plano_com_saldo_no_combo_Estabelecimento() throws Throwable {
		alterarEstabelecimentoPlanoSaldo();
	}
	
	@E("^seleciono um CNPJ diferente que nao tenha plano ou saldo no combo Estabelecimento$")
	public void seleciono_um_CNPJ_diferente_sem_plano_sem_saldo_no_combo_Estabelecimento() throws Throwable {
		alterarEstabelecimentoSemPlanoSemSaldo();
	}

	@Entao("^o painel carrega as informacoes respectivas ao CNPJ selecionado$")
	public void o_painel_carrega_as_informacoes_respectivas_ao_CNPJ_selecionado() throws Throwable {
		validarCNPJPainel();
		SairPage.sairGeral();
	}

	@E("^clico no banner superior$")
	public void clico_no_banner_superior() throws Throwable {
		clicarBannerSuperior();
	}

	@Entao("^o sistema redireciona para a tela marketing cadastrada superior$")
	public void o_sistema_redireciona_para_a_tela_marketing_cadastrada_superior() throws Throwable {
		validaLinkBannerSuperior();
	}

	@E("^clico nos banners inferiores$")
	public void clico_nos_banners_inferiores() throws Throwable {
		clicarBannerInferior();
	}

	@Entao("^o sistema redireciona para a tela marketing cadastrada inferior$")
	public void o_sistema_redireciona_para_a_tela_marketing_cadastrada_inferior() throws Throwable {
		validaLinkBannerInferiores();
	}

	@E("^clico na imagem correspondente ao Twitter$")
	public void clico_na_imagem_correspondente_ao_Twitter() throws Throwable {
		clicaTwitter();
	}

	@Entao("^o sistema redireciona para a url da Alelo no Twitter$")
	public void o_sistema_redireciona_para_a_url_da_Alelo_no_Twitter() throws Throwable {
		validaURLTwitter();
	}

	@E("^clico na imagem correspondente ao Facebook$")
	public void clico_na_imagem_correspondente_ao_Facebook() throws Throwable {
		clicaFacebook();
	}

	@Entao("^o sistema redireciona para a url da Alelo no Facebook$")
	public void o_sistema_redireciona_para_a_url_da_Alelo_no_Facebook() throws Throwable {
		validaURLFacebook();
	}

	@E("^clico na imagem correspondente ao Linkedin$")
	public void clico_na_imagem_correspondente_ao_Linkedin() throws Throwable {
		clicaLinkedin();
	}

	@Entao("^o sistema redireciona para a url da Alelo no Linkedin$")
	public void o_sistema_redireciona_para_a_url_da_Alelo_no_Linkedin() throws Throwable {
		validaURLLinkedin();
	}
	
	@Entao("^o sistema apresenta o sidekick de ARV$")
	public void o_sistema_apresenta_o_sidekick_de_ARV() throws Throwable {
		validaSidekickArv();
	}
	
	@Entao("^o sistema apresenta o sidekick de Planos$")
	public void o_sistema_apresenta_o_sidekick_de_Planos() throws Throwable {
		validaSidekickPlano();
	}
	
	@Entao("^o sistema nao apresenta o sidekick$")
	public void o_sistema_nao_apresenta_o_sidekick() throws Throwable {
		validaNaoAparicaoSidekick();
	}
	
}
