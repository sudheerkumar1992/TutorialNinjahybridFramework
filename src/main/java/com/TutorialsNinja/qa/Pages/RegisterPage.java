package com.TutorialsNinja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	@FindBy(id="input-firstname")
	WebElement firstNameField;
	@FindBy(id="input-lastname")
	WebElement lastNameField;
	@FindBy(id="input-email")
	WebElement emailField;
	@FindBy(id="input-telephone")
	WebElement mobNoField;
	@FindBy(id="input-password")
	WebElement passwordField;
	@FindBy(id="input-confirm")
	WebElement confPasswordField;
	@FindBy(name="agree")
	WebElement privacyPolicyField;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueBtnField;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void enterFirstName(String firstNameTxt) {
		firstNameField.sendKeys(firstNameTxt);
	}
	public void enterLastName(String LastNameTxt) {
		lastNameField.sendKeys(LastNameTxt);
	}
	public void enterMobNo(String number) {
		mobNoField.sendKeys(number);
	}
	public void enteremail(String emailTxt) {
		emailField.sendKeys(emailTxt);
	}
	public void enterpassword(String passTxt) {
		passwordField.sendKeys(passTxt);
	}
	public void enterConPassword(String conPassTxt) {
		confPasswordField.sendKeys(conPassTxt);
	}
	public void clickPrivacyPolicy() {
		privacyPolicyField.click();
	}
	public void clickCntBtn() {
		continueBtnField.click();
	}

}
