package br.com.alelo.utils;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverAnonimous {

	public static WebDriver getDriverAnonimo() {
		DesiredCapabilities capability;
		capability = DesiredCapabilities.chrome();
		capability.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		capability.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("test-type");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-web-security");
		options.addArguments("--allow-running-insecure-content");
		options.addArguments("--ignore-certificate-errors");
		// options.addArguments("--ignore-urlfetcher-cert-requests");
		options.addArguments("incognito");
		ChromeDriver driver_Anonimo = new ChromeDriver(options);

		return driver_Anonimo;
	}

}
