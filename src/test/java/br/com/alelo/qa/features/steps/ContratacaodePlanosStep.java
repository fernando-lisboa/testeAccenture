/**
 * Autor: Fernando Lisboa
 * Empresa: Taking
 * Data: 12/12/2019
 * Caminho: Portal Estabelecimento Comercial  --> Side kick - Antecipação antes das 14:00
 */

package br.com.alelo.qa.features.steps;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.ContratacaodePlanosActions;
import br.com.alelo.utils.DriverAnonimo;
import br.com.alelo.utils.setupTestes.actions.CommonsActions;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;

public class ContratacaodePlanosStep extends ParentSteps {

	CommonsActions comm = new CommonsActions();

	@E("contratando plano de \"([^\"]*)\" e contratando \"([^\"]*)\" \"([^\"]*)\"$")
	public void contratando_plano_de_e_contratando(String Cenario, boolean Contratacao, Boolean operador)
			throws Throwable {

		if (operador) {
			ContratacaodePlanosActions CPA = new ContratacaodePlanosActions(DriverAnonimo.getDriver());
			CPA.ContratarPlano(Cenario, Contratacao);

		} else {

			ContratacaodePlanosActions CPA = new ContratacaodePlanosActions(webdriver);
			CPA.ContratarPlano(Cenario, Contratacao);
		}
	}
	
	@Dado("^que eu tenha planos disponíveis para cantratação \"([^\"]*)\"$")
	public void que_eu_tenha_planos_disponíveis_para_cantratação(Boolean operador) throws Throwable {
		
		if(operador){
			comm.preparaBancoPlanosSimulacao();
		}else{
			
			comm.preparaBancoPlanos();
		}
		
	}

}
