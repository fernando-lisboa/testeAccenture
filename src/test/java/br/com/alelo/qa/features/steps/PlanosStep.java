/**
* @author Fernando Lisboa - Taking 
* Change: 08/01/2019 | Author: Jessé Dantas - Taking
*/
package br.com.alelo.qa.features.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.HomeActions;
import br.com.alelo.qa.web.actions.OfertaAtivaActions;
import br.com.alelo.qa.web.actions.PlanosActions;
import br.com.alelo.qa.web.actions.SairActions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PlanosStep extends ParentSteps {

	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	SairActions sair;
	PlanosActions planos;
	OfertaAtivaActions oferta;
	HomeActions home;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();

	// ############################## Métodos Given ##############################

	// ############################## Métodos When ##############################

	@Quando("^clico no SideKick no menu expansivel lateral de contratacao$")
	public void clico_no_SideKick_no_menu_expansivel_lateral_de_contratacao() throws Throwable {
		planos.alterarEstabelecimento();
		planos.contratacaoARV();
	}

	@Quando("^seleciono a opcao 1$")
	public void seleciono_a_opcao_1() throws Throwable {
		planos.contratacao1();
	}

	@Quando("^seleciono a opcao 2$")
	public void seleciono_a_opcao_2() throws Throwable {
		planos.contratacao2();
	}

	@Quando("^seleciono a opcao 3$")
	public void seleciono_a_opcao_3() throws Throwable {
		planos.contratacao3();
	}

	@Quando("^seleciono uma opcao$")
	public void seleciono_uma_opcao() throws Throwable {
		planos.contratacaoDefault();
	}

	@Quando("^clico em Aceitar Termos$")
	public void clico_em_Aceitar_Termos() throws Throwable {
		planos.concordarTermos();
	}

	@Quando("^clico em Contratar$")
	public void clico_em_Contratar() throws Throwable {
		// COMENTADO PARA NAO QUEIMAR MASSA
		// efetivaContratacaoARV();
	}

	@Quando("^clico em Cancelar contratacao$")
	public void clico_em_Cancelar_contratacao() throws Throwable {
		planos.clicarCancelar();
	}

	@Quando("^clico em Fechar contratacao$")
	public void clico_em_Fechar_contratacao() throws Throwable {
		planos.clicarFechar();
	}

	// ############################## Métodos Then ##############################

	@Entao("^o Portal EC realiza a contratacao$")
	public void o_Portal_EC_realiza_a_contratacao() throws Throwable {
		planos.validaContratacao();
		sair.sairGeral();
	}

	@Entao("^o Portal EC cancela a contratacao$")
	public void o_Portal_EC_cancela_a_contratacao() throws Throwable {
		planos.validaCancelamentoContratacao();
		sair.sairGeral();
	}

	@Entao("^o Portal EC fecha o modal da contratacao$")
	public void o_Portal_EC_fecha_o_modal_da_contratacao() throws Throwable {
		planos.validaFecharContratacao();
		sair.sairGeral();
	}
}
