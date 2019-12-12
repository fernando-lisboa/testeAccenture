package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class LoginPage extends PageObject{
	
	
	@FindBy(id="login-cpf-input")
	protected WebElement userLogin;
	
	@FindBy(id="formInlinePassword")
	protected WebElement password;
	
	@FindBy(id = "imageLoader")
	protected WebElement loader;
	
	@FindBy(id="AccountLoginBtnSubmitHandler")
	protected WebElement btnEntrar;
	
	@FindBy(id="panelPageCnpjContainerIndicator")
	protected WebElement painelInicial;
	
	@FindBy(xpath = "//input[@role='combobox']")
	protected WebElement comboCnpj;
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Veja mais Detalhes')]")
	protected WebElement resumo;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
}
