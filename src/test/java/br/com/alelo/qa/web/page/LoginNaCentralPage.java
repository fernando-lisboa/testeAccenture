package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class LoginNaCentralPage extends PageObject {

	@FindBy(id = "inputLogin")
	protected WebElement inputLogin;

	@FindBy(id = "inputPassord")
	protected WebElement inputPassord;

	@FindBy(className = "btn-login btn btn-link")
	protected WebElement btnLogar;

	public LoginNaCentralPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
