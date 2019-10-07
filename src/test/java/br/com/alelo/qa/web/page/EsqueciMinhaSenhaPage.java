package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class EsqueciMinhaSenhaPage extends PageObject{
	
	@FindBy(id="cpf")
	protected WebElement txtCpf;
	
	@FindBy(id="dia")
	protected WebElement txtDia;
	
	@FindBy(id="mes")
	protected WebElement txtMes;
	
	@FindBy(id="ano")
	protected WebElement txtAno;
	
	@FindBy(id="cnpj")
	protected WebElement txtCnpj;
	
	@FindBy(id="txt_answer")
	protected WebElement txtCaptcha;
	
	@FindBy(xpath="//input[@id='avancarEsqueciSenhaMensagem']")
	protected WebElement btnContinuar;
	
	@FindBy(xpath="//form[@class='formulario-dados senha']//input[@id='voltar-login']")
	protected WebElement btnVoltar;
	
	@FindBy(xpath="//small[contains(text(),'Um ou mais dados incorretos ou inválidos')]")
	protected WebElement msgDadosInvalidos;

	public EsqueciMinhaSenhaPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

}
