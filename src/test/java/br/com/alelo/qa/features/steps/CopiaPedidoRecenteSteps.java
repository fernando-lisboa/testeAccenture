package br.com.alelo.qa.features.steps;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.DadosDoPedidoActions;
import br.com.alelo.qa.web.actions.FacaSeuPedidoActions;
import br.com.alelo.qa.web.actions.ResumoDoPedidoActions;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class CopiaPedidoRecenteSteps extends ParentSteps{
	
	FacaSeuPedidoActions facaSeuPedido;
	ResumoDoPedidoActions resumoPedido;
	DadosDoPedidoActions dadosPedido;
	
	@Dado("^Clico em Copiar um pedido recente$")
	public void clico_em_Copiar_um_pedido_recente() throws Throwable {
	    facaSeuPedido = new FacaSeuPedidoActions(webdriver);
	    facaSeuPedido.clicarEmCopiarUmPedidoRecente();
	}

	@Dado("^seleciono o pedido de \"([^\"]*)\"$")
	public void seleciono_o_pedido_de(String codigoPedido) throws Throwable {
		facaSeuPedido = new FacaSeuPedidoActions(webdriver);
		facaSeuPedido.selecionePedidoRecente(codigoPedido);
	}

	@Dado("^vou para proxima etapa$")
	public void vou_para_proxima_etapa() throws Throwable {
	    facaSeuPedido = new FacaSeuPedidoActions(webdriver);
	    facaSeuPedido.clicarEmProximaEtapa();
	}

	@Quando("^aparecer os dados do pedido eu altero a data de credito para \"([^\"]*)\"$")
	public void aparecer_os_dados_do_pedido_eu_altero_a_data_de_credito_para(String novaDataCredito) throws Throwable {
		dadosPedido = new DadosDoPedidoActions(webdriver);
		dadosPedido.alterarDataCredito(novaDataCredito);
	}

	@Quando("^vou para tela de resumo do pedido$")
	public void vou_para_tela_de_resumo_do_pedido() throws Throwable {
		dadosPedido = new DadosDoPedidoActions(webdriver);
		dadosPedido.irParaResumoDoPedido();
	}

	@Entao("^clico em fazer pedido$")
	public void clico_em_fazer_pedido() throws Throwable {
	    resumoPedido = new ResumoDoPedidoActions(webdriver);
	   // resumoPedido.dataCreditoPedidoConfere();
	    resumoPedido.realizarPedido();
	}

}
