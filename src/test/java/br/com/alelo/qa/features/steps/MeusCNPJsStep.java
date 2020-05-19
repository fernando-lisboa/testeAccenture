/**
 * Autor: Michael Alba
 * Empresa: Taking
 * Data: 12/03/2020
 * Caminho: Portal Criação e Alteração de Senha de Usuário
 */

package br.com.alelo.qa.features.steps;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.MeusCNPJsActions;
import br.com.alelo.utils.DriverAnonimo;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class MeusCNPJsStep extends ParentSteps {

	@E("vou pedir ajuda no atendimento e acesso a outra aba do navegador \"([^\"]*)\"$")
	public void vou_pedir_ajuda_no_atendimento_e_acesso_a_outra_aba_do_navegador(boolean operador) throws Throwable {
		MeusCNPJsActions adicionaCNPJ = new MeusCNPJsActions(webdriver);
		adicionaCNPJ.PedirAjudaMenu();
	}

	@Entao("^eu simulo a associacao do cnpj \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void devo_associar_um_CNPJ(int CNPJS, String CNPJ_Pesquisa, Boolean operador) throws Throwable {

		if (operador) {
			MeusCNPJsActions adicionaCNPJ = new MeusCNPJsActions(DriverAnonimo.getDriver());
			adicionaCNPJ.AdicionaCNPJS(CNPJS, CNPJ_Pesquisa);
		} else {
			MeusCNPJsActions adicionaCNPJ = new MeusCNPJsActions(webdriver);
			adicionaCNPJ.AdicionaCNPJS(CNPJS, CNPJ_Pesquisa);
		}
	}

	@Entao("a validacao do cenario deve conter como resultado \"([^\"]*)\" \"([^\"]*)\"$")
	public void a_validacao_do_cenario_deve_conter_como_resultado_(String Resultado, Boolean operador) throws Throwable {

		if (operador) {
			MeusCNPJsActions AA = new MeusCNPJsActions(DriverAnonimo.getDriver());
			AA.ResultadoEvidencia(Resultado);
		} else {
			MeusCNPJsActions AA = new MeusCNPJsActions(webdriver);
			AA.ResultadoEvidencia(Resultado);
		}
	}
}
