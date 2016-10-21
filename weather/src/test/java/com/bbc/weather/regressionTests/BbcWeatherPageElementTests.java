package com.bbc.weather.regressionTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bbc.weather.constants.StaticProperties;
import com.bbc.weather.core.AllSupportedBrowsers;
import com.bbc.weather.pageObjects.BbcHomePage;
import com.bbc.weather.pageObjects.BbcWeatherPage;

public class BbcWeatherPageElementTests {

	private WebDriver browser = AllSupportedBrowsers.getTheBrowser();
	BbcHomePage homePageLanding;
	BbcWeatherPage weatherLandingPage;

	@BeforeClass
	public void testSetUp() throws Throwable {
		homePageLanding = new BbcHomePage(browser).navigateHomepage();
		weatherLandingPage = homePageLanding.NavigateToWeatherPage();
	}

	@Test(timeOut = StaticProperties.ONE_MINUTE)
	public void verifyWeatherPageElements() {
		Assert.assertFalse(true);
	}

	@Test(timeOut = StaticProperties.ONE_MINUTE)
	public void verifyPresentWeatherDisplaySection() {

	}

	@Test(timeOut = StaticProperties.ONE_MINUTE)
	public void verifyPresentWeatherDisplay5days() {

	}

	@Test(timeOut = StaticProperties.ONE_MINUTE)
	public void verifyAddLocation() {

	}

	@Test(timeOut = StaticProperties.ONE_MINUTE)
	public void verifyForecast() {

	}

	@AfterClass
	public void close() {
		weatherLandingPage.tearDown();
	}

}
