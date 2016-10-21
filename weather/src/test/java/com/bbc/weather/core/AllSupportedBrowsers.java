package com.bbc.weather.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.bbc.weather.constants.StaticProperties;
import com.bbc.weather.util.listeners.ActivityCapture;

public class AllSupportedBrowsers {

	private static WebDriver baseDriver;
	private static EventFiringWebDriver driver;

	private static void newFirefoxBrowser() {
		baseDriver = new FirefoxDriver();
	}

	private static void newChromeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")
						+ "/test-classes/chromeDriverExe/chromedriver.exe");
		baseDriver = new ChromeDriver();

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
		driver = new EventFiringWebDriver(baseDriver);
		ActivityCapture handle = new ActivityCapture();
		driver.register(handle);
		return driver;
	}
}
