package br.com.alelo.qa.features.steps;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.PainelActions;
import br.com.alelo.utils.setupTestes.actions.CommonsActions;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ContratacaoPainelMeuNegocio extends ParentSteps {
	String cnpj;
	CommonsActions comm = new CommonsActions();
	PainelActions painel;

	@Quando("^efetuar uma contratacao via sidekick \"([^\"]*)\"$")
	public void efetuar_uma_contratacao_via_sidekick(String cnpjContratado) throws Throwable {
		painel = new PainelActions(webdriver);
		cnpj = cnpjContratado;
		comm.prepararBancoParaInicioDosTestesContratacao();
		painel.alterarEstabelecimentoPainelContratacaoCancelamento(cnpjContratado);
		painel.contrataPainel(cnpj);

	}

	@Entao("^devo validar o status da contratacao e suas respectivas datas \"([^\"]*)\"$")
	public void devo_validar_o_status_da_contratacao_e_suas_respectivas_datas(String statusEsperado) throws Throwable {

		painel.validarContratacao(statusEsperado, cnpj);
	}

	@Quando("^efetuar o cancelamento do produto painel meu negocio \"([^\"]*)\"$")
	public void efetuar_o_cancelamento_do_produto_painel_meu_negocio(String cnpjContratado) throws Throwable {
		painel = new PainelActions(webdriver);
		cnpj = cnpjContratado;
		comm.prepararBancoParaInicioDosTestesContratacao();
		painel.alterarEstabelecimentoPainelContratacaoCancelamento(cnpjContratado);
		painel.cancelamentoPainel(cnpjContratado);
	}

	@Entao("^devo validar o status do cancelamento e suas respectivas datas \"([^\"]*)\"$")
	public void devo_validar_o_status_do_cancelamento_e_suas_respectivas_datas(String status) throws Throwable {

		painel.validarCancelamentoPainel(status);

	}

}
