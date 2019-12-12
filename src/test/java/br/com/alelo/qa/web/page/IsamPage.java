/**
 * 
 */
package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

/**
 * @author Fernando Lisboa
 *
 */
public class IsamPage extends PageObject {
	
	@FindBy(id = "imageLoader")
	protected WebElement loader;

	public IsamPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
