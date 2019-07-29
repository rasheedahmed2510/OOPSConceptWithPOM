/**
 * 
 */
package com.qa.oops.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author inrahmed
 *
 */
public class LoginPage extends BasePage {
	
	//define the object repositories/ locators. Instead of @FindBy we are using By class as they are light weight
	private By emailAddress= By.id("username");
	private By password= By.id("password");
	private By loginBtn= By.id("loginBtn");
	private By loginScreenHeader = By.xpath("//i18n-string[@data-key='login.signupLink.text']");
	
	//Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//Define the getters - access private vars via public methods
	
	public WebElement getEmailAddress() {
		return getElement(emailAddress);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}

	public WebElement getLoginScreenHeader() {
		return getElement(loginScreenHeader);
	}
	
	public String getLoginPageTitle(){
		return getPageTitle();
	}
	
	public void getPageHeader(){
		getPageHeader(loginScreenHeader);
	}
	
	//method overloading example
	public HomePage doLogin(String username, String password){
		getEmailAddress().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginBtn().click();
		return getInstance(HomePage.class);
	}
	
	//method overloading example
	public void doLogin(){
		getEmailAddress().sendKeys("");
		getPassword().sendKeys("");
		getLoginBtn().click();
	}
	
}
