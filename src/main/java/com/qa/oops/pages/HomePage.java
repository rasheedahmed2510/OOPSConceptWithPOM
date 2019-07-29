package com.qa.oops.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
	
	//page locators
	private By header= By.xpath("//span[@data-key='getting-started-ui.completeHeading.heading']");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public WebElement getHeader() {
		return getElement(header);
	}

}
