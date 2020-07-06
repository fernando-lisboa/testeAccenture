package br.com.alelo.qa.web.actions;

import static java.lang.Thread.sleep;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.alelo.integrations.db.ConnBuc;
import br.com.alelo.integrations.db.ConnSit;
import br.com.alelo.qa.web.page.CriarUsuarioResetarSenhaPage;
import br.com.alelo.utils.setupTestes.actions.CommonsActions;

public class OptarPorAceitarDeliveryActions extends CriarUsuarioResetarSenhaPage {

	public OptarPorAceitarDeliveryActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	Random rand = new Random();

	public void preencherPID() throws Exception {

		// region [Itens de Retorno do Banco de dados]
		String queryItens = "with Itens as(SELECT ROW_NUMBER() OVER(ORDER BY doc.nr_documento DESC) row_num, doc.nr_documento, pdc.cd_banco, pdc.nu_agencia, pdc.nu_conta FROM base_unica_cad.documento doc left join base_unica_cad.pessoa_unidade pu on (pu.niu_pessoa = doc.niu_pessoa) left join base_unica_cad.pessoa_domicilio_bancario pdc on (pdc.niu_pessoa = pu.niu_pessoa) WHERE doc.nr_documento in ('26998825000130'))select * from Itens where row_num = 1";
		CommonsActions conn_ation = new CommonsActions();
		ResultSet teste = conn_ation.consultaBanco(ConnSit.getConexao(), queryItens);
		List<String> Itens = new ArrayList<>();
		while (teste.next()) {
			String nrDoc = teste.getString("NR_DOCUMENTO");
			String cdBanco = teste.getString("CD_BANCO");
			String nuAgencia = teste.getString("NU_AGENCIA");
			String nuConta = teste.getString("NU_CONTA");
			Itens.add(nrDoc);
			Itens.add(cdBanco);
			Itens.add(nuAgencia);
			Itens.add(nuConta);
			break;
		}
		// endregion

		waitForElementPageToBeClickable(primeiroAcessocnpj);

		// region [Formulario de Primeiro Acesso]Telefone
		primeiroAcessoTelefone.sendKeys("11960745073");

		// CNPJ
		primeiroAcessocnpj.clear();
		primeiroAcessocnpj.sendKeys(Itens.get(0));
		sleep(1000);
		primeiroAcessocnpj.clear();
		primeiroAcessocnpj.sendKeys(Itens.get(0));

		// Banco
		WebElement selectBanco = webdriver.findElement(By.id("formInlineBank"));
		String banco_completo = "";
		for (WebElement banco : selectBanco.findElements(By.tagName("option")))
			if (banco.getText().contains(Itens.get(1))) {
				banco_completo = banco.getText();
				break;
			}

		Select selectBanco_ = new Select(primeiroAcessoBanco);
		selectBanco_.selectByVisibleText(banco_completo);
		// primeiroAcessoBanco.

		// Agencia
		primeiroAcessoAgencia.sendKeys(Itens.get(2));

		// Conta
		primeiroAcessoConta.sendKeys(Itens.get(3));

		waitForElementPageToBeClickable(btn_primeiroAcessoConfirmar);

		sleep(2000);

		// Confirmar
		btn_primeiroAcessoConfirmar.click();
		sleep(2000);

		// Confirmar
		btn_primeiroAcessoConfirmar.click();

		waitForElementPageToBeClickable(btn_primeiroAcessoComecar);
		// Começar
		btn_primeiroAcessoComecar.click();

		waitForElementToBeInvisible(loader);

	}

	public void selecionarApp(String cenario) {
		if (cenario.equals("ifood")) {
			waitForElementPageToBeClickable(swiftRappy);
			swiftIfood.click();
		} else {
			waitForElementPageToBeClickable(swiftRappy);
			swiftRappy.click();
		}

	}

	public void habilitarEconfirmarMsg() {
		btnConfirmarHabilitar.click();
		String text = txtCardFeedBack.getText();
		System.out.println(text);
		
	}

}
