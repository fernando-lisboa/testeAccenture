/**
 * 
 */
package br.com.alelo.qa.web.actions;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alelo.qa.web.page.PainelPage;

/**
 * @author Fernando Lisboa
 *
 */
public class PainelActions extends PainelPage {

	public PainelActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void validarPainel() throws IOException {
		waitForElementPageToLoad(aguardar_gif);
		validarUrlAtual(urlInicio);
	}

	public void alterarEstabelecimento() throws IOException, InterruptedException {
		alterarCNPJ(aguardar_gif, opcao_select, opcao_ec);
	}

	public void alterarEstabelecimentoPlano() throws IOException, InterruptedException {
		alterarCNPJ(aguardar_gif, opcao_select, opcao_ec_plano);
	}

	public void alterarEstabelecimentoPlanoSaldo() throws IOException, InterruptedException {
		alterarCNPJ(aguardar_gif, opcao_select, opcao_ec_plano_saldo);
	}

	public void alterarEstabelecimentoArv() throws IOException, InterruptedException {
		alterarCNPJ(aguardar_gif, opcao_select, opcao_ec_arv);
	}

	public void alterarEstabelecimentoSemPlanoSemSaldo() throws IOException, InterruptedException {
		alterarCNPJ(aguardar_gif, opcao_select, opcao_ec_sp_ss);
	}

	private void alterarCNPJ(WebElement aguardar_gif, WebElement opcao_select, WebElement opcao_ec)
			throws IOException, InterruptedException {
		waitForElementPageToLoad(aguardar_gif);
		opcao_select.click();
		Thread.sleep(5000);
		opcao_ec.click();
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
			String textoDeComparacao = elemento.getText();
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

	public void clicaTwitter() {
		botao_twitter.click();
	}

	public void validaURLTwitter() throws InterruptedException {
		Thread.sleep(5000);
		trocarJanela(1);
		validarUrlAtual(getLinkTwitter());
	}

	public void clicaFacebook() {
		botao_facebook.click();
	}

	public void validaURLFacebook() throws InterruptedException {
		Thread.sleep(5000);
		trocarJanela(1);
		validarUrlAtual(getLinkFacebook());
	}

	public void clicaLinkedin() {
		botao_linkedin.click();
	}

	public void validaURLLinkedin() throws InterruptedException {
		Thread.sleep(5000);
		trocarJanela(1);
		validarUrlAtual(getLinkLinkedin());
	}

	public void validaSidekickArv() throws InterruptedException {
		Thread.sleep(5000);
		validarTextoElemento(sidekick_arv, textSidekickArv);
	}

	public void validaSidekickPlano() throws InterruptedException {
		Thread.sleep(5000);
		validarTextoElemento(sidekick_Plano, textSidekickPlano);
	}

	public void validaNaoAparicaoSidekick() throws InterruptedException {
		Thread.sleep(5000);
		validarUrlAtual(urlInicio);
	}

}
