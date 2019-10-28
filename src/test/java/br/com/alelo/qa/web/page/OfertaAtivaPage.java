package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class OfertaAtivaPage extends PageObject{

	public OfertaAtivaPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(id="antecipation-more-button")
	protected WebElement sidekickDesenvolve;
	
	@FindBy(id="urlMultisservicos")
	protected WebElement urlMultisservicos;
	
	@FindBy(id="btnSimuleAgora")
	protected WebElement btnSimuleAgora;
	
	@FindBy(id="accountValidateBtnCancelar")
	protected WebElement btnAlterarValor;
	
	
	@FindBy(id="btnContratarAgora")
	protected WebElement btnContratarAgora;
	
	@FindBy(id="primeiraParcela")
	protected WebElement primeiraParcela;
	
	@FindBy(id="valorUltimaParcela")
	protected WebElement valorUltimaParcela;
	
	@FindBy(id="vencimentoPrimeiraParcela")
	protected WebElement vencimentoPrimeiraParcela;
	
	@FindBy(id="vencimentoUltimaParcela")
	protected WebElement vencimentoUltimaParcela;
	
	@FindBy(id="cet")
	protected WebElement cet;
	
	@FindBy(id="valorDoCredito")
	protected WebElement valorDoCredito;
	
	@FindBy(id="labelMsgDeParceria")
	protected WebElement labelMsgDeParceria;
	
	@FindBy(id="flagTermoDeAceite")
	protected WebElement flagTermoDeAceite;
	
	@FindBy(id="simuleJa")
	protected WebElement simuleJa;
	
	@FindBy(id="saibaMaisBanner")
	public WebElement saibaMais;
	
	@FindBy(id="cnpj")
	protected WebElement cnpj;
	
	@FindBy(xpath = "//input[@role='combobox']")
	protected WebElement comboCnpj;
	
	@FindBy(xpath = "//span[contains(.,'@ 97.765.810/0001-70 - 2000496258')]")
	protected WebElement cnpjComOferta;
	
	@FindBy(id = "accountValidateBtnCancelar")
	protected WebElement btnOkEntendi;
	
	@FindBy(id="btnAlterarValor")
	protected WebElement btnAlterarvalor;
	
	
	@FindBy(xpath = "//input[contains(@min,'1000')]")
	protected WebElement btnBarraValor;
	
	@FindBy(xpath = "//*[@id='ticks2']/*[@class='noContent']")
	protected WebElement btnBarraParcelas;
	
	@FindBy(id="btnSimularNovamente")
	protected WebElement btnSimularNovamente;
	
	@FindBy(id="btnVoltarSemAlterar")
	protected WebElement btnVoltarSemAlterar;
	
	@FindBy(id="iconProfileId")
	protected WebElement btnProfile;
	
	@FindBy(id="navbarDesktopSair")
	protected WebElement btnSair;
	
}
