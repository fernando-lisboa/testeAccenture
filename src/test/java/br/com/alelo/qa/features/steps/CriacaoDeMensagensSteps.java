///**
//  * Autor: Matheus Lisboa
// * Empresa: Taking
// * Data: 10/03/2020
// * Caminho: Portal Estabelecimento Comercial  --> WebAdmin
// */

package br.com.alelo.qa.features.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.CriacaoDeMensagensActions;
import br.com.alelo.qa.web.actions.LoginActions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;

public class CriacaoDeMensagensSteps extends ParentSteps {

	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	LoginActions login;
	CriacaoDeMensagensActions page;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();

	@Dado("^eu clique no botao de mensagem$")
	public void eu_clique_no_botao_de_mensagem() throws Throwable {
		page = new CriacaoDeMensagensActions(webdriver);
		page.criarMensagem();
	}

	@Dado("^e clicar no botao adicionar$")
	public void e_clicar_no_botao_adicionar() throws Throwable {
		page.adicionarMensagem();
	}

	@Dado("^quando eu preencher o formulario de mensagens e clicar em adicionar, \"([^\"]*)\",\"([^\"]*)\"$")
	public void quando_eu_preencher_o_formulario_de_mensagens_e_clicar_em_adicionar(String tipoMensagem,
			String tipoEnvio) throws Throwable {
		Thread.sleep(2000);
		page.preencherMensagem(tipoMensagem, tipoEnvio);

	}

	@Entao("^deve ser criada uma nova mensagem com os dados informados$")
	public void deve_ser_criada_uma_nova_mensagem_com_os_dados_informados() throws Throwable {
		//TODO IMPLEMENTAR ASSERT PARA CRIAÇAO DE MSG
		//page.validarExibicaoMensagemNoPortal();
	}

	@Dado("^e clicar no botao editar mensagem$")
	public void e_clicar_no_botao_editar_mensagem() throws Throwable {
	}

	@Dado("^preencher as datas para editar a mensagem$")
	public void preencher_as_datas_para_editar_a_mensagem() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^então a vigencia da mensagem deve ficar de acordo com a alteracao feita$")
	public void então_a_vigencia_da_mensagem_deve_ficar_de_acordo_com_a_alteracao_feita() throws Throwable {
	}

	////////////////////////////////////
	// Editar Mensagem
	////////////////////////////////////

	@Dado("^eu clique no menu mensagem$")
	public void eu_clique_no_menu_mensagem() throws Throwable {
		page = new CriacaoDeMensagensActions(webdriver);
		System.out.println("Abrindo Menu Mensagem");
	}

	
	@Dado("^clicar no icone de editar$")
	public void clicar_no_icone_de_editar() throws Throwable {
		page.editarMensagem();
	}

	@Entao("^deve ser alterado a data final da postagem$")
	public void deve_ser_alterado_a_data_final_da_postagem() throws Throwable {
		page.validarEdicao();
	}

	///////////////////////////
	// Exclusao de Mensagem
	//////////////////////////

	@Dado("^eu clique na aba de mensagem$")
	public void eu_clique_na_aba_de_mensagem() throws Throwable {
		page = new CriacaoDeMensagensActions(webdriver);
		System.out.println("Abrindo Menu Mensagem");
		page.criarMensagem();
	}

	@Dado("^selecionar o status e filtrar e clicar no icone de excluir, \"([^\"]*)\"$")
	public void selecionar_o_status_e_filtrar_e_clicar_no_icone_de_excluir(String status) throws Throwable {
		/*
		 * Ter que clicar no botao status_notification selecionar o status e clicar em
		 * filtar
		 */
		page = new CriacaoDeMensagensActions(webdriver);
		page.alterarStatusMensagem(status);
		page.excluirMensagem();
	}

	@Dado("^deve ser apresentado a mensagem de confirmacao de exclusao$")
	public void deve_ser_apresentado_a_mensagem_de_confirmacao_de_exclusao() throws Throwable {
		page.validarMensagemDeExclusao();
	}
	
	//indicador notificacao
	
	@Dado("^que eu tenha um usuário com notificações$")
	public void que_eu_tenha_um_usuário_com_notificações() throws Throwable {
		 System.out.println("Logado com o usuario que contem a mensagem ");
	}
	
	@Então("^devo validar que o icone de notificação está visivel com a quantidade de notificacoes disponiveis$")
	public void devo_validar_que_oicone_de_notificação_está_visivel_com_a_quantidade_de_notificacoes_disponiveis() throws Throwable {
		page = new CriacaoDeMensagensActions(webdriver);
		page.iconNotificationId();
		
	}
	
	
	
	
	
}
