package com.bbc.weather.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.bbc.weather.constants.StaticProperties;

public class Page {

	public PageWaitsNActions pageActionsAndWaits;
	protected WebDriver driver;

	public Page(WebDriver browser) {
		pageActionsAndWaits = new PageWaitsNActions(browser);
		driver = browser;
		setBrowserStaticProperties();
	}

	private void setBrowserStaticProperties() {
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.pageLoadTimeout(StaticProperties.ONE_MINUTE, TimeUnit.SECONDS);
		driver.manage().timeouts()
				.implicitlyWait(StaticProperties.TEN_SECONDS, TimeUnit.SECONDS);
	}

	/*
	 * Look for an element after a wait Element present Element displayed
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
			driver.findElement(elementLocator);
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
	 */

	public void clickOnItemAndNavigateToPage(WebElement webElement) {
		pageActionsAndWaits.clickOnItem(webElement);
	}

	public void navigateToPage(String pageUrl) {
		driver.navigate().to(pageUrl);
	}

	public void pageRefresh() {
		driver.navigate().refresh();
	}

	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
