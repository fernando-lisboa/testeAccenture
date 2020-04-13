/**
 * 
 */
package br.com.alelo.qa.web.actions;

import static org.hamcrest.CoreMatchers.is;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.alelo.qa.web.page.CriacaoDeMensagensPage;
import br.com.alelo.utils.RandomUtils;

/**
 * @author Matheus Lisboa
 *
 */
public class CriacaoDeMensagensActions extends CriacaoDeMensagensPage {

	public CriacaoDeMensagensActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	Alert alert;
	Select select;
	WebElement dateWidget;
	RandomUtils random;

	public void criarMensagem() throws InterruptedException {
		waitForElementPageToBeClickable(mensagens_link);
		mensagens_link.click();
		System.out.println("aguardando abrir formulário");
	}

	public void adicionarMensagem() throws InterruptedException {
		btn_adicionar_mensagem.click();
		System.out.println("aguardando abrir formulário");
	}

	public void preencherMensagem(String tipoDaMensagem, String tipoDeEnvio) throws InterruptedException {

		nome_da_mensagem.sendKeys(nomeDaMensagem);
		assunto_da_mensagem.sendKeys(notificationSubject);
		descricao_da_mensagem.sendKeys(notificationMessage);
		select = new Select(comboTipoDeMensagem);
		select.selectByVisibleText(tipoDaMensagem);
		select = new Select(comboTipoDeEnvio);
		select.selectByVisibleText(tipoDeEnvio);
		preencherData(dataInicialVigencia, dataInicioDaMensagemTable, dataFinalDaMensagemTable, 0);
		preencherData(dataFinalVigencia, dataInicioDaMensagemTable, dataFinalDaMensagemTable, 10);

		waitForElementPageToBeClickable(btn_salvar_mensagem);
		btn_salvar_mensagem.click();
		waitForElementPageToBeClickable(btnConfirmaMensagem);
		aceitarAlerta();
	}

	public void preencherData(WebElement elemento, WebElement dataInicioDaMensagemTable,
			WebElement dataFinalDaMensagemTable, int dias) {
		elemento.click();
		DateFormat dateFormat2 = new SimpleDateFormat("d");
		Date date2 = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date2);
		c.add(Calendar.DATE, +dias);
		date2 = c.getTime();

		String today = dateFormat2.format(date2);
		if (dias == 0) {
			dateWidget = dataInicioDaMensagemTable;
		} else {
			dateWidget = dataFinalDaMensagemTable;

		}
		List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

		for (WebElement cell : columns) {

			System.out.println(cell.getText());

			if (cell.getText().equals(today)) {
				if (!cell.getAttribute("class").contains("day old")) {
					cell.click();
					break;
				}

			}
		}
	}

	public void aceitarAlerta() {
		btnConfirmaMensagem.click();
	}

	public void editarMensagem() {
		waitForElementPageToBeClickable(mensagens_link);
		mensagens_link.click();
		waitForElementPageToBeClickable(img_btn_edicao);
		img_btn_edicao.click();
		preencherData(dataFinalVigencia, dataInicioDaMensagemTable, dataFinalDaMensagemTable, 35);
		waitForElementPageToBeClickable(btn_salvar_mensagem);
		btn_salvar_mensagem.click();
	}

	public void validarEdicao() {
		Assert.assertTrue(msgEsperada, true);
	}

	// Metodo para Alterar Status da Mensagem

	public void alterarStatusMensagem(String status) {
		waitForElementPageToBeClickable(status_notification);
		status_notification.click();
		select = new Select(status_notification);
		select.selectByVisibleText(status);
		waitForElementPageToBeClickable(btn_filtrar);
		btn_filtrar.click();
	}

	public void excluirMensagem() {
		waitForElementPageToBeClickable(btnExcluirMensagem);
		btnExcluirMensagem.click();
		waitForElementPageToBeClickable(botaoConfirmaExcluir);
		botaoConfirmaExcluir.click();
	}

	public void validarMensagemDeExclusao() {
		try {
			Thread.sleep(2000);
			List<WebElement> list = msgConfirmacao.findElements(By.tagName("h1"));
			String el1 = list.get(0).getText();
			String el2 = list.get(1).getText();
			Thread.sleep(2000);
			Assert.assertThat(el1 + " " + el2, is(msgEsperadaExclusao));
		} catch (InterruptedException e) {
			System.out.println("Botão não está presente na tela " + e);
			e.printStackTrace();
		}
	}

	public void iconNotificationId() {
		waitForElementPageToBeClickable(badgeNotification);
		Assert.assertTrue("icone de notificacao nao disponivel", badgeNotification.isDisplayed());
	}

}