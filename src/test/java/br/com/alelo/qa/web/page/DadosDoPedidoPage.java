package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class DadosDoPedidoPage extends PageObject{
	
	@FindBy(css="input[id=dp1568737590801]")
	protected WebElement cmpDataDeCredito;
	
	@FindBy(xpath="//div[@class='grid-unit-2-5']//img")
	protected WebElement btnCalendario;
	
	@FindBy(xpath="//span[@class='ui-icon ui-icon-circle-triangle-e']")
	protected WebElement btnProximoCalendario;
	
	@FindBy(xpath="//span[@class='ui-datepicker-month']")
	protected WebElement lblMesCalendario;
	
	@FindBy(xpath="//span[@class='ui-datepicker-year']")
	protected WebElement lblAnoCalendario;
	
	@FindBy(xpath="//tr[4]//td[4]")
	protected WebElement btnDiaRandon;
	
	
	@FindBy(xpath="//div[@class='container-botao-alterar-pedido']//input[@class='botao botao--verde']")
	protected WebElement btnAlterarPedido;
	
	@FindBy(xpath="//div[@class='tabs-botao']//input[@id='id_botao_avancar_pedidos']")
	protected WebElement btnProximaEtapa;
	
	

	public DadosDoPedidoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
