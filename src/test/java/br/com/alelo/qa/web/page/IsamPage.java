/**
 * 
 */
package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

/**
 * @author Fernando Lisboa
 *
 */
public class IsamPage extends PageObject {

	public IsamPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	protected String url_ISAM = "https://apisec.siteteste.inf.br/mga/sps/mga/user/mgmt/html/device/device_selection.html";
	protected String url_interna_ISAM = "https://apisec.siteteste.inf.br/mga/sps/mga/user/mgmt/html/device/device_selection.html";

	public String getUrlISAM() {
		return url_ISAM;
	}

	public String getUrlInternaISAM() {
		return url_interna_ISAM;
	}

	@FindBy(id = "imageLoader")
	protected WebElement loader;

	@FindBy(id = "username")
	protected WebElement usuario_ISAM;

	@FindBy(id = "password")
	protected WebElement senha_ISAM;

	@FindBy(xpath = "//input[@value = \"Login\"]")
	protected WebElement botao_login;

	@FindBy(xpath = "(//td/a[text() = \"Remover\"])[1]")
	protected WebElement remover_sessao;
}
