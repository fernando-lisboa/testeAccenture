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
public class PainelPage extends PageObject {

	public PainelPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	protected String urlInicio = "http://meuestabelecimento-hml.siteteste.inf.br/inicio";
	protected String urlExtrato = "http://meuestabelecimento-hml.siteteste.inf.br/extrato";

	protected String linkTwitter = "https://twitter.com/alelobrasil";
	protected String linkFacebook = "https://www.facebook.com/AleloBrasil";
	protected String linkLinkedin = "https://www.linkedin.com/alelobrasil";

	public String getUrlInicio() {
		return urlInicio;
	}

	public String getUrlExtrato() {
		return urlExtrato;
	}

	public String getLinkTwitter() {
		return linkTwitter;
	}

	public String getLinkFacebook() {
		return linkFacebook;
	}

	public String getLinkLinkedin() {
		return linkLinkedin;
	}

	@FindBy(id = "imageLoader")
	protected WebElement aguardar_gif;

	@FindBy(id = "cnpj")
	protected WebElement opcao_select;

	@FindBy(id = "//*[@id=\"cnpj\"]/../div/div/b[contains(text(), \"14.931.844/0009-18 - 1015001294\")]")
	protected WebElement opcao_ec;

	@FindBy(id = "//*[@id=\"cnpj\"]/../div/div/b[contains(text(), \"82.143.278/0001-82 - 1012770645\")]")
	protected WebElement opcao_ec_plano;

	@FindBy(id = "//*[@id=\"cnpj\"]/../div/div/b[contains(text(), \"67.140.569/0001-23 - 2000494743\")]")
	protected WebElement opcao_ec_plano_saldo;

	@FindBy(id = "//*[@id=\"cnpj\"]/../div/div/b[contains(text(), \"14.931.844/0009-18 - 1015001294\")]")
	protected WebElement opcao_ec_arv;

	@FindBy(id = "//*[@id=\"cnpj\"]/../div/div/b[contains(text(), \"00.304.562/0009-86 - 1015000654\")]")
	protected WebElement opcao_ec_sp_ss;

	@FindBy(xpath = "//*[@id=\"menuContentContainer\"]/div/div/div/div[2]/div/img")
	protected WebElement banner_superior;

	@FindBy(xpath = "//*[@id=\"footerAleloLogo\"]")
	protected WebElement banner_inferior;

	@FindBy(id = "footerRedesSociaisTwitter")
	protected WebElement botao_twitter;

	@FindBy(id = "footerRedesSociaisFacebook")
	protected WebElement botao_facebook;

	@FindBy(id = "footerRedesSociaisLinkedin")
	protected WebElement botao_linkedin;

	@FindBy(id = "textNormalSidekick")
	protected WebElement sidekick_arv;
	public String textSidekickArv = "Antecipe suas vendas";

	@FindBy(id = "textNormalSidekick")
	protected WebElement sidekick_Plano;
	public String textSidekickPlano = "Quer ter o seu caixa sempre em dia?";

	@FindBy(id = "Null")
	protected WebElement estabelecimento_comparar;
	public String estabelecimentoComparar = "Quer ter o seu caixa sempre em dia?";

}
