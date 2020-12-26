package br.com.desafio.qa.web.actions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.desafio.qa.web.page.SendQuotePage;

public class SendQuoteActions extends SendQuotePage{

	private WebElement findElement;

	public SendQuoteActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void fillFiledSendQuote(String user, String password){
		
		try {
			fillFieldEmail.sendKeys("teste@teste.com.br");
			fillFieldPhone.sendKeys("1141414242");
			fillFieldusername.sendKeys(user);
			fillFieldPassord.sendKeys(password);
			fillFieldConfirmpassword.sendKeys(password);
			fillFieldComments.sendKeys("Teste de Desafio Accenture 1.0.1");
			btnSendEmail.click();
			waitForElementToBeIsVisible(btnConfirm);
			System.out.println("Preenchimento send quote preenchido corretamente...");
			
		} catch (Exception e) {
			System.out.println("NÃO FOI POSSÍVEL PREENCHER OS CAMPOS SEND QUOTE..." + e.toString());
			
		}
		
	}

	public void validationMessegeSuccess() {
		
		System.out.println(validationMassagen.getText());
		Assert.assertEquals("Mensagem de envio não apresentada conforme esperado", mensagemEsperada, validationMassagen.getText());
		
	}

}
