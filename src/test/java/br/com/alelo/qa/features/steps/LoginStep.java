/**
  * Autor: Fernando Lisboa
 * Empresa: Taking
 * Data: 12/12/2019
 * Caminho: Portal Estabelecimento Comercial  --> Login
 */

package br.com.alelo.qa.features.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.HomeActions;
import br.com.alelo.qa.web.actions.OfertaAtivaActions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class LoginStep extends ParentSteps {

	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	OfertaAtivaActions oferta;
	HomeActions homeActions;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();
	

	@Dado("^que estou na tela de login$")
	public void que_estou_na_tela_de_login() throws Throwable {
		telaLogin();
		
	}
	@Dado("^que estou na tela de login webAdmin$")
	public void que_estou_na_tela_de_login_WebAdmin() throws Throwable {
		telaLoginWebAdmin();
		
	}
	

	@Quando("^preencho o formulario de login$")
	public void preencho_o_formulario_de_login() throws Throwable {
		formularioLogin();
	}
	
	@Quando("^preencho o formulario de login webAdmin$")
	public void preencho_o_formulario_de_login_webAdmin() throws Throwable {
		formularioLoginWebAdmin();
	}

	@Quando("^aciono o botao Entrar$")
	public void aciono_o_botao_Entrar() throws Throwable {
		botaoEntrar();
	}
	@Quando("^aciono o botao Entrar webAdmin$")
	public void aciono_o_botao_Entrar_webAdmin() throws Throwable {
		botaoEntrarWebAdmin();
	}

	@Entao("^	$")
	public void o_usuario_e_redirecionado_para_a_pagina_inicial() throws Throwable {
		paginaInicial();
	}
	@Entao("^o usuario e redirecionado para a pagina inicial webAdmin$")
	public void o_usuario_e_redirecionado_para_a_pagina_inicial_webAdmin() throws Throwable {
		paginaInicialWebAdmin();
	}

	@Quando("^preencho o campo CPF com informacoes invalidas$")
	public void preencho_o_campo_CPF_com_informacoes_invalidas() throws Throwable {
		cpfInvalido();
	}

	@Entao("^a aplicacao bloqueia o botao Entrar$")
	public void a_aplicacao_bloqueia_o_botao_Entrar() throws Throwable {
		bloqueiaBotaoEntrar();
	}

	@Quando("^preencho o campo senha com informacoes invalidas$")
	public void preencho_o_campo_senha_com_informacoes_invalidas() throws Throwable {
		senhaInvalida();
	}

	@Entao("^a aplicacao apresenta um modal com mensagem de falha$")
	public void a_aplicacao_apresenta_um_modal_com_mensagem_de_falha() throws Throwable {
		modalFalha();
	}

	@Quando("^aciono o botao habilitar minha conta$")
	public void aciono_o_botao_habilitar_minha_conta() throws Throwable {
		habilitarConta();
	}

	@Entao("^o usuario e redirecionado para a pagina de habilitacao de conta via email$")
	public void o_usuario_e_redirecionado_para_a_pagina_de_habilitacao_de_conta_via_email() throws Throwable {
		validacaoPrimeiroAcesso();
	}

	@Quando("^aciono o botao esqueci minha senha$")
	public void aciono_o_botao_esqueci_minha_senha() throws Throwable {
		esqueciSenha();
	}

	@Entao("^o usuario e redirecionado para a pagina de recuperacao de senha$")
	public void o_usuario_e_redirecionado_para_a_pagina_de_recuperacao_de_senha() throws Throwable {
		validacaoEsqueciSenha();
	}
}
