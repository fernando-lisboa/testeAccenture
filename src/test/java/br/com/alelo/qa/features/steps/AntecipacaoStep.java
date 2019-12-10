/**
 * Autor: Fernando Lisboa
 * Empresa: Taking
 * Data: 12/12/2019
 * Caminho: Portal Estabelecimento Comercial  --> Side kick - Antecipação antes das 14:00
 */

package br.com.alelo.qa.features.steps;

import cucumber.api.java.pt.Quando;
import driver.web.DriverWeb;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import basePages.AntecipacaoPage;
import basePages.LoginPage;
import basePages.SairPage;
import br.com.alelo.qa.web.actions.HomeActions;
import br.com.alelo.qa.web.actions.OfertaAtivaActions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;

public class AntecipacaoStep extends ParentSteps {

	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	OfertaAtivaActions oferta;
	HomeActions homeActions;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();

	@Dado("^que estou logado em qualquer tela no Portal EC$")
	public void que_estou_logado_em_qualquer_tela_no_Portal_EC() throws Throwable {
//		LoginPage.loginGeral();
	}

	@Quando("^clico no SideKick no menu expansivel lateral de antecipacao de recebiveis$")
	public void clico_no_SideKick_no_menu_expansivel_lateral_de_antecipacao_de_recebiveis() throws Throwable {
//		alterarEstabelecimento();
//		antecipacaoARV();
	}
	
	@Quando("^clicar no banner com campanha de antecipacao de recebiveis$")
	public void clicar_no_banner_com_campanha_de_antecipacao_de_recebiveis() throws Throwable {
//		telaArv();
//		
//		alterarEstabelecimentoArv();
		
	}

	@Quando("^clico em concordo com os termos de antecipacao de recebiveis$")
	public void clico_em_concordo_com_os_termos_de_antecipacao_de_recebiveis() throws Throwable {
//		concordarTermos();
	}

	@E("^clico em Antecipar Agora$")
	public void clico_em_Antecipar_Agora() throws Throwable {
//		clicarAntecipar();
	}

	@Entao("^Portal EC realiza a antecipacao$")
	public void portal_EC_realiza_a_antecipacao() throws Throwable {
		validaAntecipacao();
		SairPage.sairGeral();
	}

	@Quando("^clico em Cancelar antecipacao de recebiveis$")
	public void clico_em_Cancelar_antecipacao_de_recebiveis() throws Throwable {
		clicarCancelar();
	}

	@Entao("^o Portal EC cancela a antecipacao$")
	public void o_Portal_EC_cancela_a_antecipacao() throws Throwable {
		validaCancelamentoAntecipacao();
		SairPage.sairGeral();
	}

	@E("^clico no botao Fechar antecipacao de recebiveis$")
	public void clico_na_botao_Fechar_antecipacao_de_recebiveis() throws Throwable {
		clicarFechar();
	}

	@Entao("^o Portal EC fecha o modal da antecipacao$")
	public void o_Portal_EC_fecha_o_modal_da_antecipacao() throws Throwable {
		modalfechado();
		SairPage.sairGeral();
	}

	@E("^clico em alterar valor$")
	public void clico_em_alterar_valor() throws Throwable {
		clicarAlterarValor();
	}

	@E("^insiro um valor abaixo do valor que desejo antecipar$")
	public void insiro_um_valor_abaixo_do_valor_que_desejo_antecipar() throws Throwable {
		inserirValor();
	}

	@E("^clico em vizualizar valores disponiveis$")
	public void clico_em_vizualizar_valores_disponiveis() throws Throwable {
		clicarVizualizarValores();
	}

	@E("^seleciono a opção desejada$")
	public void seleciono_a_opção_desejada() throws Throwable {
		selecionarOpcao();
	}

	@E("^clico calcular valor liquido$")
	public void clico_calcular_valor_liquido() throws Throwable {
		calcularValor();
	}

	@Quando("^clico no botao alterar recorrencia antecipacao de recebiveis$")
	public void clico_no_botao_alterar_recorrencia_antecipacao_de_recebiveis() throws Throwable {
		clicarAlterar();
	}

	@Quando("^seleciono a opcao semanal$")
	public void seleciono_a_opcao_semanal() throws Throwable {
		selecionarSemanal();
	}

	@Quando("^seleciono o dia da semana$")
	public void seleciono_o_dia_da_semana() throws Throwable {
		selecionaDiaSemana();
	}

	@Quando("^seleciono a opcao desativada$")
	public void seleciono_a_opcao_desativada() throws Throwable {
		selecionaOpcaoDesativada();
	}

	@Quando("^clico em definir recebimento$")
	public void clico_em_definir_recebimento() throws Throwable {
		clicaDefinirRecebimento();
	}

	@Entao("^o Portal EC retorna para o modal da antecipacao$")
	public void o_Portal_EC_retorna_para_o_modal_da_antecipacao() throws Throwable {
		validarModalAntecipacao();
		clicarFechar();
		SairPage.sairGeral();
	}

	@E("^clico no botao cancelar recorrencia$")
	public void clico_no_botao_cancelar_recorrencia() throws Throwable {
		clicarCancelarRecorrencia();
	}
	
	@E("^clico no botao cancelar alteracao valores$")
	public void clico_no_botao_cancelar_alteracao_valores() throws Throwable {
		clicarCancelarParcial();
	}
}
