/**
 * 
 */
package br.com.alelo.qa.web.actions;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.alelo.qa.web.page.ExtratoPage;
import driver.web.DriverWeb;

/**
 * @author Fernando Lisboa
 *
 */
public class ExtratoActions extends ExtratoPage {

	public ExtratoActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clicarAbaExtrato() throws IOException, InterruptedException {
		Thread.sleep(5000);
		waitForElementPageToLoad(aguardar_gif);
		menu_extrato.wait(20);
		menu_extrato.click();
		waitForElementPageToLoad(aguardar_gif);
		Thread.sleep(5000);
		super.alterarCNPJ(elementoGif, opcaoSelect, opcaoEcExtrato);
	}

	public void selecionarPeriodo() throws InterruptedException {
		waitForElementPageToLoad(aguardar_gif);
		clica_calendario.wait(10);
		clica_calendario.click();
		Thread.sleep(5000);
		range_primeiro_dia.wait(10);
		range_primeiro_dia.click();
		Thread.sleep(5000);
		range_ultimo_dia.wait(10);
		range_ultimo_dia.click();
	}

	public void clicarOK() {
		botao_ok_calendario.click();
		waitForElementPageToLoad(aguardar_gif);
	}

	public void validarTransacoes() throws InterruptedException {
		Thread.sleep(5000);
		validarMensagem("VENDAS", primeiraLinhaExtrato);
	}

	public void clicarLinhaVendas() throws InterruptedException {
		primeira_linha_extrato.wait(10);
		primeira_linha_extrato.click();
		waitForElementPageToLoad(aguardar_gif);
	}

	public void validarDetalheVendasDia() throws InterruptedException {
		clicarLinhaVendas();
		clicarLinhaVendas();
		validarMensagem("DESCRIÇÃO", detalhesLinhaVenda);
	}

	public void clicarLinhaOutrastransacoes() throws InterruptedException {
		segunda_linha_extrato.wait(10);
		segunda_linha_extrato.click();
		waitForElementPageToLoad(aguardar_gif);
	}

	public void validarDetalheOutrastransacoesDia() {
		clicarLinhaOutrastransacoes();
		clicarLinhaOutrastransacoes();
		validarMensagem("DESCRIÇÃO", detalhesLinhaOutrasTransacoes);
	}

	public void buscarNumeroCartao() {
		campo_cartao.click();
		numero_cartao.sendKeys(numeroCartao);
		botao_ok_cartao.click();
		waitForElementPageToLoad(aguardar_gif);
	}

	public void validarResultadosNumeroCartao() throws InterruptedException {
		Thread.sleep(5000);

		if (obterTexto(numero).contains(numeroFinalCartao)) {
			System.out.println("Teste realizado com sucesso.");
		} else {
			fail("Numero de cartão diferente do pesquisado.");
		}
	}

	public void downloadPDFSuperior() throws InterruptedException {
		waitForElementPageToLoad(aguardar_gif);
		pdf_superior.wait(15);
		pdf_superior.click();
		waitForElementPageToLoad(aguardar_gif);
	}

	public void validarPDFBaixado() {
		waitForElementPageToLoad(aguardar_gif);
		System.out.println("PDF baixado!");
	}

	public void downloadPDFInferior() throws InterruptedException {
		pdf_inferior.wait(15);
		pdf_inferior.click();
	}

	public void downloadCSVSuperior() throws InterruptedException {
		waitForElementPageToLoad(aguardar_gif);
		csv_superior.wait(15);
		csv_superior.click();
		waitForElementPageToLoad(aguardar_gif);
	}

	public void validarCSVBaixado() {
		System.out.println("CSV baixado!");
	}

	public void downloadCSVInferior() throws InterruptedException {
		waitForElementPageToLoad(aguardar_gif);
		csv_inferior.wait(15);
		csv_inferior.click();
		waitForElementPageToLoad(aguardar_gif);
	}

	public void impressaoSuperior() throws InterruptedException {
		impressao_superior.wait(15);
		impressao_superior.click();
		waitForElementPageToLoad(aguardar_gif);
//		esperarSerClicavel(confirmaImpressao, 20);
//		clicar(confirmaImpressao);
//		esperarSerClicavel(confirmaImpressaoBrowser, 20);
//		Thread.sleep(5000);
//		clicar(confirmaImpressaoBrowser);
	}

	public void validaImpressao() throws InterruptedException {
		System.out.println("Impressão efetuada!");
		Thread.sleep(5000);
		fechar_impressao.click();
	}

	public void impressaoInferior() throws InterruptedException {
		impressao_inferior.wait(15);
		impressao_inferior.click();
		waitForElementPageToLoad(aguardar_gif);
//		esperarSerClicavel(confirmaImpressao, 20);
//		clicar(confirmaImpressao);
//		esperarSerClicavel(confirmaImpressaoBrowser, 20);
//		Thread.sleep(5000);
//		clicar(confirmaImpressaoBrowser);
	}

}
