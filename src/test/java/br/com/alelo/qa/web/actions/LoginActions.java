package br.com.alelo.qa.web.actions;

import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.LoginPage;

public class LoginActions extends LoginPage {



	public LoginActions(WebDriver driver) {
		super(driver);
	}

	public boolean validaMensagemDeErro(String msg) {
		return menssagem_erro.equals(msg);
	}

	public void preencherForm(String cpf, String password, String nasc) {

		String[] arrNascimento = nasc.split("/");
		campo_recaptcha.click();
		campo_recaptcha.sendKeys("captcha");
		campo_cpf.click();
		campo_cpf.sendKeys(cpf);
		campo_senha.click();
		campo_senha.sendKeys(password);
		campo_nasc_dia.click();
		campo_nasc_dia.sendKeys(arrNascimento[0]);

		campo_nasc_mes.sendKeys(arrNascimento[1]);

		campo_nasc_ano.sendKeys(arrNascimento[2]);
		
	}

	public void clickLogin() {
		btn_ok.click();
	}

	public void acessarTelaPrimeiroAcesso() {
		btnPrimeiroAcesso.click();
	}
	
	public void esqueciMinhaSenha(){
		btnEsqueciMinhaSenha.click();
	}
	
	public void aguardarFormularioDeLoginCarregar(){	
		waitForElementPageToBeClickable(campo_cpf);
		waitForElementPageToBeClickable(campo_nasc_ano);
		waitForElementPageToBeClickable(campo_nasc_mes);
		waitForElementPageToBeClickable(campo_nasc_dia);
		waitForElementPageToBeClickable(campo_recaptcha);
		waitForElementPageToBeClickable(campo_senha);
		waitForElementPageToBeClickable(btn_ok);
	}

}
