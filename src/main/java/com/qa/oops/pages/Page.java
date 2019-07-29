/**
 * 
 */
package com.qa.oops.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author inrahmed
 *
 */
public abstract class Page {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//create a constructor of abstract class
	public Page(WebDriver driver){
		this.driver= driver;
		this.wait =new WebDriverWait(this.driver, 15);
	}
	
	//define the abstract methods
	public abstract String getPageTitle();
	
	public abstract String getPageHeader(By locator);
	
	public abstract WebElement getElement(By locator);
	
	public abstract void waitForElementPresent(By locator);
	
	public abstract void waitForPageTitle(String title);
	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass){
		try{
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
