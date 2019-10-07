package br.com.alelo.qa.web.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.alelo.qa.web.page.CobrancasPage;

public class CobrancaActions extends CobrancasPage {

	public CobrancaActions(WebDriver driver) {
		super(driver);
	}

	public void clicarEmBuscar() {
		btnBuscar.click();
	}

	public void preencherFilial(String filial) {
		cFilial.click();
		cFilial.sendKeys(filial);
	}

	public void preencherPedido(String pedido) {
		cPedido.click();
		cPedido.sendKeys(pedido);
	}

	public void preencherMesEmissao(String mesEmissao) {
		cMesEmissao.click();
		cMesEmissao.sendKeys(mesEmissao);
	}

	public void preencherMesPagamento(String mesPagamento) {
		cMesPagamento.click();
		cMesPagamento.sendKeys(mesPagamento);
	}
	
	public void descerPagina(){
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void voltarAoTopo() {
			btnVoltarAoTopo.click();
	}
	
	public void selecionarProdutoContrato(String contrato){
		////select[@class='select fixSelectOverflow']
		Select selectProdutoContrato = new Select(webdriver.findElement(By.xpath("//select[@class='select fixSelectOverflow']")));
		selectProdutoContrato.selectByVisibleText(contrato);
		
	}
	
	public void validaColunaProdutoContrato(String contrato){
		int line = 0;

		while (webdriver.findElement(By.xpath("//body//div[@class='kgCanvas']//div//div["+line+"]//div[1]//div[2]")) != null) {
			System.out.println(webdriver.findElement(By.xpath("//body//div[@class='kgCanvas']//div//div["+line+"]//div[1]//div[2]")).getText());
		}

	}

}
