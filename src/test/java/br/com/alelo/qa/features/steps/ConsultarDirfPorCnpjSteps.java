
/**
  * Autor: Fernando Lisboa
 * Empresa: Taking
 * Data: 12/12/2019
 * Caminho: Portal Estabelecimento Comercial  --> Dirf
 */
package br.com.alelo.qa.features.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.ConsultarDirfPorCnpjActions;
import br.com.alelo.qa.web.actions.OfertaAtivaActions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ConsultarDirfPorCnpjSteps extends ParentSteps {
	
	
	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	OfertaAtivaActions oferta;
	ConsultarDirfPorCnpjActions dirf;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();
	
	@Dado("^eu clique no link de informacoes$")
	public void eu_clique_no_link_de_informacoes() throws Throwable {
		dirf.telaDocumentos();
	}

	@Dado("^e visualizar a lista de anos disponiveis$")
	public void e_visualizar_a_lista_de_anos_disponiveis() throws Throwable {
		dirf.validarHomepage();
		
	}

	@Quando("^clicar no botao baixar arquivo \"([^\"]*)\"$")
	public void clicar_no_botao_baixar_arquivo(int anoReferencia) throws Throwable {
		
		dirf.abrirPdf(anoReferencia);
	}

	@Entao("^o arquivo deve ser baixado no local informado$")
	public void o_arquivo_deve_ser_baixado_no_local_informado() throws Throwable {
		
		dirf.baixarPdf();
	}
}
