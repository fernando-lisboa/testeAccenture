package br.com.alelo.qa.features.steps;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.FacaSeuPedidoActions;
import br.com.alelo.qa.web.actions.TermoTMEActions;
import br.com.alelo.qa.web.sections.TermoTMESection;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;

public class TermoDeAceiteTmeSteps extends ParentSteps {
	
	FacaSeuPedidoActions facaSeuPedidoActions;
	TermoTMEActions termoTME;

	@Dado("^realizo o aceite do termo MTE$")
	public void realizo_o_aceite_do_termo_MTE() throws Throwable {
		termoTME = new TermoTMEActions(webdriver);
		termoTME.aceitarTermo();
	}

}
