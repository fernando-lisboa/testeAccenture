/**
 *   Caminho: Portal Estabelecimento Comercial  --> ARV Na Central
 *      Date: 12/12/2019 | Fernando Lisboa - Taking 
 * Last Date: 30/12/2019 | Jessé Dantas - Taking
 */
package br.com.alelo.qa.features.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.ContratacaoArvNaCentralActions;
import br.com.alelo.qa.web.actions.HomeActions;
import br.com.alelo.qa.web.actions.OfertaAtivaActions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Dados;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ContratacaoArvNaCentral_Steps extends ParentSteps {

	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	OfertaAtivaActions oferta;
	ContratacaoArvNaCentralActions ContratacaoArvNaCentral;
	HomeActions homeActions;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();

	// ############################## Métodos Given ##############################

	@Dado("^que estou logado em qualquer tela arv na central com CPF \"([^\"]*)\" e senha \"([^\"]*)\"$")
	public void que_estou_logado_em_qualquer_tela_arv_na_central(String cpfComAcesso, String cpfSenhaValida)
			throws Throwable {
		ContratacaoArvNaCentral.telaLogin();
		ContratacaoArvNaCentral.formularioLogin(cpfComAcesso, cpfSenhaValida);
		ContratacaoArvNaCentral.clicarEntrar();
		ContratacaoArvNaCentral.paginaInicial();
	}

	@Dado("^que eu acesse o portal ARV na central$")
	public void que_eu_acesse_o_portal_ARV_na_central() throws Throwable {
		ContratacaoArvNaCentral.telaLogin();
	}

	@Dado("^insira o CPF \"([^\"]*)\" com acesso$")
	public void insira_um_CPF_com_acesso(String cpfComAcesso) throws Throwable {
		ContratacaoArvNaCentral.cpfComAcesso(cpfComAcesso);
	}

	@Dado("^insira a senha \"([^\"]*)\" válida$")
	public void insira_uma_senha_valida(String cpfSenhaValida) throws Throwable {
		ContratacaoArvNaCentral.cpfSenhaValida(cpfSenhaValida);
	}

	@Dado("^eu clicar no botao logar$")
	public void eu_clicar_no_botao_logar() throws Throwable {
		ContratacaoArvNaCentral.clicarEntrar();
	}

	@Dado("^que eu esteja logado no portal ARV na central com CPF \"([^\"]*)\" e senha \"([^\"]*)\"$")
	public void que_eu_esteja_logado_no_portal_ARV_na_central(String cpfComAcesso, String cpfSenhaValida)
			throws Throwable {
		ContratacaoArvNaCentral.telaLogin();
		ContratacaoArvNaCentral.formularioLogin(cpfComAcesso, cpfSenhaValida);
		ContratacaoArvNaCentral.clicarEntrar();
		ContratacaoArvNaCentral.paginaInicial();
	}

	@Dado("^inserir um CNPJ \"([^\"]*)\" ARV disponível(.*)$")
	public void inserir_um_CNPJ_com_ou_sem_ARV(String cnpj) throws Throwable {
		ContratacaoArvNaCentral.consultaCnpj(cnpj);
	}

	@Dado("^inserir um CNPJ com ARV disponível \"([^\"]*)\"$")
	public void inserir_um_CNPJ_com_ARV_disponível(String cnpj) throws Throwable {
		cnpj = "existente";
		ContratacaoArvNaCentral.consultaCnpj(cnpj);
	}

	@Dado("^inserir um CNPJ sem ARV disponível \"([^\"]*)\"$")
	public void inserir_um_CNPJ_sem_ARV_disponível(String cnpj) throws Throwable {
		System.out.println("Consultando CNPJ sem saldo de ARV");
		cnpj = "existente";
		// ContratacaoArvNaCentral.CNPJ = "12259140000168";
		ContratacaoArvNaCentral.consultaCnpj(cnpj);
	}

	@Dado("^inserir um CNPJ inexistente na base \"([^\"]*)\"$")
	public void inserir_um_CNPJ_inexistente_na_base(String cnpjInexistente) throws Throwable {
		ContratacaoArvNaCentral.cnpjInexistenteInserir(cnpjInexistente);
	}

	@Dado("^inserir um CNPJ com mais de um EC cadastrado$")
	public void inserir_um_CNPJ_com_mais_de_um_EC_cadastrado() throws Throwable {
		String cnpj = "existente";
		ContratacaoArvNaCentral.consultaCnpj(cnpj);
	}

	@Dado("^inserir um CNPJ com mais de um domicilio bancario \"([^\"]*)\"$")
	public void inserir_um_CNPJ_com_mais_de_um_domicilio_bancario(String valor) throws Throwable {
		ContratacaoArvNaCentral.consultaCnpj(valor);
	}

	@Dado("^que inserir um CNPJ com mais de um EC com ARV disponível para contratacao \"([^\"]*)\"$")
	public void que_inserir_um_CNPJ_com_mais_de_um_EC_com_ARV_disponível_para_contratacao(String cnpj)
			throws Throwable {
		ContratacaoArvNaCentral.loginInicial();
		ContratacaoArvNaCentral.consultaCnpjContrataco(cnpj);
	}

	@Dado("^inserir um CNPJ com arv disponível para contratação \"([^\"]*)\"$")
	public void inserir_um_CNPJ_com_arv_disponível_para_contratação(String cnpj) throws Throwable {
		ContratacaoArvNaCentral.consultaCnpj(cnpj);
	}

	@Dado("^selecionar a opcao de contratacao total do ARV$")
	public void selecionar_a_opcao_de_contratacao_total_do_ARV() throws Throwable {
		ContratacaoArvNaCentral.selecionarOpcaoTodos();
	}

	@Dado("^prenencher o check de termo de aceite e clicar em gerar proposta$")
	public void prenencher_o_check_de_termo_de_aceite_e_clicar_em_gerar_proposta() throws Throwable {
		ContratacaoArvNaCentral.concordarTermos();
	}

	// ############################## Métodos When ##############################

	@Quando("^eu clicar no botão logar$")
	public void eu_clicar_no_botão_logar() throws Throwable {
		ContratacaoArvNaCentral.clicarEntrar();
		ContratacaoArvNaCentral.paginaInicial();
	}

	@Quando("^acessar o sistema de ARV na central$")
	public void acessar_o_sistema_de_ARV_na_central() throws Throwable {
		ContratacaoArvNaCentral.paginaInicial();
	}

	@Quando("^Clicar no botão SAIR no canto inferior esquedo da tela$")
	public void clicar_no_botão_SAIR_no_canto_inferior_esquedo_da_tela() throws Throwable {
		ContratacaoArvNaCentral.clicarSair();
	}

	@Quando("^clicar no botao Buscar$")
	public void clicar_no_botao_Buscar() throws Throwable {
		ContratacaoArvNaCentral.clicarBuscarCnpj();
	}

	@Quando("^aparecer a tela com o campo dos dados cadastrais e as condicoes de antecipacao total e parcial$")
	public void aparecer_a_tela_com_o_campo_dos_dados_cadastrais_e_as_condicoes_de_antecipacao_total_e_parcial()
			throws Throwable {
		ContratacaoArvNaCentral.validarDadosCadastrais();
	}

	@Quando("^clicar em gerar proposta$")
	public void clicar_em_gerar_proposta() throws Throwable {
		ContratacaoArvNaCentral.gerarProposta();
	}

	@Quando("^aparecer a tela com o campo dos dados cadastrais e as condicoes de antecipacao total e parcial e selecionar a opcao todos para antecipacao$")
	public void aparecer_a_tela_com_o_campo_dos_dados_cadastrais_e_as_condicoes_de_antecipacao_total_e_parcial_e_selecionar_a_opcao_todos_para_antecipacao()
			throws Throwable {
		System.out.println("Todos os ecs selecionados...");
		ContratacaoArvNaCentral.gerarProposta();
	}

	@Quando("^selecionar um EC para antecipacao$")
	public void selecionar_um_EC_para_antecipacao() throws Throwable {
		ContratacaoArvNaCentral.selecionarOpcaoIndividual();
	}

	@Quando("^aparecer a tela com o campo dos dados cadastrais e as condicoes de antecipacao total e parcial e selecionar um ec$")
	public void aparecer_a_tela_com_o_campo_dos_dados_cadastrais_e_as_condicoes_de_antecipacao_total_e_parcial_e_selecionar_um_ec()
			throws Throwable {
		ContratacaoArvNaCentral.selecionarOpcaoIndividual();
	}

	@Quando("^apresentar os dados do estabelecimentos com os respectivos domicilios bancarios agrupado por banco e o valor a ser pago para cada um$")
	public void apresentar_os_dados_do_estabelecimentos_com_os_respectivos_domicilios_bancarios_agrupado_por_banco_e_o_valor_a_ser_pago_para_cada_um()
			throws Throwable {
		ContratacaoArvNaCentral.validarDomicilioBancario();
		// validarValorBruto();
		ContratacaoArvNaCentral.validarValorLiquido();
		ContratacaoArvNaCentral.validarValorDesconto();
	}

	@Quando("^clicar no botão confirmar e contratar$")
	public void clicar_no_botão_confirmar_e_contratar() throws Throwable {
		ContratacaoArvNaCentral.confirmarContratar();
	}

	@Quando("^selecionar a opcao todos para antecipacao$")
	public void selecionar_a_opcao_todos_para_antecipacao() throws Throwable {
		System.out.println("Todas as opções de contratação selecionadas...");
	}

	@Quando("^selecionar um valor para antecipacao parcial e clicar em vizualizar valores disponiveis \"([^\"]*)\"$")
	public void selecionar_um_valor_para_antecipacao_parcial_e_clicar_em_vizualizar_valores_disponiveis(String valor)
			throws Throwable {
		ContratacaoArvNaCentral.clicarAlterarValor();
		ContratacaoArvNaCentral.clicarinserirValor();
		ContratacaoArvNaCentral.inserirValor(valor);
		ContratacaoArvNaCentral.clicarVisualizarProposta();
	}

	@Quando("^selecionar uma recorrencia \"([^\"]*)\"$")
	public void selecionar_uma_recorrencia_diaria(String recorrencia) throws Throwable {
		ContratacaoArvNaCentral.clicarAlterarRecorrencia();
		ContratacaoArvNaCentral.selecionarRecorrencia(recorrencia);
		ContratacaoArvNaCentral.clicarBtnDefinirrecebimento();
		ContratacaoArvNaCentral.gerarProposta();
	}

	// ############################## Métodos Then ##############################

	@Entao("^deve ser feito o logout da aplicacao$")
	public void deve_ser_feito_o_logout_da_aplicacao() throws Throwable {
		ContratacaoArvNaCentral.validaBtnSair();
	}

	@Entao("^devo visualizar no canto superior esquerdo da tela o Nome do usuário e a Saudacao$")
	public void devo_visualizar_no_canto_superior_esquerdo_da_tela_o_Nome_do_usuário_e_a_Saudacao() throws Throwable {
		ContratacaoArvNaCentral.validaMensagemBoasVindas();
	}

	@Entao("^deve aparecer \"([^\"]*)\"$")
	public void deve_aparecer(String validacao) throws Throwable {
		switch (validacao) {
		case "exibir uma mensagem que não há saldo disponível para antecipacao":
			ContratacaoArvNaCentral.validarMensagemArvNaoDisponivel();
			break;
		case "a tela com o campo dos dados cadastrais e as condicoes de antecipacao":
			ContratacaoArvNaCentral.validarDadosCadastrais();
			ContratacaoArvNaCentral.gerarProposta();
			break;
		default:
			break;
		}
	}

	/*
	 * @Entao("^deve aparecer a tela com o campo dos dados cadastrais e as condicoes de antecipacao total e parcial com os campos Nome do Primeiro EC, No do CNPJ, domicilio bancário, nome dos representante legal$"
	 * ) public void
	 * deve_aparecer_a_tela_com_o_campo_dos_dados_cadastrais_e_as_condicoes_de_antecipacao_total_e_parcial_com_os_campos_Nome_do_Primeiro_EC_No_do_CNPJ_domicilio_bancário_nome_dos_representante_legal
	 * () throws Throwable { ContratacaoArvNaCentral.validarDadosCadastrais();
	 * ContratacaoArvNaCentral.gerarProposta(); }
	 */

	/*
	 * @Entao("^exibir uma mensagem que não há saldo disponível para antecipacao$")
	 * public void
	 * exibir_uma_mensagem_que_não_há_saldo_disponível_para_antecipacao() throws
	 * Throwable { ContratacaoArvNaCentral.validarMensagemArvNaoDisponivel(); }
	 */
	
	@Entao("^deve exibir a mensagem \"([^\"]*)\"$")
	public void deve_exibir_a_mensagem(String arg1) throws Throwable {
		ContratacaoArvNaCentral.validaConsultaInexistente();
	}

	@Entao("^deve aparecer a tela com o campo dos dados cadastrais apresentando o Primeiro CNPJ e nome do EC da lista e os ECs relacionados com os dados para contratacao \"([^\"]*)\", \"([^\"]*)\"$")
	public void deve_aparecer_a_tela_com_o_campo_dos_dados_cadastrais_apresentando_o_Primeiro_CNPJ_e_nome_do_EC_da_lista_e_os_ECs_relacionados_com_os_dados_para_contratacao(
			String ec1, String ec2) throws Throwable {
		ContratacaoArvNaCentral.validaCnpjConsultadoMaisDeUmEc(ec1, ec2);
	}

	@Entao("^deve exibir a lista de CNPJ e domicilio bancário por bloco com seus respectivos ECs$")
	public void deve_exibir_a_lista_de_CNPJ_e_domicilio_bancário_por_bloco_com_seus_respectivos_ECs() throws Throwable {
		ContratacaoArvNaCentral.validarDomicilioBancario();
	}

	@Entao("^deve ser apresentado a tela de confirmaçao com o valor total da contratacao$")
	public void deve_ser_apresentado_a_tela_de_confirmaçao_com_o_valor_total_da_contratacao() throws Throwable {
		ContratacaoArvNaCentral.validarModal();
		ContratacaoArvNaCentral.clicarCancelarContratacao();
	}

	@Entao("^deve apresentar a tela de Antecipação realizada com sucesso com a msg todos os códigos foram antecipados e o botão fechar$")
	public void deve_apresentar_a_tela_de_Antecipação_realizada_com_sucesso_com_a_msg_todos_os_códigos_foram_antecipados_e_o_botão_fechar()
			throws Throwable {
		ContratacaoArvNaCentral.validarContratacaoSucesso();
	}

	@Entao("^deve apresentar a tela de antecipe suas vendas com o valor solicitado$")
	public void deve_apresentar_a_tela_de_antecipe_suas_vendas_com_o_valor_solicitado() throws Throwable {
		ContratacaoArvNaCentral.validarAlterarValorModal();
	}

	@Entao("^deve alterar a recorrencia de inativa para  \"([^\"]*)\"$")
	public void deve_alterar_a_recorrencia_de_inativa_para(String recorrencia) throws Throwable {
		ContratacaoArvNaCentral.validarSolicitacaoDeRecorrecia(recorrencia);
	}

}
