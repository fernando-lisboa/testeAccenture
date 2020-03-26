package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class LoginARVNaCentralPage_ extends PageObject {

	@FindBy(id = "inputLogin")
	protected WebElement inputLogin;

	@FindBy(id = "inputPassord")
	protected WebElement inputPassord;
	
	@FindBy(id = "btnBuscarEc")
	protected WebElement btnBuscar;

	@FindBy(xpath = "//button[@type='submit'][contains(.,'ENTRAR')]")
	protected WebElement btnLogar;

	@FindBy(xpath = "//p[@class='aleloLogoutLink'][contains(.,'SAIR')]")
	protected WebElement btnLogout;

	public LoginARVNaCentralPage_(WebDriver driver) {
		super(driver); 
		// TODO Auto-generated constructor stub
	}
	
	//@FindBy (id = "swal2-content")
	@FindBy(xpath = "(//div[contains(.,'Usuário ou Senha inválido!')])[4]")
	public WebElement tentativaInvalidaLogin;
	public String txtUserInvalido = "Usuário ou Senha inválido!";

	@FindBy(id ="nomeUsuarioLogado")
	public WebElement nomeUsuarioLogado;
	public String nomeUsuarioLogado1 = "Fernando Lisbon";
	
	@FindBy(id = "swal2-title")
	public WebElement msgError;
	public String msgErrorInvalido = "Oops...";
}
