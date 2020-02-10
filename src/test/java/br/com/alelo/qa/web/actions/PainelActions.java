/**
 * 
 */
package br.com.alelo.qa.web.actions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import br.com.alelo.qa.web.page.PainelPage;

/**
 * @author Fernando Lisboa
 *
 */
public class PainelActions extends PainelPage {

	public void validarPainel() throws IOException {
		waitForElementPageToLoad(aguardar_gif);
		validarUrlAtual(urlInicio);
	}

	public void alterarEstabelecimento() throws IOException, InterruptedException {
		alterarCNPJ(opcao_ec1);
		alterarCNPJ(opcao_ec2);
		alterarCNPJ(opcao_ec3);
		alterarCNPJ(opcao_ec4);
	}

	public void alterarEstabelecimentoPainel() throws IOException, InterruptedException {
		alterarCNPJ(ofertaPainel);
	}

	public void alterarEstabelecimentoPlano() throws IOException, InterruptedException {
		alterarCNPJ(opcao_ec_plano);
	}

	public void alterarEstabelecimentoPlanoSaldo() throws IOException, InterruptedException {
		alterarCNPJ(opcao_ec_plano_saldo);
	}

	public void alterarEstabelecimentoArv() throws IOException, InterruptedException {
		alterarCNPJ(opcao_ec_arv);
	}

	public void alterarEstabelecimentoBloq(String cnpj) throws IOException, InterruptedException {

		if (cnpj.equals("1")) {
			alterarCNPJ(opcao_ec1);
		} else if (cnpj.equals("2")) {
			alterarCNPJ(opcao_ec3);
		} else if (cnpj.equals("3")) {
			alterarCNPJ(opcao_ec1);
		} else if (cnpj.equals("5")) {
			alterarCNPJ(opcao_ec1);
		}
	}

	public void alterarEstabelecimentoDesbloq(String cnpj) throws IOException, InterruptedException {

		if (cnpj.equals("2")) {
			alterarCNPJ(desbloq_2);
		} else if (cnpj.equals("1")) {
			alterarCNPJ(desbloq_1);
		}
	}

	public void alterarEstabelecimentoSemPlanoSemSaldo() throws IOException, InterruptedException {
		alterarCNPJ(opcao_ec_sp_ss);
	}

	private void alterarCNPJ(WebElement elemento) throws IOException, InterruptedException {
		opcao_select.click();
		Thread.sleep(3000);
		elemento.click();
		Thread.sleep(4000);
	}

	public void validarCNPJPainel() throws InterruptedException {
		Thread.sleep(5000);
		String compararEstabelecimento = opcao_select.getAttribute("value");
		// obterValorDoElementoAttribute(opcao_select, "value");
		if (compararEstabelecimento.contains(estabelecimentoComparar)) {
			System.out.println("Teste realizado com sucesso");
		} else {
			fail("Valor comparado é diferente do Estabelecimento");
		}
	}

	public void trocarJanela(Integer elemento) {
		try {
			Set<String> handles = webdriver.getWindowHandles();
			Object[] it = handles.toArray();

			webdriver.switchTo().window((String) it[elemento]);
		} catch (Exception e) {
			String valorError = "Este Indice de Janela não existe!\n\nUse um valor Valido!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
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

	public void clicarBannerSuperior() {
		banner_superior.click();
	}

	public void validaLinkBannerSuperior() {
		validarUrlAtual(urlInicio);
	}

	public void clicarBannerInferior() {
		banner_inferior.click();
	}

	public void validaLinkBannerInferiores() {
		validarUrlAtual(urlInicio);
	}

	public void validaSidekickArv() throws InterruptedException {
		Thread.sleep(5000);
		validarTextoElemento(sidekick_arv, textSidekickArv);
	}

	public void validaSidekickPainel() throws InterruptedException {
		validarTextoElemento(sidekickPainel, textSidekickPainel);
	}

	public void validaSidekickPlano() throws InterruptedException {
		Thread.sleep(5000);
		validarTextoElemento(sidekick_Plano, textSidekickPlano);
	}

	public void validaNaoAparicaoSidekick() throws InterruptedException {
		Thread.sleep(5000);
		validarUrlAtual(urlInicio);
	}

	public void validarValorAReceber() {
		Assert.assertTrue(vouReceber.isDisplayed());
	}

	public void validarValorRecebido() {
		Assert.assertTrue(jaRecebi.isDisplayed());
	}

	public void bloqueiaEc(String path, String nomeArquivo) {

		linkPainelMeuNegocio.click();
		String usingSystemProperty = System.getProperty("user.dir");
		inputFileBlock.sendKeys(usingSystemProperty + path + nomeArquivo);
		btnFazerUpload.click();
		waitForElementPageToBeClickable(btnFechar);
		Assert.assertThat(sucesso.getText(), is(sucessoText));
		btnFechar.click();

		System.out.println("DONE");
	}

	public static Resource getUserFileResource(String path, String nomeArquivo) throws IOException {
		File file = new File(path + nomeArquivo);
		return new FileSystemResource(file);
	}

	public void validarMenuDosGraficos(String grafico) {
		if (grafico.equalsIgnoreCase("faturamento")) {
			validarTextoElemento(graficoFaturamento, resumoUltmosTrintaDias);
		} else if (grafico.equalsIgnoreCase("Mensal")) {
			validarTextoElemento(graficoMensal, munuMensal);

		} else if (grafico.equalsIgnoreCase("Semanal")) {
			validarTextoElemento(graficoSemana, munuSemanal);
		} else {
			validarTextoElemento(graficodiario, munuDiario);
		}
	}

	public PainelActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void consultarStatusContratacaoPainel() throws InterruptedException {
		waitForElementPageToBeClickable(menuDocumentos);
		menuDocumentos.click();
		Thread.sleep(10000);
		validarTextoElemento(statusContratoSuspenso, statusContratoText);
	}

	public void consultarStatusDesbloqueio(String statusEsperado) throws InterruptedException {
		waitForElementPageToBeClickable(menuDocumentos);
		menuDocumentos.click();
		Thread.sleep(10000);
		if (statusEsperado.equals("TESTE GRÁTIS")) {
			validarTextoElemento(labelTesteGratis, statusEsperado);
		} else
			validarTextoElemento(Contratado, statusEsperado);
	}

}
