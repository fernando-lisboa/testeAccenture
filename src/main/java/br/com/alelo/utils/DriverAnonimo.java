package br.com.alelo.utils;


import org.openqa.selenium.WebDriver;


public class DriverAnonimo {
	
	private static WebDriver webdriverAnonimo;

	public static WebDriver getDriver() {
		return webdriverAnonimo;
	}

	public static void setDriver(WebDriver webdriverAnonimo) {
		DriverAnonimo.webdriverAnonimo = webdriverAnonimo;
	}

}
