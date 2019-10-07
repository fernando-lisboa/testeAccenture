package br.com.alelo.qa.web.support;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public class PageObject {
	
	protected WebDriver webdriver;
	
	@Autowired
	private int maxTimeWaitLoadPage = 300;
	
	private WebDriverWait wait;
	
	protected WebElement encontraElementoPorParteDoTexto(String partialText){
		return webdriver.findElement(By.xpath("//*[contains(text(),'"+partialText+"')]"));
	}
	
	protected WebElement encontraElementoPorParteDoId(String partialId){
		return webdriver.findElement(By.xpath("//*[contains(@id,'"+partialId+"')]"));
	}
	
	public PageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.webdriver = driver;
		this.webdriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	}
	
	public void waitForElementPageToLoad(WebElement element) {
		wait = new WebDriverWait(webdriver, maxTimeWaitLoadPage);
		
    }
	
	public void waitForElementPageToBeClickable(WebElement element){
		wait = new WebDriverWait(webdriver, maxTimeWaitLoadPage);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		
	}
	
	public void waitforFormToBeLoad(List<WebElement> elements){
		wait = new WebDriverWait(webdriver, maxTimeWaitLoadPage);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	

}