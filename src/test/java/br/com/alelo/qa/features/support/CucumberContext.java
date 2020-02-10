package br.com.alelo.qa.features.support;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
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

    @SuppressWarnings("deprecation")
    @Bean(name = "webdriver", destroyMethod = "close")
    public WebDriver getWebDriver() throws MalformedURLException {
        WebDriver webdriver = null;
        DesiredCapabilities capability;
        switch (webbrowser) {
            case "firefox":
                capability = DesiredCapabilities.firefox();
                capability.setBrowserName("firefox");
                capability.setPlatform(Platform.LINUX);
                webdriver = new RemoteWebDriver(new URL("https://zalenium-cicd-tools.sao.siteteste.inf.br/wd/hub/"), capability);
                break;
            case "chrome":
                capability = DesiredCapabilities.chrome();
                capability.setBrowserName("chrome");
                capability.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                capability.setPlatform(Platform.LINUX);
                webdriver = new RemoteWebDriver(new URL("https://zalenium-cicd-tools.sao.siteteste.inf.br/wd/hub/"), capability);
                break;
            case "ie":
                capability = DesiredCapabilities.internetExplorer();
                capability.setBrowserName("Internet Explorer");
                capability.setPlatform(Platform.WIN10);
                webdriver = new RemoteWebDriver(new URL("https://zalenium-cicd-tools.sao.siteteste.inf.br/wd/hub/"), capability);
                break;
            case "safari-local":
                webdriver = new SafariDriver();
                break;
            case "chromedriver":
                capability = DesiredCapabilities.chrome();
                capability.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                capability.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                WebDriverManager.chromedriver().setup();
                webdriver = new ChromeDriver();
                webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
                break;
            case "geckodriver":
                WebDriverManager.firefoxdriver().setup();
                webdriver = new FirefoxDriver();
                break;
            case "ghost":
                ChromeOptions options = new ChromeOptions();
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
    public WebDriverWait getWebDriverWait() throws MalformedURLException {
        return new WebDriverWait(getWebDriver(), 5);
    }

}

