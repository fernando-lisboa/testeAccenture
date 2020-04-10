/**
 * 
 */
package br.com.alelo.qa.web.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

/**
 * @author Fernando Lisboa
 *
 */
public class ExtratoPage extends PageObject {

	@FindBy(css = "div.dailyOperationsContainer")
	protected WebElement vendasDia;

	@FindBy(linkText = "Clique aqui")
	protected WebElement linkVendasDia;

	@FindBy(xpath = "//*[contains(@class, 'interestButton')]")
	protected WebElement bntInteresse;

	@FindBy(xpath = "//*[contains(@class, 'close')]")
	protected WebElement bntFechaModalInteresse;

	@FindBy(xpath = "//*[contains(@class, 'bgLightGray')]")
	protected WebElement cabecalhoRel;

	@FindBy(xpath = "//*[contains(@class, 'dirfBody textGray fontNormal noPointer')]")
	protected List<WebElement> corpoRel;

	@FindBy(id = "calendar-input-start")
	protected WebElement bntStartDataCalendario;

	@FindBy(id = "calendar-input-end")
	protected WebElement bntEndDataCalendario;

	@FindBy(xpath = "//*[contains(@class, 'CalendarMonth CalendarMonth_1')]")
	protected List<WebElement> listCalendarios;

	@FindBy(xpath = "//*[contains(@class, 'divGreyDark  border10Radius divPrefix divBorder col-lg-1 col-md-1 col-sm-1 col-xs-1')]")
	protected List<WebElement> listColDataRelatorio;

	@FindBy(xpath = "//*[contains(@class, 'col-lg-11 col-md-11 col-sm-11 col-xs-11')]")
	protected List<WebElement> listColTransRelatorio;
	
	@FindBy(xpath = "//*[contains(@class, 'divItemBorderOpened divList divGrey border10Radius row')]")
	protected List<WebElement> camposTabelaOutrasTransacoes;
	
	@FindBy(id = "statementSales[object Object]")
	protected List<WebElement> listLinhaSumarizada;
	
	@FindBy(id = "statementOtherTransactions[object Object]")
	protected List<WebElement> listLinhaOutrasTransacoes;
	
	@FindBy(id = "bgLightGray textGray fontLight fontSize14")
	protected WebElement cabecalhoTabelaDetalheTransacao;

	@FindBy(xpath = "//*[contains(@class, 'divTotal col-lg-3 col-md-2 col-sm-2 col-xs-12')]")
	protected WebElement valorTotalExtrato;

	@FindBy(xpath = "//*[contains(@class, 'textGray fontNormal noPointer')]")
	protected List<WebElement> listLinhaDetalheTransacao;

	@FindBy(css = "#buttonFindByDate")
	protected WebElement buttonOk;

	@FindBy(xpath = "//*[contains(@class, 'bgLightGray textGray fontLight fontSize14')]")
	protected WebElement cabecalhoTabelaDetalhada;

	@FindBy(xpath = "//*[contains(@class, 'noPointer textTable divItemBorderOpened fontSize14 noBorderRadiusLeft')]")
	protected List<WebElement> camposTabelaDetalhada;

	@FindBy(id = "buttonTopExport")
	protected WebElement bntExportar;

	@FindBy(id = "gerarExtrato")
	protected WebElement bntGerarExtrato;

	@FindBy(xpath = "//*[contains(@class, 'exportType')]")
	protected List<WebElement> tipoExportacaoPDFCSV;
	
	@FindBy(id = "buttonTopPdf")
	protected WebElement bntPDF;
	
	@FindBy(id = "buttonTopCsv")
	protected WebElement bntCSV;
	
	@FindBy(id = "buttonTopPrint")
	protected WebElement bntImprimir;
	
	@FindBy(id = "buttonBottomPdf")
	protected WebElement bntInferiorPDF;
	
	@FindBy(id = "buttonBottomCsv")
	protected WebElement bntInferiorCSV;
	
	@FindBy(id = "buttonBottomPrint")
	protected WebElement bntInferiorImprimir;
	
	@FindBy(id = "buttonTopPrint")
	protected List<WebElement> bntModalImprimir;
	
	@FindBy(id = "buttonTopClose")
	protected WebElement bntModalFecharSuperior;
	
	@FindBy(id = "buttonBottomClose")
	protected WebElement bntModalFecharInferior;
	
	@FindBy(xpath = "//*[contains(@class, 'headerDivPdf')]")
	protected List<WebElement> cabecalhoConteudoModalImprimir;
	
	@FindBy(xpath = "//*[contains(@class, 'labelDivPdf')]")
	protected List<WebElement> conteudoModalImprimir;

	public ExtratoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
