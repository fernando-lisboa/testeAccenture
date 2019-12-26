package br.com.alelo.qa.web.actions;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.AntecipacaoPage;

public class AntecipacaoActions extends AntecipacaoPage {

	public void alterarEstabelecimento(String cnpjAgenda) throws IOException, InterruptedException {
		waitForElementPageToLoad(loader);
		alterarCNPJ(cnpjAgenda);
		Thread.sleep(2000);
	}

	public void alterarEstabelecimentoArv(String cnpjAgenda) throws IOException, InterruptedException {

		waitForElementPageToLoad(loader);
		alterarCNPJ(cnpjAgenda);
		Thread.sleep(2000);
	}

	public void antecipacaoARV() throws InterruptedException {
		waitForElementPageToLoad(loader);
		Thread.sleep(5000);
		clicaArv.click();
		String sidekick;
		sidekick = btnSideKick.getText();

		if (sidekick.equals("SOLICITE AGORA")) {
			Thread.sleep(5000);
			btnSideKick.click();
		} else {
			fail("Texto diferente do que foi procurado");
		}
	}

	public void concordarTermos() throws InterruptedException {
		Thread.sleep(3000);
		checkAceiteTermosRecebiveis.click();
	}

	public void clicarAntecipar() throws InterruptedException {
		Thread.sleep(3000);
		btnAntecipar.click();
		waitForElementPageToLoad(loader);
	}

	public void validaAntecipacao() throws InterruptedException {
		String msgAntecipacao = mensagemAntecipacao.getText();

		if (msgAntecipacao.equalsIgnoreCase("antecipação realizada")) {
			Thread.sleep(1000);
			System.out.println(mensagemAntecipacao);
			botaoFechar.click();
		} else {
			fail("Mensagem procurada não é igual a esperada, falha na antecipação");
		}
	}

	public void clicarCancelar() {
		botaoCancelar.click();
	}

	public void clicarCancelarParcial() {
		botaoCancelarParcial.click();
	}

	public void clicarCancelarRecorrencia() {
		botaoCancelarRecorrencia.click();
	}

	public void validaCancelamentoAntecipacao() {
		validarUrlAtual(getUrlInicio());
		System.out.println("Antecipação cancelada");
	}

	public void clicarFechar() {
		waitForElementPageToBeClickable(botaoFechar);
		botaoFechar.click();
	}

	public void telaArv() throws InterruptedException {
		System.out.println("acessando URL Arv página nova..." + getUrlInicioArv());
		navegarUrl(getUrlInicioArv());
		Thread.sleep(2000);
	}

	public void modalfechado() {
		validarUrlAtual(getUrlInicio());
		System.out.println("Modal fechado");
	}

	public void clicarAlterarValor() throws InterruptedException {
		Thread.sleep(3000);
		btnAlteraValor.click();
	}

	public void inserirValor() throws InterruptedException {
		Thread.sleep(2000);
		Double valorMaxAntecipar = Double
				.parseDouble(valorMaximo.getText().substring(3, 11).replace(".", "").replace(",", "."));

		double valorAntecipar = 0;

		if (valorMaxAntecipar >= 0) {
			valorAntecipar = valorMaxAntecipar / 10;
			System.out.println(valorAntecipar);
		} else {
			fail("Divisão igual ou menor a zero para antecipação");
		}

		campoAlterarValor.sendKeys(String.valueOf(valorAntecipar));
	}

	public void clicarVizualizarValores() throws InterruptedException {
		btnVisualizarValores.click();
		waitForElementPageToLoad(loader);
	}

	public void selecionarOpcao() throws InterruptedException {
		Thread.sleep(3000);
	}

	public void calcularValor() {
		celularValorLiquido.click();
	}

	public void clicarAlterar() {
		waitForElementPageToLoad(loader);
		waitForElementPageToBeClickable(btnAlteraValor);
		btnAlterarRecorrencia.click();
	}

	public void selecionarSemanal() throws InterruptedException {
		checkSemanal.click();
		Thread.sleep(3000);
	}

	public void selecionaDiaSemana() throws InterruptedException {
		checkDiaSemanal.click();
		Thread.sleep(3000);
	}

	public void selecionaOpcaoDesativada() throws InterruptedException {
		Thread.sleep(3000);
		checkDesativar.click();
	}

	public void clicaDefinirRecebimento() {
		botaoDefinirRecebimento.click();
	}

	public void validarModalAntecipacao() {
		String textoValidacao = tituloModalAntecipacao.getText();

		if (textoValidacao.equalsIgnoreCase(tituloModalAntecipacao.getText())) {
			System.out.println("Teste realizado com sucesso!");
		} else {
			fail("Texto procurado não é igual ao esperado");
		}
	}

	public void alterarCNPJ(String cnpjAgenda) throws IOException, InterruptedException {
		waitForElementPageToLoad(loader);
		comboCnpj.click();
		Thread.sleep(5000);
		// clicar("xpath", elemento3); TODO aplicar o cnpj a ser selecionado
		// após clicar no combo
	}

	public void navegarUrl(String url) {
		webdriver.navigate().to(url);
	}

	public AntecipacaoActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
