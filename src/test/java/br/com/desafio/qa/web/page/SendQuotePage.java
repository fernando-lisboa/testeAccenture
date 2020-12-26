package br.com.desafio.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.desafio.qa.web.support.PageObject;

public class SendQuotePage extends PageObject {
	
	public SendQuotePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(id = "email")
	public WebElement fillFieldEmail;
	
	@FindBy(id = "phone")
	public WebElement fillFieldPhone;
	
	@FindBy(id = "username")
	public WebElement fillFieldusername;
	
	@FindBy(id = "password")
	public WebElement fillFieldPassord;
	
	@FindBy(id = "confirmpassword")
	public WebElement fillFieldConfirmpassword;
	
	@FindBy(id = "Comments")
	public WebElement fillFieldComments;

	
	@FindBy(id = "sendemail")
	public WebElement btnSendEmail;

	@FindBy(xpath = "/html/body/div[4]/div[7]/div/button")
	public WebElement btnConfirm;
	
	@FindBy(xpath = "/html/body/div[4]/h2")
	public WebElement validationMassagen;
	public String mensagemEsperada = "Sending e-mail success!";

}
