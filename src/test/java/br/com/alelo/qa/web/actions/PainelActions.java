/**
 * 
 */
package br.com.alelo.qa.web.actions;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

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
		aguardarGif(elementoGif);
		validarUrlAtual(urlInicio);
	}

	public void alterarEstabelecimento() throws IOException, InterruptedException {
		super.alterarCNPJ(elementoGif, opcaoSelect, opcao_ec);
	}

	public void alterarEstabelecimentoPlano() throws IOException, InterruptedException {
		super.alterarCNPJ(elementoGif, opcaoSelect, opcao_ec_plano);
	}

	public void alterarEstabelecimentoPlanoSaldo() throws IOException, InterruptedException {
		super.alterarCNPJ(elementoGif, opcaoSelect, opcao_ec_plano_saldo);
	}

	public void alterarEstabelecimentoArv() throws IOException, InterruptedException {
		super.alterarCNPJ(elementoGif, opcaoSelect, opcao_ec_arv);
	}

	public void alterarEstabelecimentoSemPlanoSemSaldo() throws IOException, InterruptedException {
		super.alterarCNPJ(elementoGif, opcaoSelect, opcao_ec_sp_ss);
	}

	public void validarCNPJPainel() throws InterruptedException {
		Thread.sleep(5000);
		String compararEstabelecimento = obterValorDoElementoAttribute(opcaoSelect, "value");
		if (compararEstabelecimento.contains(estabelecimento)) {
			System.out.println("Teste realizado com sucesso");
		} else {
			fail("Valor comparado é diferente do Estabelecimento");
		}
	}

	public void clicarBannerSuperior() {
		clicar(bannerSuperior);
	}

	public void validaLinkBannerSuperior() {
		validarUrlAtual(urlBannerSuperior);
	}

	public void clicarBannerInferior() {
		clicar(bannerInferior);
	}

	public void validaLinkBannerInferiores() {
		validarUrlAtual(urlBannerInferior);
	}

	public void clicaTwitter() {
		clicar(botaoTwitter);
	}

	public void validaURLTwitter() throws InterruptedException {
		Thread.sleep(5000);
		trocarJanela(1);
		validarUrlAtual(validaLinkTwitter);
	}

	public void clicaFacebook() {
		clicar(botaoFacebook);
	}

	public void validaURLFacebook() throws InterruptedException {
		Thread.sleep(5000);
		trocarJanela(1);
		validarUrlAtual(validaLinkFacebook);
	}

	public void clicaLinkedin() {
		clicar(botaoLinkedin);
	}

	public void validaURLLinkedin() throws InterruptedException {
		Thread.sleep(5000);
		trocarJanela(1);
		validarInicioUrlAtual(validaLinkLinkedin);
	}

	public void validaSidekickArv() throws InterruptedException {
		Thread.sleep(5000);
		validarTextoElemento(sidekick, textoSidekickArv);
	}

	public void validaSidekickPlano() throws InterruptedException {
		Thread.sleep(5000);
		validarTextoElemento(sidekick, textoSidekickPlano);
	}

	public void validaNaoAparicaoSidekick() throws InterruptedException {
		Thread.sleep(5000);
		validarUrlAtual(urlInicio);
	}

}
