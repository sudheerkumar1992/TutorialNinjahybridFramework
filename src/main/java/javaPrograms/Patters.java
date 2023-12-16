package javaPrograms;

import org.apache.commons.exec.OS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Patters {

	public static void main(String[] args) {
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "F:\\EclipsData\\NewTesting\\inetBanking_V1\\Drivers\\chromedriver.exe");
		 * ChromeOptions options=new ChromeOptions();
		 * options.setBinary("F:\\ChromeDRIVERS\\chrome-win64\\chrome.exe"); WebDriver
		 * driver=new ChromeDriver(options); driver.get("https://www.facebook.com");
		 */
		//System.getProperties().list(System.out);
		System.out.println(System.getProperty("os.name"));
			}

}
