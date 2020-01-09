/**
  * Autor: Fernando Lisboa
 * Empresa: Taking
 * Data: 12/12/2019
 * Caminho: Portal Estabelecimento Comercial  --> Sair
 */

package br.com.alelo.qa.features.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.HomeActions;
import br.com.alelo.qa.web.actions.OfertaAtivaActions;
import br.com.alelo.qa.web.actions.SairActions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class SairStep extends ParentSteps {

	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	SairActions sairActions;
	OfertaAtivaActions oferta;
	HomeActions homeActions;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();

	@Dado("^que estou em qualquer pagina da area logada do portal EC$")
	public void que_estou_em_qualquer_pagina_da_area_logada_do_portal_EC() throws Throwable {
		sairActions.validarAreaLogada();
		webdriver.getCurrentUrl().contains("inicio");
	}

	@Quando("^aciono o botao de usuario$")
	public void aciono_o_botao_de_usuario() throws Throwable {
		sairActions.clicarUsuario();
	}

	@Quando("^aciono a opcao Sair apresentada no menu$")
	public void aciono_a_opcao_Sair_apresentada_no_menu() throws Throwable {
		sairActions.clicarSair();
	}

	@Entao("^o Portal EC desloga a sessao e redireciona o usuario para a area nao logada$")
	public void o_Portal_EC_desloga_a_sessao_e_redireciona_o_usuario_para_a_area_nao_logada() throws Throwable {
		sairActions.validarUrlAtual();
	}
}
