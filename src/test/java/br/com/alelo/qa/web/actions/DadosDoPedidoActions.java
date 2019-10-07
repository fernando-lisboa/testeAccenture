package br.com.alelo.qa.web.actions;

import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.DadosDoPedidoPage;

public class DadosDoPedidoActions extends DadosDoPedidoPage{
	
	public String alterarDataCredito(String novaData){
		waitForElementPageToLoad(btnCalendario);
		this.btnCalendario.click();
		String[] arrData = novaData.split("/");
		while(!arrData[1].equals(this.lblAnoCalendario.getText())){
			btnProximoCalendario.click();
		}
		while (!arrData[0].equals(this.lblMesCalendario.getText())) {
			btnProximoCalendario.click();
		}
		btnDiaRandon.click();
		return this.cmpDataDeCredito.getText();
		
	}
	
	public void irParaResumoDoPedido(){
		this.btnProximaEtapa.click();
	}
	public DadosDoPedidoActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
}
