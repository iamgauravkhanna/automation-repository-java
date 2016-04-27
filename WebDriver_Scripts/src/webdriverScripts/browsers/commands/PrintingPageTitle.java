/*********************************
 
Title  : Printing Page Title
Author : Gaurav Khanna

 *********************************/

package webdriverScripts.browsers.commands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PrintingPageTitle {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	@Test
	public void testprintingPageTitle() {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://not-just-a-tester.blogspot.in/";

		// Open the link
		webDriver.get(baseUrl);

		// Maximize browser window
		webDriver.manage().window().maximize();

		// Print Page Title
		System.out.println("Title is - " + webDriver.getTitle());

		// This will close the browser
		webDriver.quit();
	}
}
