package br.com.alelo.qa.web.actions;

import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.is;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.alelo.integrations.db.ConnBuc;
import br.com.alelo.integrations.db.ConnSit;
import br.com.alelo.integrations.db.ConnUsadq;
import br.com.alelo.qa.web.page.CriarUsuarioResetarSenhaPage;
import br.com.alelo.utils.setupTestes.actions.CommonsActions;

public class OptarPorAceitarDeliveryActions extends CriarUsuarioResetarSenhaPage {

	public OptarPorAceitarDeliveryActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	Random rand = new Random();

	public void validarRelatórioWA(Map<String, String> map) {
		 map.forEach((k, v) -> System.out.println(String.format("key: %s | value: %s", k, v)));
		 
		map.forEach((k, v) -> {
			try {
			//		Assert.assertThat("CNPJ diferente do esperado ",v.toString(), is(cnpj));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}

	public void preencherPID(String ambiente) throws Exception {

		// region [Itens de Retorno do Banco de dados]
		// HML
		String queryItensHml = "with Itens as(SELECT ROW_NUMBER() OVER(ORDER BY doc.nr_documento DESC) row_num, doc.nr_documento, pdc.cd_banco, pdc.nu_agencia, pdc.nu_conta FROM base_unica_cad.documento doc left join base_unica_cad.pessoa_unidade pu on (pu.niu_pessoa = doc.niu_pessoa) left join base_unica_cad.pessoa_domicilio_bancario pdc on (pdc.niu_pessoa = pu.niu_pessoa) WHERE doc.nr_documento in ('28339982000160'))select * from Itens where row_num = 1";
		// SIT
		String queryItensSit = "with Itens as(SELECT ROW_NUMBER() OVER(ORDER BY doc.nr_documento DESC) row_num, doc.nr_documento, pdc.cd_banco, pdc.nu_agencia, pdc.nu_conta FROM base_unica_cad.documento doc left join base_unica_cad.pessoa_unidade pu on (pu.niu_pessoa = doc.niu_pessoa) left join base_unica_cad.pessoa_domicilio_bancario pdc on (pdc.niu_pessoa = pu.niu_pessoa) WHERE doc.nr_documento in ('02750575000157'))select * from Itens where row_num = 1";
		CommonsActions conn_ation = new CommonsActions();
		List<String> Itens = new ArrayList<>();
		if (ambiente.equals("sit")) {
			ResultSet teste = conn_ation.consultaBanco(ConnSit.getConexao(), queryItensSit);
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

		} else {
			ResultSet teste = conn_ation.consultaBanco(ConnBuc.getConexao(), queryItensHml);

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
		}
		// endregion

		waitForElementPageToBeClickable(primeiroAcessocnpj);

		// region [Formulario de Primeiro Acesso]Telefone
		primeiroAcessoTelefone.sendKeys("11960745079");

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

		sleep(4000);

		// Confirmar
		btn_primeiroAcessoConfirmar.click();
		waitForElementPageToLoad(loader);
		// Começar

		btn_primeiroAcessoComecar.click();

		waitForElementToBeInvisible(loader);

	}

	public void selecionarApp(String prod) throws InterruptedException {
		if (prod.equals("Ifood")) {
			waitForElementPageToBeClickable(swiftIfood);
			swiftIfood.click();
			sleep(1000);
		} else if (prod.equals("Rappy")) {
			waitForElementPageToBeClickable(swiftRappy);
			sleep(1000);
			swiftRappy.click();
		} else {
			waitForElementPageToBeClickable(swiftRappy);
			swiftIfood.click();
			sleep(1000);
			waitForElementPageToBeClickable(swiftIfood);
			swiftRappy.click();
			sleep(1000);
		}

	}

	public void verificarDelivery() {
		List<WebElement> labelList = labelAskDelivery.findElements(By.tagName("h4"));

		Assert.assertTrue("Mensagem de delivery não disponível", labelList.get(0).getText().equals(txtAskDelivery));
		// Assert.assertTrue("Label do botão diferente de Concluir",
		// btnConfirmarHabilitar.getText().equals("Concluir"));

	}

	public void habilitarEconfirmarMsg() {
		waitForElementPageToBeClickable(btnConfirmarHabilitar);
		btnConfirmarHabilitar.click();
		WebElement text = txtCardFeedBack.findElement(By.tagName("h1"));
		System.out.println(text.getText());
		Assert.assertThat("Mensagem de confirmação não exibida", text.getText(), is(txtConfirmacao));
		retornarPortal.click();
		Assert.assertTrue("NãO RETORNOU PARA O PORTAL NA TELA DE INICIO", webdriver.getCurrentUrl().contains("inicio"));

	}

	public void validarBancoDeDados_App(String ambiente, String idPlataforma) throws Exception {
		int platform;
		// Consulta banco de dados para verificação de solicitação de App -

		if (idPlataforma.equals("Ifood")) {
			platform = 1;
		} else {
			platform = 2;
		}

		String queryItens = "select * from TDSV_ESTBL_COML WHERE ID_PLATF_DLIVRY =" + platform + "";
		CommonsActions conn_ation = new CommonsActions();
		ResultSet returnSelect;
		List<String> Itens = new ArrayList<>();
		if (ambiente.equals("sit")) {
			returnSelect = conn_ation.consultaBanco(ConnSit.getConexao(), queryItens);
		} else {
			returnSelect = conn_ation.consultaBanco(ConnUsadq.getConexao(), queryItens);
		}
		while (returnSelect.next()) {
			String idEstabelecimento = returnSelect.getString("ID_ESTBL");
			String nuCnpj = returnSelect.getString("NU_CNPJ");
			String cdEstabelecimento = returnSelect.getString("CD_ESTBL_COML");
			String idPlataformaDelivery = returnSelect.getString("ID_PLATF_DLIVRY");
			Itens.add(idEstabelecimento);
			Itens.add(nuCnpj);
			Itens.add(cdEstabelecimento);
			Itens.add(idPlataformaDelivery);

			break;
		}

		// TODO fazer assert Para verificar as tabelas
		System.out.println();

	}

	public void logout() {
		webdriver.findElement(By.id("nav-dropdown")).click();
		webdriver.findElement(By.id("navbarDesktopSair")).click();
	}

}
