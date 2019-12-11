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
public class CriacaoDeMensagensPage extends PageObject{
	
	@FindBy(xpath = "/html/body/div[2]/nav[1]/div/div/ul/li[2]/a")
	protected WebElement mensagens_link;
	
	@FindBy(id = "btnAdicionarOferta")
	protected WebElement btn_adicionar_mensagem;
	
	@FindBy(id = "btnBeginDate")
	protected WebElement data_inicial;
	
	@FindBy(id = "btnEndDate")
	protected WebElement credenciadora_dois;
	
	@FindBy(id = "vanCheckLabel2")
	protected WebElement data_final;
	
	@FindBy(id = "beginDate")
	protected WebElement data_inicial_de_vigencia;
	
	@FindBy(id = "notificationType")
	protected WebElement tipo_de_envio;
	
	@FindBy(id = "notificationDefaultMessage")
	protected WebElement tipo_da_mensagem;
	
	@FindBy(id = "notificationName")
	protected WebElement nome_da_mensagem;
	
	@FindBy(id = "btnCalendarFilter")
	protected WebElement btn_filtrar;
	
	@FindBy(id = "endDate")
	protected WebElement status_message;
	
	@FindBy(id = "notificationName")
	protected WebElement data_final_de_vigencia;
	
	@FindBy(id = "/html/body/div[7]/div[3]/table")
	protected WebElement data_final_de_vigencia_conteudo;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/table")
	protected WebElement data_inicial_de_vigencia_conteudo;
	
	@FindBy(xpath = "/html/body/div[4]/div[3]/div/div/div[2]/div/h1[2]")
	protected WebElement mensagem_confirmacao;
	
	@FindBy(id = "btnInsert")
	protected WebElement btn_salvar_mensagem;
	
	@FindBy(id = "notificationMessage")
	protected WebElement descricao_da_mensagem;
	
	@FindBy(id = "notificationSubject")
	protected WebElement assunto_da_mensagem;
		
	@FindBy(id = "btnGrayLight")
	protected WebElement btn_cancelar;	
		

	public CriacaoDeMensagensPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
