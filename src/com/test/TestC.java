package com.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestC {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		System.out.println("*******************");
		System.out.println("launching remote IE browser");
		//driver = Browser.getBrowser(3);
		DesiredCapabilities ds = DesiredCapabilities.internetExplorer();
		ds.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		driver = new RemoteWebDriver(new URL("http://192.168.1.5:4444/wd/hub"),ds);		
		driver.manage().window().maximize();
	}
	
	@Test
	public void testGooglePageTitleInIEBrowser() throws InterruptedException{
		
		driver.navigate().to("http://www.google.com");
		//Thread.sleep(5000);
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - "+strPageTitle);
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
		
	}

	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing IE browser");
			driver.quit();
			System.out.println("Closed");
		}
	}
}