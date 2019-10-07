package br.com.alelo.qa.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.alelo.qa.web.support.PageObject;

public class HomePage extends PageObject {
	
private String path = "content/pesim/home.html";
	
	//Elementos da tela
	@FindBy(xpath="//p[@id='bem-vindo']")
	protected WebElement bemvindo;
	
	 
	
	public HomePage(WebDriver driver) {
		super(driver);
		waitForElementPageToLoad(bemvindo);
	}
	
}
