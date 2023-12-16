package com.TutorialsNinja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement pageHeading;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public String retriveAccountSuccessPageHeading() {
		String accountsuccPageHeadText=pageHeading.getText();
		return accountsuccPageHeadText;
	}

}
