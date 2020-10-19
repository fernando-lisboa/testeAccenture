package br.com.alelo.qa.web.actions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.apache.commons.codec.language.bm.Languages.SomeLanguages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alelo.qa.features.support.JavaScriptUtils;
import br.com.alelo.qa.web.page.AntecipacaoPage;
import br.com.alelo.qa.web.page.PlanosPage;
import br.com.alelo.utils.DriverAnonimo;

public class AntecipacaoActions extends AntecipacaoPage {

	JavaScriptUtils javaS = new JavaScriptUtils(webdriver);
	JavaScriptUtils javaSA = new JavaScriptUtils(DriverAnonimo.getDriver());
	WebDriver driver = DriverAnonimo.getDriver();

	public AntecipacaoActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String text;

	public void validarSideKickAlert() {
		try {
			waitForElementToBeInvisible(loader);
			List<WebElement> listAba = webdriver.findElements(By.className("navbar-nav")).get(0)
					.findElements(By.tagName("a"));

			for (Integer y = 1; y <= listAba.size(); y++) {
				WebElement elAba = webdriver
						.findElement(By.xpath("/html/body/div[1]/main/body/div/nav/div/div[2]/ul[1]/li[" + y + "]/a"));
				elAba.click();
				waitForElementToBeInvisible(loader);
				WebElement alertside = webdriver.findElement(By.xpath("//*[@id=\"alertSidekick\"]/div/span"));
				if (!alertside.isEnabled() && !alertside.isDisplayed())
					fail("Modal sidekick nao apresentado ou desabilitado na aba: " + elAba.getText());
			}
		} catch (Exception e) {
			System.out.println("não localizado elemento na tela " + labelSidekick + " " + e);
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

	public void FluxoAntecipacaoDeRecebiveisARV(boolean Modal, String Cenario, boolean Valor, boolean Recorrencia,
			boolean Contratacao, String cnpj) {
		try {
			Thread.sleep(4000);

			PlanosPage planosPage = new PlanosPage(webdriver);

			if (!Modal) {
				if (Cenario.contains("operador")) {
					driver.navigate().to("https://meuestabelecimento-hml.siteteste.inf.br/antecipe");
					waitForElementToBeInvisible(loader);
					alterarEstabelecimento(cnpj);
				} else if (!Cenario.contains("operador")) {
					webdriver.navigate().to("https://meuestabelecimento-hml.siteteste.inf.br/antecipe");
					waitForElementToBeInvisible(loader);
					alterarEstabelecimento(cnpj);
					waitForElementToBeInvisible(loader);
				}
			} else
				// Abre Modal
				javaS.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null, planosPage.botao_side_kick);

			String cenario_ = Cenario.replace("operador", "").replace("estabelecimento", "");

			if (cenario_.trim().equals("Parcial")) {
				// Clicar em Alterar Valor
				if (!PreencheValorCampoSetSelectButton(null, btnAlteraValor, null, 40))
					fail("Botao Altera valor sem ação");

				if (Valor) {
					// Preenche - INSIRA ABAIXO O VALOR QUE DESEJA ANTECIPAR
					if (!PreencheValorCampoSetSelectButton(null, campoAlterarValor, "100000", 40))
						fail("Campo Altera Valor nao pode ser preenchido");

					Thread.sleep(2000);

					// VISUALIZAR VALORES DISPONÍVEIS
					if (!PreencheValorCampoSetSelectButton(null, btnVisualizarValores, null, 40))
						fail("Botao visualizar valores sem ação");

					// Apresenta os valores disponíveis para antecipação
					waitForElementPageToBeClickable(calcularValorLiquido);
					List<WebElement> listaChecksValoresDisponiveis = webdriver.findElements(By.name("groupSummary"));
					if (!PreencheValorCampoSetSelectButton(null, listaChecksValoresDisponiveis.get(0), null, 40))
						fail("checkbox de selecao de valor sem ação");

					// CALCULAR VALOR LÍQUIDO
					if (calcularValorLiquido.isEnabled())
						if (!PreencheValorCampoSetSelectButton(null, calcularValorLiquido, null, 40))
							fail("Botao Calcular valor líquido sem ação");
				}
				// TODo contratar

			}

			if (Recorrencia) {
				Thread.sleep(2000);
				if (!PreencheValorCampoSetSelectButton(null, btnAlterarRecorrencia, null, 40))
					fail("Botao Altera Recorrencia sem ação");
				waitForElementPageToBeClickable(webdriver.findElement(By.id("cardRecurr-DAILY")));

				switch (cenario_.trim()) {
				case "Recorrente Diário":
					webdriver.findElement(By.id("cardRecurr-DAILY")).click();
					waitForElementToBeInvisible(loader);
					break;
				case "RecorrenteTotal Semanal":
					webdriver.findElement(By.id("cardRecurr-WEEKLY")).click();
					Thread.sleep(1000);
					webdriver.findElement(By.id("radioWeekly-QUA")).click();
					waitForElementToBeInvisible(loader);
					break;
				case "Recorrente Desativado":
					webdriver.findElement(By.id("cardRecurr-DISABLED")).click();
					waitForElementToBeInvisible(loader);
					break;
				default:
					break;
				}
				// DEFINIR RECEBIMENTO
				if (botaoDefinirRecebimento.isEnabled())
					javaS.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null, botaoDefinirRecebimento);
			}

			// CONTRATAR RECORRENCIA
			if (Recorrencia) {
				waitForElementPageToBeClickable(checkAceiteTermosRecebiveis);
				if (!PreencheValorCampoSetSelectButton(null, checkAceiteTermosRecebiveis, null, 40))
					fail("Flag de concordo com termos não clicável");
				waitForElementPageToBeClickable(btnAntecipar);
				btnAntecipar.click();
			}

			if (Contratacao) {
				Thread.sleep(2000);

				if (!PreencheValorCampoSetSelectButton(null, checkAceiteTermosRecebiveis, null, 40))
					fail("Flag de concordo com termos não clicável");

				webdriver.findElement(By.id("anticipationButton")).click();
				Thread.sleep(2000);
				if (Cenario.contains("operador")) {
					text = webdriver.findElement(By.xpath("//div[@id='simulationAlert']/div[2]")).getText();
					System.out.println(text);
					Assert.assertTrue("Simulação não foi efetivada... contratado arv pelo operador",
							text.equals(textoConfirmacaoArv));
				}

			}
			validarMensagemContratacao(Recorrencia, Cenario, Modal);

			Thread.sleep(200);
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}
	
	

	public void ResultadoEvidencia(String Resultado) throws InterruptedException {
		Thread.sleep(2000);
		switch (Resultado) {

		case "valor bruto deve ser menor que o valor liquido apresentado na abertura":
			if (!webdriver.findElement(By.id("anticipationModalAnticipationBoxValorLiquido")).isDisplayed())
				fail("a validação de Valor nao foi possivel");
			Thread.sleep(2000);
			break;
		case "valor bruto deve ser total":
			if (!webdriver.findElement(By.id("anticipationModalAnticipationBoxValorBruto")).isDisplayed())
				fail("a validação de Valor nao foi possivel");
			break;
		case "antecipacao recorrente deve estar ativa":
			if (!webdriver.findElement(By.xpath("//div[@id='anticipationModalAnticipationBody']/div[1]/div[4]/div/h4"))
					.getText().equals("ATIVA"))
				fail("antecipacao recorrente deveria estar ativa");
			break;
		case "antecipacao recorrente deve estar inativa":

			if (!webdriver.findElement(By.xpath("//div[@id='anticipationModalAnticipationBody']/div[1]/div[4]/div/h4"))
					.getText().equals("INATIVA"))
				fail("antecipacao recorrente deveria estar inativa");
			break;
		case "SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO":
			text = webdriver.findElement(By.xpath("//div[@id='simulationAlert']/div[2]")).getText();
			if (!text.equals("IMPORTANTE: A simulação não efetivará a contratação do produto."))
				fail("antecipacao recorrente deveria estar inativa");

			break;

		}
	}

	public void alterarEstabelecimento(String numCNPJ) throws InterruptedException {
		
		Thread.sleep(2000);
		waitForElementToBeInvisible(loader);
		
		Thread.sleep(1000);
		try {
			WebElement cnpj_ = webdriver.findElement(By.id("cnpj"));
			cnpj_.click();
			Thread.sleep(2000);

			WebElement findElement = webdriver
					.findElement(By.xpath("//div[@class='cnpjComboBox'][contains(.,'" + numCNPJ + "')]"));
			findElement.click();

		} catch (Exception e) {
			System.out.println("ERRO AO SELECIONAR O CNPJ =>"+"["+numCNPJ+"]"+ e.getMessage());
		}

		waitForElementToBeInvisible(loader);
	}

	public void validarMensagemContratacao(Boolean Recorrencia, String Cenario, Boolean Modal)
			throws InterruptedException {

		// Validação para contratações atraves da tela antecipe
		if (!Modal) {

			Thread.sleep(2000);
			if (Recorrencia) {

				if (Modal) {
					try {

						Thread.sleep(2000);
						List<WebElement> list = confirmacaoSimulacao.findElements(By.tagName("h2"));
						String el1 = list.get(0).getText();
						String el2 = list.get(1).getText();
						Thread.sleep(3000);
						Assert.assertThat("Recorrencia não efetivada...", el1 + " " + el2,
								is(textoconfirmacaoSimulacao.toUpperCase()));
					} catch (InterruptedException e) {
						System.out.println("Recorrencia não efetivada " + e);
						e.printStackTrace();
					}
				} else if (!Modal && !Cenario.contains("operador")) {
					try {
						Thread.sleep(2000);
						List<WebElement> list = confirmacaoSimulacao.findElements(By.tagName("h2"));
						String el1 = list.get(0).getText();
						String el2 = list.get(1).getText();
						Thread.sleep(3000);
						Assert.assertThat("Recorrencia não efetivada...", el1 + " " + el2,
								is(textoconfirmacaoSimulacao.toUpperCase()));
					} catch (InterruptedException e) {
						System.out.println("Recorrencia não efetivada " + e);
						e.printStackTrace();
					}
				}

			}
			if (!Recorrencia && !Cenario.contains("operador")) {
				try {
					Thread.sleep(2000);
					List<WebElement> list = modalConfirmacaoContratacaoArvTela.findElements(By.tagName("h2"));
					String el1 = list.get(0).getText();
					String el2 = list.get(1).getText();
					Thread.sleep(3000);
					Assert.assertThat("Contratação não foi efetivada...", el1 + " " + el2,
							is(textoConfirmacaoContratacaoArvTela));
				} catch (InterruptedException e) {
					System.out.println("Contratação não efetivada " + e);
					e.printStackTrace();

				}
			}
		}

		if (Modal) {
			// VALIDA RESULTADO DE CONTRATAÇÃO DE ARV
			Thread.sleep(2000);
			if (Recorrencia) {

				if (Modal) {
					try {

						Thread.sleep(1000);
						List<WebElement> list = confirmacaoSimulacao.findElements(By.tagName("h2"));
						String el1 = list.get(0).getText();
						String el2 = list.get(1).getText();
						Thread.sleep(1000);
						Assert.assertThat("Recorrencia não efetivada...", el1 + " " + el2,
								is(textoconfirmacaoSimulacao.toUpperCase()));
					} catch (InterruptedException e) {
						System.out.println("Recorrencia não efetivada " + e);
						e.printStackTrace();
					}
				} else {
					try {
						Thread.sleep(2000);
						List<WebElement> list = confirmacaoSimulacao.findElements(By.tagName("h2"));
						String el1 = list.get(0).getText();
						String el2 = list.get(1).getText();
						Thread.sleep(3000);
						Assert.assertThat("Recorrencia não efetivada...", el1 + " " + el2,
								is(textoconfirmacaoSimulacao.toUpperCase()));
					} catch (InterruptedException e) {
						System.out.println("Recorrencia não efetivada " + e);
						e.printStackTrace();
					}
				}

			}
			// Valida mensagen de sucesso para contratação via Modal
			if (!Recorrencia && !Cenario.contains("operador")) {
				try {
					Thread.sleep(2000);
					List<WebElement> list = modalConfirmacaoContratacaoArv.findElements(By.tagName("h2"));
					String el1 = list.get(0).getText();
					String el2 = list.get(1).getText();
					Thread.sleep(3000);
					Assert.assertThat("Contratação não foi efetivada...", el1 + " " + el2,
							is(textoConfirmacaoContratacaoArv));
				} catch (InterruptedException e) {
					System.out.println("Contratação não efetivada " + e);
					e.printStackTrace();
				}
			}
		}
		// VALIDA RESULTADO DE SIMULAÇÃO DE CONTRATAÇÃO DE ARV
		if (Cenario.contains("operador")) {
			text = webdriver.findElement(By.xpath("//div[@id='simulationAlert']/div[2]")).getText();
			System.out.println(text);
			Assert.assertTrue("Simulação não foi efetivada... contratado arv pelo operador",
					text.equals(textoConfirmacaoArv));
		}
	}

	// define recorrecia automática após contratação pontual
	public void definirRecorrenciaAposContratacao(Boolean operador, String cenario, String modal)
			throws InterruptedException {
		if (!PreencheValorCampoSetSelectButton(null, bntConfirmaContratacaoRecorrente, null, 40))
			fail("Botão confirmar recorrencia não clicável");
		waitForElementPageToBeClickable(webdriver.findElement(By.id("cardRecurr-DAILY")));
		switch (cenario.trim()) {
		case "Recorrente Diário":
			webdriver.findElement(By.id("cardRecurr-DAILY")).click();
			break;
		case "RecorrenteTotal Semanal":
			webdriver.findElement(By.id("cardRecurr-WEEKLY")).click();
			Thread.sleep(1000);
			webdriver.findElement(By.id("radioWeekly-QUA")).click();
			break;

		default:
			break;
		}

		if (botaoDefinirRecebimento.isEnabled())
			botaoDefinirRecebimento.click();
		waitForElementToBeInvisible(loader);

		if (operador) {
			waitForElementPageToBeClickable(btnOkrecorrencia);
			Assert.assertTrue("Não efetivou a simulação corretamente",
					msgSucessoRecorrencia.getText().equals(txtMsgRecorrencia));
		} else {
			waitForElementPageToBeClickable(btnOkrecorrencia);
			Assert.assertTrue("Não efetivou a simulação corretamente",
					msgSucessoContratacaoRecorrencia.getText().equals(txtMsgContratacaoRecorrencia));
		}

		if (modal.equals("antecipe") && operador) {
			javaSA.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null, aceptMsgAntecipe);
		} else if (modal.equals("modal") && operador) {
			javaSA.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null, aceptMsg);
		} else {
			btnOkrecorrencia.click();
		}
		if (operador) {
			//sairDaSimulação(modal);
		}
	}

	// Valida se ao contrratar recorrencia, volta para o inicio o fecha a sessão
	public void sairDaSimulação(String modal) throws InterruptedException {
		Thread.sleep(5000);
		waitForElementToBeInvisible(loader);
		Assert.assertThat("não simulou recorrencia", acceptHelpSimulation.getText(), is(txtAccetpHelpSimulation));
		javaSA.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null, btnOkHelp);
		if (driver.getCurrentUrl().contains(modal)) {
			Assert.assertTrue("SideKick não está presente na tela após simulação", sideKickSimulation.isDisplayed());
			System.out.println("Voltou para a tela inicial após o final do teste e manteve o scope OPERADOR");
			driver.findElement(By.id("nav-dropdown")).click();
			driver.findElement(By.id("navbarDesktopSair")).click();
			System.out.println("fim dos testes");

		} else {
			fail("Não retornou para a tela inicial após simulação");
			driver.findElement(By.id("nav-dropdown")).click();
			driver.findElement(By.id("navbarDesktopSair")).click();
		}
	}
}
