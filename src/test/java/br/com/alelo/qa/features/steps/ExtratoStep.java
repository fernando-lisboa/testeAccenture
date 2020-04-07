package br.com.alelo.qa.features.steps;

import java.util.List;

import br.com.alelo.dto.TransacoesAprovadasDTO;
import br.com.alelo.qa.data.entity.TransacoesAprovadas;
import br.com.alelo.qa.features.support.ParentSteps;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ExtratoStep extends ParentSteps {

	private String idEc;

	@Dado("^possua um Ec \"([^\"]*)\"$")
	public void possua_um_Ec(String idEc) throws Throwable {
		
		this.idEc = idEc;

	}

	@Dado("^que este Ec tenha as seguintes transacoes aprovadas$")
	public void que_este_Ec_tenha_as_seguintes_transacoes_aprovadas(List<TransacoesAprovadas> listTransacoes) throws Throwable {
		
		StringBuilder builder = new StringBuilder();

		for (TransacoesAprovadas transacao : listTransacoes) {
			builder.append("\n");
			builder.append(transacao.toString());
			builder.append("\n");
		}
	}

	@Quando("^eu buscar por este IdEc \"([^\"]*)\"$")
	public void eu_buscar_por_este_IdEc(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Quando("^clicar no link extrato$")
	public void clicar_no_link_extrato() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Quando("^filtrar pela data entre$")
	public void filtrar_pela_data_entre(DataTable arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		throw new PendingException();
	}

	@Entao("^deve apresentar o extrato sumarizado com duas linhas$")
	public void deve_apresentar_o_extrato_sumarizado_com_duas_linhas(DataTable arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		throw new PendingException();
	}

	@Entao("^o valor total \"([^\"]*)\"$")
	public void o_valor_total(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}