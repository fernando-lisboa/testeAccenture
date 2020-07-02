package br.com.alelo.qa.web.actions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.alelo.qa.web.page.OfertaAtivaPage;

/**
 * @author Fernando Lisboa classe responsável pelas ações de proposta ativa
 *
 */
public class OfertaAtivaActions extends OfertaAtivaPage {

	String vlrTotalNovaSimulacao;
	String vlrTotalOferta;

	public void preencherCnpj(String valor) {

		comboCnpj.click();
		cnpjComOferta.click();

	}

	public void alterarCNPJ() throws IOException, InterruptedException {

		webdriver.get("https://meuestabelecimento-desenvolve-sit.siteteste.inf.br/servicos");
		Thread.sleep(5000);
		btnOkEntendi.click();
		Thread.sleep(3000);
		cnpj.click();
		Thread.sleep(2000);
		cnpjComOferta.click();

		System.out.println("Url servicos OK");
	}

	public void acceptAlert() {
		new WebDriverWait(webdriver, 10).until(ExpectedConditions.alertIsPresent());
		webdriver.switchTo().alert().accept();
	}

	public void sideKick() throws InterruptedException {

		// TODO Implementar click no Sidekick

	}

	public void clicarSaibaMais() {

		simuleJa.click();

	}

	public void aceitarTermo() {

		JavascriptExecutor jsExec = (JavascriptExecutor) webdriver;
		jsExec.executeScript("scroll.scrollDown += 100");
		flagTermoDeAceite.click();
	}

	public void confirmarContratacao() {

		btnContratarAgora.click();

	}

	public void alterarValor() {

		btnAlterarValor.click();
		btnBarraValor.click();

	}

	public void simularNovamente() throws Throwable {
		btnSimularNovamente.click();
		Thread.sleep(2000);
	}

	public void alterarParcelas() {
		btnBarraParcelas.click();

	}

	public void validarDetalheDaContratacao() {

		String vlrPrimeiraParcela = primeiraParcela.getText();
		String vlrUltimaParcela = valorUltimaParcela.getText();
		String dtPrimeiraParcela = vencimentoPrimeiraParcela.getText().replaceAll("/", "");
		String dtultimaParcela = vencimentoUltimaParcela.getText().replaceAll("/", "");
		String custoEfetivo = cet.getText();
		vlrTotalOferta = valorDoCredito.getText();

		String dtEsperadaPrimeiraParcela = dataPrimeiraParcela30();
		String dtEsperadaUltimaParcela = dataUltimaParcela();
		Assert.assertTrue("Valor da Primeira parcela inexistente...", vlrPrimeiraParcela != null);
		Assert.assertTrue("Valor da Ultima parcela inexistente...", vlrUltimaParcela != null);

		Assert.assertTrue("Data da primeira parcela diferente de 30 dias...",
				dtEsperadaPrimeiraParcela.equals(dtPrimeiraParcela));
		Assert.assertTrue("Data da primeira parcela diferente de 30 dias...",
				dtEsperadaUltimaParcela.equals(dtultimaParcela));
		Assert.assertTrue("Valor da Primeira parcela inexistente...", custoEfetivo != null);
		Assert.assertTrue("Valor da Primeira parcela inexistente...", vlrTotalOferta != null);
	}

	public void validarNovaSimulacao() {

		String vlrPrimeiraParcela = primeiraParcela.getText();
		String vlrUltimaParcela = valorUltimaParcela.getText();
		String dtPrimeiraParcela = vencimentoPrimeiraParcela.getText().replaceAll("/", "");
		String dtultimaParcela = vencimentoUltimaParcela.getText().replaceAll("/", "");
		String custoEfetivo = cet.getText();
		vlrTotalNovaSimulacao = valorDoCredito.getText();

		String dtEsperadaPrimeiraParcela = dataPrimeiraParcela30();
		String dtEsperadaUltimaParcela = dataUltimaParcela();
		Assert.assertTrue("Valor da Primeira parcela inexistente...", vlrPrimeiraParcela != null);
		Assert.assertTrue("Valor da Ultima parcela inexistente...", vlrUltimaParcela != null);

		Assert.assertTrue("Data da primeira parcela diferente de 30 dias...",
				dtEsperadaPrimeiraParcela.equals(dtPrimeiraParcela));
		Assert.assertTrue("Data da primeira parcela diferente de 30 dias...",
				dtEsperadaUltimaParcela.equals(dtultimaParcela));
		Assert.assertTrue("Valor da Primeira parcela inexistente...", custoEfetivo != null);
		Assert.assertTrue("Valor da Primeira parcela inexistente...", vlrTotalNovaSimulacao != vlrTotalOferta);
	}

	public void voltarSemAlterar() {
		btnVoltarSemAlterar.click();

	}

	public void validarQueNaoAlterouValorAoVoltar() {
		String valorInicial = valorDoCredito.getText();

		Assert.assertTrue("Valor oferecido divergente...", valorInicial.equals(vlrTotalOferta));
	}

	public String dataPrimeiraParcela30() {

		Calendar data = Calendar.getInstance();
		data.setTime(new Date());
		data.add(Calendar.MONTH, +1);
		String dataFormatada = new SimpleDateFormat("ddMMyyyy").format(data.getTime());

		return dataFormatada;

	}


	public String dataUltimaParcela() {

		Calendar data = Calendar.getInstance();
		data.setTime(new Date());
		data.add(Calendar.MONTH, +12);
		String dataFormatada = new SimpleDateFormat("ddMMyyyy").format(data.getTime());

		return dataFormatada;

	}
	
	public void sair() {

		btnProfile.click();
		btnSair.click();
		
	}

	public OfertaAtivaActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	

}
