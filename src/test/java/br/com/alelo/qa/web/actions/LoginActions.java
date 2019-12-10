package br.com.alelo.qa.web.actions;

import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.LoginPage;
import br.com.alelo.qa.web.page.OfertaAtivaPage;

public class LoginActions extends LoginPage {

	OfertaAtivaPage page = new OfertaAtivaPage(webdriver);

	public void preencherLogin(String user, String senha) {

		userLogin.sendKeys(user);
		password.sendKeys(senha);
		btnEntrar.click();

	}

	public void loginGeral(String user, String senha) throws Throwable {

		waitForElementPageToBeClickable(userLogin);
		userLogin.click();
		userLogin.sendKeys(user);
		password.sendKeys(senha);
		btnEntrar.click();
		aguardarTelaInicial();

	}

	public void aguardarTelaInicial() throws InterruptedException {

		Thread.sleep(10000);
	}

	public LoginActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
