package br.com.alelo.qa.web.actions;

import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.FacaSeuPedidoPage;

public class FacaSeuPedidoActions extends FacaSeuPedidoPage{
	
	public void clicarEmNovoPedido(){
		waitForElementPageToBeClickable(btnNovoPedido);
		this.btnNovoPedido.click();
	}
	
	public void clicarEmProximaEtapa(){
		waitForElementPageToBeClickable(btnProximaEtapa);
		this.btnProximaEtapa.click();
	}
	
	public void selecionarContrato(String contrato) {
		this.encontraElementoPorParteDoTexto(contrato).click();
	}
	
	public void clicarEmCopiarUmPedidoRecente(){
		this.btnCopiarUmPedidoRecente.click();
	}
	
	public void selecionePedidoRecente(String idPedido){
		this.slcPedidosRecentes.click();
		this.encontraElementoPorParteDoTexto(idPedido).click();
		
	}

	public FacaSeuPedidoActions(WebDriver driver) {
		super(driver);
	}

}
