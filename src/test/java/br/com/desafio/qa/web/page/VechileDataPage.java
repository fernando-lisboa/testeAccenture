package br.com.desafio.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.desafio.qa.web.support.PageObject;

public class VechileDataPage extends PageObject {
	

		public VechileDataPage(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}

		public String urlInicial = "http://sampleapp.tricentis.com/101/app.php";

		public String getUrlInicial() {
			return urlInicial;
		}

		@FindBy(id = "make")
		public WebElement selectMake;
		
		@FindBy(id = "model")
		public WebElement selectModel;
		
		@FindBy(id = "cylindercapacity")
		public WebElement fillFieldCylindercapacity;
		
		
		@FindBy(id = "engineperformance")
		public WebElement fillFieldEnginePerformance;
		
		@FindBy(id = "dateofmanufacture")
		public WebElement fillFieldDate;
		
		@FindBy(id = "righthanddriveyes")
		public WebElement fillFieldRightHandDrivers;
		
		@FindBy(id = "numberofseats")
		public WebElement selectNumberofseats;
		
		@FindBy(id = "numberofseatsmotorcycle")
		public WebElement fillFieldnumberofseatsmotorcycle;

		@FindBy(id = "fuel")
		public WebElement fillFieldFuelType;
		
		@FindBy(id = "payload")
		public WebElement fillFieldPayload;

		@FindBy(id = "totalweight")
		public WebElement fillFieldtotalweight;
		
		@FindBy(id = "listprice")
		public WebElement fillFieldListPrice;
		
		@FindBy(id = "licenseplatenumber")
		public WebElement fillFieldLicencePlateNunber;
		
		@FindBy(id = "annualmileage")
		public WebElement fillFieldAnnualMileage;
		
		@FindBy(id = "nextenterinsurantdata")
		public WebElement btnNext;
		
		
		
		


}
