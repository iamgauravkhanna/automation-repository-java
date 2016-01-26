/*********************************
 
Title  : Printing Current Page URL
Author : Gaurav Khanna

 *********************************/

package webdriverScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PrintingCurrentPageURL {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	@Test
	public void testprintingCurrentPageURL() {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://not-just-a-tester.blogspot.in";

		// Open the link
		webDriver.get(baseUrl);

		// Maximize browser window
		webDriver.manage().window().maximize();

		// Click on Selenium link
		webDriver.findElement(By.linkText("Selenium")).click();

		// Print Current Page URL
		System.out.println("Current URL -- " + webDriver.getCurrentUrl());

		// This will close the browser
		webDriver.quit();
	}

}
