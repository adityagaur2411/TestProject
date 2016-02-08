package com.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class TestA {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		System.out.println("*******************");
		System.out.println("launching remote chrome browser");
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//driver = Browser.getBrowser(1);
		driver = new RemoteWebDriver(new URL("http://192.168.1.5:4444/wd/hub"), capabilities);
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void testGooglePageTitleInFirefox() {
		driver.navigate().to("http://www.google.com");
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - "+strPageTitle);
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
	}

	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing firefox browser");
			driver.quit();
		}
	}
	
}