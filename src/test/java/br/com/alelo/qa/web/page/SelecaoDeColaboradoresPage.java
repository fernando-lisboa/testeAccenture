package br.com.alelo.qa.web.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class SelecaoDeColaboradoresPage extends PageObject {
	
	@FindBy(xpath="//input[@id='idBtnImportar']")
	protected WebElement btnImportarPlanilha;
	
	@FindBy(xpath="//body/div[@class='modal modal-importar_colaboradores jqm-init ui-draggable modal-visible']/div[@class='modal-importar_colaboradores__conteudo']/div[@class='modal-content']/form[@id='importarColaboradoresForm']/div[contains(@class,'to-bind')]/div[@class='modal-conteudo-importar_colaboradores']/div/div[1]")
	protected WebElement mensagemDeNovoModeloDePlanilha;

	@FindBy(xpath="//input[@id='idSelectionAllHeaderPedido']")
	protected WebElement slcSelecionarTodos;
	
	@FindBy(xpath="//div[@class='tabs-botao']//input[@id='id_botao_avancar_pedidos']")
	protected WebElement btnProximaEtapa;
	
	@FindBy(xpath="//span[contains(text(),'Adicione ao menos 1 colaborador ao pedido.')]")
	protected WebElement msgErroSelecaoColaborador;
	
	@FindBy(xpath="//div[@class='modal modal-usuario modal-locais jqm-init ui-draggable modal-visible']//input[@class='botao botao--verde']")
	protected WebElement btnConfirmarLocalDeEntregaSim;
	
	@FindBy(xpath="//div[@class='modal modal-usuario modal-locais jqm-init ui-draggable modal-visible']//input[@class='botao botao--cinza close']")
	protected WebElement btnConfirmarLocalDeEntregaNao;
	
	@FindBy(id="dp1568657501009")
	protected WebElement cmpDataDoCredito;
	
	@FindBy(css="div.container.pedido:nth-child(12) div.tabs.pedido-sistema.tabsPedidos:nth-child(1) div.tabs-content-container:nth-child(4) div.tab-content.lista__item--ativo:nth-child(8) div.funcionarios-grid.corpo-form:nth-child(8) div.grid div.grid-unit-1-2:nth-child(1) p.subtitulo.subtitulo--verde:nth-child(1) > span:nth-child(1)")
	protected WebElement lblTotalColaboradoresSelecionados;
	
	@FindBy(xpath="//div[@class='crop-msg-padding']//div[@class='msg-validacao']//div//div[@class='alerta alerta--sucesso']")
	protected WebElement msgColaboradorCadastro;
	
	
	protected List<WebElement> tabelaColaboradores(){
		List<WebElement> tabela = webdriver.findElements(By.cssSelector("//div[@class='selectionAllHeaderPedidoNovoPedido']//label"));
		for	(WebElement dado : tabela){
			System.out.println(dado.getText());
		}
		return tabela;	
	}
	
	protected WebElement encontrarCampoValor(String xpath) {
		return webdriver.findElement(By.xpath(xpath));
	}

	
	public SelecaoDeColaboradoresPage(WebDriver driver) {
		super(driver);
	}
	

}
