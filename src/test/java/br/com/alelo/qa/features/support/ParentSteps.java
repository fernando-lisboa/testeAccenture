package br.com.alelo.qa.features.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import br.com.alelo.utils.PropertiesFile;

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
	
	@Value("${baseurlAdm}")
	protected String baseurlAdm;
	
	@Value("${urlInicio}")
	protected String urlInicio;

	@Autowired
	protected boolean vsts;

	protected PropertiesFile props;

}
