package br.com.alelo.qa.web.actions;

import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.LoginNaCentralPage;

public class LoginArvNaCentralActions extends LoginNaCentralPage {
	
	 public void LoginArvNaCentral(String userARV, String passwordARV) throws Throwable {
         
         waitForElementPageToBeClickable(inputLogin);
         inputLogin.sendKeys(userARV);
         inputPassord.sendKeys(passwordARV);
         waitForElementPageToBeClickable(btnLogar);
         btnLogar.click();
         waitForElementToBeInvisible(loader);

     }

	public LoginArvNaCentralActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
