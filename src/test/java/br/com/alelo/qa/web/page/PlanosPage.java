/**
 * 
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
public class PlanosPage extends PageObject{
	
	
	
	@FindBy(xpath="//*[@id=\"anticipationModalAnticipationDescriptionText\"]/div[2]/div/h5")
	protected WebElement texto_termo_aceite;
	
	@FindBy(id="anticipationModalAnticipationCloseIcon")
	protected WebElement botao_fechar;
	
	@FindBy(id="btnAnticipationCancel")
	protected WebElement botao_cancelar;
	
	@FindBy(id="btnAntecipationRecurrCancel")
	protected WebElement botao_cancelar_recorrencia;
	
	@FindBy(id="btnAnticipationModalAntecipationCancel")
	protected WebElement botao_cancelar_parcial;
	
	@FindBy(id="conditionCard-0")
	protected WebElement radio_opcao_1;
	
	@FindBy(id="antecipation-accept-button")
	protected WebElement botao_contratar;
	
	@FindBy(id="antecipation-terms-check")
	protected WebElement check_aceite_termos;
	
	@FindBy(id="conditionCard-2")
	protected WebElement radio_opcao_3;
	
	@FindBy(id="conditionCard-1")
	protected WebElement radio_opcao_2;
		
		

	public PlanosPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
