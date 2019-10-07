package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class SejaBemVindoAleloPage extends PageObject {
	
	@FindBy(xpath="//button[@class='botao botao--verde']")
	public WebElement btnComecar;

	
	public SejaBemVindoAleloPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

}
