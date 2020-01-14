/**
  * Autor: Fernando Lisboa
 * Empresa: Taking
 * Data: 12/12/2019
 * Caminho: IBM Security Access Manager
 */

package br.com.alelo.qa.features.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.HomeActions;
import br.com.alelo.qa.web.actions.IsamActions;
import br.com.alelo.qa.web.actions.OfertaAtivaActions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ISAMStep extends ParentSteps {

	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);

	IsamActions isam;
	OfertaAtivaActions oferta;
	HomeActions home;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();

	@Dado("^que estou na tela de login IBM$")
	public void que_estou_na_tela_de_login_IBM() throws Throwable {
		isam.telaLoginISAM();
	}

	@Quando("^preencho nome de usuario e senha$")
	public void preencho_nome_de_usuario_e_senha() throws Throwable {
		isam.preencherUsuario();
		isam.preencherSenha();
	}

	@Quando("^clico no botao login$")
	public void clico_no_botao_login() throws Throwable {
		isam.clicarLogin();
	}

	@Entao("^o usuario e redirecionado para a pagina inicial do ISAM$")
	public void o_usuario_e_redirecionado_para_a_pagina_inicial_do_ISAM() throws Throwable {
		isam.validarInicialISAM();
	}

	@Dado("^que estou logado na plataforma$")
	public void que_estou_logado_na_plataforma() throws Throwable {
		isam.loginISAMGeral();
	}

	@Quando("^removo todas as sessos ativas$")
	public void removo_todas_as_sessos_ativas() throws Throwable {
		isam.removerSessao();
	}

	@Entao("^os usuarios ficam livres para acesso ao Portal EC$")
	public void os_usuarios_ficam_livres_para_acesso_ao_Portal_EC() throws Throwable {
		isam.validarSessao();
	}

}
