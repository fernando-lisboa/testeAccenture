package br.com.alelo.qa.web.actions;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alelo.qa.web.page.ContratacaoArvNaCentralPage;

public class ContratacaoArvNaCentralActions extends ContratacaoArvNaCentralPage{

	public void concordarTermos() throws InterruptedException {
		Thread.sleep(3000);
		flagAceite.click();;
	}

	public void clicarCancelar() {
		btnCancelar.click();
	}

	public void clicarCancelarContratacao() {
		btnCancelarConfirmacaoContratacao;
	}

	public void telaLogin() {
		System.out.println(urlArvCentral);
		abrirUrl(urlArvCentral);
	}

	public void formularioLogin() {
		// esperarElemento(inputLogin, 10);
		escrever(inputLogin, valorLogin);
		escrever(inputPassword, valorPassword);
	}

	public void consultaCnpj(String valor) {

		if (valor == "existente") {
			escrever(comboCnpj, CNPJ);
		} else {

			escrever(comboCnpj, cnpjInexistyente);
		}

	}

	public void consultaCnpjContrataco(String valor) {

		escrever(comboCnpj, valor);
	}

	public void clicarBuscarCnpj() {
		clicar(btnBuscarEc);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clicarEntrar() {
		clicar(btnLogin);
	}

	public void paginaInicial() throws InterruptedException {
		esperarElemento(btnBuscarEc, 60);
		System.out.println(urlInicio);
		validarUrlAtual(urlInicio);
	}

	public void clicarCancelarCalculoParcial() {
		clicar(btnCancelarCalculoValoresDisponiveis);
	}

	public void clicarAlterarRecorrencia() {
		clicar(btnAlterarRecorrencia);
	}

	public void clicarBtnDefinirrecebimento() throws InterruptedException {
		clicar(btnDefinirRecebimento);
		Thread.sleep(3000);
	}

	public void validaCancelamentoAntecipacao() {
		validarUrlAtual(urlArvCentral);
		System.out.println("Antecipação cancelada");
	}

	public void clicarSair() {
		esperarSerClicavel(btnSair, 10);
		clicar(btnSair);
	}

	public void clicarAlterarValor() throws InterruptedException {
		Thread.sleep(3000);
		clicar(btnAlterarValor);
	}

	public void clicarinserirValor() throws InterruptedException {
		Thread.sleep(3000);
		clicar(campoInsertValorParcial);
	}

	public void inserirValor(String valor) {

		escrever(campoInsertValorParcial, valor);
	}

	public void clicarVisualizarProposta() {
		clicar("btnViewValueAntecipation");
	}

	public void validarAlterarValorModal() {

		String valorLabelAntecipe = obterTexto(labelAntecipeSuasVendas);
		Assert.assertTrue("Tela de alteração de valores não exibida...",
				valorLabelAntecipe.equals("ANTECIPE SUAS VENDAS"));
	}

	public void selecionarOpcaoIndividual() throws InterruptedException {
		clicar(flagContratacaoIndividual_1);
		Thread.sleep(3000);

	}

	public void selecionarOpcaoIndividual2() throws InterruptedException {
		clicar(flagContratacaoIndividual_2);
		Thread.sleep(3000);

	}

	public void selecionarOpcaoTodos() throws InterruptedException {

		validarSeElementoEstaVisivel(flagContratacaoTodos);

		clicar(flagContratacaoTodos);
		Thread.sleep(3000);
		clicar(flagContratacaoTodos);

	}

	public void loginInicial() throws InterruptedException {

		telaLogin();
		formularioLogin();
		clicarEntrar();
		paginaInicial();
	}

	public void calcularValor() {
		clicar(btnCalcularValoreLiquido);
	}

	public void gerarProposta() {
		clicar(btnGerarProposta);
	};

	public void confirmaRecorrencia() throws InterruptedException {

	}

	public void confirmarContratar() throws InterruptedException {
		clicar(btnConfirmarEContratar);
		Thread.sleep(3000);
	}

	public void selecionarRecorrencia(String valor) throws InterruptedException {
		if(valor.equals("diaria")){
			clicar(flagRecebimentoDiario);
		}else{
			clicar(flagRecebimentoSemanal_diaSemana);
		}
		Thread.sleep(3000);
	}

	public void selecionaDiaSemana() throws InterruptedException {
		clicar(flagRecebimentoSemanal_diaSemana);
		Thread.sleep(3000);
	}

	public void selecionaOpcaoDesativada() throws InterruptedException {
		Thread.sleep(3000);
		clicar(flagRecebimentoDesativado);
	}

	public void validaMensagemBoasVindas() {

		String obterMsg = obterTexto(msgBomDia);
		String obterUser = obterTexto(labelNomeUsuarioLogado);

		if (obterMsg.equals("Bom Dia")) {
			Assert.assertTrue("mensagem de boas vindas diferente da esperada", obterMsg.equals("Bom Dia"));
		} else if (obterMsg.equals("Boa Tarde")) {
			Assert.assertTrue("mensagem de boas vindas diferente da esperada", obterMsg.equals("Boa Tarde"));
		} else {
			Assert.assertTrue("mensagem de boas vindas diferente da esperada", obterMsg.equals("Boa Noite"));
		}

		Assert.assertTrue("Usuário logado diferente do esperado", obterUser.equals(usuarioLogadoEsperado));

	}

	public void validaBtnSair() {

		String obterMsg = obterTexto(labelConfirmarSair);
		Assert.assertTrue("Não saiu da aplicação corretamente", obterMsg.equals(resultesperadoBtnSair));

	}

	public void validaConsultaInexistente() {

		String obterMsg = obterTexto(labelCnpjInexistente);
		Assert.assertTrue("Msg diferente da esperada", obterMsg.equals("- NENHUM CNPJ LOCALIZADO -"));

	}

	public void validarContratacaoSucesso() {

		String obterMsg = obterTexto(text_confirmacao_contratacao);
		Assert.assertTrue("Msg diferente da esperada", obterMsg.equals("TODOS OS CÓDIGOS FORAM ANTECIPADOS"));

	}

	public void validarSolicitacaoDeRecorrecia(String valor) {

		if (valor.equals("diaria")) {
			String confirmacao = obterTexto(confirmaRecorrencia).substring(0, 6);
			Assert.assertTrue("Tela de alteração de valores não exibida...", confirmacao.equals("DIÁRIA"));
		}else{
			
			String confirmacao = obterTexto(labelConfirmaRecebimentoSemanal).substring(0, 7);
			Assert.assertTrue("Tela de alteração de valores não exibida...", confirmacao.equals("SEMANAL"));
		}

	}

	public void validaValorBruto() {

		String brutoIndividual = DriverWeb.getDriver()
				.findElement(By.id("(//div[contains(@class,'textGray fontNormal col-md-2')])[3]")).getText();
		String brutoTotal = DriverWeb.getDriver()
				.findElement(By.id("(//div[contains(@class,'textGray fontNormal col-md-2')])[6]")).getText();
		Assert.assertEquals("Valor Bruto Divergente do valor Total", brutoIndividual, brutoTotal);

	}

	public void validarValorLiquidoIndividual() {

		String liquidoIndividual = DriverWeb.getDriver()
				.findElement(By.id("(//div[contains(@class,'textDarkGreen fontBolder col-md-3')])[1]")).getText();
		String liquidoTotal = DriverWeb.getDriver()
				.findElement(By.id("((//div[contains(@class,'textDarkGreen fontBolder col-md-3')])[2]")).getText();
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
		String liquidoIndividual = obterTexto(valorLiqIndividual);
		System.out.println(liquidoIndividual);
		String str = liquidoIndividual.substring(3);
		System.out.println(str);
		System.out.println(str.replaceAll("\\.", "").replaceAll(",", ".").replaceAll("ALTERAR", ""));
		java.math.BigDecimal big = new java.math.BigDecimal(
				str.replaceAll("\\.", "").replaceAll(",", ".").replaceAll("ALTERAR", "").replaceAll("\\n", ""));

		return big;
	}

	public BigDecimal replaceValorDesconto() {
		String descontoIndividual = obterTexto(valorDescontoIndividual);
		System.out.println(descontoIndividual);
		String str = descontoIndividual.substring(3);
		java.math.BigDecimal big = new java.math.BigDecimal(str.replaceAll("\\.", "").replaceAll(",", "."));

		return big;
	}

	public BigDecimal repalceValorBruto() {
		String brutoIndividual = obterTexto(valorBrutoIndividual);
		System.out.println(brutoIndividual);
		String str = brutoIndividual.substring(3);
		java.math.BigDecimal big = new java.math.BigDecimal(str.replaceAll("\\.", "").replaceAll(",", "."));

		return big;

	}

	public void validarModal() {
		String textoValidacao = obterTexto("xpath", labelConfirmarDadosContratacao);

		if (textoValidacao.contains(valorLabelConfirmarDadosContratacao)) {
			System.out.println("Teste realizado com sucesso!");
		} else {
			fail("Texto procurado não é igual ao esperado");
		}
	}

	public void validarMaisDeUmEC(String valor1, String valor2) {

		String numeroDoPrimeiroEc = obterTexto("xpath",
				"//div[@class='textGray fontNormal col-md-2'][contains(.,'" + valor1 + "')]");
		String numeroDoSegundoEc = obterTexto("xpath",
				"//div[@class='textGray fontNormal col-md-2'][contains(.,'" + valor2 + "')]");

		String valorCnpj = obterTexto("id", labelCnpjContratacao);

		Assert.assertTrue("Numero do CNPJ diferente do Esperado", valorCnpj.contains(valorCnpjPesquisado));
		Assert.assertTrue("Nome fantasia diferente do Esperado", valorCnpj.contains(valorNomeFantasia));

		if (encontra(numeroDoPrimeiroEc).isDisplayed()) {
			Assert.assertTrue("CNPJ com apenas um ec", numeroDoPrimeiroEc.contains(valor1));
		}
		if (encontra(numeroDoSegundoEc).isDisplayed()) {
			Assert.assertTrue("CNPJ com apenas um ec", numeroDoSegundoEc.contains(valor2));
		}

	}

	public void validarValorLiquido() {

		tbl = DriverWeb.getDriver().findElement(By.id(valorLiqTable));

		if (!tbl.getSize().equals(null)) {

			List<WebElement> listValorLiq = tbl.findElements(By.tagName("td"));

			for (WebElement cell : listValorLiq) {

				System.out.println(cell.getText());

				// TODO somar as celulas da tabela e comparar com o valorLiquido
			}

		} else {

			String liqIndividual = obterTexto(valorLiqIndividual);
			String liqTotal = obterTexto(valorLiqTotal);

			Assert.assertEquals("Valor Bruto Divergente do valor Total", liqIndividual, liqTotal);
		}

	}

	public void validarValorDescontoTbl() {

		tbl = DriverWeb.getDriver().findElement(By.id(valorLiqTable));

		if (!tbl.getSize().equals(null)) {

			List<WebElement> listDesconto = tbl.findElements(By.tagName("td"));

			for (WebElement cell : listDesconto) {

				System.out.println(cell.getText());

				// TODO somar as celulas da tabela e comparar com o valorLiquido
			}

		} else {

			int valorIndividualDesc = Integer.parseInt(obterTexto(valorLiqIndividual));

			Assert.assertEquals(valorIndividualDesc, valorLiqTotal);
		}

	}

	public void validarMensagemArvNaoDisponivel() {

		String text = obterTexto("xpath", arvNaoDisponivel);

		if (text.equalsIgnoreCase(msgArvNaoDisponivel)) {
			System.out.println("Teste realizado com sucesso!");
		} else {
			fail("Texto procurado não é igual ao esperado");
		}
	}

	public void validarDomicilioBancario() {
		String domicilioBanco1 = obterTexto("id", text_banco1_confirmacao);
		String domicilioAgencia1 = obterTexto("id", text_agencia1_confirmacao);
		String domicilioConta1 = obterTexto("id", text_conta1_confirmacao);
		String domicilioBanco2 = obterTexto("id", text_banco2_confirmacao);
		String domicilioAgencia2 = obterTexto("id", text_agencia2_confirmacao);
		String domicilioConta2 = obterTexto("id", text_conta2_confirmacao);

		Assert.assertTrue("Não dividiu a antecipação por domicilio bancário", domicilioBanco1 != null);
		Assert.assertTrue("Não dividiu a antecipação por domicilio bancário", domicilioAgencia1 != null);
		Assert.assertTrue("Não dividiu a antecipação por domicilio bancário", domicilioConta1 != null);
		Assert.assertTrue("Não dividiu a antecipação por domicilio bancário", domicilioBanco2 != null);
		Assert.assertTrue("Não dividiu a antecipação por domicilio bancário", domicilioAgencia2 != null);
		Assert.assertTrue("Não dividiu a antecipação por domicilio bancário", domicilioConta2 != null);

	}

	public void validaCnpjConsultadoMaisDeUmEc(String ec1, String ec2) {

		String numeroDoPrimeiroEc = obterTexto("xpath", "//div[@class='content w15'][contains(.,'" + ec1 + "')]");
		String numeroDoSegundoEc = obterTexto("xpath", "//div[@class='content w15'][contains(.,'" + ec2 + "')]");
		String valorCnpj = obterTexto("id", labelCnpjContratacao);

		Assert.assertTrue("Numero do CNPJ diferente do Esperado", valorCnpj.contains(valorCnpjPesquisado));
		Assert.assertTrue("Nome fantasia diferente do Esperado", valorCnpj.contains(valorNomeFantasia));
		Assert.assertTrue("CNPJ com apenas um ec", numeroDoPrimeiroEc.contains(ec1));
		Assert.assertTrue("CNPJ com apenas um ec", numeroDoSegundoEc.contains(ec2));

	}

	public void validarDadosCadastrais() {
		String valorCnpj = obterTexto("id", labelCnpjContratacao);
		String nomeFantasia = obterTexto("id", labelCnpjContratacao);
		String domicilioBanco = obterTexto("id", domicilioBancarioContratacaoBanco);
		String domicilioAgencia = obterTexto("id", domicilioBancarioContratacaoAgencia);
		String domicilioConta = obterTexto("id", domicilioBancarioContratacaoConta);
		// String RepresentanteLegal = obterTexto("id", nomeRepresentanteLegal);
		// //So tirar o comentário quando tiver massa para representante legal
		// String enderecoDoEstabelecimento = obterTexto("id",
		// enderecoEstabelecimento); //So tirar o comentário quando tiver massa
		// para endereço

		if (valorCnpj.contains(valorCnpjPesquisado)) {
			System.out.println("Teste realizado com sucesso!");
		} else {
			fail("Texto procurado não é igual ao esperado");
		}

		if (nomeFantasia.contains(valorNomeFantasia)) {
			System.out.println("Teste realizado com sucesso!");
		} else {
			fail("Texto procurado não é igual ao esperado");
		}

		if (domicilioBanco.contains(valorDomicilioBanco)) {
			System.out.println("Teste realizado com sucesso!");
		} else {
			fail("Texto procurado não é igual ao esperado");
		}

		if (domicilioAgencia.contains(valorDomicilioAgencia)) {
			System.out.println("Teste realizado com sucesso!");
		} else {
			fail("Texto procurado não é igual ao esperado");
		}

		if (domicilioConta.contains(valorDomicilioConta)) {
			System.out.println("Teste realizado com sucesso!");
		} else {
			fail("Texto procurado não é igual ao esperado");
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

	public ContratacaoArvNaCentralActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
