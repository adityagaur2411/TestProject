package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {

	static String driverPath = "C:/Users/Aditya/workspace/FirstTestNGProject/lib/";
	
	public static WebDriver driver;
	
	public static WebDriver getBrowser(int browserType) {
		
		switch (browserType) {
		
		case 1:
			
			System.out.println("in switch case 1");
			return	driver = new FirefoxDriver();
			
		case 2:
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			//return	driver = new ChromeDriver();
			
		case 3:
			System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");
			return	driver = new InternetExplorerDriver();
			
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			return null;// driver = new FirefoxDriver();
		}
	}
}