///**
// * Autor: Fernando Lisboa
// * Empresa: Taking
// * Data: 12/12/2019
// * Caminho: Portal Estabelecimento Comercial  --> Agenda
// */
//
//package br.com.alelo.qa.features.steps;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import br.com.alelo.qa.features.support.ParentSteps;
//import br.com.alelo.qa.web.actions.AgendaActions;
//import br.com.alelo.qa.web.actions.HomeActions;
//import br.com.alelo.qa.web.actions.SairActions;
//import br.com.alelo.utils.SimpleCacheManager;
//import cucumber.api.java.pt.Dado;
//import cucumber.api.java.pt.E;
//import cucumber.api.java.pt.Entao;
//import cucumber.api.java.pt.Quando;
//
//public class AgendaStep extends ParentSteps {
//
//	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
//	AgendaActions agenda;
//	HomeActions home;
//	SairActions sair;
//	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();
//
//	@Dado("^que estou logado no Portal EC$")
//	public void que_estou_logado_no_Portal_EC() throws Throwable {
//		System.out.println("logado...");
//	}
//
//	@Quando("^que estou na tela Agenda$")
//	public void que_estou_na_tela_Agenda() throws Throwable {
//		agenda.telaAgenda();
//	}
//
//	@E("^seleciono o campo correspondente ao dia atual$")
//	public void seleciono_o_campo_correspondente_ao_dia_atual() throws Throwable {
//		agenda.diaAtual();
//	}
//
//	@E("^seleciono o botao avancar no mes$")
//	public void seleciono_o_botao_avancar_no_mes() throws Throwable {
//		agenda.avacarMes();
//	}
//
//	@E("^seleciono o botao retroceder no mes$")
//	public void seleciono_o_botao_retroceder_no_mes() throws Throwable {
//		agenda.retrocederMes();
//	}
//
//	@Entao("^o Portal EC apresenta a tela de Agenda do respectivo mes$")
//	public void o_Portal_EC_apresenta_a_tela_de_Agenda_do_respectivo_ao_mes() throws Throwable {
//		agenda.telaExtratoMes();
//		sair.sairGeral();
//	}
//
//	@Entao("^o Portal EC apresenta a tela de Extrato do respectivo dia$")
//	public void o_Portal_EC_apresenta_a_tela_de_Extrato_do_respectivo_dia() throws Throwable {
//		agenda.telaExtratoMes();
//		sair.sairGeral();
//	}
//
//	@Quando("^estou na home page$")
//	public void estou_na_home_page() throws Throwable {
//		agenda.validarHomepage();
//	}
//
//	@E("^clico no botao Veja mais detalhes$")
//	public void clico_no_botao_Veja_mais_detalhes() throws Throwable {
//		agenda.clicarMaisDetalhes();
//	}
//
//	@Entao("^o Portal EC apresenta a tela de agenda$")
//	public void o_Portal_EC_apresenta_a_tela_de_agenda() throws Throwable {
//		agenda.validarAgenda();
//		sair.sairGeral();
//	}
//
//	@E("^clico no banner esquerdo$")
//	public void clico_no_banner_esquerdo() throws Throwable {
//		agenda.clicarBannerEsquerdo();
//	}
//
//	@E("^clico no banner direito$")
//	public void clico_no_banner_direito() throws Throwable {
//		agenda.clicarBannerDireito();
//	}
//
//	@Entao("^o sistema redireciona para a tela marketing cadastrada esquerdo$")
//	public void o_sistema_redireciona_para_a_tela_marketing_cadastrada_esquerdo() throws Throwable {
//		agenda.validaBannerEsquerdo();
//		sair.sairGeral();
//	}
//
//	@Entao("^o sistema redireciona para a tela marketing cadastrada direito$")
//	public void o_sistema_redireciona_para_a_tela_marketing_cadastrada_direito() throws Throwable {
//		agenda.validaBannerDireito();
//		sair.sairGeral();
//	}
//
//	@Quando("^clico no botao comprovantes$")
//	public void clico_no_botao_comprovantes() throws Throwable {
//		String cnpjAgenda = ""; //TODO ajustar para o CNPJ do comprovante
//		agenda.clicarComprovantes(cnpjAgenda);
//	}
//
//	@Quando("^clico no botao Baixar em PDF superior$")
//	public void clico_no_botao_Baixar_em_PDF_superior() throws Throwable {
//		agenda.clicarPDFSuperior();
//	}
//
//	@Quando("^clico no botao Baixar em PDF inferior$")
//	public void clico_no_botao_Baixar_em_PDF_inferior() throws Throwable {
//		agenda.clicarPDFInferior();
//	}
//
//	@Entao("^o sistema baixa o extrato em PDF$")
//	public void o_sistema_baixa_o_extrato_em_PDF() throws Throwable {
//		agenda.validarDownloadPDF();
//		sair.sairGeral();
//	}
//
//	@Quando("^clico no botao Baixar em CSV superior$")
//	public void clico_no_botao_Baixar_em_CSV_superior() throws Throwable {
//		agenda.clicarCSVSuperior();
//	}
//
//	@Quando("^clico no botao Baixar em CSV inferior$")
//	public void clico_no_botao_Baixar_em_CSV_inferior() throws Throwable {
//		agenda.clicarCSVInferior();
//	}
//
//	@Entao("^o sistema baixa o extrato em CSV$")
//	public void o_sistema_baixa_o_extrato_em_CSV() throws Throwable {
//		agenda.validarDownloadCSV();
//		sair.sairGeral();
//	}
//
//	@Quando("^clico no botao Imprimir comprovante superior$")
//	public void clico_no_botao_Imprimir_comprovante_superior() throws Throwable {
//		agenda.clicarImprimirSuperior();
//	}
//
//	@Quando("^clico no botao Imprimir comprovante inferior$")
//	public void clico_no_botao_Imprimir_comprovante_inferior() throws Throwable {
//		agenda.clicarImprimirInferior();
//	}
//
//	@Entao("^o sistema imprime o comprovante$")
//	public void o_sistema_imprime_o_comprovante() throws Throwable {
//		agenda.validarImpressao();
//		sair.sairGeral();
//	}
//}