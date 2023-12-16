package com.TutorialsNinja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	//Objects/methods
	@FindBy(id="input-email")
	WebElement emailEnter;
	
	@FindBy(id="input-password")
	WebElement passwordEnter;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement clickLogin;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	public void enterEmail(String emailText) {
		emailEnter.sendKeys(emailText);
	}
	public void enterPassword(String passwordText) {
		passwordEnter.sendKeys(passwordText);
	}
	public void clickOnLoginButton() {
		clickLogin.click();
	}
	
}
