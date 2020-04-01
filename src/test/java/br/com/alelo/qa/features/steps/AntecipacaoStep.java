/**
 * Autor: Fernando Lisboa
 * Empresa: Taking
 * Data: 12/12/2019
 * Caminho: Portal Estabelecimento Comercial  --> Side kick - Antecipação antes das 14:00
 */

package br.com.alelo.qa.features.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.AntecipacaoActions;
import br.com.alelo.qa.web.actions.HomeActions;
import br.com.alelo.qa.web.actions.SairActions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class AntecipacaoStep extends ParentSteps {

	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	AntecipacaoActions antecipacao;
	HomeActions home;
	SairActions sair;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();

	@Quando("^clico no SideKick no menu expansivel lateral de antecipacao de recebiveis$")
	public void clico_no_SideKick_no_menu_expansivel_lateral_de_antecipacao_de_recebiveis() throws Throwable {

	}

	@Quando("^seleciono a opcao de alterar valor e escolher o valor desejado e clicar no botao de vizualizacao de valores$")
	public void seleciono_a_opcao_de_alterar_valor_e_escolher_o_valor_desejado_e_clicar_no_botao_de_vizualizacao_de_valores()
			throws Throwable {

	}

	@Quando("^clicar na opcao de vizualizar valores liquidos For encaminhado para a tela de contratacao$")
	public void clicar_na_opcao_de_vizualizar_valores_liquidos_For_encaminhado_para_a_tela_de_contratacao()
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new Exception();
	}

	@Entao("^devo vizualizar os valores disponiveis para antecipacao do valor aproximado solicitado com o botao contratar agora desabilitado$")
	public void devo_vizualizar_os_valores_disponiveis_para_antecipacao_do_valor_aproximado_solicitado_com_o_botao_contratar_agora_desabilitado()
			throws Throwable {

	}
}
//
// @Dado("^que estou logado em qualquer tela no Portal EC$")
// public void que_estou_logado_em_qualquer_tela_no_Portal_EC() throws Throwable
// {
// }
//
// @Quando("^clico no SideKick no menu expansivel lateral de antecipacao de
// recebiveis$")
// public void
// clico_no_SideKick_no_menu_expansivel_lateral_de_antecipacao_de_recebiveis()
// throws Throwable {
//
// String cnpjCombo = "Xpath do cnpj a ser selecionado"; // TODO colocar o cnpj
// a ser antecipado
// antecipacao.alterarEstabelecimento(cnpjCombo);
// antecipacao.antecipacaoARV();
// }
//
// @Quando("^clicar no banner com campanha de antecipacao de recebiveis$")
// public void clicar_no_banner_com_campanha_de_antecipacao_de_recebiveis()
// throws Throwable {
//
// String cnpjCombo = "Xpath do cnpj a ser selecionado"; // TODO colocar o cnpj
// a ser antecipado
// antecipacao.telaArv();
// antecipacao.alterarEstabelecimentoArv(cnpjCombo);
//
// }
//
// @Quando("^clico em concordo com os termos de antecipacao de recebiveis$")
// public void clico_em_concordo_com_os_termos_de_antecipacao_de_recebiveis()
// throws Throwable {
//
// antecipacao.concordarTermos();
// }
//
// @E("^clico em Antecipar Agora$")
// public void clico_em_Antecipar_Agora() throws Throwable {
// antecipacao.clicarAntecipar();
// }
//
// @Entao("^Portal EC realiza a antecipacao$")
// public void portal_EC_realiza_a_antecipacao() throws Throwable {
// antecipacao.validaAntecipacao();
// sair.sairGeral();
// }
//
// @Quando("^clico em Cancelar antecipacao de recebiveis$")
// public void clico_em_Cancelar_antecipacao_de_recebiveis() throws Throwable {
// antecipacao.clicarCancelar();
// }
//
// @Entao("^o Portal EC cancela antecipacao$")
// public void o_Portal_EC_cancela_a_antecipacao() throws Throwable {
// antecipacao.validaCancelamentoAntecipacao();
// sair.sairGeral();
// }
//
// @E("^clico no botao Fechar antecipacao de recebiveis$")
// public void clico_na_botao_Fechar_antecipacao_de_recebiveis() throws
// Throwable {
// antecipacao.clicarFechar();
// }
//
// @Entao("^o Portal EC fecha o modal antecipacao$")
// public void o_Portal_EC_fecha_o_modal_da_antecipacao() throws Throwable {
// antecipacao.modalfechado();
// sair.sairGeral();
// }
//
// @E("^clico em alterar valor$")
// public void clico_em_alterar_valor() throws Throwable {
// antecipacao.clicarAlterarValor();
// }
//
// @E("^insiro um valor abaixo do valor que desejo antecipar$")
// public void insiro_um_valor_abaixo_do_valor_que_desejo_antecipar() throws
// Throwable {
// antecipacao.inserirValor();
// }
//
// @E("^clico em vizualizar valores disponiveis$")
// public void clico_em_vizualizar_valores_disponiveis() throws Throwable {
// antecipacao.clicarVizualizarValores();
// }
//
// @E("^seleciono a opção desejada$")
// public void seleciono_a_opção_desejada() throws Throwable {
// antecipacao.selecionarOpcao();
// }
//
// @E("^clico calcular valor liquido$")
// public void clico_calcular_valor_liquido() throws Throwable {
// antecipacao.calcularValor();
// }
//
// @Quando("^clico no botao alterar recorrencia antecipacao de recebiveis$")
// public void clico_no_botao_alterar_recorrencia_antecipacao_de_recebiveis()
// throws Throwable {
// antecipacao.clicarAlterar();
// }
//
// @Quando("^seleciono a opcao semanal$")
// public void seleciono_a_opcao_semanal() throws Throwable {
// antecipacao.selecionarSemanal();
// }
//
// @Quando("^seleciono o dia da semana$")
// public void seleciono_o_dia_da_semana() throws Throwable {
// antecipacao.selecionaDiaSemana();
// }
//
// @Quando("^seleciono a opcao desativada$")
// public void seleciono_a_opcao_desativada() throws Throwable {
// antecipacao.selecionaOpcaoDesativada();
// }
//
// @Quando("^clico em definir recebimento$")
// public void clico_em_definir_recebimento() throws Throwable {
// antecipacao.clicaDefinirRecebimento();
// }
//
// @Entao("^o Portal EC retorna para o modal da antecipacao$")
// public void o_Portal_EC_retorna_para_o_modal_da_antecipacao() throws
// Throwable {
// antecipacao.validarModalAntecipacao();
// antecipacao.clicarFechar();
// sair.sairGeral();
// }
//
// @E("^clico no botao cancelar recorrencia$")
// public void clico_no_botao_cancelar_recorrencia() throws Throwable {
// antecipacao.clicarCancelarRecorrencia();
// }
//
// @E("^clico no botao cancelar alteracao valores$")
// public void clico_no_botao_cancelar_alteracao_valores() throws Throwable {
// antecipacao.clicarCancelarParcial();
// }
// }
