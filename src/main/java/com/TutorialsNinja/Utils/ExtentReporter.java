package com.TutorialsNinja.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	public static ExtentReports generateExtentReport() throws IOException {
		ExtentReports extentreport=new ExtentReports();
		File extentReportFile=new File("F:\\EclipsData\\NewTesting\\inetBanking_V1\\test-output\\ExtentReports\\extentreport.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialsNinja Automation Report");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setTimeStampFormat("DD/MM/YYYY HH:MM:SS");
		
		extentreport.attachReporter(sparkReporter);
		
		Properties configprop=new Properties();
		File configProFile=new File("F:\\EclipsData\\NewTesting\\inetBanking_V1\\src\\main\\java"
									+ "\\com\\TutorialsNinja\\qa\\config\\config.Properties");
		FileInputStream fis =new FileInputStream(configProFile);
		configprop.load(fis);
		extentreport.setSystemInfo("Aplication URL",configprop.getProperty("url"));
		extentreport.setSystemInfo("Browser Name",configprop.getProperty("browser"));
		extentreport.setSystemInfo("Email",configprop.getProperty("validEmail"));
		extentreport.setSystemInfo("Password",configprop.getProperty("validPassword"));
		extentreport.setSystemInfo("Operating System",configprop.getProperty("os.name"));
		extentreport.setSystemInfo("User Name",configprop.getProperty("user.name"));
		extentreport.setSystemInfo("Java Version",configprop.getProperty("java.version"));
		
		return extentreport;
		
	}
}
