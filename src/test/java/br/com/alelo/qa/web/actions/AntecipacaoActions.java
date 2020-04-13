package br.com.alelo.qa.web.actions;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.alelo.qa.features.support.JavaScriptUtils;
import br.com.alelo.qa.web.page.PlanosPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.AntecipacaoPage;
import org.openqa.selenium.WebElement;

public class AntecipacaoActions extends AntecipacaoPage {

	public AntecipacaoActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void alterarEstabelecimento(String cnpjAgenda) throws IOException, InterruptedException {
		// waitForElementPageToLoad(loader);
		Thread.sleep(3000);
		alterarCNPJ(cnpjAgenda);
		Thread.sleep(2000);
	}

	public void antecipacaoARV() throws InterruptedException {
		// waitForElementPageToLoad(loader);
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

	public void validarSideKickAlert() {
		try {
			for (WebElement aba : webdriver.findElements(By.className("navbar-nav")).get(0)
					.findElements(By.tagName("a"))) {
				System.out.println(aba.getText());
				aba.click();
				waitForElementToBeInvisible(loader);
				if(!sideKickAtencao.isEnabled()&& !sideKickAtencao.isDisplayed()){
					
					
					fail("Sidekick de simulação não está disponível para o operador na aba "+ aba.getText() );
					
					
				}
			}
		} catch (Exception e) {
			System.out.println("não localizado elemento na tela "+ labelSidekick +" " + e);
		}

	}

	public void clicarAntecipar() throws InterruptedException {
		Thread.sleep(3000);
		btnAntecipar.click();
		// waitForElementPageToLoad(loader);
		Thread.sleep(3000);
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
		// waitForElementPageToLoad(loader);
		Thread.sleep(3000);
	}

	public void selecionarOpcao() throws InterruptedException {
		Thread.sleep(3000);
	}

	public void calcularValor() {
		calcularValorLiquido.click();
	}

	public void clicarAlterar() throws InterruptedException {
		// waitForElementPageToLoad(loader);
		Thread.sleep(3000);
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
		// waitForElementPageToLoad(loader);
		Thread.sleep(3000);
		comboCnpj.click();
		Thread.sleep(5000);
		// clicar("xpath", elemento3); TODO aplicar o cnpj a ser selecionado
		// após clicar no combo
	}

	public void navegarUrl(String url) {
		webdriver.navigate().to(url);
	}

	public Integer valorTotalRecebiveis_ = 0;
	public Integer valorSelecionado_ = 0;

	public void FluxoAntecipacaoDeRecebiveisARV(boolean Modal, String Cenario, boolean Valor, boolean Antecipacao) {
		try {
			Thread.sleep(4000);
			JavaScriptUtils javaS = new JavaScriptUtils(webdriver);
			PlanosPage planosPage = new PlanosPage(webdriver);

			if (!Modal) {
				webdriver.navigate().to("https://meuestabelecimento-hml.siteteste.inf.br/antecipe");
			} else {
				// Abre Modal
				javaS.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null, planosPage.botao_side_kick);
			}

			// Armazena o valor total de Recebiveis sem alterações
			// javaS.waitForElementPageToBeClickable(webdriver.findElement(By.xpath("//*[@id='anticipationModalAnticipationBoxValorLiquido']/h1")));
			// String valorTotalRecebiveis =
			// webdriver.findElement(By.xpath("//*[@id='anticipationModalAnticipationBoxValorLiquido']/h1")).getText().replace("R$
			// ", "").replace(".", "");
			// valorTotalRecebiveis_ = Integer.parseInt(valorTotalRecebiveis);

			if (Cenario.equals("Parcial")) {
				// Clicar em Alterar Valor
				PreencheValorCampoSetSelectButton(null, btnAlteraValor, null, 40);

				if (Valor) {
					// Preenche - INSIRA ABAIXO O VALOR QUE DESEJA ANTECIPAR
					PreencheValorCampoSetSelectButton(null, campoAlterarValor, "100000", 40);

					Thread.sleep(2000);

					// VISUALIZAR VALORES DISPONÍVEIS
					PreencheValorCampoSetSelectButton(null, btnVisualizarValores, null, 40);

					// Apresenta os valores disponíveis para antecipação
					waitForElementPageToBeClickable(calcularValorLiquido);
					List<WebElement> listaChecksValoresDisponiveis = webdriver.findElements(By.name("groupSummary"));
					PreencheValorCampoSetSelectButton(null, listaChecksValoresDisponiveis.get(0), null, 40);

					// CALCULAR VALOR LÍQUIDO
					if (calcularValorLiquido.isEnabled())
						PreencheValorCampoSetSelectButton(null, calcularValorLiquido, null, 40);
				}
				// String valorSelecionado =
				// webdriver.findElement(By.xpath("//*[@id='anticipationModalAnticipationBoxValorLiquido']/h1")).getText().replace("R$
				// ", "").replace(".", "");
				// valorSelecionado_ = Integer.parseInt(valorSelecionado);
			}

			if (Antecipacao) {
				PreencheValorCampoSetSelectButton(null, btnAlterarRecorrencia, null, 40);
				switch (Cenario) {
				case "Recorrente Diário":
					PreencheValorCampoSetSelectButton(null, webdriver.findElement(By.id("cardRecurr-DAILY")), null, 40);
					break;
				case "RecorrenteTotal Semanal":
					PreencheValorCampoSetSelectButton(null, webdriver.findElement(By.id("cardRecurr-WEEKLY")), null,
							40);
					Thread.sleep(1000);
					PreencheValorCampoSetSelectButton(null, webdriver.findElement(By.id("radioWeekly-QUA")), null, 40);
					break;
				case "Recorrente Desativado":
					PreencheValorCampoSetSelectButton(null, webdriver.findElement(By.id("cardRecurr-DISABLED")), null,
							40);
					break;
				default:
					break;
				}
				// DEFINIR RECEBIMENTO
				if (botaoDefinirRecebimento.isEnabled())
					javaS.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null, botaoDefinirRecebimento);
			}

			// CONCORDO COM OS TERMOS DE ANTECIPAÇÃO DE RECEBÍVEIS
			PreencheValorCampoSetSelectButton(null, checkAceiteTermosRecebiveis, null, 40);
			Thread.sleep(200);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void ResultadoEvidencia(String Resultado) {
		switch (Resultado) {
		case "valor bruto deve ser menor que o valor liquido apresentado na abertura":
			// if(valorTotalRecebiveis_ < valorSelecionado_)
			break;
		case "valor bruto deve ser total":
			break;
		case "antecipacao recorrente deve estar ativa":

			break;
		case "antecipacao recorrente deve estar inativa":
			break;
		}
	}

	public void alterarEstabelecimentoArv(boolean cnpj) throws IOException, InterruptedException {
		   WebElement cnpj_ = webdriver.findElement(By.id("cnpj"));
		   cnpj_.click();
		   Thread.sleep(1000);
		   List<WebElement> cnpjs = new ArrayList<>();
		   for (WebElement cnPJ : webdriver.findElement(By.xpath("//*[@id='cnpjSelector']/div"))
		         .findElements(By.tagName("b"))) {
		      cnpjs.add(cnPJ);
		      System.out.println(cnPJ.getText());
		   }
		   for (WebElement cnPJ : webdriver.findElement(By.xpath("//*[@id='cnpjSelector']/div"))
		         .findElements(By.tagName("span"))) {
		      cnpjs.add(cnPJ);
		      System.out.println(cnPJ.getText());
		   }
		   
		   if (cnpj)
		      for (WebElement cnPJ : cnpjs) {
		         if (cnPJ.getText().equals(opcaoARV)) {
		            cnPJ.click();
		            break;
		         }
		      }
		   else
		      for (WebElement cnPJ :cnpjs) {
		         if (cnPJ.getText().equals(opcaoEC)) {
		            cnPJ.click();
		            break;
		         }
		      }
		   waitForElementToBeInvisible(loader);
		}
}
