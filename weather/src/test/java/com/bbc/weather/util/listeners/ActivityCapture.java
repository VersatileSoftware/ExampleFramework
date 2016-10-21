package com.bbc.weather.util.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

import com.bbc.weather.constants.StaticProperties;

public class ActivityCapture implements WebDriverEventListener {

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {

	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		Reporter.log("After click " + arg0.toString(), StaticProperties.printConsole);
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		Reporter.log("After FindBy " + arg0.toString(),StaticProperties.printConsole);
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		Reporter.log("After navigating back " + arg0.toString(),StaticProperties.printConsole);
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		Reporter.log("After navigating forword " + arg0.toString(),StaticProperties.printConsole);
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		Reporter.log("After navigating " + arg0.toString(),StaticProperties.printConsole);
		Reporter.log("After navigating " + arg1.toString(),StaticProperties.printConsole);
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {

	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {

	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		Reporter.log("before click " + arg0.toString(),StaticProperties.printConsole);
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		Reporter.log("before FindBY " + arg0.toString(),StaticProperties.printConsole);
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		Reporter.log("Before navigating back " + arg0.toString(),StaticProperties.printConsole);
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		Reporter.log("Before navigating Forword " + arg0.toString(),StaticProperties.printConsole);
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		Reporter.log("Before navigating " + arg0.toString(),StaticProperties.printConsole);
		Reporter.log("Before navigating " + arg1.toString(),StaticProperties.printConsole);
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {

	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		Reporter.log("Testcase done" + arg0.toString(),StaticProperties.printConsole);
		Reporter.log("Testcase done" + arg1.toString(),StaticProperties.printConsole);
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

}
