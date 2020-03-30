package br.com.alelo.qa.web.actions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alelo.qa.web.page.RecebimentosPage;
import br.com.alelo.utils.SimpleCacheManager;
import br.com.alelo.utils.setupTestes.actions.CommonsActions;

public class RecebimentosActions extends RecebimentosPage {
	
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();
	CommonsActions comm = new CommonsActions();
	private String valorEsperado;
	int i;
	private WebElement dateWidget;

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

	private void alterarCNPJ(WebElement elemento) {
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
		Assert.assertTrue("valor a receber não está visível", valorAReceber.isDisplayed());
		Assert.assertTrue("Mes de referencia não está visível", mesReferencia.isDisplayed());
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
		Assert.assertTrue(!valorEsperado.equals("0,00"));
		String attribute = mesExibido.getAttribute("value");
		String dataEsperada = comm.dataRecebiveis(i).toString();
		Assert.assertThat(attribute, is(dataEsperada));
		Assert.assertThat(comboProduto.getText(), is(produto));

	}

	public void selecionarProduto(String produto) {
		waitForElementToBeInvisible(loader);
		if (produto.equals("ALELO REFEICAO")) {
			comboProduto.click();
			produtoRefeicao.click();

		} else if (produto.equals("ALELO ALIMENTACAO")) {
			comboProduto.click();
			produtoAlimentacao.click();

		} else {
			comboProduto.click();
			produtoTodos.click();
		}
	}

	public void localizaDiaComRecebiveisDisponiveis() {
		waitForElementToBeInvisible(loader);

		Boolean sair = false;
		Integer listElements = listAReceber.size();
		for (i = 0; i < listElements; i++) {
			if (sair == true)
				break;
			for (WebElement list : listAReceber) {
				System.out.println(listAReceber.get(i).getText());
				System.out.println(i);

				if (!list.getText().replace("R$ ", "").equals("0,00")) {
					valorEsperado = list.getText().replace("R$ ", "");
					list.click();
					sair = true;
					break;
				}

				i++;
			}

		}

	}

	public void validarDetalheTransacoes(String produtoEsperado) throws Throwable {
		Thread.sleep(2000);
		List<String> percorrerDetalhes = percorrerDetalhes(tableDetalhe);
		for (String produto : percorrerDetalhes)
			if(!produtoEsperado.equals("TODOS"))
				Assert.assertThat(produto, is(produtoEsperado));
			else
				Assert.assertTrue("Não trouxe todos os produtos",produto.contains("ALELO"));
	}

	public List<String> percorrerDetalhes(WebElement elemento) throws Throwable {
		Thread.sleep(2000);
		List<String> list_produto = new ArrayList<String>();
		int tabela = tableDetalhe.findElements(By.tagName("tr")).size();
		for (int i = 1; i <= tabela; i++) {
			WebElement elemento_montado = null;
			if (tabela == 1)
				elemento_montado = webdriver
						.findElement(By.xpath("//*[@id='tableSummaryOperationListDesktop']/tbody/tr/td[3]/span"));
			else
				elemento_montado = webdriver.findElement(
						By.xpath("//*[@id='tableSummaryOperationListDesktop']/tbody/tr[" + i + "]/td[3]/span"));
			list_produto.add(elemento_montado.getText());
		}
		return list_produto;

	}

}
