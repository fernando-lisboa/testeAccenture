package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class HomePage extends PageObject {
	private String path = "content/pesim/home.html";

	// Elementos da tela
	@FindBy(id = "panelTitleId")
	protected WebElement bemvindo;

	@FindBy(id = "imageLoader")
	protected WebElement loader;

	public HomePage(WebDriver driver) {
		super(driver);
		waitForElementPageToLoad(bemvindo);
	}
}
