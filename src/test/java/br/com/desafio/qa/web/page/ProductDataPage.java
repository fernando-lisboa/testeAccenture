package br.com.desafio.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.desafio.qa.web.support.PageObject;

public class ProductDataPage extends PageObject {

	
		public ProductDataPage(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}


		@FindBy(id = "startdate")
		public WebElement fillFieldStartDate;
		
		@FindBy(id = "insurancesum")
		public WebElement fillFieldInsuranceSum;
		
		@FindBy(id = "meritrating")
		public WebElement fillFieldMeritrating;
		
		@FindBy(id = "damageinsurance")
		public WebElement fillFielddAmageinsurance;
		
		@FindBy(id = "EuroProtection")
		public WebElement fillFielddEuroProtection;
		
		@FindBy(id = "courtesycar")
		public WebElement fillFielddCourtesycar;
		
		@FindBy(id = "nextselectpriceoption")
		public WebElement btnNextselectpriceoption;
		
		@FindBy(id = "xLoaderPrice")
		public WebElement loaderProductData;
		
		
		
		
}
