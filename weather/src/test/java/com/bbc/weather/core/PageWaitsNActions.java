package com.bbc.weather.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bbc.weather.constants.StaticProperties;

public class PageWaitsNActions {

	private WebDriver browser;

	public PageWaitsNActions(WebDriver browser) {
		this.browser = browser;
	}

	/*
	 * 
	 * EXPLICIT WAITS
	 */

	public void waitForElementVisibility(WebElement webElement) {
		new WebDriverWait(browser, StaticProperties.TEN_SECONDS,
				StaticProperties.ONE_HUNDRED_MILI).until(ExpectedConditions
				.visibilityOf(webElement));
	}

	public void waitForElementEnabled(WebElement webElement) {
		new WebDriverWait(browser, StaticProperties.TEN_SECONDS,
				StaticProperties.ONE_HUNDRED_MILI).until(ExpectedConditions
				.elementToBeClickable(webElement));
	}

	public void waitForElementDisappear(By locator) {
		new WebDriverWait(browser, StaticProperties.TEN_SECONDS,
				StaticProperties.ONE_HUNDRED_MILI).until(ExpectedConditions
				.invisibilityOfElementLocated(locator));
	}

	/*
	 * DROPDOWN ACTIONS
	 */
	public void selectByValue(WebElement dropDown, String value) {
		Select select = new Select(dropDown);
		select.selectByValue(value);
	}

	public void selectByFullText(WebElement dropDown, String text) {
		Select select = new Select(dropDown);
		select.selectByVisibleText(text);
	}

	/*
	 * 
	 * Mouse over an element
	 */

	public void moveMouseOver(WebElement webElement) {
		waitForElementVisibility(webElement);
		new Actions(browser).moveToElement(webElement).perform();
	}

	/*
	 * Click on element
	 */

	public void clickOnItem(WebElement webElement) {
		waitForElementVisibility(webElement);
		moveMouseOver(webElement);
		webElement.click();
	}

	public void setCheckBoxOrRadioButton(WebElement webElement) {
		clickOnItem(webElement);
	}

	public void clearInputField(WebElement webElement) {
		waitForElementVisibility(webElement);
		webElement.clear();
	}

	public void enterTextInInput(WebElement webElement, String inputText) {
		clearInputField(webElement);
		webElement.sendKeys(inputText);
	}

	public String getElementText(WebElement webElement) {
		waitForElementVisibility(webElement);
		return webElement.getText();
	}

}
