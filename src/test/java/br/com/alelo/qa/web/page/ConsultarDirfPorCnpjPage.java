package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class ConsultarDirfPorCnpjPage extends PageObject{
	
	String urlDocumentos = "https://meuestabelecimento-hml.siteteste.inf.br/documentos";

	
	public String getUrlDocumentos() {
		return urlDocumentos;
	}


	public void setUrlDocumentos(String urlDocumentos) {
		this.urlDocumentos = urlDocumentos;
	}


	@FindBy(id = "icon")
	protected WebElement iconeDownloadPdf;
	
	@FindBy(id = "menuDocumentos")
	protected WebElement menuDocumentos;
	
	@FindBy(xpath = "//img[@id='dirfWebButtonDownload'])[1]")
	protected WebElement btnBaixarArquivo_1;
	
	@FindBy(xpath = "//img[@id='dirfWebButtonDownload'])[2]")
	protected WebElement btnBaixarArquivo_2;
	
	@FindBy(xpath = "//img[@id='dirfWebButtonDownload'])[3]")
	protected WebElement btnBaixarArquivo_3;
	
	@FindBy(xpath = "//img[@id='dirfWebButtonDownload'])[4]")
	protected WebElement btnBaixarArquivo_4;
	
	@FindBy(xpath = "//img[@id='dirfWebButtonDownload'])[5]")
	protected WebElement btnBaixarArquivo_5;
	
	@FindBy(id = "imageLoader")
	protected WebElement loader;
	
	@FindBy(xpath = "//img[@id='dirfWebButtonDownload'])[6]")
	protected WebElement btnBaixarArquivo_6;
	
	
	public ConsultarDirfPorCnpjPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
