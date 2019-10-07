package br.com.alelo.qa.web.actions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.ResumoDoPedidoPage;

public class ResumoDoPedidoActions extends ResumoDoPedidoPage {
	
	public void pedidoRealizadoComSucesso(){
		this.msgPedidoRealizadoComSucesso.isDisplayed();
	}
	
	public void valorPedidoConfere(String valor){
		this.valorTotalDebeneficios(valor).isDisplayed();
	}
	
	public void dataCreditoPedidoConfere(){
		Calendar data = Calendar.getInstance();
        data.setTime(new Date());
        data.add(Calendar.DAY_OF_MONTH, 7);
        String dataFormatada =  new SimpleDateFormat("ddMMyyyy").format(data.getTime());
		this.dataParaCredito(dataFormatada).isDisplayed();
	}
	
	public void realizarPedido(){
		this.btnFazerPedido.click();
	}

	public ResumoDoPedidoActions(WebDriver driver) {
		super(driver);
	}

}
