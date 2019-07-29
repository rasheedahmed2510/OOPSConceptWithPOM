package com.qa.oops.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.oops.pages.BasePage;
import com.qa.oops.pages.Page;
import com.qa.oops.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	WebDriver driver;
	public Page page;
	public Properties prop;
	
	public BaseTest(){
		try {
			prop= new Properties();
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/oops/properties/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			//Exception when file not found
			e.printStackTrace();
		} catch (IOException e) {
			// IO Exception when not able to load the properties file
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	@Parameters(value={"browser"})
	public void setUp(String browser){
		if(browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}else if(browser.equals("FF")){
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}else{
			System.out.println("No browser is defined in the xml file...");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		page= new BasePage(driver);  //To assign the webdriver to all the pages
	}
	
	@AfterMethod
	public void tearDown(ITestResult res){
		if(res.getStatus()==2){
			TestUtils.takeScreenShotOnFailure(driver);
		}
		driver.quit();
	}
	
}
