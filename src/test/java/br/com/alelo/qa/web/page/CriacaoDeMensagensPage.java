/**
 * 
 */
package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;
import br.com.alelo.utils.RandomUtils;

/**
 * @author Matheus Lisboa
 *
 */
public class CriacaoDeMensagensPage extends PageObject {

	public CriacaoDeMensagensPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	RandomUtils random;

	@FindBy(xpath = "/html/body/div[2]/nav[1]/div/div/ul/li[2]/a")
	protected WebElement mensagens_link;

	@FindBy (xpath = "//*[@id=\"notificationDefaultMessage\"]")
	protected WebElement comboTipoDeMensagem;

	@FindBy (id = "notificationType")
	protected WebElement comboTipoDeEnvio;

	@FindBy(id = "btnAdicionarOferta")
	protected WebElement btn_adicionar_mensagem;
	
	@FindBy(id = "statusNotification")
	protected WebElement status_notification;
	public String statusNotification = "Vigente";
	
	@FindBy(id = "vanCheckLabel2")
	protected WebElement data_final;

	@FindBy(id = "btnBeginDate")
	protected WebElement dataInicialVigencia;

	@FindBy(id = "btnEndDate")
	protected WebElement dataFinalVigencia;
	
	@FindBy(id = "notificationType")
	protected WebElement tipo_de_envio;

	@FindBy(id = "notificationDefaultMessage")
	protected WebElement tipo_da_mensagem;

	@FindBy(id = "imageLoader")
	protected WebElement loader;

	@FindBy(id = "notificationName")
	protected WebElement nome_da_mensagem;
	public String nomeDaMensagem = "Criação de mensagem via WebAdmin-Front";

	@FindBy(id = "notificationSubject")
	protected WebElement assunto_da_mensagem;
	public String notificationSubject = "Teste via Front";

	@FindBy(id = "notificationMessage")
	protected WebElement descricao_da_mensagem;
	public String notificationMessage = "Testando inclusão via robô - Front";
	
	//Botao filtrar
	@FindBy(id = "btnCalendarFilter")
	protected WebElement btn_filtrar;

	//Ícone para editar 
	
	@FindBy(xpath = "/html/body/div[3]/div[2]/table/tbody/tr[2]/td[7]/a")
	protected WebElement img_btn_edicao;
	
	protected WebElement editar;
	
	@FindBy (id = "table")
	protected WebElement tableEditar;
	
	@FindBy(id = "endDate")
	protected WebElement status_message;


	@FindBy(xpath = "/html/body/div[6]/div[3]/table")
	protected WebElement dataInicioDaMensagemTable;

	@FindBy(xpath = "/html/body/div[7]/div[3]/table")
	protected WebElement dataFinalDaMensagemTable;

	@FindBy(xpath = "/html/body/div[4]/div[3]/div/div/div[2]/div/h1[2]")
	protected WebElement mensagem_confirmacao;

	@FindBy(id = "btnInsert")
	protected WebElement btn_salvar_mensagem;

	@FindBy(xpath = "//h1[contains(.,'mensagem editada')]")
	protected WebElement editarSucesso;
	public String msgEsperada = "MENSAGEM EDITADA";
	
	
	//exclusao
	@FindBy(xpath = "//h1[contains(.,'Tem certeza que deseja']")
	protected WebElement exclusaoSucesso;
	
	@FindBy(id = "btnGrayLight")
	protected WebElement btn_cancelar;

	@FindBy(xpath = "//button[contains(@class,'btn btn-default btnRedir')]")
	protected WebElement btnConfirmaMensagem;
	
	@FindBy(xpath = "/html/body/div[3]/div[2]/table/tbody/tr[3]/td[8]/a/img")
	protected WebElement btnExcluirMensagem;
	
	@FindBy(xpath = "/html/body/div[4]/div[3]/div/div/div[2]/div")
	protected WebElement msgConfirmacao;
	public String msgEsperadaExclusao = "EXCLUSÃO REALIZADA COM SUCESSO!";

	@FindBy(id = "deleteNotification")
	protected WebElement botaoConfirmaExcluir;
}
