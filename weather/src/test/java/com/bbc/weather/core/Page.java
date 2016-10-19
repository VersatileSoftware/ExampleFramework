package com.bbc.weather.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.bbc.weather.constants.StaticProperties;


public class Page {
	
	public WebDriver browser;
	public PageWaitsNActions pageActionsAndWaits;
	
	public Page() {
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
		pageActionsAndWaits=new PageWaitsNActions(browser);
		setBrowserStaticProperties();
	}
	
	private void newFirefoxBrowser() {
		browser=new FirefoxDriver();
	}

	private void newChromeBrowser() {
		// TODO
		browser = new ChromeDriver();
		
	}
	
	private void setBrowserStaticProperties(){
		browser.manage().window().maximize();
		browser.manage().timeouts().pageLoadTimeout(StaticProperties.ONE_MINUTE, TimeUnit.SECONDS);
		browser.manage().timeouts().implicitlyWait(StaticProperties.TEN_SECONDS, TimeUnit.SECONDS);
	}
	
	/*
	 * Look for an element after a wait
	 * Element present
	 * Element displayed
	 * 
	 * 
	 * 
	 */	
	public boolean isElementPresent(WebElement webElement) {
		try {
			webElement.getText();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isElementPresent(By elementLocator) {
		try {
			browser.findElement(elementLocator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isElementVisible(WebElement webElement) {
		if (isElementPresent(webElement)) {
			return isDisplayed(webElement);
		} else {
			return false;
		}
	}

	public boolean isDisplayed(WebElement webElement) {
		return webElement.isDisplayed();
	}

	public boolean isEnabled(WebElement webElement) {
		return webElement.isEnabled();
	}
	
	public boolean isChecked(WebElement webElement) {
		return webElement.isSelected();
	}
	
	/*
	 * NAVIGATION
	 * 
	 */

	 public void clickOnItemAndNavigateToPage(WebElement webElement) {
	        pageActionsAndWaits.clickOnItem(webElement);
	 }
	 
	 public void navigateToPage(String pageUrl){
		 browser.navigate().to(pageUrl); 
	 }
	 
	 public void pageRefresh() {
	        browser.navigate().refresh();
	    }

	 public void tearDown() {
			try {
				browser.close();
				browser.quit();
			} catch (Exception e) {
				// the browser had already closed or was not instantiated
			}
		}
}
