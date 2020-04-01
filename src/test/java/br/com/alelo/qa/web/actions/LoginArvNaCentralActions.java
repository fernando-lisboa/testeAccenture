package br.com.alelo.qa.web.actions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.LoginARVNaCentralPage_;

public class LoginArvNaCentralActions extends LoginARVNaCentralPage_ {

	public LoginArvNaCentralActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void loginArvNaCentral(String userARV, String passwordARV) throws Throwable {

		waitForElementPageToBeClickable(inputLogin);
		inputLogin.sendKeys(userARV);
		inputPassord.sendKeys(passwordARV);
		waitForElementPageToBeClickable(btnLogar);
		btnLogar.click();
		Thread.sleep(3000);
	}

	public void logout() {
		waitForElementPageToBeClickable(btnLogout);
		btnLogout.click();

	}

	public void validarLoginSucesso(String status) throws Throwable {

		Thread.sleep(3000);
		if (status.equals("positivo")) {
			waitForElementPageToBeClickable(btnBuscar);
			Assert.assertTrue("Login Com Sucesso", nomeUsuarioLogado.getText().equals(nomeUsuarioLogado1));
			logout();
		} else {
			Thread.sleep(3000);
			Assert.assertTrue("Não logou", msgError.getText().equals(msgErrorInvalido));

			System.out.println("Teste realizado com sucesso");
		}

	}

}