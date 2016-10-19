package com.bbc.weather.regressionTests;

import org.junit.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bbc.weather.constants.StaticProperties;
import com.bbc.weather.pageObjects.BbcHomePage;

public class BbcWeatherPageElementTests {
	
	BbcHomePage homePage;
	
	
	@BeforeClass
	public void testSetUp() throws Throwable{
		homePage=new BbcHomePage().navigateHomepage();
//		homePage.myBrowser.clickOnItemAndNavigateToPage(homePage.weatherTextLink);
	}
	
	@Test(timeOut=StaticProperties.ONE_MINUTE)
	public void verifyElements(){
		System.out.println("AM IN TEST");
	}
	
	@AfterClass
	public void close(){
		homePage.myBrowser.tearDown();
	}

}
