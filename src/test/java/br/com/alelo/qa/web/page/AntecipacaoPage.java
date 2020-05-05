package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class AntecipacaoPage extends PageObject {

	public AntecipacaoPage(WebDriver driver) {
		super(driver);
	}

	String urlInicio = "http://meuestabelecimento-hml.siteteste.inf.br/inicio";
	String urlInicioArv = "https://meuestabelecimento-hml.siteteste.inf.br/antecipe";

	public String getUrlInicioArv() {
		return urlInicioArv;
	}

	public void setUrlInicioArv(String urlInicioArv) {
		this.urlInicioArv = urlInicioArv;
	}

	public String getUrlInicio() {
		return urlInicio;
	}

	public void setUrlInicio(String urlInicio) {
		this.urlInicio = urlInicio;
	}

	@FindBy(xpath = "//input[@role='combobox']")
	protected WebElement comboCnpj;

	@FindBy(id = "simulate-terms-check")
	public WebElement checkAceiteTermosRecebiveis;

	@FindBy(id = "anticipationButton")
	protected WebElement btnAntecipar;

	@FindBy(xpath = "//*[@id=\"anticipationModalCallbackBody\"]/div[1]/h2[1]")
	protected WebElement mensagemAntecipacao;

	@FindBy(id = "btnAnticipationChangeValue")
	public WebElement btnAlteraValor;

	@FindBy(id = "textAnticipationAntecipationValueMax")
	protected WebElement valorMaximo;

	@FindBy(id = "formControlsText")
	public WebElement campoAlterarValor;

	@FindBy(id = "btnViewValueAntecipation")
	public WebElement btnVisualizarValores;

	@FindBy(id = "antecipation-opt-3-check")
	protected WebElement opcao_1;

	@FindBy(id = "btnViewLiquidValueAntecipation")
	public WebElement calcularValorLiquido;

	@FindBy(id = "btnAnticipationChange")
	public WebElement btnAlterarRecorrencia;

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
	public WebElement botaoDefinirRecebimento;

	@FindBy(id = "cardRecurr-DISABLED")
	protected WebElement checkDesativar;

	@FindBy(id = "radioWeekly-SEG")
	protected WebElement checkDiaSemanal;

	@FindBy(id = "cardRecurr-WEEKLY")
	protected WebElement checkSemanal;

	@FindBy(id = "loaderId")
	protected WebElement loader;

	@FindBy(id = "textNormalSidekick")
	protected WebElement clicaArv;

	@FindBy(id = "btnSimulateNormalSidekick")
	protected WebElement btnSideKick;

	@FindBy(id = "btnGenerateToken")
	protected WebElement btnIniciarSimulacao;

	
	@FindBy(xpath = "//b[contains(.,'• 28.339.982/0001-60 - 2000496258')]")
	protected WebElement opcao_ec_arv;
	public String opcaoARV = "• 28.339.982/0001-60 - 2000496258";
	
	@FindBy(xpath = "//h5[contains(@class,'textLabelSidekick')]")
	protected WebElement sideKickAtencao;
	public String labelSidekick = "VOCÊ ESTÁ NO MODO SIMULAÇÃO";

	@FindBy(xpath = "//b[contains(.,'• 12.259.140/0001-68 - 1015000255')]")
	protected WebElement opcao_ec;
	
	@FindBy(xpath = "//b[contains(.,'• 12.819.758/0002-16 - 0000660817')]")
	protected WebElement weOpcaoEcSimulacao;
	public String opcaoECSimulacao = "@ 12.819.758/0002-16 - 0000660817";

	@FindBy(xpath = "//div[@id='simulationAlert']/div[2]")
	protected WebElement modalConfirmacaoArv;
	public String textoConfirmacaoArv = "IMPORTANTE: A simulação não efetivará a contratação do produto.";
	
	// ELEMENTO DE CONFIRMAÇÃO DE CONTRATAÇÃO VIA MODAL
	@FindBy(xpath = "/html/body/div[7]/div[2]/div/div/div[2]/div[1]")
	
	protected WebElement modalConfirmacaoContratacaoArv;
	public String textoConfirmacaoContratacaoArv = "ANTECIPAÇÃO REALIZADA COM SUCESSO";
	
	// ELEMENTO DE CONFIRMAÇÃO DE CONTRATAÇÃO VIA TELA
	@FindBy(xpath = "/html/body/div[4]/div[2]/div/div/div[2]/div[1]")
	protected WebElement modalConfirmacaoContratacaoArvTela;
	public String textoConfirmacaoContratacaoArvTela = "ANTECIPAÇÃO REALIZADA COM SUCESSO";

	@FindBy(className = "modalTitleSuccess")
	protected WebElement modalConfirmacaoContratacaoArv1;
	public String textoConfirmacaoContratacaoArv1 = "ANTECIPAÇÃO REALIZADA COM SUCESSO";
	
	//ELEMENTO DE CONFIRMAÇÃO DE CONTRATAÇÃO DE RECORRENCIA VIA MODAL
	@FindBy(xpath = "/html/body/div[7]/div[2]/div/div/div[2]/div[1]")
	protected WebElement msgRecorrencia;
	public String textoMsgRecorrencia = "antecipação realizada com sucesso";
	
	
}
