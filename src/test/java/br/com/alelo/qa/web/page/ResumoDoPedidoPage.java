package br.com.alelo.qa.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class ResumoDoPedidoPage extends PageObject{
	
	@FindBy(xpath="//div[@class='crop-msg-padding']//div[@class='msg-validacao']//div//div[@class='alerta alerta--sucesso']")
	protected WebElement msgPedidoRealizadoComSucesso;
	
	@FindBy(xpath="//div[@class='tabs-botao']//input[@id='id_botao_avancar_pedidos']")
	protected WebElement btnFazerPedido;
	
	protected WebElement valorTotalDebeneficios(String valor){
		return webdriver.findElement(By.xpath("//p[contains(text(),'R$ "+valor+"')]"));
	}
	
	protected WebElement dataParaCredito(String data){
		return webdriver.findElement(By.xpath("//p[contains(text(),'"+data+"')]"));
	}

	public ResumoDoPedidoPage(WebDriver driver) {
		super(driver);
	}

}
