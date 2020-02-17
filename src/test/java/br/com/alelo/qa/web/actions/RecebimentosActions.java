package br.com.alelo.qa.web.actions;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alelo.qa.web.page.RecebimentosPage;

public class RecebimentosActions extends RecebimentosPage {

	public RecebimentosActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void alterarEstabelecimento(String cnpj) throws IOException, InterruptedException {
		Thread.sleep(3000);
		if (cnpj.equals("28339982000160")) {
			alterarCNPJ(ecRecebiveis_1);
		} else if (cnpj.equals("12259140000168")) {
			alterarCNPJ(ecRecebiveis_2);
		}

	}

	private void alterarCNPJ(WebElement elemento) throws IOException, InterruptedException {
		opcao_select.click();
		Thread.sleep(3000);
		elemento.click();
		Thread.sleep(4000);
	}

	public void valitarTelaRecebiveis() {
		menuRecebimentos.click();
		try {
			Thread.sleep(2000);
			validarTextoElemento(labelTelaRecebimentos, textLabelTelaRecebimentos);
		} catch (InterruptedException e) {
			System.out.println("Ocorreu um erro..." + e);
			e.printStackTrace();
		}

	}

	public void valitarTelaConteudoRecebiveis() {
		Assert.assertTrue("valor recebido não está visivel", valorrecebido.isDisplayed());
		Assert.assertTrue("valor recebido não está visivel", valorAReceber.isDisplayed());
		Assert.assertTrue("valor recebido não está visivel", mesReferencia.isDisplayed());
		validarTextoElemento(labelTelaRecebimentos, textLabelTelaRecebimentos);
	}

	public void validarTextoElemento(WebElement elemento, String textoComparacao) {
		try {
			Thread.sleep(5000);
			String textoDeComparacao = elemento.getText();
			System.out.println(textoDeComparacao);
			if (textoComparacao.equalsIgnoreCase(textoDeComparacao)) {
				System.out.println("Teste realizado com sucesso.");
			} else {
				System.out.println("Erro. \n" + "Mensagem esperada: " + textoComparacao + "\nMensagem obtida: "
						+ textoDeComparacao);
				Assert.fail();
			}
		} catch (Exception e) {
			Assert.fail();
			System.out.println(e);
		}
	}

	public void avacarMes() throws InterruptedException {
		Thread.sleep(5000);
		String textoMesAtual = mesReferencia.getText();
		waitForElementPageToLoad(avancarMes);
		avancarMes.click();
		Thread.sleep(2000);
		String textoMesFuturo = mesReferencia.getText();
		System.out.println(textoMesFuturo);

		if (!textoMesAtual.equals(textoMesFuturo)) {
			System.out.println("Teste realizado com sucesso.");
		} else {
			fail("Problemas ao avançar o mês");
		}
	}

	public void retrocederMes() throws InterruptedException {
		Thread.sleep(5000);
		String textoMesAtual = mesReferencia.getText();
		waitForElementPageToBeClickable(retrocederMes);
		retrocederMes.click();
		Thread.sleep(2000);
		System.out.println(textoMesAtual);
		String textoMesPassado = mesReferencia.getText();
		System.out.println(textoMesPassado);

		if (!textoMesAtual.equals(textoMesPassado)) {
			System.out.println("Teste realizado com sucesso.");
		} else {
			fail("Problemas ao retroceder o mês");
		}
	}

	public void validarPeriodos(String periodo) throws InterruptedException {
		if (periodo.equals("mês atual")) {
			valitarTelaConteudoRecebiveis();
		} else if (periodo.equals("mês seguinte")) {
			avacarMes();
		} else {
			retrocederMes();
			Assert.assertTrue("valor recebido não está visivel", valorrecebido.isDisplayed());
		}

	}

}
