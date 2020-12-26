package br.com.desafio.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.desafio.qa.web.support.PageObject;

public class SelectPricePage extends PageObject {
	
	public SelectPricePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(id = "selectgold")
	public WebElement selectFieldGold;
	
	@FindBy(id = "nextsendquote")
	public WebElement btnNextsendquote;

}
