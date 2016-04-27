/*********************************
 
Title  : Printing Page Title
Author : Gaurav Khanna

 *********************************/

package webdriverScripts.others;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ScrollingPage {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	@Test
	public void testscrollingPage() throws InterruptedException {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://not-just-a-tester.blogspot.in/";

		// Open the link
		webDriver.get(baseUrl);

		// Maximize browser window
		webDriver.manage().window().maximize();

		// Initalize JavaScript Object
		JavascriptExecutor jsx = (JavascriptExecutor) webDriver;

		// Execute Scroll Page Java Script
		jsx.executeScript("window.scrollBy(0,450)", "");

		// Wait for 5 seconds
		Thread.sleep(5000);

		// Execute Scroll Page Java Script
		jsx.executeScript("window.scrollBy(0,450)", "");

		// Wait for 5 seconds
		Thread.sleep(5000);

		// Execute Scroll Page Java Script
		jsx.executeScript("window.scrollBy(0,450)", "");

		// This will close the browser
		webDriver.quit();
	}

}
