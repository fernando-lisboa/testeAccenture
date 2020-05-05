package br.com.alelo.qa.web.actions;

import br.com.alelo.integrations.db.ConnBuc;
import br.com.alelo.qa.web.page.CriarUsuarioResetarSenhaPage;
import br.com.alelo.utils.GeraCpfCnpj;
import br.com.alelo.utils.setupTestes.actions.CommonsActions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;
import static org.junit.Assert.fail;

public class MeusCNPJsActions extends CriarUsuarioResetarSenhaPage {

	public MeusCNPJsActions(WebDriver driver) {
		super(driver);
	}

	/**
	 * <h3>Função Utilizada para Criar usuários e Mudar Senha através do esqueci
	 * senha da tela inicial do portal.</>><h3>Parâmetros Booleanos PID e
	 * TrocaSenha
	 * <h3>
	 */

	public void AdicionaCNPJS(int associarCNPJS) throws InterruptedException {
		Thread.sleep(2000);
		try {
			Random rand = new Random();

			for (int i = 0; i < associarCNPJS; i++) {
				Thread.sleep(6000);
				// Clica em Meus CNPJS
				meusCNPJSMenuPortal.click();
				Thread.sleep(4000);
				// Adicionar CNPJS
				btnAdicionarCNPJSPortal.click();
				// region [Itens de Retorno do Banco de dados]
				String n_query_randomic = Integer.toString(rand.nextInt(4));
				String queryItens = "with Itens as(SELECT ROW_NUMBER() OVER(ORDER BY doc.nr_documento DESC) row_num, doc.nr_documento, pdc.cd_banco, pdc.nu_agencia, pdc.nu_conta FROM base_unica_cad.documento doc left join base_unica_cad.pessoa_unidade pu on (pu.niu_pessoa = doc.niu_pessoa) left join base_unica_cad.pessoa_domicilio_bancario pdc on (pdc.niu_pessoa = pu.niu_pessoa) WHERE doc.nr_documento in ('28339982000160','41707658000115','37491504000161','12259140000168'))select * from Itens where row_num = "
						+ n_query_randomic;
				CommonsActions conn_ation = new CommonsActions();
				ResultSet teste = conn_ation.consultaBanco(ConnBuc.getConexao(), queryItens);
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

				waitForElementPageToBeClickable(btnConfirmarCNPJSPortal);

				sleep(2000);

				// Confirmar
				/*
				 * btnConfirmarCNPJSPortal.click();
				 * 
				 * webdriver.findElement(By.id("buttonBottomPrint")).click();
				 */

			}
		} catch (Exception e) {
			System.out.println("Message: " + e.getMessage() + "Trace: " + e.getStackTrace());
		}
	}

	public void ResultadoEvidencia(String Resultado) throws InterruptedException {
		btnConfirmarCNPJSPortal.click();
		waitForElementPageToBeClickable(btnComecar);
		String text = webdriver.findElement(By.xpath("//div[@id='simulationAlert']/div[2]")).getText();
		System.out.println(text);
		Assert.assertTrue("Simulação não foi efetivada... contratado arv pelo operador",
				text.equals(textoConfirmacaoArv));
	}
}
