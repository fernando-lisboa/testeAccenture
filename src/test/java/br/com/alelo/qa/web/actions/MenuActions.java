package br.com.alelo.qa.web.actions;

import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.sections.MenuSection;

public class MenuActions extends MenuSection{

	public MenuActions(WebDriver driver) {
		super(driver);
	}
	
	public void acessarFinanceiroCobranca(){
		waitForElementPageToBeClickable(menuFinanceiro);
		this.menuFinanceiro.click();
		waitForElementPageToBeClickable(menuFinanceiroCobranca);
		this.menuFinanceiroCobranca.click();
	}
	
	public void acessarNovoPedido(){
		waitForElementPageToBeClickable(menuPedidoDeBeneficios);
		this.menuPedidoDeBeneficios.click();
		waitForElementPageToBeClickable(menuPedidoDeBeneficiosFacaSeuPedido);
		this.menuPedidoDeBeneficiosFacaSeuPedido.click();
	}

}
