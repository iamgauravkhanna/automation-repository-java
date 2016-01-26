/*********************************
 
Title  : Printing Page Source
Author : Gaurav Khanna

 *********************************/

package webdriverScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrintingPageSource {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	// Declaring pageSource variable of String Type
	String pageSource;

	@Test
	public void testprintingPageSource() {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://not-just-a-tester.blogspot.in/";

		// Open the link
		webDriver.get(baseUrl);

		// Maximize browser window
		webDriver.manage().window().maximize();

		// Assigning Page Source content to variable 'pageSource'
		pageSource = webDriver.getPageSource();

		// Print Current Page Source
		System.out.println("Page Source is - " + pageSource);

		// Verify that page source contains text 'Gaurav Khanna'
		Assert.assertTrue(pageSource.contains("Gaurav Khanna"));

		// This will close the browser
		webDriver.quit();
	}

}
