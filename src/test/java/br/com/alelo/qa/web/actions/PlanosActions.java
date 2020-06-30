/**
* @author Fernando Lisboa - Taking 
* Change: 08/01/2019 | Author: Jessé Dantas - Taking
*/

package br.com.alelo.qa.web.actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.PlanosPage;

/**
 * @author Fernando Lisboa
 *
 */
public class PlanosActions extends PlanosPage {

	public PlanosActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void alterarEstabelecimento() throws IOException, InterruptedException {
		waitForElementPageToLoad(aguardar_gif);
//		super.alterarCNPJ(aguardar_gif, opcao_select, opcao_ec);
		opcao_select.click();
		opcao_ec.click();
		Thread.sleep(2000);
	}

	public void contratacaoARV() throws InterruptedException {
		waitForElementPageToLoad(aguardar_gif);
		Thread.sleep(5000);
		click_side_kick.click();
		String sidekick;
		sidekick = botao_side_kick.getText();

		if (sidekick.equals("SAIBA MAIS")) {
			Thread.sleep(5000);
			botao_side_kick.click();
		} else {
			fail("Texto diferente do que foi procurado");
		}
	}

	public void contratacao1() throws InterruptedException {
		waitForElementPageToLoad(aguardar_gif);
		Thread.sleep(2000);
		radio_opcao_1.click();
	}

	public void contratacao2() throws InterruptedException {
		waitForElementPageToLoad(aguardar_gif);
		Thread.sleep(2000);
		radio_opcao_2.click();
	}

	public void contratacao3() throws InterruptedException {
		waitForElementPageToLoad(aguardar_gif);
		Thread.sleep(2000);
		radio_opcao_3.click();
	}

	public void contratacaoDefault() throws InterruptedException {
		contratacao1();
	}

	public void concordarTermos() throws InterruptedException {
		Thread.sleep(3000);
		check_aceite_termos.click();
		assertEquals(true, check_aceite_termos.isSelected());
	}

	public void efetivaContratacaoARV() throws InterruptedException {
		Thread.sleep(500);
		botao_contratar.click();
		waitForElementPageToLoad(aguardar_gif);
	}

	public void validaContratacao() throws InterruptedException {
		String mensagemContratacao;
		mensagemContratacao = mensagem_contratacao.getText();

		if (mensagemContratacao.equals(msgContratacao)) {
			Thread.sleep(1000);
			System.out.println(mensagemContratacao);
			botao_fechar.click();
		} else {
			fail("Mensagem diferente da que foi procurada, erro na Contratação");
		}
	}

	public void clicarCancelar() {
		botao_cancelar.click();
	}

	public void validaCancelamentoContratacao() {
		validarUrlAtual(urlInicio);
		System.out.println("Contratação cancelada");
	}

	public void clicarFechar() {
		botao_fechar.click();
	}

	public void validaFecharContratacao() {
		validarUrlAtual(urlInicio);
		System.out.println("Modal contratação fechado");
	}

}
