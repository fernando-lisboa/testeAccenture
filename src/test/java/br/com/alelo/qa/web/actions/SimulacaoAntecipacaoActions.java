//package br.com.alelo.qa.web.actions;
//
//import static org.hamcrest.CoreMatchers.is;
//
//import java.util.List;
//
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import br.com.alelo.qa.web.page.AntecipacaoPage;
//
//public class SimulacaoAntecipacaoActions  extends AntecipacaoPage{
//	
//	public SimulacaoAntecipacaoActions(WebDriver driver) {
//		super(driver);
//		// TODO Auto-generated constructor stub
//	}
//
//	public void validarMensagemContratacao(Boolean Recorrencia, String Cenario, Boolean Modal)
//			throws InterruptedException {
//
//		// Validação para contratações qtraves da tela antecipe
//		if (!Modal) {
//
//			Thread.sleep(2000);
//			if (Recorrencia) {
//
//				if (Modal) {
//					try {
//
//						Thread.sleep(2000);
//						List<WebElement> list = msgRecorrencia.findElements(By.tagName("h2"));
//						String el1 = list.get(0).getText();
//						String el2 = list.get(1).getText();
//						Thread.sleep(3000);
//						Assert.assertThat("Recorrencia não efetivada...", el1 + " " + el2,
//								is(textoMsgRecorrencia.toUpperCase()));
//					} catch (InterruptedException e) {
//						System.out.println("Recorrencia não efetivada " + e);
//						e.printStackTrace();
//					}
//				} else {
//					try {
//						Thread.sleep(2000);
//						List<WebElement> list = msgRecorrencia.findElements(By.tagName("h2"));
//						String el1 = list.get(0).getText();
//						String el2 = list.get(1).getText();
//						Thread.sleep(3000);
//						Assert.assertThat("Recorrencia não efetivada...", el1 + " " + el2,
//								is(textoMsgRecorrencia.toUpperCase()));
//					} catch (InterruptedException e) {
//						System.out.println("Recorrencia não efetivada " + e);
//						e.printStackTrace();
//					}
//				}
//
//			}
//			if (!Recorrencia) {
//				try {
//					Thread.sleep(2000);
//					List<WebElement> list = modalConfirmacaoContratacaoArvTela.findElements(By.tagName("h2"));
//					String el1 = list.get(0).getText();
//					String el2 = list.get(1).getText();
//					Thread.sleep(3000);
//					Assert.assertThat("Contratação não foi efetivada...", el1 + " " + el2,
//							is(textoConfirmacaoContratacaoArvTela));
//				} catch (InterruptedException e) {
//					System.out.println("Contratação não efetivada " + e);
//					e.printStackTrace();
//
//				}
//			}
//		}
//
//		if (Modal) {
//			// VALIDA RESULTADO DE CONTRATAÇÃO DE ARV RECORRENTE
//			Thread.sleep(2000);
//			if (Recorrencia) {
//
//				if (Modal) {
//					try {
//
//						Thread.sleep(2000);
//						List<WebElement> list = msgRecorrencia.findElements(By.tagName("h2"));
//						String el1 = list.get(0).getText();
//						String el2 = list.get(1).getText();
//						Thread.sleep(3000);
//						Assert.assertThat("Recorrencia não efetivada...", el1 + " " + el2,
//								is(textoMsgRecorrencia.toUpperCase()));
//					} catch (InterruptedException e) {
//						System.out.println("Recorrencia não efetivada " + e);
//						e.printStackTrace();
//					}
//				} else {
//					try {
//						Thread.sleep(2000);
//						List<WebElement> list = msgRecorrencia.findElements(By.tagName("h2"));
//						String el1 = list.get(0).getText();
//						String el2 = list.get(1).getText();
//						Thread.sleep(3000);
//						Assert.assertThat("Recorrencia não efetivada...", el1 + " " + el2,
//								is(textoMsgRecorrencia.toUpperCase()));
//					} catch (InterruptedException e) {
//						System.out.println("Recorrencia não efetivada " + e);
//						e.printStackTrace();
//					}
//				}
//
//			}
//
//			if (!Recorrencia) {
//				try {
//					Thread.sleep(2000);
//					List<WebElement> list = modalConfirmacaoContratacaoArv.findElements(By.tagName("h2"));
//					String el1 = list.get(0).getText();
//					String el2 = list.get(1).getText();
//					Thread.sleep(3000);
//					Assert.assertThat("Contratação não foi efetivada...", el1 + " " + el2,
//							is(textoConfirmacaoContratacaoArv));
//				} catch (InterruptedException e) {
//					System.out.println("Contratação não efetivada " + e);
//					e.printStackTrace();
//				}
//			}
//		}
//		// VALIDA RESULTADO DE SIMULAÇÃO DE CONTRATAÇÃO DE ARV
//		if (Cenario.contains("operador")) {
//			String text = webdriver.findElement(By.xpath("//div[@id='simulationAlert']/div[2]")).getText();
//			System.out.println(text);
//			Assert.assertTrue("Simulação não foi efetivada... contratado arv pelo operador",
//					text.equals(textoConfirmacaoArv));
//		}
//	}
//
//}
