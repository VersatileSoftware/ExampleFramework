package com.bbc.weather.pageComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BbcHeaderElements {

	@FindBy(id = "orb-header")
	public WebElement headerSetion;

	@FindBy(id = "orb-nav-weather")
	public WebElement weatehrTextLink;

	@FindBy(id = "orb-search-q")
	public WebElement searchInputBox;

	@FindBy(id = "orb-search-button")
	public WebElement searchButton;

	@FindBy(xpath = "//*[@id='orb-nav-links']/ul/li/a")
	public List<WebElement> allHeaderTextLinks;

	public BbcHeaderElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
