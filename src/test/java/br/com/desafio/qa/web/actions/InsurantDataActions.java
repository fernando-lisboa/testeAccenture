package br.com.desafio.qa.web.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import br.com.desafio.qa.features.support.JavaScriptUtils;
import br.com.desafio.qa.web.page.InsurantDataPage;

public class InsurantDataActions extends InsurantDataPage {

	public InsurantDataActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void fillFieldInsurantData() {
		JavaScriptUtils javaS = new JavaScriptUtils(webdriver);
		String usingSystemProperty = System.getProperty("user.dir");
		try {

			fillFieldFirstName.sendKeys("TesteDesafio");
			fillFieldlastname.sendKeys("Accenture");
			javaS.JavaScriptAction(JavaScriptUtils.Funcao.setValue, null, "11/12/1990", dateOfBirthCalender);
			dateOfBirthCalender.sendKeys(Keys.ENTER);
			PreencheValorCampoSetSelectButton(null, selectGender, null, 40);
			fillFieldStreetAddress.sendKeys("RUA DO TESOURO");
			Select selectInsurant = new Select(selectCountry);
			selectInsurant.selectByVisibleText("Brazil");
			fillFieldFZipCode.sendKeys("06414007");
			fillFieldCity.sendKeys("Barueri");
			selectInsurant = new Select(selectOccupation);
			selectInsurant.selectByVisibleText("Employee");
			PreencheValorCampoSetSelectButton(null, selectHobbies, null, 40);
			fillFieldWebsite.sendKeys("www.testedesafio.com.br");
			//fillFieldPicture.sendKeys(usingSystemProperty + "\\src\\test\\resources\\armazenador\\foto.PNG");
			btnNextProductData.click();
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
