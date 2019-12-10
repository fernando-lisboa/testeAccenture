/**
  * Autor: Fernando Lisboa
 * Empresa: Taking
 * Data: 12/12/2019
 * Caminho: Portal Estabelecimento Comercial  --> Configurações
 */

package br.com.alelo.qa.features.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import basePages.SairPage;
import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.HomeActions;
import br.com.alelo.qa.web.actions.OfertaAtivaActions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ConfiguracoesStep extends ParentSteps {

	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	OfertaAtivaActions oferta;
	HomeActions homeActions;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();
	
	
	@Dado("^que estou na pagina Configuracoes$")
	public void que_estou_na_pagina_Configuracoes() throws Throwable {
		validarConfiguracoes();
	}
	
	@Quando("^aciono o botao Adicionar CNPJ$")
	public void aciono_o_botao_Adicionar_CNPJ() throws Throwable {
		adicionarCNPJSuperior();
	}
	
	@Quando("^aciono o botao Adicionar CNPJ superior$")
	public void aciono_o_botao_Adicionar_CNPJ_superior() throws Throwable {
		adicionarCNPJSuperior();
	}
	
	@Quando("^aciono o botao Adicionar CNPJ inferior$")
	public void aciono_o_botao_Adicionar_CNPJ_inferior() throws Throwable {
		adicionarCNPJInferior();
	}

	@E("^insiro as informacoes no formulario dados bancarios$")
	public void insiro_as_informacoes_no_formulario_dados_bancarios() throws Throwable {
		informacoesFomularioDadosBancarios();
	}

	@E("^insiro as informacoes no formulario dados bancarios invalidos$")
	public void insiro_as_informacoes_no_formulario_dados_bancarios_invalidos() throws Throwable {
		informacoesFomularioDadosBancariosInvalidos();
	}

	@E("^aciono o botao Confirmar$")
	public void aciono_o_botao_Confirmar() throws Throwable {
		//botaoConfirmar();  <<<< Comentado para não queimar a massa
	}

	@Entao("^o Portal EC me redireciona para a pagina de configuracoes com o novo estabelecimento inserido$")
	public void o_Portal_EC_me_redireciona_para_a_pagina_de_configuracoes_com_o_novo_estabelecimento_inserido()
			throws Throwable {
		//confirmaCadastroEstabelecimento(); <<<< Comentado para não queimar a massa
		validaBotaoConfirmar();
		SairPage.sairGeral();
	}

	@Entao("^o Portal EC apresenta uma mensagem de erro$")
	public void o_Portal_EC_apresenta_uma_mensagem_de_erro() throws Throwable {
		botaoConfirmar(); // <<< Adicionado para não queimar a massa de casos anteriores
		validarMensagemErro();
		SairPage.sairGeral();
	}
}