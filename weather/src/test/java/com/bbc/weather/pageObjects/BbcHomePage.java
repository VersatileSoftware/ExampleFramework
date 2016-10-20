package com.bbc.weather.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BbcHomePage extends BbcBasePageWithHeader {
	

	public BbcHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public BbcWeatherPage NavigateToWeatherPage() {
		clickOnItemAndNavigateToPage(headerElements.weatehrTextLink);
		return new BbcWeatherPage(driver);
	}
}
