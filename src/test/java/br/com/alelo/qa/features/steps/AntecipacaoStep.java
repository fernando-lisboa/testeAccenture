/**
 * Autor: Fernando Lisboa
 * Empresa: Taking
 * Data: 12/12/2019
 * Caminho: Portal Estabelecimento Comercial  --> Side kick - Antecipação antes das 14:00
 */

package br.com.alelo.qa.features.steps;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.AntecipacaoActions;
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
	
    @E("^seleciono um CNPJ de número \"([^\"]*)\" no combo Estabelecimento$")
    public void seleciono_um_CNPJ_no_combo_Estabelecimento(String numCNPJ) throws Throwable {
        AntecipacaoActions AA = new AntecipacaoActions(webdriver);
        AA.alterarEstabelecimentoArv(numCNPJ);
}

	@E("estou usando \"([^\"]*)\", se cenario \"([^\"]*)\", devo alterar o valor \"([^\"]*)\", antecipar \"([^\"]*)\" e contratando \"([^\"]*)\" \"([^\"]*)\"$")
	public void se_cenario_devo_alterar_o_valor_e_antecipar(boolean Modal, String Cenario, boolean Valor,
			boolean Recorrencia, boolean Contratacao, String cnpj) throws Throwable {
		AntecipacaoActions AA = new AntecipacaoActions(webdriver);
		AA.FluxoAntecipacaoDeRecebiveisARV(Modal, Cenario, Valor, Recorrencia, Contratacao, cnpj);
	}

	@Entao("a validacao do cenario deve conter como resultado \"([^\"]*)\"$")
	public void a_validacao_do_cenario_deve_conter_como_resultado(String Resultado) throws Throwable {
		AntecipacaoActions AA = new AntecipacaoActions(webdriver);
		//AA.ResultadoEvidencia(Resultado);
	}
	
	
	@Entao("^valido que o sidkick de simulação está presente e todos os menus$")
	public void valido_que_o_sidkick_de_simulação_está_presente_e_todos_os_menus() throws Throwable {
		AntecipacaoActions AA = new AntecipacaoActions(webdriver);
		AA.validarSideKickAlert();
		
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
