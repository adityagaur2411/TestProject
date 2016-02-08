package com.test;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class TestB {
		
	WebDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, UnknownHostException {
		
		//String driverPath = "C:/Users/Aditya/workspace/FirstTestNGProject/lib/";
		System.out.println("*******************");
		System.out.println("launching remote firefox browser");
		//driver = Browser.getBrowser(2);
		
		String ip = InetAddress.getLocalHost().getHostAddress();
		
		System.out.println(ip); //aditya
		
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		driver = new RemoteWebDriver(new URL("http://192.168.1.5:4444/wd/hub"), capabilities);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testGooglePageTitleInChrome() {
		driver.navigate().to("http://www.google.com");
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - "+strPageTitle);
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
	}

	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing chrome browser");
			driver.quit();
		}
	}
}