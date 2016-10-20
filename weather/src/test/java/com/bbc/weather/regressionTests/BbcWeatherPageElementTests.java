package com.bbc.weather.regressionTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bbc.weather.constants.StaticProperties;
import com.bbc.weather.core.AllSupportedBrowsers;
import com.bbc.weather.pageObjects.BbcHomePage;
import com.bbc.weather.pageObjects.BbcWeatherPage;

public class BbcWeatherPageElementTests {

	private WebDriver browser = AllSupportedBrowsers.getTheBrowser();
	BbcWeatherPage weatherLandingPage;

	@BeforeClass
	public void testSetUp() throws Throwable {
		weatherLandingPage = new BbcHomePage(browser).navigateHomepage()
				.NavigateToWeatherPage();
	}

	@Test(timeOut = StaticProperties.ONE_MINUTE)
	public void verifyElements() {
		System.out.println("AM IN TEST");
	}

	@AfterClass
	public void close() {
		weatherLandingPage.tearDown();
	}

}
