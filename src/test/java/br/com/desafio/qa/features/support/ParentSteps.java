package br.com.desafio.qa.features.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import br.com.desafio.utils.DriverAnonimo;
import br.com.desafio.utils.PropertiesFile;
import cucumber.api.java.After;

@ContextConfiguration(classes = { CucumberContext.class, PropertiesContext.class })
public class ParentSteps {

	@Autowired
	protected WebDriver webdriver;

	@Autowired
	protected WebDriverWait wait;

	@Autowired
	protected boolean screenshotOnFailure;

	@Autowired
	protected String screenshotDestinationFolder;

	@Autowired
	protected String baseurl;

	
	@Value("${urlInicio}")
	protected String urlInicio;

	@Autowired
	protected boolean vsts;
	
	@Autowired
	protected boolean help;

	protected PropertiesFile props;

	@After
	private void killDriverProcess() {
		webdriver.quit();
		DriverAnonimo.getDriver().quit();
	}

}
