package com.bbc.weather.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {
	public static String takeScreenShot(WebDriver webdriver, String testName)
			throws Throwable {
		File srcfile = ((TakesScreenshot) webdriver)
				.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH-mm-ss-SS");
		String formattedDate = formatter.format(date);
		String fileName = testName + "_" + formattedDate;
		FileUtils.copyFile(
				srcfile,
				new File(System.getProperty("user.dir")
						+ System.getProperty("file.separator") + "ScreenShot"
						+ System.getProperty("file.separator") + fileName
						+ ".jpg"));
		return fileName;
	}

	public static String takeScreenShot(WebDriver webdriver, String testName,
			String file) throws Throwable {
		File srcfile = ((TakesScreenshot) webdriver)
				.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH-mm-ss-SS");
		String formattedDate = formatter.format(date);
		String fileName = testName + "_" + file + "_" + formattedDate;
		FileUtils.copyFile(
				srcfile,
				new File(System.getProperty("user.dir")
						+ System.getProperty("file.separator") + "ScreenShot"
						+ System.getProperty("file.separator") + fileName
						+ ".jpg"));
		return fileName;
	}

}
