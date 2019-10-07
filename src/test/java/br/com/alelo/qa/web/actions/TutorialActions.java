package br.com.alelo.qa.web.actions;

import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.ConfirmeDadosContratantePage;
import br.com.alelo.qa.web.page.ConfirmeEnderecoEntregaContratantePage;
import br.com.alelo.qa.web.page.SejaBemVindoAleloPage;
import br.com.alelo.qa.web.support.PageObject;

public class TutorialActions extends PageObject{
	
	SejaBemVindoAleloPage primeiraTela;
	ConfirmeDadosContratantePage segundaTela;
	ConfirmeEnderecoEntregaContratantePage terceiraTela;
	
	public TutorialActions(WebDriver driver) {
			super(driver);
			primeiraTela  = new SejaBemVindoAleloPage(driver);
			segundaTela = new ConfirmeDadosContratantePage(driver);
			terceiraTela = new ConfirmeEnderecoEntregaContratantePage(driver);
	}
	
	public void primeiroPasso() {
		primeiraTela.btnComecar.click();
	}
	
	
	
	

}
