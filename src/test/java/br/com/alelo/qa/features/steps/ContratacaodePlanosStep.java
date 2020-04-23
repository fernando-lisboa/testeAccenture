/**
 * Autor: Fernando Lisboa
 * Empresa: Taking
 * Data: 12/12/2019
 * Caminho: Portal Estabelecimento Comercial  --> Side kick - Antecipação antes das 14:00
 */

package br.com.alelo.qa.features.steps;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.AntecipacaoActions;
import br.com.alelo.qa.web.actions.ContratacaodePlanosActions;
import br.com.alelo.utils.setupTestes.actions.CommonsActions;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;

public class ContratacaodePlanosStep extends ParentSteps {

	@E("contratando plano de \"([^\"]*)\" e contratando \"([^\"]*)\"$")
	public void contratando_plano_de_e_contratando(String Cenario, boolean Contratacao) throws Throwable {
		ContratacaodePlanosActions CPA = new ContratacaodePlanosActions(webdriver);
		CPA.ContratarPlano(Cenario, Contratacao);
	}
}
