package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class ConfirmeEnderecoEntregaContratantePage extends PageObject {
	
	@FindBy(xpath="//button[@id='botaoContinuar']")
	public WebElement btnProximaEtapa;
	
	
	@FindBy(xpath="//button[@id='botaoNovoLocal']")
	public WebElement btnNovoLocal;
	
	@FindBy(xpath="//div[@class='modal modal-usuario jqm-init ui-draggable modal-visible']//input[@id='cancelar-pedido']")
	public WebElement btnModalSim;
	
	@FindBy(xpath="//div[@class='modal modal-usuario jqm-init ui-draggable modal-visible']//input[@id='botaoModalVoltar']")
	public WebElement btnModalVoltar;

	public ConfirmeEnderecoEntregaContratantePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
