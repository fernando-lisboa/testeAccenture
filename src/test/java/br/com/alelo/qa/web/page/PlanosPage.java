/**
* @author Fernando Lisboa - Taking 
* Change: 08/01/2019 | Author: Jessé Dantas - Taking
*/
package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

/**
 * @author User
 *
 */
public class PlanosPage extends PageObject {

	public PlanosPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	protected String urlInicio = "http://meuestabelecimento-hml.siteteste.inf.br/inicio";

	public String getUrlInicio() {
		return urlInicio;
	}

	@FindBy(xpath = "//*[@id=\"anticipationModalAnticipationDescriptionText\"]/div[2]/div/h5")
	protected WebElement texto_termo_aceite;

	@FindBy(id = "anticipationModalAnticipationCloseIcon")
	protected WebElement botao_fechar;

	@FindBy(id = "btnAnticipationCancel")
	protected WebElement botao_cancelar;

	@FindBy(id = "btnAntecipationRecurrCancel")
	protected WebElement botao_cancelar_recorrencia;

	@FindBy(id = "btnAnticipationModalAntecipationCancel")
	protected WebElement botao_cancelar_parcial;

	@FindBy(id = "antecipation-accept-button")
	protected WebElement botao_contratar;

	@FindBy(id = "imageLoader")
	protected WebElement aguardar_gif;

	@FindBy(id = "antecipation-terms-check")
	protected WebElement check_aceite_termos;

	@FindBy(id = "conditionCard-0")
	protected WebElement radio_opcao_1;

	@FindBy(id = "conditionCard-2")
	protected WebElement radio_opcao_3;

	@FindBy(id = "conditionCard-1")
	protected WebElement radio_opcao_2;

	@FindBy(id = "cnpj")
	protected WebElement opcao_select;

	@FindBy(xpath = "//*[@id=\"cnpj\"]/../div/div/b[contains(text(), \"[DATA]\")]")
	protected WebElement opcao_ec;

	@FindBy(id = "textNormalSidekick")
	protected WebElement click_side_kick;

	@FindBy(id = "btnSimulateNormalSidekick")
	public WebElement botao_side_kick;

	@FindBy(id = "")
	protected WebElement mensagem_contratacao;
	public String msgContratacao = "Contratação realizada";

}
