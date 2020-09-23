package br.com.alelo.qa.features.steps;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.AntecipacaoActions;
import br.com.alelo.qa.web.actions.RecebimentosActions;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class RecebimentoSteps extends ParentSteps {
	
	
	
	@Quando("^eu clicar no menu recebimentos \"([^\"]*)\"$")
	public void eu_clicar_no_menu_recebimentos(String cnpj) throws Throwable {
		Thread.sleep(1000);
		RecebimentosActions actions = new RecebimentosActions(webdriver);
		AntecipacaoActions AA = new AntecipacaoActions(webdriver);
//		AA.alterarEstabelecimento(cnpj);
		actions.valitarTelaRecebiveis();
		
	}

	@Entao("^devo validar que é exibido o valor recebido e o valor a receber do meu ec \"([^\"]*)\"$")
	public void devo_validar_que_é_exibido_o_valor_recebido_e_o_valor_a_receber_do_meu_ec(String periodo) throws Throwable {
		
		RecebimentosActions actions = new RecebimentosActions(webdriver);
		actions.validarPeriodos(periodo);
	}


	@Entao("^devo visualizar a lista de valores a receber de acordo com o produto selecionado \"([^\"]*)\"$")
	public void devo_visualizar_a_lista_de_valores_a_receber_de_acordo_com_o_produto_selecionado(String produto) throws Throwable {
		RecebimentosActions actions = new RecebimentosActions(webdriver);
		actions.validarCampoCabecalho(produto);
		System.out.println("TESTE FINALIZADO COM SUCESSO");
	}

	@Entao("^devo validar que foi apresentado uma tabela com os detalhes das transacoes de acordo com o filtro \"([^\"]*)\"$")
	public void devo_validar_que_foi_apresentado_uma_tabela_com_os_detalhes_das_transacoes_de_acordo_com_o_filtro(String produto) throws Throwable {
		RecebimentosActions actions = new RecebimentosActions(webdriver);
		actions.validarDetalheTransacoes(produto);
		
	}

	@Quando("^Selecionar uma data com a opcao de produto \"([^\"]*)\" para o CNPJ \"([^\"]*)\" e clicar em comprovante\"([^\"]*)\"$")
	public void selecionar_a_data_atual_e_a_opcao_de_produtos_e_clicar_em_comprovante(String produto, String CNPJ, boolean Comprovante) throws Throwable {
		RecebimentosActions actions = new RecebimentosActions(webdriver);
		actions.localizaDiaComRecebiveisDisponiveis(produto, CNPJ, Comprovante);
	}

}
