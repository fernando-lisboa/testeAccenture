package br.com.desafio.qa.web.actions;

import org.openqa.selenium.WebDriver;

import br.com.desafio.qa.features.support.JavaScriptUtils;
import br.com.desafio.qa.web.page.SelectPricePage;

public class SelectPriceActions extends SelectPricePage {

	public SelectPriceActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	JavaScriptUtils javaS = new JavaScriptUtils(webdriver);
	
	public void fillFildSelectPriceOption(){
		
		try {
			PreencheValorCampoSetSelectButton(null, selectFieldGold, null, 40);
			waitForElementPageToBeClickable(btnNextsendquote);
			btnNextsendquote.click();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
