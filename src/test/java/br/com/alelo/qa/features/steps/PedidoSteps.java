package br.com.alelo.qa.features.steps;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.CadastroNovoColaboradorActions;
import br.com.alelo.qa.web.actions.FacaSeuPedidoActions;
import br.com.alelo.qa.web.actions.ResumoDoPedidoActions;
import br.com.alelo.qa.web.actions.SelecaoDeColaboradoresActions;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class PedidoSteps extends ParentSteps {

	FacaSeuPedidoActions facaSeuPedidoActions;
	SelecaoDeColaboradoresActions selecaoDeColaboradoresActions;
	ResumoDoPedidoActions resumoDoPedidoActions;
	CadastroNovoColaboradorActions cadastroNovoColaboradorAction;
	

	@Dado("^seleciono Novo Pedido$")
	public void seleciono_Novo_Pedido() throws Throwable {
		facaSeuPedidoActions = new FacaSeuPedidoActions(webdriver);
		facaSeuPedidoActions.clicarEmNovoPedido();
		facaSeuPedidoActions.clicarEmProximaEtapa();
	}

	@Quando("^seleciono o contrato \"([^\"]*)\"$")
	public void seleciono_o_contrato(String contrato) throws Throwable {
		facaSeuPedidoActions = new FacaSeuPedidoActions(webdriver);
		facaSeuPedidoActions.selecionarContrato(contrato);
		facaSeuPedidoActions.clicarEmProximaEtapa();
		
	}
	
	@Quando("^seleciono o contrato \"([^\"]*)\" e o contrato \"([^\"]*)\"$")
	public void seleciono_o_contrato_e_o_contrato(String contrato1, String contrato2) throws Throwable {
		facaSeuPedidoActions = new FacaSeuPedidoActions(webdriver);
		facaSeuPedidoActions.selecionarContrato(contrato1);
		facaSeuPedidoActions.selecionarContrato(contrato2);
		facaSeuPedidoActions.clicarEmProximaEtapa();
	}


	@Quando("^clico no botão Importar Colaborador$")
	public void clico_no_botão_Importar_Colaborador() throws Throwable {
		selecaoDeColaboradoresActions = new SelecaoDeColaboradoresActions(webdriver);
		selecaoDeColaboradoresActions.clicoEmImportarPlanilha();
	}

	@Entao("^e exibido um popup, com a mensagem de nova versao da planilha modelo$")
	public void e_exibido_um_popup_com_a_mensagem_de_nova_versao_da_planilha_modelo() throws Throwable {
		selecaoDeColaboradoresActions = new SelecaoDeColaboradoresActions(webdriver);
		selecaoDeColaboradoresActions.mensagemDeNovoModeloDePlanilhaExibida();
	}

	@Quando("^incluo colaboradores manualmente através do botão Novo Colaborador$")
	public void incluo_colaboradores_manualmente_através_do_botão_Novo_Colaborador() throws Throwable {
		cadastroNovoColaboradorAction = new CadastroNovoColaboradorActions(webdriver);
		cadastroNovoColaboradorAction.cadastrarNovoColaborador();
	}

	@Então("^finalizo o pedido com todos os colaboradores$")
	public void finalizo_o_pedido_com_todos_os_colaboradores() throws Throwable {
		selecaoDeColaboradoresActions = new SelecaoDeColaboradoresActions(webdriver);
		selecaoDeColaboradoresActions.selecionarTodosOsColabores();
		
	}


	@Então("^o PME o pedido deve ser realizado com sucesso$")
	public void o_PME_o_pedido_deve_ser_realizado_com_sucesso() throws Throwable {
		selecaoDeColaboradoresActions = new SelecaoDeColaboradoresActions(webdriver);
		selecaoDeColaboradoresActions.finalizarPedido();
	}

	@Então("^realizo novamente os passos anteriores até a tela de colaboradores e verifico se o Pop-Up ainda é exibido$")
	public void realizo_novamente_os_passos_anteriores_até_a_tela_de_colaboradores_e_verifico_se_o_Pop_Up_ainda_é_exibido()
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}
	
	@Quando("^incluo colaboradores manualmente atraves do botao Novo Colaborador$")
	public void incluo_colaboradores_manualmente_atraves_do_botao_Novo_Colaborador() throws Throwable {
		cadastroNovoColaboradorAction = new CadastroNovoColaboradorActions(webdriver);
		cadastroNovoColaboradorAction.cadastrarNovoColaborador();
		selecaoDeColaboradoresActions = new SelecaoDeColaboradoresActions(webdriver);
		selecaoDeColaboradoresActions.colaboradorCadastradoComSucesso();
	}

	@Quando("^clico no botao Importar Colaborador$")
	public void clico_no_botao_Importar_Colaborador() throws Throwable {
	    selecaoDeColaboradoresActions = new SelecaoDeColaboradoresActions(webdriver);
	    selecaoDeColaboradoresActions.clicoEmImportarPlanilha();
	}

	@Entao("^e exibido um popup, com a mensagem denova versao da planilha modelo$")
	public void e_exibido_um_popup_com_a_mensagem_denova_versao_da_planilha_modelo() throws Throwable {
	    selecaoDeColaboradoresActions = new SelecaoDeColaboradoresActions(webdriver);
	    selecaoDeColaboradoresActions.mensagemDeNovoModeloDePlanilhaExibida();
	}
	
	@Quando("^preencho o valor a ser depositado para cada colaborador$")
	public void preencho_o_valor_a_ser_depositado_para_cada_colaborador() throws Throwable {
		selecaoDeColaboradoresActions = new SelecaoDeColaboradoresActions(webdriver);
		selecaoDeColaboradoresActions.selecionarTodosOsColabores();
		selecaoDeColaboradoresActions.preencherValorASerDepositadoRefeicao("200");
		//selecaoDeColaboradoresActions.alterarDataCredito();
	}

	@Quando("^confirmo o local de entrega cadastrado$")
	public void confirmo_o_local_de_entrega_cadastrado() throws Throwable {
		selecaoDeColaboradoresActions = new SelecaoDeColaboradoresActions(webdriver);
		selecaoDeColaboradoresActions.confirmarLocalDeEntrega();
	}

	@Quando("^acessar a tela de resumo do pedido$")
	public void acessar_a_tela_de_resumo_do_pedido() throws Throwable {
		resumoDoPedidoActions = new ResumoDoPedidoActions(webdriver);
		resumoDoPedidoActions.dataCreditoPedidoConfere();
	}
	
	@Quando("^seleciono prosseguir finalizando o pedido com todos os colaboradores$")
	public void seleciono_prosseguir_finalizando_o_pedido_com_todos_os_colaboradores() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^clicar em Fazer Pedido$")
	public void clicar_em_Fazer_Pedido() throws Throwable {
		selecaoDeColaboradoresActions = new SelecaoDeColaboradoresActions(webdriver);
		selecaoDeColaboradoresActions.finalizarPedido();
	}

	@Entao("^deve aparecer a mensagem 'Pedido realizado com sucesso!'$")
	public void deve_aparecer_a_mensagem_Pedido_realizado_com_sucesso() throws Throwable {
		resumoDoPedidoActions = new ResumoDoPedidoActions(webdriver);
		resumoDoPedidoActions.pedidoRealizadoComSucesso();
	}
	
	@Quando("^clico em Proxima etapa sem selecionar colaboradores$")
	public void clico_em_Proxima_etapa_sem_selecionar_colaboradores() throws Throwable {
		selecaoDeColaboradoresActions = new SelecaoDeColaboradoresActions(webdriver);
		selecaoDeColaboradoresActions.finalizarPedido();
	}

	@Então("^deve aparecer a mensagem 'Adicione ao menos (\\d+) colaborador ao pedido\\.'$")
	public void deve_aparecer_a_mensagem_Adicione_ao_menos_colaborador_ao_pedido(int arg1) throws Throwable {
		selecaoDeColaboradoresActions = new SelecaoDeColaboradoresActions(webdriver);
		selecaoDeColaboradoresActions.mensagemDeErroVisivel();
	}


	@Quando("^entro na tela de colaboradores fecho o Pop-up vermelho sobre os pedidos com valor zerado$")
	public void entro_na_tela_de_colaboradores_fecho_o_Pop_up_vermelho_sobre_os_pedidos_com_valor_zerado() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


	@Entao("^realizo novamente os passos anteriores ate a tela de colaboradores e verifico se o Pop-Up ainda e exibido$")
	public void realizo_novamente_os_passos_anteriores_ate_a_tela_de_colaboradores_e_verifico_se_o_Pop_Up_ainda_e_exibido() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


}
