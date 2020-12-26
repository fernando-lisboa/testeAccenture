package br.com.desafio.qa.features.support;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import io.github.bonigarcia.wdm.WebDriverManager;

@Configuration
@ContextConfiguration(classes = {PropertiesContext.class})
public class CucumberContext {

    @Autowired
    private String webbrowser;

    @Bean(name = "webdriver", destroyMethod = "close")
    public WebDriver getWebDriver() throws IOException {
        WebDriver webdriver = null;
        DesiredCapabilities capability;
        
        String targetLocation = Paths.get("target").toAbsolutePath().toString();
		String fileLocation = targetLocation + File.separator +"download" + File.separator;
		
		File directory = new File(fileLocation);
		
	    if (! directory.exists()){
	        directory.mkdir();
	    }else {
	    	FileUtils.cleanDirectory(directory); 
	    }
        
        switch (webbrowser) {
            case "firefox":
                capability = DesiredCapabilities.firefox();
                capability.setBrowserName("firefox");
                capability.setPlatform(Platform.LINUX);
                webdriver = new RemoteWebDriver(new URL("http://10.236.2.4:4444/wd/hub/"), capability);
                break;
            case "chrome":
                capability = DesiredCapabilities.chrome();
                capability.setBrowserName("chrome");
                capability.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                capability.setPlatform(Platform.LINUX);
                capability.setCapability("name", "Portal_EC");
                webdriver = new RemoteWebDriver(new URL("http://10.236.2.4:4444/wd/hub/"), capability);
                break;
            case "ie":
                capability = DesiredCapabilities.internetExplorer();
                capability.setBrowserName("Internet Explorer");
                capability.setPlatform(Platform.WIN10);
                webdriver = new RemoteWebDriver(new URL("http://10.236.2.4:4444/wd/hub/"), capability);
                break;
            case "safari-local":
                webdriver = new SafariDriver();
                break;
            case "chromedriver":
                capability = DesiredCapabilities.chrome();
                capability.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                capability.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                WebDriverManager.chromedriver().setup();
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("download.default_directory", fileLocation);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("test-type");
                options.addArguments("--start-maximized");
                options.addArguments("--disable-web-security");
                options.addArguments("--allow-running-insecure-content");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--ignore-urlfetcher-cert-requests");
                options.addArguments("incognito");

                webdriver = new ChromeDriver(options);
                webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;
            case "ghost_zalenium":
            	options = new ChromeOptions();
            	options.addArguments("--headless");
            	WebDriverManager.chromedriver().setup();
            	webdriver = new ChromeDriver(options);
            	break;
            	
            case "geckodriver":
                WebDriverManager.firefoxdriver().setup();
                webdriver = new FirefoxDriver();
                break;
            case "ghost":
                options = new ChromeOptions();
                options.addArguments("--headless");
                WebDriverManager.chromedriver().setup();
                webdriver = new ChromeDriver(options);
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                webdriver = new OperaDriver();
                break;
        }
        return webdriver;
    }

    @Bean("wait")
    public WebDriverWait getWebDriverWait() throws IOException {
        return new WebDriverWait(getWebDriver(), 5);
    }
}

