package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class AntecipacaoPage extends PageObject{
	
	
	@FindBy(id = "simulate-terms-check")
	protected WebElement checkAceiteTermosRecebiveis;
	
	@FindBy(id = "anticipationButton")
	protected WebElement btnAntecipar;
	
	@FindBy(xpath = "//*[@id=\"anticipationModalCallbackBody\"]/div[1]/h2[1]")
	protected WebElement mensagemAntecipacao;
	
	@FindBy(id = "btnAnticipationChangeValue")
	protected WebElement btnAlteraValor;
	
	@FindBy(id = "textAnticipationAntecipationValueMax")
	protected WebElement valorMaximo;
	
	@FindBy(id = "formControlsText")
	protected WebElement campoAlterarValor;
	
	@FindBy(id = "btnViewValueAntecipation")
	protected WebElement btnVisualizarValores;
	
	@FindBy(id = "antecipation-opt-3-check")
	protected WebElement opcao_1;
	
	@FindBy(id = "btnViewLiquidValueAntecipation")
	protected WebElement celularValorLiquido;
	
	@FindBy(id = "btnAnticipationChange")
	protected WebElement btnAlterarRecorrencia;
	
	@FindBy(id = "btnAnticipationModalAntecipationCancel")
	protected WebElement botaoCancelarParcial;
	
	@FindBy(id = "btnAntecipationRecurrCancel")
	protected WebElement botaoCancelarRecorrencia;
	
	@FindBy(id = "btnAnticipationCancel")
	protected WebElement botaoCancelar;
	
	@FindBy(id = "anticipationModalAnticipationCloseIcon")
	protected WebElement botaoFechar;
	
	@FindBy(id = "//*[@id=\"anticipationModalAnticipationDescriptionText\"]/div[2]/div/h5")
	protected WebElement textoTermoAceite;
	
	@FindBy(id = "anticipationModalAnticipationTitle")
	protected WebElement tituloModalAntecipacao;
	
	@FindBy(id = "btnAntecipationRecurrVisualize")
	protected WebElement botaoDefinirRecebimento;
	
	@FindBy(id = "cardRecurr-DISABLED")
	protected WebElement checkDesativar;
	
	@FindBy(id = "radioWeekly-SEG")
	protected WebElement checkDiaSemanal;
	
	@FindBy(id = "cardRecurr-WEEKLY")
	protected WebElement checkSemanal;
		

	public AntecipacaoPage(WebDriver driver) {
		super(driver);
	}

}
