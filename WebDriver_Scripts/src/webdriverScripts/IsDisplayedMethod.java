/*********************************
 
Title  : IsDisplayed Method
Author : Gaurav Khanna

 *********************************/

package webdriverScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IsDisplayedMethod {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	@Test
	public void testisDisplayedMethod() {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://book.theautomatedtester.co.uk/chapter1";

		// Open the link
		webDriver.get(baseUrl);

		// Validate that response of 'isDisplayed()' returns true
		Assert.assertTrue(webDriver.findElement(By.id("verifybutton"))
				.isDisplayed());

		// This will close the browser
		webDriver.quit();

	}

}
