package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class AgendaPage extends PageObject {
	
	protected String url_agenda =	"http://meuestabelecimento-hml.siteteste.inf.br/agenda";
	protected String urlAgendaResumo =	"http://meuestabelecimento-hml.siteteste.inf.br/agenda";
	protected String urlBannerEsquerdo =	"verificar se ainda se aplica";
	protected String urlBannerDireito =	"verificar se ainda se aplica";
	
	public String getUrlBannerEsquerdo() {
		return urlBannerEsquerdo;
	}


	public void setUrlBannerEsquerdo(String urlBannerEsquerdo) {
		this.urlBannerEsquerdo = urlBannerEsquerdo;
	}


	public String getUrlBannerDireito() {
		return urlBannerDireito;
	}


	public void setUrlBannerDireito(String urlBannerDireito) {
		this.urlBannerDireito = urlBannerDireito;
	}


	public String getUrlAgendaResumo() {
		return urlAgendaResumo;
	}


	public void setUrlAgendaResumo(String urlAgendaResumo) {
		this.urlAgendaResumo = urlAgendaResumo;
	}


	public String getUrl_agenda() {
		return url_agenda;
	}


	public void setUrl_agenda(String url_agenda) {
		this.url_agenda = url_agenda;
	}


	@FindBy(id = "navbarDesktopAgenda")
	protected WebElement menuAgenda;
	
	@FindBy(id = "navbarDesktopAgenda")
	protected WebElement bannerEsquerdo;
	
	@FindBy(id = "navbarDesktopAgenda")
	protected WebElement bannerDireito;
	
	@FindBy(id = "imageLoader")
	protected WebElement loader;
	

	@FindBy(id = "ScheDay_today")
	protected WebElement elementoHoje;

	@FindBy(id = "datetimmecustomDiv")
	protected WebElement elementoData;
	
	@FindBy(id = "tableSummaryOperationListDesktop")
	protected WebElement elementoResumo;
	
	@FindBy(id = "labelPerfilSelector")
	protected WebElement elementoPerfil;
	 
	@FindBy(id = "scheduleTopBarMonthSelected")
	protected WebElement elementoMes;
	
	@FindBy(id = "scheduleTopBarNextImage")
	protected WebElement avancarMes;

	@FindBy(id = "scheduleTopBarPreviousImage")
	protected WebElement retrocederMes;
	
	@FindBy(id = "summary-more-details-button")
	protected WebElement botaoVejaMaisDetalhes;
	
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
	

	public AgendaPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
