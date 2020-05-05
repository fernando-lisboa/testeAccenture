package br.com.alelo.qa.web.actions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import br.com.alelo.qa.features.support.JavaScriptUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alelo.qa.web.page.LoginPage;
import br.com.alelo.qa.web.page.OfertaAtivaPage;
import br.com.alelo.qa.features.support.JavaScriptUtils;

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
		userLogin.sendKeys(user);
		password.sendKeys(senha);
		btnEntrar.click();

		if (loginFail.isDisplayed()) {
			fail("antecipacao recorrente deveria estar inativa");
		}

		waitForElementToBeInvisible(loader);

		if (webdriver.getCurrentUrl().equals("https://meuestabelecimento-hml.siteteste.inf.br/pkmslogout")) {

			System.out.println("Excedeu quantidade de token e / ou isam fora...");

		}
	}
	
	public void confirmarToken() throws InterruptedException{
		try {
			JavaScriptUtils js = new JavaScriptUtils(webdriver);
			js.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null, webdriver.findElement(By.xpath("//button[@id='btnInitiateSession']")));
			Thread.sleep(2000);
			js.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null, webdriver.findElement(By.xpath("//button[@id='btnGenerateCode']")));
			Thread.sleep(5000);
			//js.JavaScriptAction(JavaScriptUtils.Funcao.atualizarPagina,null,null,null);
		}catch (Exception e){}
	}

	public void telaLoginWebAdmin() {
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

	public void erroLogin() {
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
		waitForElementToBeInvisible(loader);
		validarUrlAtual(urlInicial);
		iconePerfil.click();
		waitForElementPageToBeClickable(btnSair);
		btnSair.click();

	}

	public void loginGeralWebAdmin(String user, String password) throws Throwable {

		if (webdriver.getCurrentUrl().contains("login")) {
			campo_cpf_webAdmin.sendKeys(user);
			campo_senha_web_admin.sendKeys(password);
			botao_entrar_webAdmin.click();
		}
	}
}
