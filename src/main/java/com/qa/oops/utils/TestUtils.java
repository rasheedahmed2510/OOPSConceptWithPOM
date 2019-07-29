package com.qa.oops.utils;

import java.io.File;
import java.io.IOException;
import org.apache.maven.surefire.shade.common.org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.qa.oops.pages.BasePage;

public class TestUtils extends BasePage{
	
	public static int IMPLICIT_WAIT= 10;
	public static int PAGELOAD_TIMEOUT=15;

	public TestUtils(WebDriver driver) {
		super(driver);
	}

	//common methods
	public static void takeScreenShotOnFailure(WebDriver driver){
		TakesScreenshot scrShot= (TakesScreenshot)driver;
		File srcFile= scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./screenshot/.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
