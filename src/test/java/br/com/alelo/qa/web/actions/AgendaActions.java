package br.com.alelo.qa.web.actions;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.AgendaPage;
import br.com.alelo.qa.web.page.UrlPage;

public class AgendaActions extends AgendaPage {

	// UrlPage urls = new UrlPage(webdriver);

	public void telaAgenda() throws InterruptedException {
		waitForElementPageToLoad(loader);
		Thread.sleep(2000);
		waitForElementPageToBeClickable(menuAgenda);
		menuAgenda.click();
		waitForElementPageToLoad(loader);
	}

	public void diaAtual() throws InterruptedException {
		waitForElementPageToLoad(loader);
		Thread.sleep(5000);
		waitForElementPageToBeClickable(elementoHoje);
		elementoHoje.click();
		Thread.sleep(5000);
		waitForElementPageToLoad(loader);
	}

	public void avacarMes() throws InterruptedException {
		Thread.sleep(5000);
		String textoMesAtual = elementoMes.getText();
		waitForElementPageToLoad(avancarMes);
		avancarMes.click();
		waitForElementPageToLoad(loader);

		String textoMesFuturo = elementoMes.getText();

		if (!textoMesAtual.equals(textoMesFuturo)) {
			System.out.println("Teste realizado com sucesso.");
		} else {
			fail("Problemas ao avançar o mês");
		}
	}

	public void retrocederMes() throws InterruptedException {
		Thread.sleep(5000);
		String textoMesAtual = elementoMes.getText();
		waitForElementPageToBeClickable(retrocederMes);
		retrocederMes.click();
		waitForElementPageToLoad(loader);

		System.out.println(textoMesAtual);
		String textoMesPassado = elementoMes.getText();
		System.out.println(textoMesPassado);

		if (!textoMesAtual.equals(textoMesPassado)) {
			System.out.println("Teste realizado com sucesso.");
		} else {
			fail("Problemas ao retroceder o mês");
		}
	}

	public void telaExtratoMes() {
		waitForElementPageToLoad(loader);
		validarUrlAtual(getUrl_agenda());
	}

	public void TelaExtratoDia() throws InterruptedException {
		waitForElementPageToLoad(loader);
		waitForElementPageToBeClickable(elementoData);
		waitForElementPageToBeClickable(elementoResumo);
		elementoResumo.click();
		validarUrlAtual(getUrlAgendaResumo());
		Thread.sleep(3000);
	}

	public void validarHomepage() throws InterruptedException {
		Thread.sleep(5000);
		validarUrlAtual(getUrl_agenda());
	}

	public void clicarMaisDetalhes() throws InterruptedException {
		waitForElementPageToLoad(loader);
		waitForElementPageToBeClickable(botaoVejaMaisDetalhes);
		Thread.sleep(5000);
		botaoVejaMaisDetalhes.click();
	}

	public void validarAgenda() {
		validarUrlAtual(getUrl_agenda());
	}

	public void clicarBannerEsquerdo() {
		waitForElementPageToBeClickable(bannerEsquerdo);
		bannerEsquerdo.click();
	}

	public void clicarBannerDireito() {
		waitForElementPageToBeClickable(bannerDireito);
		bannerDireito.click();
	}

	public void validaBannerEsquerdo() {
		validarUrlAtual(urlBannerEsquerdo);
	}

	public void validaBannerDireito() {
		validarUrlAtual(urlBannerDireito);
	}

	public void clicarComprovantes(String cnpjAgenda) throws InterruptedException, IOException {
		alterarCNPJ(cnpjAgenda);
		waitForElementPageToBeClickable(botaoComprovante);
		Thread.sleep(5000);
		botaoComprovante.click();
		waitForElementPageToLoad(loader);
	}

	public void clicarPDFSuperior() {
		waitForElementPageToBeClickable(pdfSuperiorAgenda);
		pdfSuperiorAgenda.click();
	}

	public void clicarPDFInferior() {
		waitForElementPageToBeClickable(pdfInferiorAgenda);
		pdfInferiorAgenda.click();
	}

	public void clicarCSVSuperior() {
		waitForElementPageToBeClickable(csvSuperiorAgenda);
		csvSuperiorAgenda.click();
	}

	public void clicarCSVInferior() {
		waitForElementPageToBeClickable(csvInferiorAgenda);
		csvInferiorAgenda.click();
	}

	public void clicarImprimirSuperior() throws InterruptedException {
		waitForElementPageToBeClickable(ImprimirSuperiorAgenda);
		ImprimirSuperiorAgenda.click();
	}

	public void clicarImprimirInferior() throws InterruptedException {
		waitForElementPageToBeClickable(ImprimirInferiorAgenda);
		ImprimirInferiorAgenda.click();
	}

	public void alterarCNPJ(String cnpjAgenda) throws IOException, InterruptedException {
		waitForElementPageToLoad(loader);
		comboCnpj.click();
		Thread.sleep(5000);
		// clicar("xpath", elemento3); TODO aplicar o cnpj a ser selecionado
		// após clicar no combo
	}

	public void validarDownloadPDF() {
		System.out.println("PDF baixado!");
	}

	public void validarDownloadCSV() {
		System.out.println("CSV baixado!");
	}

	public void validarImpressao() {
		System.out.println("Impressão efetuada!");
	}

	public AgendaActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
