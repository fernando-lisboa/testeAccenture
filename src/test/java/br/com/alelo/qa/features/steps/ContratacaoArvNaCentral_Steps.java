package br.com.alelo.qa.features.steps;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.ContratacaoArvNaCentral_Actions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ContratacaoArvNaCentral_Steps extends ParentSteps {

	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();
	ContratacaoArvNaCentral_Actions actions;
	ContratacaoArvNaCentral_Actions login;

	@Dado("^que estou logado no Portal ARV na Central \"([^\"]*)\", \"([^\"]*)\"$")
	public void que_estou_logado_no_Portal_ARV_na_Central(String user, String password) throws Throwable {
		webdriver.get("https://meuestabelecimento-frontend-arv-central-hml.siteteste.inf.br/");
		login = new ContratacaoArvNaCentral_Actions(webdriver);
		login.loginArvNaCentral(user, password);
		
	}

	@Entao("^devo visualizar no canto superior esquerdo da tela o Nome do usuário e a Saudacao$")
	public void devo_visualizar_no_canto_superior_esquerdo_da_tela_o_Nome_do_usuário_e_a_Saudacao() throws Throwable {
		login = new ContratacaoArvNaCentral_Actions(webdriver);
		login.validaMensagemBoasVindas();
	}
//CONSULTA CNPJ 
	
	@Quando("^inserir um CNPJ no campo de pesquisa e clicar em Buscar \"([^\"]*)\"$")
	public void inserir_um_CNPJ_no_campo_de_pesquisa_e_clicar_em_Buscar(String cnpj) throws Throwable {
		actions = new ContratacaoArvNaCentral_Actions(webdriver);
		actions.inserirCnpj(cnpj);
		actions.clicarBuscarCnpj();
	}

	@Entao("^deve apresentar o cenario de validacao \"([^\"]*)\"$")
	public void deve_apresentar_o_cenario_de_valicao(String validacao) throws Throwable {
	    actions.validarMensagemArvNaoDisponivel();
//	    Corrigir o Assert 
	}

//CONSULTA COM MAIS DE UM EC DISPONIVEL
	
	@Quando("^inserir um CNPJ com mais de um EC cadastrado e clicar no botao Buscar \"([^\"]*)\"$")
	public void inserir_um_CNPJ_com_mais_de_um_EC_cadastrado_e_clicar_no_botao_Buscar(String cnpj) throws Throwable {
		actions = new ContratacaoArvNaCentral_Actions(webdriver);
		actions.inserirCnpj(cnpj);
		actions.clicarBuscarCnpj(); 
	}

	@Entao("^deve aparecer a tela com o campo dos dados cadastrais apresentando os ECs relacionados com os dados para contratacao \"([^\"]*)\", \"([^\"]*)\"$")
	public void deve_aparecer_a_tela_com_o_campo_dos_dados_cadastrais_apresentando_os_ECs_relacionados_com_os_dados_para_contratacao(String ec1, String ec2) throws Throwable {
		actions.validaCnpjConsultadoMaisDeUmEc(ec1, ec2);
		actions.validarDadosCadastrais();
	}

//	SIMULACAO DE CONTRATACAO TOTAL COM ARV
	
	@Quando("^inserir um CNPJ com mais de um EC com ARV disponível para contratacao \"([^\"]*)\"$")
	public void inserir_um_CNPJ_com_mais_de_um_EC_com_ARV_disponível_para_contratacao(String cnpj) throws Throwable {
		actions = new ContratacaoArvNaCentral_Actions(webdriver);
		actions.inserirCnpj(cnpj);
		actions.clicarBuscarCnpj();
	}

	@Quando("^selecionar a opcao todos para antecipacao$")
	public void selecionar_a_opcao_todos_para_antecipacao() throws Throwable {
	    actions.selecionarOpcaoTodos();

	}

	@Entao("^deve ser apresentado a tela de confirmaçao com o valor total da contratacao$")
	public void deve_ser_apresentado_a_tela_de_confirmaçao_com_o_valor_total_da_contratacao() throws Throwable {
//		actions.validarSimulacaoSucesso();
	}
	
//	SIMULACAO DE CONTRATACAO DE 1 EC COM ARV DISPONIVEL

	@Quando("^colocar um CNPJ com mais de um EC com ARV disponível para contratacao e clicar em gerar proposta \"([^\"]*)\"$")
	public void colocar_um_CNPJ_com_mais_de_um_EC_com_ARV_disponível_para_contratacao_e_clicar_em_gerar_proposta(String cnpj) throws Throwable {
		actions = new ContratacaoArvNaCentral_Actions(webdriver);
		actions.inserirCnpj(cnpj);
		actions.clicarBuscarCnpj();
	}

	@Entao("^deve apresentar a tela de confirmaçao com o valor total da contratacao$")
	public void deve_apresentar_a_tela_de_confirmaçao_com_o_valor_total_da_contratacao() throws Throwable {
		actions.gerarProposta();
//	    TODO Finalizar com Assert da tela de confirmacao //
	}


//Simulaçao de alteracao parcial ARV
	
	@Quando("^Inserir um CNPJ com mais de um EC com ARV disponível para contratacao \"([^\"]*)\"$")
	public void inserir_um_CNPJ_com_mais_de_um_EC_com_ARV_disponível_para_contratacao1(String cnpj) throws Throwable {
		actions = new ContratacaoArvNaCentral_Actions(webdriver);
		actions.inserirCnpj(cnpj);
	    actions.clicarBuscarCnpj();
	}

	@Quando("^selecionar um valor para antecipacao parcial e clicar em vizualizar valores disponiveis \"([^\"]*)\"$")
	public void selecionar_um_valor_para_antecipacao_parcial_e_clicar_em_vizualizar_valores_disponiveis(String valor) throws Throwable {
	   actions.clicarAlterarValor();
	   actions.clicarinserirValor(valor);
	   actions.clicarVisualizarProposta();
	   
	}
	
	@Entao("^deve apresentar a tela de antecipe suas vendas com o valor solicitado$")
	public void deve_apresentar_a_tela_de_antecipe_suas_vendas_com_o_valor_solicitado() throws Throwable {
		actions.clicarCalcValorLiquido();
	}

//	Simular Contratacao de ARV Recorrencia
	
	@Quando("^inserir um cnpj com mais de um EC com ARV disponível para contratacao \"([^\"]*)\"$")
	public void inserir_um_cnpj_com_mais_de_um_EC_com_ARV_disponível_para_contratacao(String cnpj) throws Throwable {
	   actions = new ContratacaoArvNaCentral_Actions(webdriver);
	   actions.inserirCnpj(cnpj);
	    actions.clicarBuscarCnpj();
	    
	}

	@Quando("^selecionar uma recorrencia \"([^\"]*)\"$")
	public void selecionar_uma_recorrencia(String recorrencia) throws Throwable {
		actions.clicarAlterarRecorrencia();
	}

	@Entao("^deve alterar a recorrencia de inativa para  \"([^\"]*)\"$")
	public void deve_alterar_a_recorrencia_de_inativa_para(String confirmacao) throws Throwable {
	   actions.selecionarRecorrencia(confirmacao);
		actions.clicarBtnDefinirrecebimento();

	}

}