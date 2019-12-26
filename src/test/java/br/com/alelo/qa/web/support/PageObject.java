package br.com.alelo.qa.web.support;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		this.webdriver.manage().window().maximize();
		
	}
	
	public void validarUrlAtual(String url) {
		assertEquals(url, webdriver.getCurrentUrl());
	}
	
	public void waitForElementPageToLoad(WebElement element) {
		wait = new WebDriverWait(webdriver, maxTimeWaitLoadPage);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }
	
	public void waitForElementPageToBeClickable(WebElement element){
		wait = new WebDriverWait(webdriver, maxTimeWaitLoadPage);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		
	}
	
	public void waitforFormToBeLoad(List<WebElement> elements){
		wait = new WebDriverWait(webdriver, maxTimeWaitLoadPage);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public void arrastar(WebElement element, WebElement element2) {
		Actions action = new Actions(webdriver);
		try {
			action.dragAndDrop(element, element2);
			action.perform();
		} catch (Exception e) {
			String valorError = "Não é um elemento de arraste";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}
	
	

}