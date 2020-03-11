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

	public void alterarEstabelecimentoPainelContratacaoCancelamento(String cnpj)
			throws IOException, InterruptedException {

		if (cnpj.equals("82143278000182")) {
			alterarCNPJ(testeGratis);
		} else if (cnpj.equals("12259140000168")) {
			alterarCNPJ(opcao_ec4);
		} else if (cnpj.equals("28339982000160")) {
			alterarCNPJ(opcao_ec3);
		} else
			alterarCNPJ(desbloq_2);
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
			alterarCNPJ(opcao_ec3);
		} else if (cnpj.equals("2")) {
			alterarCNPJ(opcao_ec4);
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
		Thread.sleep(2000);
	}

	public void validarCNPJPainel() throws InterruptedException {
		waitForElementToBeInvisible(loader);
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

	public void validaLinkBannerInferiores() {
		validarUrlAtual(urlInicio);
	}

	public void validaSidekickArv() throws InterruptedException {
		waitForElementToBeInvisible(loader);
		validarTextoElemento(sidekick_arv, textSidekickArv);
	}

	public void validaSidekickPainel() throws InterruptedException {
		validarTextoElemento(sidekickPainel, textSidekickPainel);
	}

	public void validaSidekickPlano() throws InterruptedException {
		waitForElementToBeInvisible(loader);
		validarTextoElemento(sidekick_Plano, textSidekickPlano);
	}

	public void validaNaoAparicaoSidekick() throws InterruptedException {
		waitForElementToBeInvisible(loader);
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

		System.out.println("Bloqueio Efetivado com sucesso");
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

	public void consultarStatusContratacaoPainel() throws InterruptedException {
		waitForElementToBeInvisible(loader);
		waitForElementPageToBeClickable(menuDocumentos);
		menuDocumentos.click();
		validarTextoElemento(statusContratoSuspenso, statusContratoText);
	}

	public void consultarStatusDesbloqueio(String statusEsperado) throws InterruptedException {
		waitForElementToBeInvisible(loader);
		waitForElementPageToBeClickable(menuDocumentos);
		menuDocumentos.click();
		waitForElementToBeInvisible(loader);
		if (statusEsperado.equals("TESTE GRÁTIS")) {
			validarTextoElemento(labelTesteGratis, statusEsperado);
		} else
			validarTextoElemento(Contratado, statusEsperado);
	}

	public void contrataPainel(String cnpjContratado) throws IOException, InterruptedException {
		graficoMensal.click();
		waitForElementToBeInvisible(loader);
		btnExperimenteGratis.click();
		waitForElementToBeInvisible(loader);
		btnContratarAgora.click();
		waitForElementToBeInvisible(loader);
		flagTermoDeAceite.click();
		waitForElementToBeInvisible(loader);
		btnAtivarGratis.click();
		labelMsgSucesso.isDisplayed();
		validarTextoElemento(labelMsgSucesso, textMsgSucesso);
		btnVoltarPainel.click();

	}

	public void validarContratacao(String cnpjEsperado, String statusEsperado) throws InterruptedException {

		validarTextoElemento(panelTitleId, textPanelTitleId);
		menuDocumentos.click();
		waitForElementToBeInvisible(loader);
		Assert.assertTrue("Status diferente do esperado para contratação no período de testes",
				contratadoGratis.getText().contains("dias restantes"));
		validarTextoElemento(dtContratacao, textdtContratacao);
		validarTextoElemento(primeiraMensalidade, textprimeiraMensalidade);

	}

	public void cancelamentoPainel(String cnpjContratado) throws IOException, InterruptedException {
		menuDocumentos.click();
		waitForElementToBeInvisible(loader);
		btnCancelar.click();
		waitForElementPageToBeClickable(btnConfirmarCancelar);
		btnConfirmarCancelar.click();

	}

	public void validarCancelamentoPainel(String status) throws IOException, InterruptedException {
		if (status.equals("TESTE GRÁTIS")) {
			//TODO
			
			// Assert.assertTrue("Status diferente do esperado para contratação
			// no período de testes",
			// contratadoGratis.getText().contains(" do Alelo Painel Meu
			// Negócio"));
		} else if (status.equals("Cancelado")) {

			validarTextoElemento(statusCancelado, status);
		}
		validarTextoElemento(ultimaMensalidade, textUltimaMensalidade);
	}

	public PainelActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
