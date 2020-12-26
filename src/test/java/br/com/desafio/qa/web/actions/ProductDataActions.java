package br.com.desafio.qa.web.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.Select;

import br.com.desafio.qa.features.support.JavaScriptUtils;
import br.com.desafio.qa.web.page.ProductDataPage;

public class ProductDataActions extends ProductDataPage {

	public ProductDataActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void fullFieldProductData() {

		try {
			JavaScriptUtils javaS = new JavaScriptUtils(webdriver);
			javaS.JavaScriptAction(JavaScriptUtils.Funcao.setValue, null, "02/02/2021", fillFieldStartDate);
			fillFieldStartDate.sendKeys(Keys.ENTER);
			Select selectVechile = new Select(fillFieldInsuranceSum);
			selectVechile.selectByIndex(4);
			selectVechile = new Select(fillFieldMeritrating);
			selectVechile.selectByIndex(3);
			selectVechile = new Select(fillFielddAmageinsurance);
			selectVechile.selectByIndex(2);
			PreencheValorCampoSetSelectButton(null, fillFielddEuroProtection, null, 40);
			selectVechile = new Select(fillFielddCourtesycar);
			selectVechile.selectByIndex(2);
			btnNextselectpriceoption.click();
			waitForElementToBeInvisible(loaderProductData);
			System.out.println("Product Data Preenchido completamente");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("não foi possível preencher os campos de product data  "+e.toString());
		}

	}

}
