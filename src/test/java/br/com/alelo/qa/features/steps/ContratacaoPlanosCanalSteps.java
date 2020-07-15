package br.com.alelo.qa.features.steps;

import java.util.Map;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.ContratacaoPlanosCanalActions;
import br.com.alelo.utils.setupTestes.actions.CommonsActions;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.cucumber.java8.PendingException;

public class ContratacaoPlanosCanalSteps extends ParentSteps {
	CommonsActions comm = new CommonsActions();

	@Quando("^efetuar o upload de planilha de planos para um \"([^\"]*)\" \"([^\"]*)\", \"([^\"]*)\"$")
	public void efetuar_o_upload_de_planilha_de_planos_para_um(String CNPJ, String caminho, String fileName)
			throws Throwable {
		ContratacaoPlanosCanalActions CP = new ContratacaoPlanosCanalActions(webdriver);
		CP.upLoadDePlanilhaDePlanos(caminho, fileName);
	}

	@Quando("^Contratar o plano ofertado \"([^\"]*)\" \"([^\"]*)\"$")
	public void contratar_o_plano_ofertado(String tpPlano, boolean contratacao) throws Throwable {
		ContratacaoPlanosCanalActions CP = new ContratacaoPlanosCanalActions(webdriver);
		CP.ContratarPlano(tpPlano, contratacao);
	}

	@Entao("^devo validar que foi gravado no banco de dados o canal de contratacao \"([^\"]*)\" \"([^\"]*)\"$")
	public void devo_validar_que_foi_gravado_no_banco_de_dados_o_canal_de_contratacao(String canal, String Ambiente, Map<String, String> map) throws Throwable {
		ContratacaoPlanosCanalActions CP = new ContratacaoPlanosCanalActions(webdriver);
		CP.validarBancoDeDadosCanal(canal,Ambiente, map);
	}

	@Dado("^que eu tenha planos disponíveis para cantratacao \"([^\"]*)\"$")
	public void que_eu_tenha_planos_disponíveis_para_cantratacao(String ambiente) throws Throwable {
		comm.preparaBancoPlanos();
	}

}
