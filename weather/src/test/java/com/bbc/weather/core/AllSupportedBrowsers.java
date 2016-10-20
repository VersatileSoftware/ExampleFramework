package com.bbc.weather.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.bbc.weather.constants.StaticProperties;

public class AllSupportedBrowsers {

	private static WebDriver driver;

	private static void newFirefoxBrowser() {
		driver = new FirefoxDriver();
	}

	private static void newChromeBrowser() {
		// TODO
		driver = new ChromeDriver();

	}

	public static WebDriver getTheBrowser() {
		switch (StaticProperties.browserType) {
		case "firefox":
			newFirefoxBrowser();
			break;
		case "chrome":
			newChromeBrowser();
		default:
			newFirefoxBrowser();
			break;
		}
		return driver;
	}
}
