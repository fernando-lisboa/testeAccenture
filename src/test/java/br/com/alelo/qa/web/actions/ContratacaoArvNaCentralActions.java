/**
 *   Caminho: Portal Estabelecimento Comercial  --> ARV Na Central
 *      Date: 12/12/2019 | Fernando Lisboa - Taking 
 * Last Date: 27/12/2019 | Jessé Dantas - Taking
 */

package br.com.alelo.qa.web.actions;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alelo.qa.web.page.ContratacaoArvNaCentralPage;

public class ContratacaoArvNaCentralActions extends ContratacaoArvNaCentralPage {

	WebElement we;

	public ContratacaoArvNaCentralActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// ############################## logins ##############################

	public void telaLogin() {
		System.out.println(urlArvCentral);
		getUrlCentral();
	}

	public void loginInicial() throws InterruptedException {

		telaLogin();
		formularioLogin(urlArvCentral, urlArvCentral);
		clicarEntrar();
		paginaInicial();
	}

	// ############################## click() ##############################

	public void concordarTermos() throws InterruptedException {
		Thread.sleep(3000);
		flagAceite.click();
	}

	public void clicarCancelar() {
		btnCancelar.click();
	}

	public void clicarCancelarContratacao() {
		btnConsolidationCancel.click();
	}

	public void clicarBuscarCnpj() {
		btnBuscarEc.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clicarEntrar() {
		btnLogin.click();
	}

	public void clicarCancelarCalculoParcial() {
		btnCancelarCalculoValoresDisponiveis.click();
	}

	public void clicarAlterarRecorrencia() {
		btnAlterarRecorrencia.click();
	}

	public void clicarBtnDefinirrecebimento() throws InterruptedException {
		btnAntecipationRecurrVisualize.click();
		Thread.sleep(3000);
	}

	public void clicarSair() {
		waitForElementPageToBeClickable(btnSair);
		btnSair.click();
	}

	public void clicarAlterarValor() throws InterruptedException {
		Thread.sleep(3000);
		btnAlterarValor.click();
	}

	public void clicarinserirValor() throws InterruptedException {
		Thread.sleep(3000);
		campoInsertValorParcial.click();
	}

	public void clicarVisualizarProposta() {
		btnViewValueAntecipation.click();
	}

	public void selecionarOpcaoIndividual() throws InterruptedException {
		flagContratacaoIndividual_1.click();
		Thread.sleep(3000);
	}

	public void selecionarOpcaoIndividual2() throws InterruptedException {
		flagContratacaoIndividual_2.click();
		Thread.sleep(3000);
	}

	public void selecionarOpcaoTodos() throws InterruptedException {

		waitForElementPageToLoad(flagContratacaoTodos);

		flagContratacaoTodos.click();
		Thread.sleep(3000);
		flagContratacaoTodos.click();

	}

	public void calcularValor() {
		btnCalcularValoreLiquido.click();
	}

	public void gerarProposta() {
		btnGerarProposta.click();
	};

	public void confirmaRecorrencia() throws InterruptedException {

	}

	public void confirmarContratar() throws InterruptedException {
		btnConfirmarEContratar.click();
		Thread.sleep(3000);
	}

	public void selecionarRecorrencia(String valor) throws InterruptedException {
		if (valor.equals("diaria")) {
			flagRecebimentoDiario.click();
		} else {
			flagRecebimentoSemanal_diaSemana.click();
		}
		Thread.sleep(3000);
	}

	public void selecionaDiaSemana() throws InterruptedException {
		flagRecebimentoSemanal_diaSemana.click();
		Thread.sleep(3000);
	}

	public void selecionaOpcaoDesativada() throws InterruptedException {
		Thread.sleep(3000);
		flagRecebimentoDesativado.click();
	}

	// ############################## sendKeys() ##############################

	public void formularioLogin(String cpfComAcesso, String cpfSenhaValida) {
		inputLogin.sendKeys(cpfComAcesso);
		inputPassword.sendKeys(cpfSenhaValida);
	}

	public void cpfComAcesso(String cpfComAcesso) {
		inputLogin.sendKeys(cpfComAcesso);

	}

	public void cpfSenhaValida(String cpfSenhaValida) {
		inputPassword.sendKeys(cpfSenhaValida);
	}

	public void cnpjInexistenteInserir(String cnpjInexistente) {
		comboCnpj.sendKeys(cnpjInexistente);
	}

	public void inserirCnpj(String cnpj) {
		comboCnpj.sendKeys(cnpj);
	}

	public void consultaCnpjContrataco(String valor) {
		comboCnpj.sendKeys(valor);
	}

	public void inserirValor(String valor) {
		campoInsertValorParcial.sendKeys(valor);
	}

	// Obsoletes
	public void consultaCnpj(String valor) {
		if (valor == "existente") {
			comboCnpj.sendKeys(valor);
		} else {
			comboCnpj.sendKeys();
		}
	}

	// ############################## Asserts() ##############################

	public void paginaInicial() throws InterruptedException {
		waitForElementPageToBeClickable(btnBuscarEc);
		System.out.println(getUrlInicio());
		validarUrlAtual(getUrlInicio());
	}

	public void validaCancelamentoAntecipacao() {
		validarUrlAtual(getUrlCentral());
		System.out.println("Antecipação cancelada");
	}

	public void validarAlterarValorModal() {

		String valorLabelAntecipe = labelAntecipeSuasVendas.getText();
		Assert.assertTrue("Tela de alteração de valores não exibida...",
				valorLabelAntecipe.equals("ANTECIPE SUAS VENDAS"));
	}

	public void validaMensagemBoasVindas() {

		String obterMsg = msgBomDia.getText();
		String obterUser = nomeUsuarioLogado.getText();

		if (obterMsg.equals("Bom Dia")) {
			Assert.assertTrue("mensagem de boas vindas diferente da esperada", obterMsg.equals("Bom Dia"));
		} else if (obterMsg.equals("Boa Tarde")) {
			Assert.assertTrue("mensagem de boas vindas diferente da esperada", obterMsg.equals("Boa Tarde"));
		} else {
			Assert.assertTrue("mensagem de boas vindas diferente da esperada", obterMsg.equals("Boa Noite"));
		}

		Assert.assertTrue("Usuário logado diferente do esperado", obterUser.equals(obterUser));

	}

	public void validaBtnSair() {

		String obterMsg = confirmarSair.getText();
		Assert.assertTrue("Não saiu da aplicação corretamente", obterMsg.equals(obterMsg));

	}

	public void validaConsultaInexistente() {

		String obterMsg = labelCnpjInexistente.getText();
		Assert.assertTrue("Msg diferente da esperada", obterMsg.equals("- NENHUM CNPJ LOCALIZADO -"));

	}

	public void validarContratacaoSucesso() {

		String obterMsg = text_confirmacao_contratacao.getText();
		Assert.assertTrue("Msg diferente da esperada", obterMsg.equals("TODOS OS CÓDIGOS FORAM ANTECIPADOS"));

	}

	public void validarSolicitacaoDeRecorrecia(String valor) {

		if (valor.equals("diaria")) {
//			String confirmacao = obterTexto(confirmaRecorrencia).substring(0, 6);
			String confirmacao = labelConfirmarRecorrencia.getText().substring(0, 6);
			Assert.assertTrue("Tela de alteração de valores não exibida...", confirmacao.equals("DIÁRIA"));
		} else {

			String confirmacao = labelConfirmaRecebimentoSemanal.getText().substring(0, 7);
			Assert.assertTrue("Tela de alteração de valores não exibida...", confirmacao.equals("SEMANAL"));
		}

	}

	public void validaValorBruto() {

		WebElement brtIndividual = we.findElement(By.id("(//div[contains(@class,'textGray fontNormal col-md-2')])[3]"));
		String brutoIndividual = brtIndividual.getText();

		WebElement brtTotal = we.findElement(By.id("(//div[contains(@class,'textGray fontNormal col-md-2')])[6]"));
		String brutoTotal = brtTotal.getText();

		Assert.assertEquals("Valor Bruto Divergente do valor Total", brutoIndividual, brutoTotal);

	}

	public void validarValorLiquidoIndividual() {

		WebElement liqIndividual = we
				.findElement(By.id("(//div[contains(@class,'textDarkGreen fontBolder col-md-3')])[1]"));
		String liquidoIndividual = liqIndividual.getText();

		WebElement liqTotal = we
				.findElement(By.id("((//div[contains(@class,'textDarkGreen fontBolder col-md-3')])[2]"));
		String liquidoTotal = liqTotal.getText();

		Assert.assertTrue("Valor Bruto Divergente do valor Total", liquidoIndividual.contains(liquidoTotal));

	}

	public void validarValorDesconto() {

		BigDecimal valorBruto = repalceValorBruto();
		BigDecimal valorLiquido = replaceValorLiquido();
		BigDecimal valorDesconto = replaceValorDesconto();

		Assert.assertTrue("Valor de desconto divergente da subtração do valor liquido pelo bruto",
				valorBruto.subtract(valorLiquido).equals(valorDesconto));

	}

	public BigDecimal replaceValorLiquido() {
		String liquidoIndividual = idValorLiqIndividual.getText();
		System.out.println(liquidoIndividual);
		String str = liquidoIndividual.substring(3);
		System.out.println(str);
		System.out.println(str.replaceAll("\\.", "").replaceAll(",", ".").replaceAll("ALTERAR", ""));
		java.math.BigDecimal big = new java.math.BigDecimal(
				str.replaceAll("\\.", "").replaceAll(",", ".").replaceAll("ALTERAR", "").replaceAll("\\n", ""));

		return big;
	}

	public BigDecimal replaceValorDesconto() {
		String descontoIndividual = idValorDescontoIndividual.getText();
		System.out.println(descontoIndividual);
		String str = descontoIndividual.substring(3);
		java.math.BigDecimal big = new java.math.BigDecimal(str.replaceAll("\\.", "").replaceAll(",", "."));

		return big;
	}

	public BigDecimal repalceValorBruto() {
		String brutoIndividual = idValorBrutoIndividual.getText();
		System.out.println(brutoIndividual);
		String str = brutoIndividual.substring(3);
		java.math.BigDecimal big = new java.math.BigDecimal(str.replaceAll("\\.", "").replaceAll(",", "."));

		return big;

	}

	public void validarModal() {
//		String textoValidacao = obterTexto("xpath", labelConfirmarDadosContratacao);
		String textoValidacao = labelConfirmarDadosContratacao.getText();

		if (textoValidacao.contains((CharSequence) labelConfirmarDadosContratacao)) {
			System.out.println("Teste realizado com sucesso!");
		} else {
			fail("Texto procurado não é igual ao esperado");
		}
	}

	public void validarMaisDeUmEC(String valor1, String valor2) {

		WebElement ec1 = we
				.findElement(By.xpath("//div[@class='textGray fontNormal col-md-2'][contains(.,'" + valor1 + "')]"));
		String numeroDoPrimeiroEc = ec1.getText();

		WebElement ec2 = we
				.findElement(By.xpath("//div[@class='textGray fontNormal col-md-2'][contains(.,'" + valor2 + "')]"));
		String numeroDoSegundoEc = ec2.getText();

		String valorCnpj = cnpjContratacao.getText();

		Assert.assertTrue("Numero do CNPJ diferente do Esperado", valorCnpj.contains(valorCnpj));
		Assert.assertTrue("Nome fantasia diferente do Esperado", valorCnpj.contains(valorCnpj));

		if (ec1.isDisplayed()) {
			Assert.assertTrue("CNPJ com apenas um ec", numeroDoPrimeiroEc.contains(valor1));
		}
		if (ec2.isDisplayed()) {
			Assert.assertTrue("CNPJ com apenas um ec", numeroDoSegundoEc.contains(valor2));
		}

	}

	public void validarValorLiquido() {

//		tbl = DriverWeb.getDriver().findElement(By.id(valorLiqTable));

		if (!idValorLiqTable.getSize().equals(null)) {

			List<WebElement> listValorLiq = idValorLiqTable.findElements(By.tagName("td"));

			for (WebElement cell : listValorLiq) {

				System.out.println(cell.getText());

				// TODO somar as celulas da tabela e comparar com o valorLiquido
			}

		} else {

			String liqIndividual = idValorLiqIndividual.getText();
			String liqTotal = idValorLiqTotal.getText();

			Assert.assertEquals("Valor Bruto Divergente do valor Total", liqIndividual, liqTotal);
		}

	}

	public void validarValorDescontoTbl() {

		// tbl = DriverWeb.getDriver().findElement(By.id(valorLiqTable));

		if (!idValorDescontoTable.getSize().equals(null)) {

			List<WebElement> listDesconto = idValorDescontoTable.findElements(By.tagName("td"));

			for (WebElement cell : listDesconto) {

				System.out.println(cell.getText());

				// TODO somar as celulas da tabela e comparar com o valorLiquido
			}

		} else {

			int valorIndividualDesc = Integer.parseInt(idValorDescontoTotal.getText());

			Assert.assertEquals(valorIndividualDesc, idValorDescontoTotal);
		}

	}

	public void validarMensagemArvNaoDisponivel() {

		String text = arvNaoDisponivel.getText();

		if (text.equalsIgnoreCase("NÃO HÁ SALDO DISPONÍVEL PARA ANTECIPAÇÃO")) {
			System.out.println("Teste realizado com sucesso!");
		} else {
			fail("Texto procurado não é igual ao esperado");
		}
	}

	public void validarDomicilioBancario() {
		String domicilioBanco1 = domiciliobancarioConfirmacaoBanco1.getText();
		String domicilioAgencia1 = domiciliobancarioConfirmacaoAgencia1.getText();
		String domicilioConta1 = domiciliobancarioConfirmacaoConta1.getText();
		String domicilioBanco2 = domiciliobancarioConfirmacaoConta2.getText();
		String domicilioAgencia2 = domiciliobancarioConfirmacaoAgencia2.getText();
		String domicilioConta2 = domiciliobancarioConfirmacaoBanco2.getText();

		Assert.assertTrue("Não dividiu a antecipação por domicilio bancário", domicilioBanco1 != null);
		Assert.assertTrue("Não dividiu a antecipação por domicilio bancário", domicilioAgencia1 != null);
		Assert.assertTrue("Não dividiu a antecipação por domicilio bancário", domicilioConta1 != null);
		Assert.assertTrue("Não dividiu a antecipação por domicilio bancário", domicilioBanco2 != null);
		Assert.assertTrue("Não dividiu a antecipação por domicilio bancário", domicilioAgencia2 != null);
		Assert.assertTrue("Não dividiu a antecipação por domicilio bancário", domicilioConta2 != null);

	}

	public void validaCnpjConsultadoMaisDeUmEc(String ec1, String ec2) {

		WebElement primeiroEc = we.findElement(By.xpath("//div[@class='content w15'][contains(.,'" + ec1 + "')]"));
		String numeroDoPrimeiroEc = primeiroEc.getText();

		WebElement segundoEc = we.findElement(By.xpath("//div[@class='content w15'][contains(.,'" + ec2 + "')]"));
		String numeroDoSegundoEc = segundoEc.getText();

		String valorCnpj = cnpjContratacao.getText();

		Assert.assertTrue("Numero do CNPJ diferente do Esperado", valorCnpj.contains(valorCnpj));
		Assert.assertTrue("Nome fantasia diferente do Esperado", valorCnpj.contains(valorCnpj));
		Assert.assertTrue("CNPJ com apenas um ec", numeroDoPrimeiroEc.contains(ec1));
		Assert.assertTrue("CNPJ com apenas um ec", numeroDoSegundoEc.contains(ec2));

	}

	public void validarDadosCadastrais() {
		String valorCnpj = cnpjContratacao.getText();
		String nomeFantasia = cnpjContratacao.getText();
		String domicilioBanco = domiciliobancarioConfirmacaoBanco1.getText();
		String domicilioAgencia = domiciliobancarioConfirmacaoAgencia1.getText();
		String domicilioConta = domiciliobancarioConfirmacaoConta1.getText();
		// String RepresentanteLegal = obterTexto("id", nomeRepresentanteLegal);
		// //So tirar o comentário quando tiver massa para representante legal
		// String enderecoDoEstabelecimento = obterTexto("id",
		// enderecoEstabelecimento); //So tirar o comentário quando tiver massa
		// para endereço

		if (valorCnpj.contains(valorCnpj)) {
			System.out.println("Teste realizado com sucesso!");
		} else {
			fail("Texto procurado não é igual ao esperado");
		}

		if (nomeFantasia.contains(nomeFantasia)) {
			System.out.println("Teste realizado com sucesso!");
		} else {
			fail("Texto procurado não é igual ao esperado");
		}

		if (domicilioBanco.contains(domicilioBanco)) {
			System.out.println("Teste realizado com sucesso!");
		} else {
			fail("Texto procurado não é igual ao esperado");
		}

		if (domicilioAgencia.contains(domicilioAgencia)) {
			System.out.println("Teste realizado com sucesso!");
		} else {
			fail("Texto procurado não é igual ao esperado");
		}

		if (domicilioConta.contains(domicilioConta)) {
			System.out.println("Teste realizado com sucesso!");
		} else {
			fail("Texto procurado não é igual ao esperado");
		}
	}
	// if (RepresentanteLegal.equalsIgnoreCase(valorNomeRepresentanteLegal))
	// {
	// System.out.println("Teste realizado com sucesso!");
	// } else {
	// fail("Texto procurado não é igual ao esperado");
	// }
	// if
	// (enderecoDoEstabelecimento.equalsIgnoreCase(valorEnderecoEstabelecimento))
	// {
	// System.out.println("Teste realizado com sucesso!");
	// } else {
	// fail("Texto procurado não é igual ao esperado");
	// }

}
