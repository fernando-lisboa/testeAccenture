package br.com.alelo.qa.web.actions;

import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.SairPage;

public class SairActions extends SairPage {

	public void validarAreaLogada() throws InterruptedException {
		waitForElementPageToLoad(loader);
		if (webdriver.getCurrentUrl().contains("inicio")) {
			Thread.sleep(5000);
			System.out.println("Está em uma área logada");
		} else {
			fail("Não está na área logada");
		}
	}

	public void clicarUsuario() throws Throwable {
		Thread.sleep(5000);
		botaoPerfil.click();
	}

	public void clicarSair() throws Throwable {
		Thread.sleep(5000);
		//esperarSerClicavel(botaoSair, 20);
		botaoSair.click();
	}

	public void validarUrlAtual() throws InterruptedException {
		String urlAtual;
		Thread.sleep(5000);
		urlAtual = webdriver.getCurrentUrl();
		
		if (!urlAtual.equals(getUrlLogout())) {
			fail("Não está na URL correta");

		} else {
			webdriver.quit();
			System.out.println("Teste realizado com sucesso!");
		}
	}

	public  void sairGeral() throws Throwable {
		botaoSair.click();
	}
	
	public SairActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
}
