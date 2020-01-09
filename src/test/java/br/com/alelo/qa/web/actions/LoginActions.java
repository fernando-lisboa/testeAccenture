package br.com.alelo.qa.web.actions;

import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.LoginPage;
import br.com.alelo.qa.web.page.OfertaAtivaPage;
import driver.web.DriverWeb;
import stepsweb.LoginStep;

public class LoginActions extends LoginPage {

	OfertaAtivaPage page = new OfertaAtivaPage(webdriver);

	public LoginActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void preencherLogin(String user, String senha) {
		userLogin.sendKeys(user);
		password.sendKeys(senha);
		btnEntrar.click();
	}

	public void loginGeral(String user, String senha) throws Throwable {
		waitForElementPageToBeClickable(userLogin);
		userLogin.click();
		userLogin.sendKeys(user);
		password.sendKeys(senha);
		btnEntrar.click();
		aguardarTelaInicial();
	}

	public void aguardarTelaInicial() throws InterruptedException {
		Thread.sleep(10000);
	}

	public void telaLoginWebAdmin() {
		System.out.println(urlInicioWebAdmin);
		abrirUrl(urlInicioWebAdmin);
	}

	public void telaLogin() {
		System.out.println(url);
		abrirUrl(url);
	}

	public void formularioLoginWebAdmin() {
		escrever(escreverCPFWebAdmin, CPFWebAdmin);
		escrever(escreverSenhaWebAdmin, SenhaWebAdmin);
	}

	public void formularioLogin() {
		escrever(escreverCPF, CPF);
		escrever(escreverSenha, Senha);
	}

	public void botaoEntrar() {
		clicar(botaoEntrar);
	}

	public void botaoEntrarWebAdmin() {
		clicar(botaoEntrarWebAdmin);
	}

	public void paginaInicial() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println(urlInicio);
		validarUrlAtual(urlInicio);
	}

	public void paginaInicialWebAdmin() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println(urlInicioWebAdminValidate);
		validarUrlAtual(urlInicioWebAdminValidate);
	}

	public void cpfInvalido() {
		escrever(escreverCPF, numCpfInvalido);
	}

	public void bloqueiaBotaoEntrar() {
		boolean botaoEntrarHabilitado = VerificarElementoEstaHabilitado(botaoEntrar);

		if (!botaoEntrarHabilitado) {
			System.out.println("Teste realizado com sucesso.");
		} else {
			fail("Botão 'Entrar' está habilitado!");
		}
	}

	public void senhaInvalida() {
		escrever(escreverCPF, CPF);
		escrever(escreverSenha, numSenhaInvalida);
	}

	public void modalFalha() throws InterruptedException {
		Thread.sleep(5000);

		// Solucao temporaria para contornar mensagem de popup do browser
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);

		} catch (AWTException e) {
			e.printStackTrace();
		}
		Thread.sleep(3000);

		String leituraConteudoModal = obterTexto(textoModal);
		System.out.print(leituraConteudoModal);
		clicar(botaoFecharModal);
	}

	public void habilitarConta() {
		clicar(botaoHabilitarConta);
	}

	public void validacaoPrimeiroAcesso() throws InterruptedException {
		Thread.sleep(5000);
		escrever(campoEmail, escreverCampoEmail);
		super.validarMensagem(textoPrimeiroAcesso, textoCompararPrimeiroAcesso);
	}

	public void esqueciSenha() {
		clicar(botaoEsqueciSenha);
	}

	public void validacaoEsqueciSenha() throws InterruptedException {
		Thread.sleep(5000);
		escrever(campoCPFsenha, escreverCPFsenha);

		// ISAM
		// escrever(campoEmail, escreverCampoEmail);
		// escrever(campoSobrenome, escreverCampoSobrenome);

		super.validarMensagem(textoEsqueciSenha, textoCompararEsqueciSenha);
	}

	public static void loginGeralWebAdmin() throws Throwable {
		try {
			LoginStep login = new LoginStep();
			login.que_estou_na_tela_de_login_WebAdmin();

			// if (DriverWeb.getDriver().getCurrentUrl().contains("login") &&
			// !DriverWeb.getDriver().findElements(By.name(escreverCPF)).isEmpty())
			// {
			if (DriverWeb.getDriver().getCurrentUrl().contains("login")) {
				System.out.println("Fazer Login");
				login.preencho_o_formulario_de_login_webAdmin();
				login.aciono_o_botao_Entrar_webAdmin();
				login.o_usuario_e_redirecionado_para_a_pagina_inicial_webAdmin();
			} else {
				System.out.println("Ja esta logado");
				Thread.sleep(5000);
			}

			/*
			 * if (!DriverWeb.getDriver().getCurrentUrl().contains("login")) {
			 * System.out.println("Ja esta logado"); Thread.sleep(5000); } else {
			 * System.out.println("Fazer Login"); login.preencho_o_formulario_de_login();
			 * login.aciono_o_botao_Entrar();
			 * login.o_usuario_e_redirecionado_para_a_pagina_inicial(); }
			 */
		} catch (Exception e) {
			fail("Dados de login inválidos!");
		}
	}

}
