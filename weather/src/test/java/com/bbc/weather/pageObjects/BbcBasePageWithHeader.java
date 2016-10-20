package com.bbc.weather.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bbc.weather.constants.StaticProperties;
import com.bbc.weather.core.Page;
import com.bbc.weather.pageComponents.BbcHeaderElements;

public abstract class BbcBasePageWithHeader extends Page {

	public BbcHeaderElements headerElements;

	public BbcBasePageWithHeader(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		headerElements = new BbcHeaderElements(driver);
	}

	public BbcHomePage navigateHomepage() throws Throwable {
		navigateToPage(StaticProperties.HOMEPAGE_URL);
		return new BbcHomePage(driver);
	}

}
