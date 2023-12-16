package com.TutorialsNinja.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TurorialsNinja.Base.Base;
import com.TutorialsNinja.Utils.Utilities;
import com.TutorialsNinja.qa.Pages.AccountPage;
import com.TutorialsNinja.qa.Pages.HomePage;
import com.TutorialsNinja.qa.Pages.LoginPage;

public class LoginTest extends Base {
	public WebDriver driver;

	public LoginTest() throws IOException {
		super();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@BeforeMethod
	public void setUp() {
		driver = initialiseBrowerAndOpenURL();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.clickOnLogin();
	}

	@Test(priority = 1,dataProvider="ValidCredentialsSupplier")
	public void VerifyLoginWithValidCredentials(String email,String password) {
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterEmail(email);
		loginpage.enterPassword(password);
		loginpage.clickOnLoginButton();
		
		AccountPage accountPage=new AccountPage(driver);
		Assert.assertTrue(accountPage.getDisplayOfStatusOfEditYourAccount(),"Edit your account information not displayed");

	}
	
	@DataProvider(name="ValidCredentialsSupplier")
	public Object[][] supplyTestData() throws IOException {
		Object[][]data=Utilities.getTestDataFromExcel("Login");
		return data;
	}

	@Test(priority = 2)
	public void VerifyLoginWithInValidCredentials() {

		driver.findElement(By.id("input-email")).sendKeys("mygmaillll8@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"))
				.getText();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchingWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),
				"Expected Warning Message is not displayed");

	}

	@Test(priority = 3)
	public void VerifyLoginWithInValidEmailandValidPassword() {

		driver.findElement(By.id("input-email")).sendKeys("mygmaillll8@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"))
				.getText();
		String expectedWarningMessage = "No match for E-Mail Address and/or Password";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),
				"Expected Warning Message is not displayed");

	}

	@Test(priority = 4)
	public void VerifyLoginWithValidEmailandInvalidPassword() {

		driver.findElement(By.id("input-email")).sendKeys("mygmail8@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("1234445");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"))
				.getText();
		String expectedWarningMessage = "No match for E-Mail Address and/or Password";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),
				"Expected Warning Message is not displayed");

	}
}