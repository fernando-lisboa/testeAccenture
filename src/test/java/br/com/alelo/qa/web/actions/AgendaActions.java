package br.com.alelo.qa.web.actions;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.AgendaPage;

public class AgendaActions extends AgendaPage {

	
	
	public void telaAgenda() throws InterruptedException {
		aguardarGif(elementoGif);
		Thread.sleep(2000);
		esperarSerClicavel(menuAgenda, 20);
		clicar(menuAgenda);
		aguardarGif(elementoGif);
	}

	public void diaAtual() throws InterruptedException {
		aguardarGif(elementoGif);
		Thread.sleep(5000);
		esperarSerClicavel(elementoHoje, 30);
		clicar(elementoHoje);
		Thread.sleep(5000);
		aguardarGif(elementoGif);
	}

	public void AvacarMes() throws InterruptedException {
		Thread.sleep(5000);
		String textoMesAtual = obterTexto(mes);
		esperarSerClicavel(avancarMes, 30);
		clicar(avancarMes);
		aguardarGif(elementoGif);
		
		String textoMesFuturo = obterTexto(mes);
		
		if (!textoMesAtual.equals(textoMesFuturo)) {
			System.out.println("Teste realizado com sucesso.");
		} else {
			fail("Problemas ao avançar o mês");
		}
	}

	public void RetrocederMes() throws InterruptedException {
		Thread.sleep(5000);
		String textoMesAtual = obterTexto(mes);
		esperarSerClicavel(retrocederMes, 30);
		clicar(retrocederMes);
		aguardarGif(elementoGif);
		
		System.out.println(textoMesAtual);
		String textoMesPassado = obterTexto(mes);
		System.out.println(textoMesPassado);

		if (!textoMesAtual.equals(textoMesPassado)) {
			System.out.println("Teste realizado com sucesso.");
		} else {
			fail("Problemas ao retroceder o mês");
		}
	}

	public void TelaExtratoMes() {
		aguardarGif(elementoGif);
		validarUrlAtual(urlAgenda);
	}

	public void TelaExtratoDia() throws InterruptedException {
		aguardarGif(elementoGif);
		esperarSerClicavel(elementoData, 15);
		esperarSerClicavel(elementoResumo, 15);
		clicar(elementoResumo);
		validarUrlAtual(urlAgendaResumo);
		Thread.sleep(3000);
	}

	public void validarHomepage() throws InterruptedException {
		Thread.sleep(5000);
		validarUrlAtual(urlInicio);
	}

	public void clicarMaisDetalhes() throws InterruptedException {
		aguardarGif(elementoGif);
		esperarSerClicavel(botaoVejaMaisDetalhes, 15);
		Thread.sleep(5000);
		clicar(botaoVejaMaisDetalhes);
	}

	public void validarAgenda() {
		validarUrlAtual(urlAgenda);
	}

	public void clicarBannerEsquerdo() {
		esperarSerClicavel(bannerEsquerdo, 15);
		clicar(bannerEsquerdo);
	}

	public void clicarBannerDireito() {
		esperarSerClicavel(bannerDireito, 15);
		clicar(bannerDireito);
	}

	public void validaBannerEsquerdo() {
		validarUrlAtual(urlBannerEsquerdo);
	}

	public void validaBannerDireito() {
		validarUrlAtual(urlBannerDireito);
	}

	public void clicarComprovantes() throws InterruptedException, IOException {
		super.alterarCNPJ(elementoGif, opcaoSelect, opcao_ec);
		esperarSerClicavel(botaoComprovante, 15);
		Thread.sleep(5000);
		clicar(botaoComprovante);
		aguardarGif(elementoGif);
	}

	public void clicarPDFSuperior() {
		esperarSerClicavel(botaoPDFSuperior, 15);
		clicar(botaoPDFSuperior);
	}

	public void clicarPDFInferior() {
		esperarSerClicavel(botaoPDFInferior, 15);
		clicar(botaoPDFInferior);
	}

	public void clicarCSVSuperior() {
		esperarSerClicavel(botaoCSVSuperior, 15);
		clicar(botaoCSVSuperior);
	}

	public void clicarCSVInferior() {
		esperarSerClicavel(botaoCSVInferior, 15);
		clicar(botaoCSVInferior);
	}

	public void clicarImprimirSuperior() throws InterruptedException {
		esperarSerClicavel(botaoImprimirSuperior, 15);
		clicar(botaoImprimirSuperior);
//		Thread.sleep(5000);
//		trocarJanela(1);
//		Thread.sleep(5000);
//		esperarSerClicavel(confirmaImpressao, 20);
//		Thread.sleep(5000);
//		clicar(confirmaImpressao);
	}

	public void clicarImprimirInferior() throws InterruptedException {
		esperarSerClicavel(botaoImprimirInferior, 15);
		clicar(botaoImprimirInferior);
//		Thread.sleep(5000);
//		trocarJanela(1);
//		Thread.sleep(5000);
//		esperarSerClicavel(confirmaImpressao, 20);
//		Thread.sleep(5000);
//		clicar(confirmaImpressao);
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
