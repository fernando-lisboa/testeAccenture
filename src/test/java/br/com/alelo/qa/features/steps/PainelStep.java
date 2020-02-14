/**
  * Autor: Fernando Lisboa
 * Empresa: Taking
 * Data: 12/12/2019
 * Caminho: Portal Estabelecimento Comercial  --> Painel
 */

package br.com.alelo.qa.features.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.PainelActions;
import br.com.alelo.qa.web.actions.SairActions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PainelStep extends ParentSteps {

	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	SairActions sair;
	PainelActions painel;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();

	@Quando("^acesso o painel no menu$")
	public void acesso_o_painel_no_menu() throws Throwable {
		painel.validarPainel();
		
	}

	@E("^seleciono um CNPJ diferente no combo Estabelecimento$")
	public void seleciono_um_CNPJ_diferente_no_combo_Estabelecimento() throws Throwable {
		painel = new PainelActions(webdriver);
		painel.alterarEstabelecimento();
	}

	@E("^seleciono um CNPJ diferente que tenha ARV no combo Estabelecimento$")
	public void seleciono_um_CNPJ_diferente_com_Arv_no_combo_Estabelecimento() throws Throwable {
		painel = new PainelActions(webdriver);
		painel.alterarEstabelecimentoArv();
	}

	@E("^seleciono um CNPJ diferente que tenha plano e sem saldo no combo Estabelecimento$")
	public void seleciono_um_CNPJ_diferente_com_plano_no_combo_Estabelecimento() throws Throwable {
		painel.alterarEstabelecimentoPlano();
	}

	@E("^seleciono um CNPJ diferente que tenha plano e com saldo no combo Estabelecimento$")
	public void seleciono_um_CNPJ_diferente_com_plano_com_saldo_no_combo_Estabelecimento() throws Throwable {
		painel.alterarEstabelecimentoPlanoSaldo();
	}

	@E("^seleciono um CNPJ diferente que nao tenha plano ou saldo no combo Estabelecimento$")
	public void seleciono_um_CNPJ_diferente_sem_plano_sem_saldo_no_combo_Estabelecimento() throws Throwable {
		painel.alterarEstabelecimentoSemPlanoSemSaldo();
	}

	@Entao("^o painel carrega as informacoes respectivas ao CNPJ selecionado$")
	public void o_painel_carrega_as_informacoes_respectivas_ao_CNPJ_selecionado() throws Throwable {
		painel.validarCNPJPainel();
		sair.sairGeral();
	}

	@Entao("^o sistema apresenta o sidekick de ARV$")
	public void o_sistema_apresenta_o_sidekick_de_ARV() throws Throwable {
		painel.validaSidekickArv();
	}

	@Entao("^o sistema apresenta o sidekick de Planos$")
	public void o_sistema_apresenta_o_sidekick_de_Planos() throws Throwable {
		painel.validaSidekickPlano();
	}

	@Entao("^o sistema nao apresenta o sidekick$")
	public void o_sistema_nao_apresenta_o_sidekick() throws Throwable {
		painel.validaNaoAparicaoSidekick();
	}

	@Dado("^seleciono um CNPJ diferente que seja elegivel para contratação do painel meu negocio$")
	public void seleciono_um_CNPJ_diferente_que_seja_elegivel_para_contratação_do_painel_meu_negocio()
			throws Throwable {
		painel = new PainelActions(webdriver);
		painel.alterarEstabelecimentoPainel();
	}

	@Entao("^o sistema apresenta o sidekick de painel$")
	public void o_sistema_apresenta_o_sidekick_de_painel() throws Throwable {
		painel.validaSidekickPainel();
	}

	@Entao("^devo validar a apresentação de infomaçoes de valores a receber$")
	public void devo_validar_a_apresentação_de_infomaçoes_de_valores_a_receber() throws Throwable {
		painel.validarValorAReceber();
	}

	@Entao("^devo validar a apresentação de infomaçoes de valores já recebidos$")
	public void devo_validar_a_apresentação_de_infomaçoes_de_valores_já_recebidos() throws Throwable {
		painel.validarValorRecebido();
	}

	@Entao("^devo validar a apresentação de infomaçoes painel com resumo de faturamento e graficos do painel meu negocio \"([^\"]*)\"$")
	public void devo_validar_a_apresentação_de_infomaçoes_painel_com_resumo_de_faturamento_e_graficos_do_painel_meu_negocio(
			String graficoEsperado) throws Throwable {
		painel.validarMenuDosGraficos(graficoEsperado);
	}

}
