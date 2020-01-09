package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class SairPage extends PageObject {

	public SairPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String urlLogout = "http://meuestabelecimento-hml.siteteste.inf.br/login";

	public String getUrlLogout() {
		return urlLogout;
	}

	public void setUrlLogout(String urlLogout) {
		this.urlLogout = urlLogout;
	}

	@FindBy(id = "imageLoader")
	protected WebElement aguardar_gif;

	@FindBy(id = "navbarDesktopSair")
	protected WebElement botaoSair;

	@FindBy(id = "nav-dropdown")
	protected WebElement botaoPerfil;

}
