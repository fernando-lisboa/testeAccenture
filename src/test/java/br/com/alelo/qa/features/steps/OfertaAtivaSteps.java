/**
  * Autor: Fernando Lisboa
 * Empresa: Taking
 * Data: 12/12/2019
 * Caminho: Portal Estabelecimento Comercial  --> OfertaAtiva
 */

package br.com.alelo.qa.features.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.HomeActions;
import br.com.alelo.qa.web.actions.OfertaAtivaActions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class OfertaAtivaSteps extends ParentSteps {

	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	OfertaAtivaActions oferta;
	HomeActions home;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();

	@Dado("^que estou  com CNPJ elegível  \"([^\"]*)\"$")
	public void que_estou_com_CNPJ_elegível(String cnpj) throws Throwable {
		
		
		oferta = new OfertaAtivaActions(webdriver);
		Thread.sleep(3000);
		oferta.preencherCnpj(cnpj);

	}

	@Quando("^for direcionado para a tela do resumo$")
	public void for_direcionado_para_a_tela_do_resumo() throws Throwable {
		
		oferta.validarDetalheDaContratacao();

	}

	@Quando("^selecionar outro valor e outra quantidade de parcelas$")
	public void selecionar_outro_valor_e_outra_quantidade_de_parcelas()  throws Throwable {

		oferta.alterarValor();
		oferta.simularNovamente();
	}
	
	
	@Entao("^o valor total deve ser alterado$")
	public void o_valor_total_deve_ser_alterado() throws Throwable {
	   
		oferta.validarNovaSimulacao();
		Thread.sleep(3000);
		oferta.sair();
	}
	
	

	@Quando("^clico na opção saiba mais$")
	public void clico_na_opção() throws Throwable {

		oferta.alterarCNPJ();
		Thread.sleep(3000);
		oferta.clicarSaibaMais();

	}

	@Então("^devo ser direcionado para a tela do resumo$")
	public void devo_ser_direcionado_para_a_tela_do_resumo() throws Throwable {

		oferta.validarDetalheDaContratacao();
		Thread.sleep(3000);
		oferta.sair();
	}
	
	@Quando("^clicar na opcao alterar valor e voltar sem alterar$")
	public void clicar_na_opcao_alterar_valor_e_voltar_sem_alterar() throws Throwable {
	   
		oferta.alterarValor();
		oferta.voltarSemAlterar();
	}

	@Entao("^os dados oferecidos nao devem ser alterados$")
	public void os_dados_oferecidos_nao_devem_ser_alterados() throws Throwable {
	    
		oferta.validarQueNaoAlterouValorAoVoltar();
		Thread.sleep(3000);
		oferta.sair();
		
	}

}
