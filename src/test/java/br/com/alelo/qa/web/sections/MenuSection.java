package br.com.alelo.qa.web.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class MenuSection extends PageObject{

	//Menu Financeiro
	@FindBy(xpath="//a[contains(text(),'Financeiro')]")
	protected WebElement menuFinanceiro;
	
	@FindBy(xpath="//a[contains(text(),'Cobrança')]")
	protected WebElement menuFinanceiroCobranca;
	
	@FindBy(xpath="//a[contains(text(),'RPS e Demonstrativos Fiscais')]")
	protected WebElement menuFinanceiroRpsEDemonstrativosFiscais;
	
	@FindBy(xpath="//a[contains(text(),'Informe de Rendimentos')]")
	protected WebElement menuFinanceiroInformeDeRedimentos;

	@FindBy(xpath="//a[contains(text(),'Pedido de benefícios')]")
	protected WebElement menuPedidoDeBeneficios;
	
	@FindBy(xpath="//a[contains(text(),'Faça seu pedido')]")
	protected WebElement menuPedidoDeBeneficiosFacaSeuPedido;
	
	public MenuSection(WebDriver driver) {
		super(driver);
	}

}
