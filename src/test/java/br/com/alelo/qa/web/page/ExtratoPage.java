/**
 * 
 */
package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

/**
 * @author Fernando Lisboa
 *
 */
public class ExtratoPage extends PageObject {

	@FindBy(id = "imageLoader")
	protected WebElement aguardar_gif;

	@FindBy(id = "notificationDefaultMessage")
	protected WebElement tipo_da_mensagem;

	@FindBy(id = "statementDescription")
	protected WebElement detalhes_linha_outras_transacoes;

	@FindBy(id = "statementDescription")
	protected WebElement detalhes_linha_venda;

	@FindBy(id = "statementSales1")
	protected WebElement segunda_linha_extrato;

	@FindBy(id = "statementSales0")
	protected WebElement primeira_linha_extrato;

	@FindBy(id = "buttonFindByDate")
	protected WebElement botao_ok_calendario;

	@FindBy(id = "//td[contains(@aria-label, \"[DATA]\")]")
	protected WebElement range_primeiro_dia;

	@FindBy(id = "//td[contains(@aria-label, \"[DATA]\")]")
	protected WebElement range_ultimo_dia;

	@FindBy(id = "datetimmecustomDiv")
	protected WebElement clica_calendario;

	@FindBy(id = "navbarDesktopExtrato")
	protected WebElement menu_extrato;

	@FindBy(id = "buttonBottomPdf")
	protected WebElement pdf_inferior;

	@FindBy(id = "buttonTopPdf")
	protected WebElement pdf_superior;

	@FindBy(id = "textCardNumber0")
	protected WebElement numero_do_cartao;

	@FindBy(id = "imageLoader")
	protected WebElement loader;

	@FindBy(id = "buttonFindCardTails")
	protected WebElement botao_ok_cartao;

	@FindBy(id = "Null")
	protected WebElement numero_cartao;
	public String numeroCartao = "3011";

	@FindBy(id = "inputmask-cardtails")
	protected WebElement campo_cartao;

	@FindBy(id = "buttonBottomPrint")
	protected WebElement impressao_inferior;

	@FindBy(id = "buttonTopPrint")
	protected WebElement impressao_superior;

	@FindBy(id = "buttonTopCsv")
	protected WebElement csv_superior;

	@FindBy(id = "buttonBottomCsv")
	protected WebElement csv_inferior;

	@FindBy(id = "buttonTopClose")
	protected WebElement fechar_impressao;

	@FindBy(id = "buttonTopPrint")
	protected WebElement confirma_impressao;

	@FindBy(xpath = "//button[text() = \"Imprimir\"]")
	protected WebElement confirma_impressao_browser;

	@FindBy(id = "Null")
	protected WebElement numero_final_cartao;

	public ExtratoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
