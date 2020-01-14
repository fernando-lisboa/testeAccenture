/**
  * Autor: Fernando Lisboa
 * Empresa: Taking
 * Data: 12/12/2019
 * Caminho: Portal Estabelecimento Comercial  --> Extrato
 */

package br.com.alelo.qa.features.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.ExtratoActions;
import br.com.alelo.qa.web.actions.HomeActions;
import br.com.alelo.qa.web.actions.OfertaAtivaActions;
import br.com.alelo.qa.web.actions.SairActions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ExtratoStep extends ParentSteps {

	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	ExtratoActions extrato;
	OfertaAtivaActions oferta;
	HomeActions home;
	SairActions sair;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();

//	@Dado("^clico na aba Extrato$")
//	public void clico_na_aba_Extrato() throws Throwable {
//		extrato.clicarAbaExtrato();
//	}

	@Quando("^seleciono um periodo$")
	public void seleciono_um_periodo() throws Throwable {
		extrato.selecionarPeriodo();
	}

	@Quando("^clico no botao ok$")
	public void clico_no_botao_ok() throws Throwable {
		extrato.clicarOK();
	}

	@Entao("^o sistema renderiza as transacoes em tela$")
	public void o_sistema_renderiza_as_transacoes_em_tela() throws Throwable {
		extrato.validarTransacoes();
		sair.sairGeral();
	}

	@Quando("^clico em uma linha de vendas$")
	public void clico_em_uma_linha_de_vendas() throws Throwable {
		extrato.validarTransacoes();
		extrato.clicarLinhaVendas();
	}

	@Entao("^o sistema mostra o detalhamento das vendas do dia$")
	public void o_sistema_mostra_o_detalhamento_das_vendas_do_dia() throws Throwable {
		extrato.validarDetalheVendasDia();
		sair.sairGeral();
	}

	@Quando("^clico em uma linha de outras transacoes$")
	public void clico_em_uma_linha_de_cobrança() throws Throwable {
		extrato.clicarLinhaOutrastransacoes();
	}

	@Entao("^o sistema mostra o detalhamento de outras transacoes do dia$")
	public void o_sistema_mostra_o_detalhamento_das_cobranças_do_dia() throws Throwable {
		extrato.validarDetalheOutrastransacoesDia();
		sair.sairGeral();
	}

	@Quando("^busco transacoes pelo numero do cartao$")
	public void busco_transacoes_pelo_numero_do_cartao() throws Throwable {
		extrato.buscarNumeroCartao();
	}

	@Entao("^o sistema tras somente resultados referentes ao numero pesquisado$")
	public void o_sistema_tras_somente_resultados_referentes_ao_numero_pesquisado() throws Throwable {
		extrato.validarResultadosNumeroCartao();
		sair.sairGeral();
	}

	@E("^clico no botao de download PDF - superior$")
	public void clico_no_botao_de_download_PDF_superior() throws Throwable {
		extrato.downloadPDFSuperior();
	}

	@Entao("^o sistema baixa o PDF$")
	public void o_sistema_baixa_o_PDF() throws Throwable {
		extrato.validarPDFBaixado();
		sair.sairGeral();
	}

	@E("^clico no botao de download PDF - inferior$")
	public void clico_no_botao_de_download_PDF_inferior() throws Throwable {
		extrato.downloadPDFInferior();
	}

	@E("^clico no botao de download CSV - superior$")
	public void clico_no_botao_de_download_CSV_superior() throws Throwable {
		extrato.downloadCSVSuperior();
	}

	@Entao("^o sistema baixa o CSV$")
	public void o_sistema_baixa_o_CSV() throws Throwable {
		extrato.validarCSVBaixado();
		sair.sairGeral();
	}

	@E("^clico no botao de download CSV - inferior$")
	public void clico_no_botao_de_download_CSV_inferior() throws Throwable {
		extrato.downloadCSVInferior();
	}

	@E("^clico no botao de Imprimir extrato - superior$")
	public void clico_no_botao_de_Imprimir_extrato_superior() throws Throwable {
		extrato.impressaoSuperior();
	}

	@Entao("^o sistema imprime o extrato$")
	public void o_sistema_imprime_o_extrato() throws Throwable {
		extrato.validaImpressao();
		sair.sairGeral();
	}

	@E("^clico no botao de Imprimir extrato - inferior$")
	public void clico_no_botao_de_Imprimir_extrato_inferior() throws Throwable {
		extrato.impressaoInferior();
	}
}