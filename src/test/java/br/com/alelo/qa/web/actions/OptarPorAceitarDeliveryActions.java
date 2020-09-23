package br.com.alelo.qa.web.actions;

import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.is;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.alelo.integrations.db.ConnBuc;
import br.com.alelo.integrations.db.ConnSit;
import br.com.alelo.integrations.db.ConnUsadq;
import br.com.alelo.qa.features.support.JavaScriptUtils;
import br.com.alelo.qa.web.page.CriarUsuarioResetarSenhaPage;
import br.com.alelo.qa.web.page.ListaRetornoWebAdmin;
import br.com.alelo.utils.setupTestes.actions.CommonsActions;
import br.com.alelo.utils.setupTestes.query.QuerySolicitacaoDelivery;

public class OptarPorAceitarDeliveryActions extends CriarUsuarioResetarSenhaPage {

	public OptarPorAceitarDeliveryActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	Random rand = new Random();
	CommonsActions conn_ation = new CommonsActions();
	private List<ListaRetornoWebAdmin> consultaMassa;

	public void validarRelatórioWA(Map<String, String> map) {
		map.forEach((k, v) -> System.out.println(String.format("key: %s | value: %s", k, v)));

		map.forEach((k, v) -> {
			try {
				// Assert.assertThat("CNPJ diferente do esperado ",v.toString(),
				// is(cnpj));
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
		WebElement selectBanco = primeiroAcessoBanco;
		String banco_completo = "";
		for (WebElement banco : selectBanco.findElements(By.tagName("option")))

			if (banco.getText().contains(Itens.get(1))) {
				System.out.println(banco.getText());
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
		waitForElementToBeInvisible(loader);

		// Começar
		sleep(4000);
		JavaScriptUtils javaSA = new JavaScriptUtils(webdriver);
		javaSA.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null, btn_primeiroAcessoComecar);
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

	public void verificarDelivery(Boolean delivery) {
		List<WebElement> labelList = labelAskDelivery.findElements(By.tagName("h4"));

		Assert.assertTrue("Mensagem de delivery não disponível", labelList.get(0).getText().equals(txtAskDelivery));

		if (delivery) {
			Assert.assertTrue("Label do botão diferente de Concluir",
					btnConfirmarHabilitar.getText().toLowerCase().equals("finalizar"));
		}else{
			Assert.assertTrue("Label do botão diferente de Avançar",
					btnConfirmarHabilitar.getText().toLowerCase().equals("Finalizar sem Habilitar"));
		}

	}

	public void habilitarEconfirmarMsg() {
		waitForElementPageToBeClickable(btnConfirmarHabilitar);
		btnConfirmarHabilitar.click();
		try {
			Thread.sleep(1000);
			WebElement text = txtCardFeedBack.findElement(By.tagName("h1"));
			System.out.println(text.getText());
			Assert.assertThat("Mensagem de confirmação não exibida", text.getText(), is(txtConfirmacao));
			retornarPortal.click();
			Assert.assertTrue("NãO RETORNOU PARA O PORTAL NA TELA DE INICIO",
					webdriver.getCurrentUrl().contains("inicio"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void validarBancoDeDados_App(String ambiente, String idPlataforma, String cnpj, String ec) throws Exception {
		String platform;
		// Consulta banco de dados para verificação de solicitação de App -

		if (idPlataforma.equals("Ifood")) {
			platform = "1";
		} else {
			platform = "2";
		}

		String queryItens = "select * from TDSV_ESTBL_COML WHERE nu_cnpj in (" + cnpj + ") and id_platf_dlivry ="
				+ platform + "";

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

			Assert.assertThat("Id estabelecimento não preenchido..", idEstabelecimento, is(idEstabelecimento));
			System.out.println("Recebido= " + idEstabelecimento + " " + idEstabelecimento);
			Assert.assertThat("Id estabelecimento não preenchido..", nuCnpj, is(cnpj));
			System.out.println("Recebido= " + nuCnpj + " " + cnpj);
			Assert.assertThat("Id estabelecimento não preenchido..", cdEstabelecimento, is(ec));
			System.out.println("Recebido= " + cdEstabelecimento + " " + ec);
			Assert.assertThat("Id estabelecimento não preenchido..", idPlataformaDelivery, is(platform));
			System.out.println("Recebido= " + idPlataformaDelivery + " Esperado = " + platform);

			break;
		}

		System.out.println("Solicitação de App Delyvery gravada com sucesso");

	}

	public void logout() {
		webdriver.findElement(By.id("nav-dropdown")).click();
		webdriver.findElement(By.id("navbarDesktopSair")).click();
	}

	public void avancarSemSelecionarDelivery() {

		JavaScriptUtils javaSA = new JavaScriptUtils(webdriver);
		waitForElementPageToBeClickable(btnConfirmarHabilitar);
		javaSA.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null, btnConfirmarHabilitar);
		waitForElementToBeInvisible(loader);
		Assert.assertTrue("NãO RETORNOU PARA O PORTAL NA TELA DE INICIO", webdriver.getCurrentUrl().contains("inicio"));

	}

	public void validaRelatorio() {
		int contador = 1;
		webdriver.findElement(By.id("relatorios-menu")).click();
		WebElement tabelaListas = webdriver.findElement(By.id("table"));
		List<ListaRetornoWebAdmin> listawebadminretorno = new ArrayList<ListaRetornoWebAdmin>();

		try {
			consultaMassa = consultaMassa();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (WebElement linhaTabelaListas : tabelaListas.findElements(By.tagName("tr"))) {
			try {
				List<WebElement> thselements = linhaTabelaListas.findElements(By.tagName("td"));

				String CNPJ = thselements.get(0).getText();
				String Aplicativos = thselements.get(1).getText();
				String CodigoEC = thselements.get(2).getText();
				String Data = thselements.get(3).getText();

				ListaRetornoWebAdmin listitem = new ListaRetornoWebAdmin(CNPJ, Aplicativos, CodigoEC, Data);
				listawebadminretorno.add(listitem);

			} catch (Exception e) {
			}
		}

		for (ListaRetornoWebAdmin listaResultadoEsperado : consultaMassa) {
			boolean CNPJEncontrado = false;
			boolean aplicativoEncontrado = false;
			boolean txtECEncontrado = false;
			boolean dataEncontrado = false;

			for (ListaRetornoWebAdmin listaResultadoObtido : listawebadminretorno) {

				String cnpjFormatado = listaResultadoObtido.getCNPJ().replaceAll("[^\\d ]", "");
				System.out.println(listaResultadoEsperado.getCNPJ() + " " + cnpjFormatado);
				if (listaResultadoEsperado.getCNPJ().equals(cnpjFormatado)) {
					CNPJEncontrado = true;

					System.out.println(listaResultadoEsperado.CNPJ + " encontrado com sucesso");

					if (listaResultadoEsperado.getCodigoEC().equals(listaResultadoObtido.getCodigoEC())) {
						txtECEncontrado = true;
						System.out.println(listaResultadoEsperado.CodigoEC + " encontrado com sucesso");
					}

					if (listaResultadoEsperado.getData().equals(listaResultadoObtido.getData())) {
						dataEncontrado = true;
						System.out.println(listaResultadoEsperado.getData() + " encontrado com sucesso");
					}
					System.out.println("validação ítem =" + contador);
					contador = contador + 1;
					break;
				}

			}
			// if (!CNPJEncontrado || !aplicativoEncontrado || !txtECEncontrado
			// || !dataEncontrado) {
			// System.out.println(listaResultadoEsperado.getCNPJ() + "|" +
			// listaResultadoEsperado.getAplicativos()
			// + "|" + listaResultadoEsperado.getCodigoEC() + "|" +
			// listaResultadoEsperado.getData()
			// + " não encontrado");
			// }
		}
	}

	private List<ListaRetornoWebAdmin> consultaMassa() throws Exception {
		Boolean ambiente = false;
		ResultSet consultaBanco;

		List<ListaRetornoWebAdmin> listawebadminretornoEsperado = new ArrayList<ListaRetornoWebAdmin>();
		QuerySolicitacaoDelivery queryMassa = new QuerySolicitacaoDelivery();
		if (ambiente) {
			consultaBanco = conn_ation.consultaBanco(ConnUsadq.getConexao(),
					queryMassa.selecionaMassaDelivery().toString());
		} else {
			consultaBanco = conn_ation.consultaBanco(ConnSit.getConexao(),
					queryMassa.selecionaMassaDelivery().toString());
		}

		while (consultaBanco.next()) {
			String nuCnpj = consultaBanco.getString("NU_CNPJ");
			String cdEstabelecimento = consultaBanco.getString("CD_ESTBL_COML");
			String data = dataAtual();
			String idPlataformaDelivery = consultaBanco.getString("ID_PLATF_DLIVRY");

			if (idPlataformaDelivery.equals("1")) {
				idPlataformaDelivery = "iFood";
			} else {
				idPlataformaDelivery = "Rappi";
			}
			ListaRetornoWebAdmin listitem = new ListaRetornoWebAdmin(nuCnpj, idPlataformaDelivery, cdEstabelecimento,
					data);
			listawebadminretornoEsperado.add(listitem);

		}

		return listawebadminretornoEsperado;
	}

	public String dataAtual() {
		Calendar data = Calendar.getInstance();
		data.setTime(new Date());
		// data.add(Calendar.MONTH, +1);
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(data.getTime());
		return dataFormatada;
	}

}
