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
	public void devo_validar_que_é_exibido_o_valor_recebido_e_o_valor_a_receber_do_meu_ec(String arg1)
			throws Throwable {

		page.avacarMes();
		page.retrocederMes();

	}
}
