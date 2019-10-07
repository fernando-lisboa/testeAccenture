package br.com.alelo.qa.web.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.EsqueciMinhaSenhaPage;

public class EsqueciMinhaSenhaActions extends EsqueciMinhaSenhaPage {

	public void preencherCpf(String cpf) {
		txtCpf.click();
		txtCpf.sendKeys(cpf);

	}

	public void preencherCnpj(String cnpj) {
		txtCnpj.clear();
		txtCnpj.click();
		txtCnpj.sendKeys(cnpj);

	}

	public void preencherCaptcha() {
		txtCaptcha.click();
		txtCaptcha.sendKeys("captcha");
	}

	public void preencherDia(String dia) {

		
		txtDia.clear();
		txtDia.click();
		txtDia.sendKeys(dia);

	}

	public void preencherMes(String mes) {

		
		txtMes.clear();
		txtMes.click();
		txtMes.sendKeys(mes);

	}

	public void preencherAno(String ano) {

		txtAno.clear();
		txtAno.click();
		txtAno.sendKeys(ano);

	}

	public void clicarEmContinuar() {
		btnContinuar.click();
	}

	public void clicarEmVoltar() {
		btnVoltar.click();
	}

	public EsqueciMinhaSenhaActions(WebDriver driver) {
		super(driver);
	}

	public void msgErroExibida(String msgErro) {
		webdriver.findElement(By.xpath("//small[contains(text(),'"+msgErro+"')]"))
				.isDisplayed();
	}

	public void aguardarFormularioEsqueciMinhaSenhaCarregar() {
		waitForElementPageToBeClickable(txtAno);
		waitForElementPageToBeClickable(txtCpf);
		waitForElementPageToBeClickable(txtCnpj);
		waitForElementPageToBeClickable(txtCaptcha);
		waitForElementPageToBeClickable(txtDia);
		waitForElementPageToBeClickable(txtMes);
		waitForElementPageToBeClickable(btnContinuar);
	}

}
