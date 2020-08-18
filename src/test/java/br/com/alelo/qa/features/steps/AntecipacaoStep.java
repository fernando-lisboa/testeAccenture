/**
 * Autor: Fernando Lisboa
 * Empresa: Taking
 * Data: 12/12/2019
 * Caminho: Portal Estabelecimento Comercial  --> Side kick - Antecipação antes das 14:00
 */

package br.com.alelo.qa.features.steps;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.AntecipacaoActions;
import br.com.alelo.utils.DriverAnonimo;
import br.com.alelo.utils.setupTestes.actions.CommonsActions;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;

public class AntecipacaoStep extends ParentSteps {

	@Dado("^que o banco de arv esteja preparado para os testes$")
	public void que_o_banco_de_arv_esteja_preparado_para_os_testes() throws Throwable {
		CommonsActions comm = new CommonsActions();
		comm.updateParaContratacaoArv();

	}

	@E("^seleciono um CNPJ de número \"([^\"]*)\" no combo Estabelecimento \"([^\"]*)\"$")
	public void seleciono_um_CNPJ_no_combo_Estabelecimento(String numCNPJ, boolean operador) throws Throwable {

		if (operador) {
			AntecipacaoActions AA = new AntecipacaoActions(DriverAnonimo.getDriver());
			AA.alterarEstabelecimento(numCNPJ);

		} else {
			AntecipacaoActions AA = new AntecipacaoActions(webdriver);
			AA.alterarEstabelecimento(numCNPJ);
		}

	}

	@E("estou usando \"([^\"]*)\", se cenario \"([^\"]*)\", devo alterar o valor \"([^\"]*)\", antecipar \"([^\"]*)\" e contratando \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void se_cenario_devo_alterar_o_valor_e_antecipar(boolean Modal, String Cenario, boolean Valor,
			boolean Recorrencia, boolean Contratacao, String cnpj, boolean operador) throws Throwable {
		if (operador) {
			AntecipacaoActions AA = new AntecipacaoActions(DriverAnonimo.getDriver());
			AA.FluxoAntecipacaoDeRecebiveisARV(Modal, Cenario, Valor, Recorrencia, Contratacao, cnpj);
		} else {
			AntecipacaoActions AA = new AntecipacaoActions(webdriver);
			AA.FluxoAntecipacaoDeRecebiveisARV(Modal, Cenario, Valor, Recorrencia, Contratacao, cnpj);
		}
	}


	@Entao("^valido que o sidkick de simulação está presente e todos os menus \"([^\"]*)\"$")
	public void valido_que_o_sidkick_de_simulação_está_presente_e_todos_os_menus(boolean operador) throws Throwable {
		if (operador) {
			AntecipacaoActions AA = new AntecipacaoActions(DriverAnonimo.getDriver());
			AA.validarSideKickAlert();
		} else {
			AntecipacaoActions AA = new AntecipacaoActions(webdriver);
			AA.validarSideKickAlert();

		}
	}

	@Entao("^eu contrato a recorrencia da operacao e valido a mensagen de sucesso \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void eu_contrato_a_recorrencia_da_operacao_e_valido_a_mensagen_de_sucesso(boolean operador, String cenario,
			String modal) throws Throwable {
		if (operador) {
			AntecipacaoActions AA = new AntecipacaoActions(DriverAnonimo.getDriver());
			AA.definirRecorrenciaAposContratacao(operador,cenario, modal);
		} else {
			AntecipacaoActions AA = new AntecipacaoActions(webdriver);
			AA.definirRecorrenciaAposContratacao(operador,cenario, modal);

		}

	}
	
	


}
