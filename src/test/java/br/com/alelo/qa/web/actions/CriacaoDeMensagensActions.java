/**
 * 
 */
package br.com.alelo.qa.web.actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.alelo.qa.web.page.CriacaoDeMensagensPage;
import br.com.alelo.utils.RandomUtils;

/**
 * @author Fernando Lisboa
 *
 */
public class CriacaoDeMensagensActions extends CriacaoDeMensagensPage {

	public CriacaoDeMensagensActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	Alert alert;
	Select select;
	WebElement we;
	RandomUtils random;

	public void criarMensagem() throws InterruptedException {
		Thread.sleep(2000);
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
		select.selectByVisibleText(tipoDaMensagem);
		select.selectByVisibleText(tipoDeEnvio);

		data_inicial_de_vigencia.click();
		preencherData(dataInicialVigencia, dataInicioDaMensagemTable, dataFinalDaMensagemTable, 0);

		data_final_de_vigencia.click();
		preencherData(dataFinalVigencia, dataInicioDaMensagemTable, dataFinalDaMensagemTable, 20);

		Thread.sleep(2000);
		btn_salvar_mensagem.click();
		Thread.sleep(5000);
		alert.accept();
		System.out.println("");

	}

	public void validarExibicaoMensagemNoPortal() {
		// acessar portalEC
		// clicar em notificações
		// percorrer a lista e localizar mensagem criada

	}

	public void preencherData(String elemento, String tableCalendar1, String tableCalendar2, int dias) {
		DateFormat dateFormat2 = new SimpleDateFormat("d");
		Date date2 = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date2);
		c.add(Calendar.DATE, +dias);
		date2 = c.getTime();

		String today = dateFormat2.format(date2);
		if (dias == 0) {
			we.findElement(By.xpath(tableCalendar1));
		} else {
			we.findElement(By.xpath(tableCalendar2));
		}
		List<WebElement> columns = we.findElements(By.tagName("td"));

		for (WebElement cell : columns) {

			System.out.println(cell.getText());

			if (cell.getText().equals(today)) {
				cell.click();
				break;
			}
		}
	}

}
