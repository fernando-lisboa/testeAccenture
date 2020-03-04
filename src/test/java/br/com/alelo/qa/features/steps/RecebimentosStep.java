package br.com.alelo.qa.features.steps;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.RecebimentosActions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class RecebimentosStep extends ParentSteps {

	RecebimentosActions page;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();

	@Quando("^eu clicar no menu recebimentos \"([^\"]*)\"$")
	public void eu_clicar_no_menu_recebimentos(String cnpj) throws Throwable {
		page = new RecebimentosActions(webdriver);
		page.alterarEstabelecimento(cnpj);
		page.valitarTelaRecebiveis();
	}

	@Entao("^devo validar que é exibido o valor recebido e o valor a receber do meu ec \"([^\"]*)\"$")
	public void devo_validar_que_é_exibido_o_valor_recebido_e_o_valor_a_receber_do_meu_ec(String periodo)
			throws Throwable {
		page.validarPeriodos(periodo);
	}

	@Quando("^selecionar a data atual e a opcao de \"([^\"]*)\"$")
	public void selecionar_a_data_atual_e_a_opcao_de(String produto) throws Throwable {
		
		page.selecionarProduto(produto);
		
	}

	@Entao("^devo visualizar a lista de valores a receber de acordo com o produto selecionado \"([^\"]*)\"$")
	public void devo_visualizar_a_lista_de_valores_a_receber_de_acordo_com_o_produto_selecionado(String produto) throws Throwable {

		page.validarCampoCabecalho(produto);
		page.validarListaRecebimentos();
		
		
	}
}
