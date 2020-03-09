///**
//  * Autor: Matheus Lisboa
// * Empresa: Taking
// * Data: 09/03/2020
// * Caminho: Portal Estabelecimento Comercial  --> WebAdmin
// */

package br.com.alelo.qa.features.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.CriacaoDeMensagensActions;
import br.com.alelo.qa.web.actions.HomeActions;
import br.com.alelo.qa.web.actions.LoginActions;
import br.com.alelo.qa.web.actions.OfertaAtivaActions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;

public class CriacaoDeMensagensSteps extends ParentSteps {

	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	LoginActions login;
	CriacaoDeMensagensActions criacaoDeMensagens;
	OfertaAtivaActions oferta;
	HomeActions home;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();


	@Dado("^eu clique no botao de mensagem$")
	public void eu_clique_no_botao_de_mensagem() throws Throwable {
		criacaoDeMensagens = new CriacaoDeMensagensActions(webdriver);
		criacaoDeMensagens.criarMensagem();
	}

	@Dado("^e clicar no botao adicionar$")
	public void e_clicar_no_botao_adicionar() throws Throwable {
		criacaoDeMensagens.adicionarMensagem();
	}

	@Dado("^quando eu preencher o formulario de mensagens e clicar em adicionar, \"([^\"]*)\",\"([^\"]*)\"$")
	public void quando_eu_preencher_o_formulario_de_mensagens_e_clicar_em_adicionar(String tipoMensagem,
			String tipoEnvio) throws Throwable {
		criacaoDeMensagens.preencherMensagem(tipoMensagem, tipoEnvio);

	}

	@Entao("^deve ser criada uma nova mensagem com os dados informados$")
	public void deve_ser_criada_uma_nova_mensagem_com_os_dados_informados() throws Throwable {
		criacaoDeMensagens.validarExibicaoMensagemNoPortal();
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

}
