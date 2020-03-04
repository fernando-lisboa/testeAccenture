package br.com.alelo.qa.web.actions;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.hamcrest.CoreMatchers.is;

import br.com.alelo.qa.web.page.RecebimentosPage;
import br.com.alelo.utils.setupTestes.actions.CommonsActions;

public class RecebimentosActions extends RecebimentosPage {

	CommonsActions comm = new CommonsActions();
	
	public RecebimentosActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void alterarEstabelecimento(String cnpj) throws IOException, InterruptedException {
		waitForElementToBeInvisible(loader);
		if (cnpj.equals("28339982000160")) {
			alterarCNPJ(ecRecebiveis_1);
		} else if (cnpj.equals("12259140000168")) {
			alterarCNPJ(ecRecebiveis_2);
		}

	}

	private void alterarCNPJ(WebElement elemento) throws IOException, InterruptedException {
		opcao_select.click();
		waitForElementToBeInvisible(loader);
		elemento.click();
		waitForElementToBeInvisible(loader);
	}

	public void valitarTelaRecebiveis() {
		menuRecebimentos.click();
		waitForElementToBeInvisible(loader);
		validarTextoElemento(labelTelaRecebimentos, textLabelTelaRecebimentos);
	}

	public void valitarTelaConteudoRecebiveis() {
		Assert.assertTrue("valor recebido não está visivel", valorRecebido.isDisplayed());
		Assert.assertTrue("valor recebido não está visivel", valorAReceber.isDisplayed());
		Assert.assertTrue("valor recebido não está visivel", mesReferencia.isDisplayed());
		validarTextoElemento(labelTelaRecebimentos, textLabelTelaRecebimentos);
	}

	public void validarTextoElemento(WebElement elemento, String textoComparacao) {
		try {
			waitForElementToBeInvisible(loader);
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

	public void avacarMes() {
		waitForElementToBeInvisible(loader);
		String textoMesAtual = mesReferencia.getText();
		waitForElementPageToLoad(avancarMes);
		avancarMes.click();
		waitForElementToBeInvisible(loader);
		String textoMesFuturo = mesReferencia.getText();
		System.out.println(textoMesFuturo);

		if (!textoMesAtual.equals(textoMesFuturo)) {
			System.out.println("Teste realizado com sucesso.");
		} else {
			fail("Problemas ao avançar o mês");
		}
	}

	public void retrocederMes() {
		waitForElementToBeInvisible(loader);
		String textoMesAtual = mesReferencia.getText();
		waitForElementPageToBeClickable(retrocederMes);
		retrocederMes.click();
		waitForElementToBeInvisible(loader);
		System.out.println(textoMesAtual);
		String textoMesPassado = mesReferencia.getText();
		System.out.println(textoMesPassado);

		if (!textoMesAtual.equals(textoMesPassado)) {
			System.out.println("Teste realizado com sucesso.");
		} else {
			fail("Problemas ao retroceder o mês");
		}
	}

	public void validarPeriodos(String periodo) {
		if (periodo.equals("mês atual")) {
			valitarTelaConteudoRecebiveis();
		} else if (periodo.equals("mês seguinte")) {
			avacarMes();
		} else {
			retrocederMes();
			Assert.assertTrue("valor recebido não está visivel", valorRecebido.isDisplayed());
		}

	}

	public void validarCampoCabecalho(String produto) {
		Assert.assertThat(valorVouReceber, is(!campoVouReceber.equals(null)));
		Assert.assertThat(mesReferencia.getText(), is(comm.dataAtual().toString()));
		Assert.assertThat(comboProduto.getText(), is(produto));

	}

	public void validarListaRecebimentos() {
		
		localizaDataRecebiveis();

	}

	public void selecionarProduto(String produto) {

		if (produto.equals("REFEIÇÃO")) {
			comboProduto.click();
			produtoRefeicao.click();

		} else if (produto.equals("ALIMENTAÇÃO")) {
			comboProduto.click();
			produtoAlimentacao.click();

		} else {
			comboProduto.click();
			produtoTodos.click();
		}
	}

	public void localizaDataRecebiveis() {

		for (WebElement list : listAReceber) {
			if (list.getAttribute("Innertext").isEmpty()) {
				list.click();
				break;
			}

		}

	}
}
