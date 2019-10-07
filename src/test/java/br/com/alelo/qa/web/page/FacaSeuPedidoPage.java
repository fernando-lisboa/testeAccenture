package br.com.alelo.qa.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class FacaSeuPedidoPage extends PageObject{
	
	
	@FindBy(xpath="//div[@class='corpo-form componenteFormaPedido']//div[1]//label[1]//div[1]//div[1]//div[2]//img[1]")
	protected WebElement btnNovoPedido;
	
	@FindBy(xpath="//div[2]//label[1]//div[1]//div[1]//div[2]")
	protected WebElement btnCopiarUmPedidoRecente;
	
	@FindBy(xpath="//body/div/div[@class='container pedido']/div[@id='tabsPedido']/div[@class='tabs-content-container']/div[@class='tab-content lista__item--ativo']/div/div[@class='corpo-form componenteFormaPedido']/div[3]/label[1]/div[1]/div[1]/div[2]/div[1]")
	protected WebElement btnCopiarUmPedidoSalvoENaoEnviado;
	
	@FindBy(xpath="//div[@class='tabs-botao']//input[@id='id_botao_avancar_pedidos']")
	protected WebElement btnProximaEtapa;
	
	@FindBy(xpath="//div[contains(text(),'Nº Contrato 12014519')]")
	protected WebElement btnRefeicao;

	@FindBy(xpath="//div[contains(text(),'Nº Contrato 12014719')]")
	protected WebElement btnAlimentacao;
	
	@FindBy(xpath="//select[@id='combo-pedidos-rascunho']")
	protected WebElement slcPedidosRecentes;
	

	
	public FacaSeuPedidoPage(WebDriver driver) {
		super(driver);
	}
	
	

}
