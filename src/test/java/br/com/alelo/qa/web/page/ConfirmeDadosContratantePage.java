package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class ConfirmeDadosContratantePage extends PageObject {
	
	@FindBy(xpath="//input[@class='botao botao--verde']")
	public WebElement btnContinuar;
	
	
	@FindBy(xpath="//body//input[3]")
	public WebElement btnAlterar;

	public ConfirmeDadosContratantePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
