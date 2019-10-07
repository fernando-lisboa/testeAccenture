package br.com.alelo.qa.web.actions;

import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.EsqueciMinhaSenhaConfirmacaoEnvioPage;

public class EsqueciMinhaSenhaConfirmacaoEnvioActions extends EsqueciMinhaSenhaConfirmacaoEnvioPage {
	
	public void validaMensagemEnvioComSucesso(){
		//waitForElementPageToLoad("//p[contains(text(),'E-mail enviado com sucesso para endereço cadastrad')]");
	}

	public EsqueciMinhaSenhaConfirmacaoEnvioActions(WebDriver driver) {
		super(driver);
	}

}
