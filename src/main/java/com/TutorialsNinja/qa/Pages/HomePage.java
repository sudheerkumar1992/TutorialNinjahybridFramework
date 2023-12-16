package com.TutorialsNinja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//Objects/Methods
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	WebElement RegisterOption;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
	}
	public void clickOnLogin() {
		loginOption.click();
	}
	public void clickOnRegister() {
		RegisterOption.click();
	}

}
