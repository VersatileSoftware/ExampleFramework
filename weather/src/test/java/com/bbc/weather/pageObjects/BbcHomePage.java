package com.bbc.weather.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BbcHomePage extends BbcBasePageWithHeader{
	
	@FindBy(className="orb-nav-weather")
	public WebElement weatherTextLink;

	public BbcHomePage() {
		PageFactory.initElements(myBrowser.browser, this);
	}
	
}
