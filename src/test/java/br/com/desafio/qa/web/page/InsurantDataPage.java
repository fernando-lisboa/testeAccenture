package br.com.desafio.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.desafio.qa.web.support.PageObject;

public class InsurantDataPage  extends PageObject {
	
	
		public InsurantDataPage(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}


		@FindBy(id = "firstname")
		public WebElement fillFieldFirstName;
		
		@FindBy(id = "lastname")
		public WebElement fillFieldlastname;
		
		@FindBy(id = "birthdate")
		public WebElement dateOfBirthCalender;
		
		@FindBy(id = "gendermale")
		public WebElement selectGender;
		
		@FindBy(id = "streetaddress")
		public WebElement fillFieldStreetAddress;
		
		@FindBy(id = "country")
		public WebElement selectCountry;
		
		@FindBy(id = "zipcode")
		public WebElement fillFieldFZipCode;
		
		@FindBy(id = "city")
		public WebElement fillFieldCity;
		
		@FindBy(id = "occupation")
		public WebElement selectOccupation;
		
		
		@FindBy(id = "speeding")
		public WebElement selectHobbies;
		
		@FindBy(id = "other")
		public WebElement fillFieldOther; // preenche a order do combo Hobbies
		
		@FindBy(id = "website")
		public WebElement fillFieldWebsite;
		
		@FindBy(id = "picture")
		public WebElement fillFieldPicture;
		
		@FindBy(id = "nextenterproductdata")
		public WebElement btnNextProductData;
		
		

}
