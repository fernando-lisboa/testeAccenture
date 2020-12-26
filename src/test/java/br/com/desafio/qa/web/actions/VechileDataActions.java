package br.com.desafio.qa.web.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import br.com.desafio.qa.features.support.JavaScriptUtils;
import br.com.desafio.qa.web.page.VechileDataPage;

public class VechileDataActions extends VechileDataPage {
	
	private VechileDataPage vechile;

	public VechileDataActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	JavaScriptUtils javaS = new JavaScriptUtils(webdriver);
	public void fillFieldVechile(){
		System.out.println("Preenchendo Formulário Vechile");
		vechile = new VechileDataPage(webdriver);
		waitForElementPageToBeClickable(selectMake);
		vechile.selectMake.click();
			try {
				
				Select selectVechile = new Select(selectMake);
				selectVechile.selectByVisibleText("Renault");
				selectVechile = new Select(selectModel);
				selectVechile.selectByVisibleText("Moped");
				fillFieldCylindercapacity.sendKeys("600");
				fillFieldEnginePerformance.sendKeys("10");
				javaS.JavaScriptAction(JavaScriptUtils.Funcao.setValue, null, "12/11/2020", fillFieldDate);
				fillFieldDate.sendKeys(Keys.ENTER);
				selectVechile = new Select(selectNumberofseats);
				selectVechile.selectByIndex(1);		
				PreencheValorCampoSetSelectButton(null, fillFieldRightHandDrivers, null, 40);
				selectVechile = new Select(fillFieldnumberofseatsmotorcycle);
				selectVechile.selectByIndex(2);
				selectVechile = new Select(fillFieldFuelType);
				selectVechile.selectByVisibleText("Petrol");
				fillFieldPayload.sendKeys("60");
				fillFieldtotalweight.sendKeys("1000");
				fillFieldListPrice.sendKeys("50000");
				fillFieldLicencePlateNunber.sendKeys("2");
				fillFieldAnnualMileage.sendKeys("10000");
				waitForElementPageToBeClickable(btnNext);
				btnNext.click();
				System.out.println("Formulário preenchido corretamente ");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	
		
}
