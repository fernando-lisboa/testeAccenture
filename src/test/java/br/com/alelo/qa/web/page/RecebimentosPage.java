package br.com.alelo.qa.web.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class RecebimentosPage extends PageObject {

	@FindBy(id = "cnpj")
	protected WebElement opcao_select;

	@FindBy(id = "menuRecebiveis")
	protected WebElement menuRecebimentos;

	@FindBy(id = "scheduleTitleId")
	protected WebElement labelTelaRecebimentos;
	public String textLabelTelaRecebimentos = "Recebimentos";

	@FindBy(id = "scheduleTopBarTotalReceivedValue")
	protected WebElement valorRecebido;

	@FindBy(id = "scheduleTopBarTotalValueToReceive")
	protected WebElement valorAReceber;

	@FindBy(id = "scheduleTopBarNextImage")
	protected WebElement avancarMes;

	@FindBy(css = ".totalValue")
	protected List<WebElement> listAReceber;

	@FindBy(xpath = "//*[@id='ScheDay_totalValue']/div[2]/span[2]/text()")
	protected List<WebElement> listAReceber2;

	@FindBy(id = "scheduleTopBarPreviousImage") 
	protected WebElement retrocederMes;

	@FindBy(id = "scheduleTopBarTotalReceivedValue")
	protected WebElement mesReferencia;

	@FindBy(xpath = "//*[@id='datetimmecustomDiv']/div/input")
	protected WebElement mesExibido;

	@FindBy(xpath = "//b[contains(.,'• 28.339.982/0001-60 - 2000496258')]")
	protected WebElement ecRecebiveis_1;

	@FindBy(xpath = "//b[contains(.,'• 12.259.140/0001-68 - 1015000255')]")
	protected WebElement ecRecebiveis_2;

	@FindBy(id = "loaderId")
	protected WebElement loader;

	@FindBy(id = "ScheDay_today")
	protected WebElement elementoHoje;

	@FindBy(id = "product")
	protected WebElement campoVouReceber;

	@FindBy(id = "product")
	protected WebElement comboProduto;

	@FindBy(xpath = "//input[@value='ALELO ALIMENTACAO']")
	protected WebElement produtoAlimentacao;

	@FindBy(xpath = "//input[@value='ALELO REFEICAO']")
	protected WebElement produtoRefeicao;

	@FindBy(xpath = "//input[@value='TODOS']")
	protected WebElement produtoTodos;

	@FindBy(id = "tableSummaryOperationListDesktop")
	protected WebElement tableListaDeOperacoes;

	@FindBy(id = "datetimmecustomDiv")
	protected WebElement elementoData;

	@FindBy(id = "buttonComprovantes0")
	protected WebElement botaoComprovante;

	@FindBy(id = "summary-export-pdf-button-1")
	protected WebElement pdfSuperiorAgenda;

	@FindBy(id = "summary-export-pdf-button-2")
	protected WebElement pdfInferiorAgenda;

	@FindBy(id = "summary-export-csv-button-1")
	protected WebElement csvSuperiorAgenda;

	@FindBy(id = "summary-export-csv-button-2")
	protected WebElement csvInferiorAgenda;

	@FindBy(id = "summary-print-button-1")
	protected WebElement ImprimirSuperiorAgenda;

	@FindBy(id = "summary-print-button-2")
	protected WebElement ImprimirInferiorAgenda;

	@FindBy(xpath = "//input[@role='combobox']")
	protected WebElement comboCnpj;

	@FindBy(id = "ScheDay_today")
	protected WebElement calendarVouReceberHoje;

	@FindBy(id = "buttonComprovantes0")
	protected WebElement btnComprovantes;
	
	@FindBy(xpath = "//*[@id='tableSummaryOperationListDesktop']/tbody")
	protected WebElement tableDetalhe;

	public RecebimentosPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
