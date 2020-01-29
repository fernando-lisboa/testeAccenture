package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class LoginPage extends PageObject {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String urlInicial = "http://meuestabelecimento-hml.siteteste.inf.br/login";
	public String urlInicio = "https://meuestabelecimento-sit.siteteste.inf.br/inicio";
	public String UrlInicioWebAdmin = "http://meuestabelecimento-webadmin-hml.siteteste.inf.br/portalec-webadmin/login";
	public String UrlInicioWebAdminValidate = "http://meuestabelecimento-webadmin-hml.siteteste.inf.br/portalec-webadmin/offers/campanha";

	public String getUrlInicial() {
		return urlInicial;
	}

	public String getUrlInicio() {
		return urlInicio;
	}

	public String getUrlInicioWebAdmin() {
		return UrlInicioWebAdmin;
	}

	public String getUrlInicioWebAdminValidate() {
		return UrlInicioWebAdminValidate;
	}

	@FindBy(id = "cpf")
	protected WebElement userLogin;

	@FindBy(id = "password")
	protected WebElement password;

	@FindBy(id = "imageLoader")
	protected WebElement loader;

	@FindBy(id = "AccountLoginBtnSubmitHandler")
	protected WebElement btnEntrar;
	
	@FindBy(id = "iconProfileId")
	protected WebElement iconePerfil;
	
	@FindBy(id = "navbarDesktopSair")
	protected WebElement btnSair;
	
	

	@FindBy(id = "panelPageCnpjContainerIndicator")
	protected WebElement painelInicial;

	@FindBy(xpath = "//input[@role='combobox']")
	protected WebElement comboCnpj;

	@FindBy(xpath = "//button[@type='button'][contains(.,'Veja mais Detalhes')]")
	protected WebElement resumo;

	@FindBy(id = "login-cpf-input")
	protected WebElement campo_cpf;
	public String Cpf = "42402435801";

	@FindBy(id = "formInlinePassword")
	protected WebElement campo_senha;
	public String Senha = "Teste@2018";

	@FindBy(id = "username")
	protected WebElement campo_cpf_webAdmin;
	public String cpfWebAdmin = "61223719049";

	@FindBy(id = "password")
	protected WebElement campo_senha_web_admin;
	public String senhaWebAdmin = "98485008049";

	@FindBy(id = "AccountLoginBtnSubmitHandler")
	protected WebElement botao_entrar;

	@FindBy(id = "btnEntrar")
	protected WebElement botao_entrar_webAdmin;

	@FindBy(id = "Null")
	protected WebElement campo_cpf_invalido;
	public String cpfInvalido = "00000000000";

	@FindBy(id = "Null")
	protected WebElement campo_senha_invalida;
	public String senhaInvalida = "00000000000";

	@FindBy(id = "inputCpf")
	protected WebElement esqueci_senha_cpf;
	public String esqueciSenhaCpf = "12345678910";

	@FindBy(id = "customModalText")
	protected WebElement texto_modal_falha;

	@FindBy(id = "customBtnCloseModal")
	protected WebElement botao_fechar_modal;

	@FindBy(id = "login-enable-account-button")
	protected WebElement botao_habilitar_conta;

	@FindBy(id = "login-forgot-password-link")
	protected WebElement botao_esqueci_senha;

	@FindBy(id = "textPrimeiroAcesso")
	protected WebElement comparar_primeiro_acesso;

	@FindBy(id = "textEsqueciMinhaSenha")
	protected WebElement comparar_esqueci_senha;

	@FindBy(id = "Null")
	protected WebElement texto_primeiro_acesso;
	public String txtPrimeiroAcesso = "PRIMEIRO ACESSO";

	@FindBy(id = "Null")
	protected WebElement texto_esqueci_senha;
	public String txtEsqueciSenha = "ESQUECI MINHA SENHA";

	@FindBy(id = "surname")
	protected WebElement campo_sobrenome;

	@FindBy(id = "formInlineEmail")
	protected WebElement campo_email;
	public String Email = "teste_address@mailinator.com";

}
