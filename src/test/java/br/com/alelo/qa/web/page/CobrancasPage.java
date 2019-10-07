package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class CobrancasPage extends PageObject{
	
	public CobrancasPage(WebDriver driver) {
		super(driver);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//waitForElementPageToLoad("dp1566306011440");
	}

	@FindBy(xpath="//button[contains(text(),'Buscar')]")
	protected WebElement btnBuscar;
	
	@FindBy(xpath="//select[@class='select fixSelectOverflow']")
	protected WebElement cmbProdutoContrato;
	
	@FindBy(xpath="//div[@class='grid componente-grid-tabela__barra-busca']//div[2]//input[1]")
	protected WebElement cFilial;

	@FindBy(xpath="//div[@class='grid componente-grid-tabela__barra-busca']//div[3]//input[1]")
	protected WebElement cPedido;
	
	@FindBy(xpath="//input[@id='dp1566306011440']")
	protected WebElement cMesEmissao;
	
	@FindBy(xpath="//input[@id='dp1566306011441']")
	protected WebElement cMesPagamento;
	
	@FindBy(xpath="//select[@class='select select--block']")
	protected WebElement cmbSituacao;
	
	@FindBy(xpath="//b[contains(text(),'Voltar ao topo')]")
	protected WebElement btnVoltarAoTopo;
	

}
