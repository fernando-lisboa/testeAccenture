package br.com.alelo.qa.web.actions;

import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alelo.qa.web.page.LoginPage;
import br.com.alelo.qa.features.steps.LoginSteps;
import br.com.alelo.qa.web.page.OfertaAtivaPage;

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
		System.out.println(webdriver.getCurrentUrl());
		
		
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
		System.out.println(UrlInicioWebAdmin);
		getUrlInicioWebAdmin();
	}

	public void telaLogin() {
		System.out.println(urlInicial);
		getUrlInicial();
	}


	public void botaoEntrar() {
		botao_entrar.click();
	}

	public void botaoEntrarWebAdmin() {
		botao_entrar_webAdmin.click();
	}

	
	
	public void erroLogin(){
		waitForElementPageToLoad(texto_modal_falha);
		validarModalErro("VERIFIQUE AS INFORMAÇÕES DIGITADAS E TENTE NOVAMENTE.", texto_modal_falha.getText());
	}

	

	public void cpfInvalido() {
		campo_cpf_invalido.sendKeys(cpfInvalido);
	}

	public void senhaInvalida() {
		campo_cpf.sendKeys(Cpf);
		campo_senha_invalida.sendKeys(senhaInvalida);
	}

	public void bloqueiaBotaoEntrar() {
		boolean botaoEntrarHabilitado = botao_entrar.isEnabled();// VerificarElementoEstaHabilitado(botao_entrar);

		if (!botaoEntrarHabilitado) {
			System.out.println("Teste realizado com sucesso.");
		} else {
			fail("Botão 'Entrar' está habilitado!");
		}
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

		String leituraConteudoModal = texto_modal_falha.getText();// obterTexto(textoModal);
		System.out.print(leituraConteudoModal);
		botao_fechar_modal.click();
	}

	public void habilitarConta() {
		botao_habilitar_conta.click();
	}

	public void validacaoPrimeiroAcesso() throws InterruptedException {
		Thread.sleep(5000);
		campo_email.sendKeys(Email);
		validarMensagem(txtPrimeiroAcesso, comparar_primeiro_acesso);
	}

	public void esqueciSenha() {
		botao_esqueci_senha.click();
	}

	public void validacaoEsqueciSenha() throws InterruptedException {
		Thread.sleep(5000);
		esqueci_senha_cpf.sendKeys(esqueciSenhaCpf);

		// ISAM
		// escrever(campoEmail, escreverCampoEmail);
		// escrever(campoSobrenome, escreverCampoSobrenome);

		validarMensagem(txtEsqueciSenha, comparar_esqueci_senha);
	}

	public void validarMensagem(String textoOriginal, WebElement elemento) {
		try {
			String textoDeComparacao = elemento.getText();// obterTexto(elemento);

			if (textoOriginal.equalsIgnoreCase(textoDeComparacao)) {
				System.out.println("Teste realizado com sucesso.");
			} else {
				Assert.fail();
			}
		} catch (Exception e) {
			Assert.fail();
			System.out.println(e);
		}
	}
	
	public void paginaInicial() throws InterruptedException {
		Thread.sleep(10000);
		validarUrlAtual(urlInicial);
		iconePerfil.click();
		waitForElementPageToBeClickable(btnSair);
		//btnSair.click();
		
	}

	public void loginGeralWebAdmin() throws Throwable {
		try {
			LoginSteps login = new LoginSteps();
			login.que_estou_logado_em_qualquer_tela_no_Web_Admin();

			// if (DriverWeb.getDriver().getCurrentUrl().contains("login") &&
			// !DriverWeb.getDriver().findElements(By.name(escreverCPF)).isEmpty())
			// {
			if (webdriver.getCurrentUrl().contains("login")) {
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
