package com.qa.oops.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.oops.pages.HomePage;
import com.qa.oops.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends BaseTest{
	
	@Test(priority=1)
	public void verifyPageTitle(){
		String title= page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "HunSpot Login");
	}
	
	@Test(priority=2)
	public void verifyLoginPageHeaderTest(){
		WebElement loginPageHeader =page.getInstance(LoginPage.class).getLoginScreenHeader();
		String loginHeader= loginPageHeader.getText();
		Assert.assertEquals(loginHeader, "Don't have an account?");
	}
	
	@Test(priority=3)
	public void doLoginTest(){
		HomePage homePage= page.getInstance(LoginPage.class).doLogin(prop.getProperty("username"), prop.getProperty("password"));
		String headerHome= homePage.getHeader().getText();
		Assert.assertEquals(headerHome, "Great job Rasheed, your account is all set up.");
	}
	
}
