package com.TutorialsNinja.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TurorialsNinja.Base.Base;
import com.TutorialsNinja.Utils.Utilities;
import com.TutorialsNinja.qa.Pages.AccountSuccessPage;
import com.TutorialsNinja.qa.Pages.HomePage;
import com.TutorialsNinja.qa.Pages.RegisterPage;

public class RegisterTest extends Base{
	public RegisterTest() throws IOException {
		super();
	}
	public WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver=initialiseBrowerAndOpenURL();
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.clickOnRegister();
		
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void VerifyRegisterAccountProvidingOnlyMandatoryFields() {
		RegisterPage registerPage=new RegisterPage(driver);
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enteremail(Utilities.generateEmailWithTimeStamp());
		registerPage.enterMobNo(dataProp.getProperty("telephoneNumber"));
		registerPage.enterpassword("698547");
		registerPage.enterConPassword("698547");
		registerPage.clickPrivacyPolicy();
		registerPage.clickCntBtn();
		AccountSuccessPage accountsuccesspage=new AccountSuccessPage(driver);
	
		String ActualSuccessHeading =accountsuccesspage.retriveAccountSuccessPageHeading();
		Assert.assertEquals(ActualSuccessHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"), "AccountPage Not Created");

	}

	@Test(priority = 2)
	public void VerifyRegisteringAccountByProvidingAllFileds() {

		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys("698547");
		driver.findElement(By.id("input-confirm")).sendKeys("698547");
		driver.findElement(By.name("newsletter")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String ActualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(ActualSuccessHeading,dataProp.getProperty("accountSuccessfullyCreatedHeading", ActualSuccessHeading), "AccountPage Not Created");

	}

	@Test(priority = 3,dependsOnMethods={"VerifyRegisteringAccountByProvidingAllFileds"})
	public void VerifyRegistringAccountByProvidingExistingEmailId() {

		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys("mygmail8@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys("698547");
		driver.findElement(By.id("input-confirm")).sendKeys("698547");
		driver.findElement(By.name("newsletter")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String AcctualMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(AcctualMessage.contains(dataProp.getProperty("duplicateEmailWarning")),
				"Warning Message is not displayed");

	}

	@Test(priority = 4)
	public void VerifyRegisteringAccountWithOutFillingAnyDetails() {

		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String ActualPrivacyPolicyWarning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"))
				.getText();
		Assert.assertTrue(ActualPrivacyPolicyWarning.contains(dataProp.getProperty("privacyPolicyWarning")),
				"Policy Warning Message is not displayed");

		String ActualFirstNameWarning = driver
				.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
		Assert.assertTrue(ActualFirstNameWarning.contains(dataProp.getProperty("firstNameWarning")),
				"First Name Warning Message is not displayed");

		String ActualLastNameWarning = driver
				.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
		Assert.assertTrue(ActualLastNameWarning.contains(dataProp.getProperty("lastNameWarning")),
				"Last Name Warning Message is not displayed");

		String ActualEmailWarnning = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div"))
				.getText();
		Assert.assertTrue(ActualEmailWarnning.contains(dataProp.getProperty("emailWarning")),
				"Email Warning message is not displayed");

		String ActualTelephoneWarning = driver
				.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
		Assert.assertTrue(ActualTelephoneWarning.contains(dataProp.getProperty("telephoneWarning")),
				"Telephone Warning message is not dispaled");

		String ActualPasswordWarning = driver
				.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		Assert.assertTrue(ActualPasswordWarning.contains(dataProp.getProperty("passwordWarning")),
				"Password Warning Message is not dispalyed");

	}

}
