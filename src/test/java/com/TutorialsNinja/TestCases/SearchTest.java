package com.TutorialsNinja.TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TurorialsNinja.Base.Base;

public class SearchTest extends Base {
	
	public SearchTest() throws IOException {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver=initialiseBrowerAndOpenURL();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void VerifySearchWithValidProduct() {
		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validProduct"));
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}
	
	@Test(priority=2)
	public void VerifySearchWithInValidProduct() {
		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("invalidProduct"));
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		String ActualMessage=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		Assert.assertEquals(ActualMessage,dataProp.getProperty("invalidProductMessage"),"No Productmessage displyed");
	}
	@Test(priority=3)
	public void VerifySearchWithOutAnyProduct() {
		driver.findElement(By.name("search")).sendKeys("");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		String ActualMessage=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		Assert.assertEquals(ActualMessage,dataProp.getProperty("withOutAnyProdMessage"),"No Productmessage displyed");
	}
}
