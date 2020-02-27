package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class RecebimentosPage extends PageObject{

	
	@FindBy(id = "cnpj")
	protected WebElement opcao_select;

	@FindBy(id = "menuRecebiveis")
	protected WebElement menuRecebimentos;

	@FindBy(id = "scheduleTitleId")
	protected WebElement labelTelaRecebimentos;
	public String textLabelTelaRecebimentos = "Recebimentos";

	@FindBy(id = "scheduleTopBarTotalReceivedValue")
	protected WebElement valorrecebido;

	@FindBy(id = "scheduleTopBarTotalValueToReceive")
	protected WebElement valorAReceber;
	
	@FindBy(id = "scheduleTopBarNextImage")
	protected WebElement avancarMes;

	@FindBy(id = "scheduleTopBarPreviousImage")
	protected WebElement retrocederMes;

	@FindBy(id = "scheduleTopBarMonthSelected")
	protected WebElement mesReferencia;
	
	@FindBy(xpath = "//b[contains(.,'• 28.339.982/0001-60 - 2000496258')]")
	protected WebElement ecRecebiveis_1;
	
	@FindBy(xpath = "//b[contains(.,'• 12.259.140/0001-68 - 1015000255')]")
	protected WebElement ecRecebiveis_2;
	
	@FindBy(id = "imageLoader")
	protected WebElement loader;
	
	public RecebimentosPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
