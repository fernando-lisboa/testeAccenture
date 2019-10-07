package br.com.alelo.qa.features.steps;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.CobrancaActions;
import br.com.alelo.qa.web.actions.MenuActions;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class CobrancaSteps extends ParentSteps {
	//Pages Actions
	CobrancaActions cobrancas;
	//Sections
	MenuActions menu;
	//variaveis
	String contrato;
	
	@Entao("^navego até a pagina de cobrancas$")
	public void navego_até_a_pagina_de_cobrancas() throws Throwable {
		menu = new MenuActions(webdriver);
	    menu.acessarFinanceiroCobranca();
	    cobrancas = new  CobrancaActions(webdriver);
	}
	
	@Entao("^verifico que sou direcionado ao inicio da tela na tela de cobranca$")
	public void verifico_que_sou_direcionado_ao_inicio_da_tela_na_tela_de_cobranca() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


	@Quando("^clicar no botao buscar$")
	public void clicar_no_botao_buscar() throws Throwable {
		cobrancas.clicarEmBuscar();
	}

	@Entao("^verifico que a busca por produto contrato eh feita corretamente$")
	public void verifico_que_a_busca_por_produto_contrato_eh_feita_corretamente() throws Throwable {
		cobrancas = new CobrancaActions(webdriver);
		cobrancas.validaColunaProdutoContrato(this.contrato);
	}
	
	@Entao("^verifico que a busca por filial eh feita corretamente$")
	public void verifico_que_a_busca_por_filial_eh_feita_corretamente() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^verifico que a busca por mes de emissao eh feita corretamente$")
	public void verifico_que_a_busca_por_mes_de_emissao_eh_feita_corretamente() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^verifico que a busca por mes de pagamento eh feita corretamente$")
	public void verifico_que_a_busca_por_mes_de_pagamento_eh_feita_corretamente() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^realizo uma busca de faturas antecipado nao agrupadas$")
	public void realizo_uma_busca_de_faturas_antecipado_nao_agrupadas() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^verifico que os faturamentos nao sao agrupados no mesmo GRID$")
	public void verifico_que_os_faturamentos_nao_sao_agrupados_no_mesmo_GRID() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^realizo uma busca de faturas pagamento a prazo agrupadas$")
	public void realizo_uma_busca_de_faturas_pagamento_a_prazo_agrupadas() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^verifico que os faturamentos sao agrupados no mesmo GRID$")
	public void verifico_que_os_faturamentos_sao_agrupados_no_mesmo_GRID() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^realizo uma busca de faturas pagamento a prazo mensal agrupadas$")
	public void realizo_uma_busca_de_faturas_pagamento_a_prazo_mensal_agrupadas() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^realizo uma busca de faturas do produto refeicao pago com cartao de credito$")
	public void realizo_uma_busca_de_faturas_do_produto_refeicao_pago_com_cartao_de_credito() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^clico no botão detalhar da tela de cobrança$")
	public void clico_no_botão_detalhar_da_tela_de_cobrança() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^valido a cobranca do refeicao pago com cartao de credito$")
	public void valido_a_cobranca_do_refeicao_pago_com_cartao_de_credito() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^realizo uma busca de faturas do produto alimentacao pago com boleto$")
	public void realizo_uma_busca_de_faturas_do_produto_alimentacao_pago_com_boleto() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^valido a cobranca do alimentacao pago com boleto$")
	public void valido_a_cobranca_do_alimentacao_pago_com_boleto() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^realizo uma busca de faturas do produto natal agrupado$")
	public void realizo_uma_busca_de_faturas_do_produto_natal_agrupado() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^valido a cobranca do natal agrupado$")
	public void valido_a_cobranca_do_natal_agrupado() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^realizo uma busca de faturas do produto cultura agrupado$")
	public void realizo_uma_busca_de_faturas_do_produto_cultura_agrupado() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^valido a cobranca do cultura agrupado$")
	public void valido_a_cobranca_do_cultura_agrupado() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^realizo uma busca de faturas do produto boleto$")
	public void realizo_uma_busca_de_faturas_do_produto_boleto() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^valido a cobranca do boleto$")
	public void valido_a_cobranca_do_boleto() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^realizo uma busca de faturas do produto cartao de credito$")
	public void realizo_uma_busca_de_faturas_do_produto_cartao_de_credito() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^valido a cobranca do cartao de credito$")
	public void valido_a_cobranca_do_cartao_de_credito() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^realizo uma busca com dados corretos na tela de cobranca$")
	public void realizo_uma_busca_com_dados_corretos_na_tela_de_cobranca() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^seleciono um item na tela de cobranca$")
	public void seleciono_um_item_na_tela_de_cobranca() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^verifico que o sistema de impressao é acionado na tela de cobranca$")
	public void verifico_que_o_sistema_de_impressao_é_acionado_na_tela_de_cobranca() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^seleciono a opcao Selecionar Itens Filtrados na tela de cobranca$")
	public void seleciono_a_opcao_Selecionar_Itens_Filtrados_na_tela_de_cobranca() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^verifico que todos os resultados da busca foram selecionados na tela de cobranca$")
	public void verifico_que_todos_os_resultados_da_busca_foram_selecionados_na_tela_de_cobranca() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^seleciono a opcao Limpar Filtro na tela de cobranca$")
	public void seleciono_a_opcao_Limpar_Filtro_na_tela_de_cobranca() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^verifico que os filtros que utilizei pra busca voltam ao estado original na tela de cobranca$")
	public void verifico_que_os_filtros_que_utilizei_pra_busca_voltam_ao_estado_original_na_tela_de_cobranca() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^desco para o final da tela$")
	public void desco_para_o_final_da_tela() throws Throwable {
		cobrancas = new CobrancaActions(webdriver);
		cobrancas.descerPagina();
	}

	@Quando("^seleciono a opcao Voltar ao topo na tela de cobranca$")
	public void seleciono_a_opcao_Voltar_ao_topo_na_tela_de_cobranca() throws Throwable {
		cobrancas = new CobrancaActions(webdriver);
		cobrancas.voltarAoTopo();
	}
	
	@Quando("^preencher/selecionar produto contrato com \"([^\"]*)\"$")
	public void preencher_selecionar_produto_contrato_com(String contrato) throws Throwable {
		cobrancas = new CobrancaActions(webdriver);
		this.contrato = contrato;
		cobrancas.selecionarProdutoContrato(contrato);
	}

	@Quando("^preencher/selecionar filial com \"([^\"]*)\"$")
	public void preencher_selecionar_filial_com(String filial) throws Throwable {
		cobrancas = new CobrancaActions(webdriver);
		cobrancas.preencherFilial(filial);
	}

	@Quando("^preencher/selecionar numero do pedido com \"([^\"]*)\"$")
	public void preencher_selecionar_numero_do_pedido_com(String pedido) throws Throwable {
		cobrancas = new CobrancaActions(webdriver);
		cobrancas.preencherPedido(pedido);
	}

	@Entao("^verifico que a busca por numero do pedido eh feita corretamente$")
	public void verifico_que_a_busca_por_numero_do_pedido_eh_feita_corretamente() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^preencher/selecionar mes de emissao com \"([^\"]*)\"$")
	public void preencher_selecionar_mes_de_emissao_com(String mesEmissao) throws Throwable {
		cobrancas = new CobrancaActions(webdriver);
		cobrancas.preencherMesEmissao(mesEmissao);
	}

	@Quando("^preencher/selecionar mes de pagamento com \"([^\"]*)\"$")
	public void preencher_selecionar_mes_de_pagamento_com(String mesPagamento) throws Throwable {
		cobrancas = new CobrancaActions(webdriver);
		cobrancas.preencherMesPagamento(mesPagamento);
	}

}
