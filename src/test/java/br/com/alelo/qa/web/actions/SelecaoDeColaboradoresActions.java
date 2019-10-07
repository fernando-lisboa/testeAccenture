package br.com.alelo.qa.web.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.SelecaoDeColaboradoresPage;

public class SelecaoDeColaboradoresActions extends SelecaoDeColaboradoresPage {

	public void mensagemDeNovoModeloDePlanilhaExibida() {
		this.mensagemDeNovoModeloDePlanilha.isDisplayed();
	}

	public void clicoEmImportarPlanilha() {
		waitForElementPageToBeClickable(btnImportarPlanilha);
		this.btnImportarPlanilha.click();
	}
	
	public void colaboradorCadastradoComSucesso(){
		this.msgColaboradorCadastro.isDisplayed();
	}
	
	public void confirmarLocalDeEntrega(){
		this.btnConfirmarLocalDeEntregaSim.click();
	}
	
	public void alterarDataCredito(){
		Calendar data = Calendar.getInstance();
        data.setTime(new Date());
        data.add(Calendar.DAY_OF_MONTH, 7);
        String dataFormatada =  new SimpleDateFormat("ddMMyyyy").format(data.getTime());
        this.cmpDataDoCredito.clear();
        this.cmpDataDoCredito.click();
		this.cmpDataDoCredito.sendKeys(dataFormatada);
	}
	
	public void finalizarPedido(){
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//this.btnProximaEtapa.isDisplayed();
		this.btnProximaEtapa.isEnabled();
		this.btnProximaEtapa.click();
	}
	
	public void mensagemDeErroVisivel(){
		this.msgErroSelecaoColaborador.isDisplayed();
	}
	
	public void selecionarTodosOsColabores(){
		//waitForElementPageToLoad(slcSelecionarTodos);
		//waitForElementPageToBeClickable(slcSelecionarTodos);
		//webdriver.findElement(By.xpath("//div[@class='selectionAllHeaderPedidoNovoPedido']//label")).click();
		this.slcSelecionarTodos.click();
	}
	
	public void preencherValorASerDepositadoRefeicao(String valor){
		String value = this.lblTotalColaboradoresSelecionados.getText();
		Integer total = Integer.parseInt(value);
		for(int colab=1;colab<=total;colab++){
			//waitForElementPageToLoad(this.encontrarCampoValor("//input[@id='idValorPedido1_"+colab+"']"));
			this.encontrarCampoValor("//input[@id='idValorPedido1_"+colab+"']").clear();
			this.encontrarCampoValor("//input[@id='idValorPedido1_"+colab+"']").click();
			this.encontrarCampoValor("//input[@id='idValorPedido1_"+colab+"']").sendKeys(valor);
		}
	}
	
	public void preencherValorASerDepositadoAlimentacao(String valor){
		Integer total = Integer.parseInt(this.lblTotalColaboradoresSelecionados.getText());
		for(int colab=1;colab<=total;colab++){
			this.encontrarCampoValor("//input[@id='idValorPedido2_"+colab+"']").clear();
			this.encontrarCampoValor("//input[@id='idValorPedido2_"+colab+"']").click();
			this.encontrarCampoValor("//input[@id='idValorPedido2_"+colab+"']").sendKeys(valor);
		}
	}
	
	public void listaDeColaboradores(){
		tabelaColaboradores();
	}

	public SelecaoDeColaboradoresActions(WebDriver driver) {
		super(driver);
	}

}
