package br.com.alelo.qa.web.actions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alelo.integrations.db.ConnBuc;
import br.com.alelo.integrations.db.ConnSit;
import br.com.alelo.integrations.db.ConnUsadq;
import br.com.alelo.qa.features.support.JavaScriptUtils;
import br.com.alelo.qa.web.page.ContratacaoPlanosCanalPage;
import br.com.alelo.qa.web.page.PlanosPage;
import br.com.alelo.utils.setupTestes.actions.CommonsActions;

public class ContratacaoPlanosCanalActions extends ContratacaoPlanosCanalPage {

	public ContratacaoPlanosCanalActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub

	}
	String queryPlanos = "SELECT NU_CNPJ, NU_EC, NM_CANAL, ID_CANAL FROM owadq.tsgm_contr WHERE nu_cnpj = 28339982000160";
	CommonsActions conn_ation = new CommonsActions();

	JavaScriptUtils javaS = new JavaScriptUtils(webdriver);

	public void upLoadDePlanilhaDePlanos(String path, String nomeArquivo) {

		botaoMenu_side_kick.click();
		menuAssociarLote.click();
		String usingSystemProperty = System.getProperty("user.dir");

		inputUpload.sendKeys(usingSystemProperty + path + nomeArquivo);
		btnFazerUpload.click();
		waitForElementPageToBeClickable(btnFechar);
		System.out.println(btnFechar.getText());
		Assert.assertThat(sucesso.getText(), is(msgSucessoTxt));
		waitForElementPageToBeClickable(btnFechar);
		btnFechar.click();

	}

	public void ContratarPlano(String Cenario, boolean Contratacao) {
		try {
			Thread.sleep(4000);
			JavaScriptUtils javaS = new JavaScriptUtils(webdriver);
			PlanosPage planosPage = new PlanosPage(webdriver);

			// Abre Modal
			javaS.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null, planosPage.botao_side_kick);

			Cenario = Cenario.replace("Plano de ", "").replace(" dias", "");

			switch (Cenario) {
			case "02":
				javaS.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null,
						webdriver.findElement(By.id("conditionCard-0")));
				break;
			case "07":
				javaS.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null,
						webdriver.findElement(By.id("conditionCard-1")));
				break;
			case "15":
				javaS.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null,
						webdriver.findElement(By.id("conditionCard-2")));
				break;
			}

			if (!PreencheValorCampoSetSelectButton(null, webdriver.findElement(By.id("antecipation-terms-check")), null,
					40))
				fail("Checkbox de confirmação nao recebeu a açao de clique");

			if (Contratacao)
				Thread.sleep(2000);
			if (!PreencheValorCampoSetSelectButton(null, webdriver.findElement(By.id("antecipation-accept-button")),
					null, 40))
				fail("Botão confirmar nao recebeu a açao de clique");
			waitForElementPageToBeClickable(btnFecharModal);
			List<WebElement> findElements = msgSucessoContratacao.findElements(By.tagName("h2"));
			String txt1 = findElements.get(0).getText();
			String txt2 = findElements.get(1).getText();
			String msgValidacao = txt1 + " " + txt2;

			Assert.assertTrue("Erro na contratação de plano", msgValidacao.equals(msgEsperadaSucessoContratacao));
			btnFecharModal.click();

			Thread.sleep(200);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	public void validarBancoDeDadosCanal(String canal, String ambiente, Map<String, String> map) throws Exception {

		switch (canal) {
		case "PortalEc":
			// Consulta banco de dados para verificação do canal contratado
			if (ambiente.equals("sit")) {
				ResultSet teste = conn_ation.consultaBanco(ConnSit.getConexao(), queryPlanos);
				while (teste.next()) {
					String cnpj = teste.getString("NU_CNPJ");
					String numeroEc = teste.getString("NU_EC");
					String nomeCanal = teste.getString("NM_CANAL");
					String idCanal = teste.getString("ID_CANAL");
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado", cnpj.equals(map.get("cnpj")));
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado",
							numeroEc.equals(map.get("numeroEc")));
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado",
							nomeCanal.equals(map.get("nomeCanal")));
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado",
							idCanal.equals(map.get("idCanal")));
					break;
				}
			} else {

				ResultSet teste = conn_ation.consultaBanco(ConnUsadq.getConexao(), queryPlanos);
				while (teste.next()) {
					String cnpj = teste.getString("NU_CNPJ");
					String numeroEc = teste.getString("NU_EC");
					String nomeCanal = teste.getString("NM_CANAL");
					String idCanal = teste.getString("ID_CANAL");
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado", cnpj.equals(map.get("cnpj")));
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado",
							numeroEc.equals(map.get("numeroEc")));
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado",
							nomeCanal.equals(map.get("nomeCanal")));
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado",
							idCanal.equals(map.get("idCanal")));
					break;
				}
			}
		case "FrontVendas":
			
			if (ambiente.equals("sit")) {
				ResultSet teste = conn_ation.consultaBanco(ConnSit.getConexao(), queryPlanos);
				while (teste.next()) {
					String cnpj = teste.getString("NU_CNPJ");
					String numeroEc = teste.getString("NU_EC");
					String nomeCanal = teste.getString("NM_CANAL");
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado", cnpj.equals(map.get("cnpj")));
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado",
							numeroEc.equals(map.get("numeroEc")));
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado",
							nomeCanal.equals(canal));
					break;
				}
			} else {

				ResultSet teste = conn_ation.consultaBanco(ConnUsadq.getConexao(), queryPlanos);
				while (teste.next()) {
					String cnpj = teste.getString("NU_CNPJ");
					String numeroEc = teste.getString("NU_EC");
					String nomeCanal = teste.getString("NM_CANAL");
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado", cnpj.equals(map.get("cnpj")));
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado",
							numeroEc.equals(map.get("numeroEc")));
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado",
							nomeCanal.equals(canal));
					break;
				}
			}
		case "App":
			
			if (ambiente.equals("sit")) {
				ResultSet teste = conn_ation.consultaBanco(ConnSit.getConexao(), queryPlanos);
				while (teste.next()) {
					String cnpj = teste.getString("NU_CNPJ");
					String numeroEc = teste.getString("NU_EC");
					String nomeCanal = teste.getString("NM_CANAL");
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado", cnpj.equals(map.get("cnpj")));
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado",
							numeroEc.equals(map.get("numeroEc")));
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado",
							nomeCanal.equals(canal));
					break;
				}
			} else {

				ResultSet teste = conn_ation.consultaBanco(ConnUsadq.getConexao(), queryPlanos);
				while (teste.next()) {
					String cnpj = teste.getString("NU_CNPJ");
					String numeroEc = teste.getString("NU_EC");
					String nomeCanal = teste.getString("NM_CANAL");
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado", cnpj.equals(map.get("cnpj")));
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado",
							numeroEc.equals(map.get("numeroEc")));
					Assert.assertTrue("CNPJ cadastrado na base diferente do ofertado",
							nomeCanal.equals(canal));
					break;
				}
			}
		}

	}

}
