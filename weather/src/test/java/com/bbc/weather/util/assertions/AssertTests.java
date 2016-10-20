package com.bbc.weather.util.assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.bbc.weather.util.listeners.ErrorCollection;
import com.bbc.weather.util.ScreenShots;

public class AssertTests {
	
	protected String testName;
	protected WebDriver driver;
	
    public AssertTests(String testName, WebDriver driver) {
        this.testName = testName;
        this.driver=driver;
    }
	
	 public void assertError(String errorMessage) throws Throwable {
	        String errorMsg = "in test [" + testName + "] \nError message [" + errorMessage + "] \n";
	        Reporter.log("The error seen : " + errorMsg);
	        try {
	            Assert.assertTrue(false, errorMsg);
	        } catch (Throwable t) {
	            ErrorCollection.addVerificationFailure(t);
	        }
	    }
	 
	 public String takeScreenShot(String file) throws Throwable {
	        return ScreenShots.takeScreenShot(driver, testName, file);
	    }
	 
	 public void assertErrorWithScreenshot(String errorMessage, String screenName) throws Throwable {
	        String filename = takeScreenShot(screenName);
	        String errorMsg = "Test [" + testName + "] \n Error message [" + errorMessage + " ] \n Screenshot [" + filename
	                + ".jpg" + "] in [" + System.getProperty("user.dir") + System.getProperty("file.separator")
	                + "ScreenShot" + System.getProperty("file.separator") + "]\n";
	        assertError(errorMsg + errorMessage);
	    }
	 

//	 public void assertElementPresent(Object pageObject, WebElement webElement) throws Throwable {
//	        assertErrorWithScreenshot(pageObject.isElementPresent(webElement),
//	                "The WebElement is not present on page. " + element.getWebElementNameAndLocator(pageObject, webElement),
//	                "elementNotPresent");
//	    }
//	 
//	 public void assertElementVisible(WebElement webElement) throws Throwable {
//	        assertErrorWithScreenshot(element.isDisplayed(webElement), "The WebElement is not visible on page. " + "\n",
//	                "elementVisible");
//	    }

	 

	 

}
