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
import org.openqa.selenium.Keys;
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

	public void sairGeral() throws Throwable {

		waitForElementToBeInvisible(loader);
		iconoPerfil.click();
		btnSair.click();
	}

	public void alterarEstabelecimento() throws IOException, InterruptedException {
		alterarCNPJ(opcao_ec1);
		waitForElementToBeInvisible(loader);
		alterarCNPJ(opcao_ec4);
		waitForElementToBeInvisible(loader);
		alterarCNPJ(opcao_ec3);
		waitForElementToBeInvisible(loader);
		alterarCNPJ(opcao_ec4);
		waitForElementToBeInvisible(loader);
	}

	public void alterarEstabelecimentoPainel() throws IOException, InterruptedException {
		alterarCNPJ(ofertaPainel);
		waitForElementToBeInvisible(loader);
	}

	public void alterarEstabelecimentoPainelContratacaoCancelamento(String cnpj)
			throws IOException, InterruptedException {

		if (cnpj.equals("82143278000182")) {
			alterarCNPJ(testeGratis);
			waitForElementToBeInvisible(loader);
		} else if (cnpj.equals("12259140000168")) {
			alterarCNPJ(opcao_ec4);
			waitForElementToBeInvisible(loader);
		} else if (cnpj.equals("28339982000160")) {
			alterarCNPJ(opcao_ec3);
			waitForElementToBeInvisible(loader);
		}
			else if (cnpj.equals("12259140000168")) {
				alterarCNPJ(opcao_ec4);
				waitForElementToBeInvisible(loader);
		} else
			alterarCNPJ(desbloq_2);
		waitForElementToBeInvisible(loader);
	}

	public void alterarEstabelecimentoPlano() throws IOException, InterruptedException {
		alterarCNPJ(opcao_ec_plano);
		waitForElementToBeInvisible(loader);
	}

	public void alterarEstabelecimentoPlanoSaldo() throws IOException, InterruptedException {
		alterarCNPJ(opcao_ec_plano_saldo);
		waitForElementToBeInvisible(loader);
	}

	public void alterarEstabelecimentoArv() throws IOException, InterruptedException {
		alterarCNPJ(opcao_ec_arv);
		waitForElementToBeInvisible(loader);
	}

	public void alterarEstabelecimentoBloq(String cnpj) throws IOException, InterruptedException {

		if (cnpj.equals("1")) {
			alterarCNPJ(opcao_ec3);
			waitForElementToBeInvisible(loader);
		} else if (cnpj.equals("2")) {
			alterarCNPJ(opcao_ec4);
			waitForElementToBeInvisible(loader);
		}
	}

	public void alterarEstabelecimentoDesbloq(String cnpj) throws IOException, InterruptedException {

		if (cnpj.equals("2")) {
			alterarCNPJ(desbloq_2);
			waitForElementToBeInvisible(loader);
		} else if (cnpj.equals("1")) {
			alterarCNPJ(desbloq_1);
			waitForElementToBeInvisible(loader);
		}
	}

	public void alterarEstabelecimentoSemPlanoSemSaldo() throws IOException, InterruptedException {
		alterarCNPJ(opcao_ec_sp_ss);
	}

	private void alterarCNPJ(WebElement elemento) throws IOException, InterruptedException {
		opcao_select.click();
		Thread.sleep(2000);
		elemento.click();
		waitForElementToBeInvisible(loader);
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
			//TODO validar quando liberar o painel diário 
			//validarTextoElemento(graficodiario, munuDiario);
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
		waitForElementToBeInvisible(loader);
		waitForElementPageToBeClickable(graficoMensal);
		graficoMensal.click();
		waitForElementToBeInvisible(loader);
		Thread.sleep(2000);
		btnExperimenteGratis.click();
		waitForElementToBeInvisible(loader);
		waitForElementPageToBeClickable(btnContratarAgora);
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

		validarTextoElemento(statusText, textConfirmacao);
	}
	
	public void realizaBuscaEstabelecimento(String estabelecimento) {

		waitForElementPageToBeClickable(opcao_select);
		opcao_select.clear();
		opcao_select.sendKeys(estabelecimento);
		opcao_select.sendKeys(Keys.DOWN);
		opcao_select.sendKeys(Keys.ENTER);

	}
	
	public void clicaMenuExtrato() {

		waitForElementPageToBeClickable(menuExtrato);
		menuExtrato.click();

	}

	public PainelActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
