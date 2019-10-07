package br.com.alelo.qa.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class CadastroNovoColaboradorPage extends PageObject {
	
	@FindBy(xpath="//input[@id='idBtnAddColab']")
	protected WebElement btnNovoColaborador;
	
	@FindBy(xpath="//input[@id='cpf']")
	protected WebElement cmpCpfNovoColaborador;
	
	@FindBy(xpath="//div[@class='grid-unit-4-7 form-field']//input[@class='input input--block']")
	protected WebElement cmpNomeNovoColaborador;

	@FindBy(xpath="//input[@id='iptDataNascimento']")
	protected WebElement cmpDataNascimentoNovoColaborador;

	@FindBy(xpath="//input[@id='postoTrabalho']")
	protected WebElement optTipoLocalEntregaPostoDeTrabalhoNovoColaborador;
	
	@FindBy(xpath="//input[@id='lblFilial']")
	protected WebElement optTipoLocalEntregaFilialNovoColaborador;
	
	@FindBy(xpath="//select[@id='sltLocais']")
	protected WebElement slcLocalDeEntrega;	

	@FindBy(xpath="//div[@class='container-select-geral']")
	protected WebElement slcLocaisDeEntregaNovoColaborador;
	
	@FindBy(xpath="//button[@class='botao botao--verde tabs-botao-avancar']")
	protected WebElement btnSalvar;
	
	protected WebElement optLocalDeEntrega(String text){
		return webdriver.findElement(By.xpath("//select[@id='sltLocais']//option[contains(text(),'"+text+"')]"));
	}

	public CadastroNovoColaboradorPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
