package br.com.alelo.qa.web.actions;

import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.ConsultarDirfPorCnpjPage;

public class ConsultarDirfPorCnpjActions extends ConsultarDirfPorCnpjPage{

	public void telaDocumentos() throws InterruptedException {
		Thread.sleep(2000);
		waitForElementPageToBeClickable(menuDocumentos);
		menuDocumentos.click();
	}

	public void validarHomepage() throws InterruptedException {
		Thread.sleep(5000);
		validarUrlAtual(getUrlDocumentos());
	}
	

	public void abrirPdf(int anoReferencia) throws InterruptedException {
		Thread.sleep(2000);
		waitForElementPageToBeClickable(btnBaixarArquivo_1);
		if (anoReferencia == 2018) {
			btnBaixarArquivo_1.click();
		}
		if (anoReferencia == 2017) {
			btnBaixarArquivo_2.click();
		}
		if (anoReferencia == 2016) {
			btnBaixarArquivo_3.click();
		}
		if (anoReferencia == 2015) {
			btnBaixarArquivo_4.click();
		}
		if (anoReferencia == 2014) {
			btnBaixarArquivo_5.click();
		}
		if (anoReferencia == 2012) {
			btnBaixarArquivo_6.click();
		}
	}
	public void baixarPdf(){
		waitForElementPageToBeClickable(iconeDownloadPdf);
		iconeDownloadPdf.click();
	}
	public ConsultarDirfPorCnpjActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

}
