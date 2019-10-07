package br.com.alelo.qa.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.alelo.qa.web.support.PageObject;

public class LoginPage extends PageObject{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//Elementos
	@FindBy(xpath="//input[@id='cpf']")
	protected WebElement campo_cpf;
	
	@FindBy(id="dia")
	protected WebElement campo_nasc_dia;
	
	@FindBy(id="mes")
	public WebElement campo_nasc_mes;
	
	@FindBy(id="ano")
	protected  WebElement campo_nasc_ano;
	
	@FindBy(id="senha")
	protected  WebElement campo_senha;
	
	@FindBy(id="txt_answer")
	protected  WebElement campo_recaptcha;
	
	@FindBy(xpath="//input[@id='avancar_passo_cnpj']")
	protected  WebElement btn_ok;
	
	@FindBy(id="mensagem-erros")
	protected WebElement menssagem_erro;
	
	@FindBy(id="avancarPrimeiroAcesso")
	protected  WebElement btnPrimeiroAcesso;
	
	@FindBy(xpath="//a[@id='avancarEsqueciSenha ']")
	protected WebElement btnEsqueciMinhaSenha;


}
