/**
  * Autor: Fernando Lisboa
 * Empresa: Taking
 * Data: 12/12/2019

 * Caminho: Portal Estabelecimento Comercial  --> Side kick - Contração de Planos após as 14:00
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

public class PlanosStep extends ParentSteps {

	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	OfertaAtivaActions oferta;
	HomeActions homeActions;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();
	

	@Dado("^que estou logado em qualquer tela do Portal EC$")
	public void que_estou_logado_em_qualquer_tela_do_Portal_EC() throws Throwable {
		LoginPage.loginGeral();
	}

	@Quando("^clico no SideKick no menu expansivel lateral de contratacao$")
	public void clico_no_SideKick_no_menu_expansivel_lateral_de_contratacao() throws Throwable {
		alterarEstabelecimento();
		contratacaoARV();
	}

	@E("^seleciono a opcao 1$")
	public void seleciono_a_opcao_1() throws Throwable {
		contratacao1();
	}

	@E("^seleciono a opcao 2$")
	public void seleciono_a_opcao_2() throws Throwable {
		contratacao2();
	}

	@E("^seleciono a opcao 3$")
	public void seleciono_a_opcao_3() throws Throwable {
		contratacao3();
	}

	@Quando("^seleciono uma opcao$")
	public void seleciono_uma_opcao() throws Throwable {
		contratacaoDefault();
	}

	@E("^clico em Aceitar Termos$")
	public void clico_em_Aceitar_Termos() throws Throwable {
		concordarTermos();
	}

	@E("^clico em Contratar$")
	public void clico_em_Contratar() throws Throwable {
		// COMENTADO PARA NAO QUEIMAR MASSA
		// efetivaContratacaoARV();
	}

	@Entao("^o Portal EC realiza a contratacao$")
	public void o_Portal_EC_realiza_a_contratacao() throws Throwable {
		validaContratacao();
		SairPage.sairGeral();
	}

	@Quando("^clico em Cancelar contratacao$")
	public void clico_em_Cancelar_contratacao() throws Throwable {
		clicarCancelar();
	}

	@Entao("^o Portal EC cancela a contratacao$")
	public void o_Portal_EC_cancela_a_contratacao() throws Throwable {
		validaCancelamentoContratacao();
		SairPage.sairGeral();
	}

	@E("^clico no botao Fechar contratacao$")
	public void clico_na_botao_Fechar_contratacao() throws Throwable {
		clicarFechar();
	}

	@Entao("^o Portal EC fecha o modal da contratacao$")
	public void o_Portal_EC_fecha_o_modal_da_contratacao() throws Throwable {
		validaFecharContratacao();
		SairPage.sairGeral();
	}
}
