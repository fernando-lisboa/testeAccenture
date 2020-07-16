package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class ContratacaoPlanosCanalPage extends PageObject {

	public ContratacaoPlanosCanalPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[@class='nav-link'][contains(.,'ASSOCIAR CNPJs')]")
	protected WebElement menuAssociarLote;

	@FindBy(id = "inputFile")
	protected WebElement inputUpload;
	
	@FindBy(id = "btnUpload")
	protected WebElement btnFazerUpload;

	@FindBy(id = "btnDownload")
	protected WebElement btnDownload;

	@FindBy(xpath = "//button[@type='button'][contains(.,'FECHAR')]")
	protected WebElement btnFechar;

	@FindBy(xpath = "//a[@class='nav-link'][contains(.,'Sidekick')]")
	public WebElement botaoMenu_side_kick;
	
	@FindBy(id = "anticipationBtnCloseModal")
	public WebElement btnFecharModal;
	
	@FindBy(id = "btnSimulateNormalSidekick")
	public WebElement botao_side_kick;

	@FindBy(xpath = "//p[contains(.,'Todas as 1 linhas da planilha foram processadas com sucesso.')]")
	protected WebElement sucesso;
	public String msgSucessoTxt = "Todas as 1 linhas da planilha foram processadas com sucesso.";
	
	@FindBy(xpath = "//p[contains(.,'Excedido o número máximo de 500 linhas')]")
	protected WebElement erroMaximoLinhas;
	public String msgErroTxt = "Excedido o número máximo de 500 linhas";
	
	@FindBy(id = "anticipationModalCallbackBody")
	protected WebElement msgSucessoContratacao;
	public String msgEsperadaSucessoContratacao = "PLANO CONTRATADO COM SUCESSO";
	

}
