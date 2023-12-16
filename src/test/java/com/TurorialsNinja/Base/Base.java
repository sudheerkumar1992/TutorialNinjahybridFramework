package com.TurorialsNinja.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.TutorialsNinja.Utils.Utilities;

public class Base {
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public Base() throws IOException {
		prop=new Properties();
		File propFile=new File("F:\\EclipsData\\NewTesting\\inetBanking_V1\\src\\main\\java\\com\\TutorialsNinja\\qa\\config\\config.Properties");
		
		dataProp=new Properties();
		File dataPropFile =new File("F:\\EclipsData\\NewTesting\\inetBanking_V1\\src\\main\\java\\com\\TutorialsNinja\\TestData\\testData.properties");
		FileInputStream dataFis=new FileInputStream(dataPropFile);
		dataProp.load(dataFis);
		
		
		FileInputStream fis=new FileInputStream(propFile);
		prop.load(fis);
		
	}
	
	public WebDriver initialiseBrowerAndOpenURL() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\EclipsData\\NewTesting\\inetBanking_V1\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("F:\\ChromeDRIVERS\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.Implicit_Wait_Time));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.Page_Load_Wait_Time));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}

}
