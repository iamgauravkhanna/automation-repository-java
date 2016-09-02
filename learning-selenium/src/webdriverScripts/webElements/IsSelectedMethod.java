package webdriverScripts.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IsSelectedMethod {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	@Test
	public void testisSelectedMethod() {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://book.theautomatedtester.co.uk/chapter1";

		// Open the link
		webDriver.get(baseUrl);

		// Click on the radio button
		webDriver.findElement(By.id("radiobutton")).click();

		// Verify that isSelected method returns true or false
		Assert.assertTrue(webDriver.findElement(By.id("radiobutton")).isSelected());

		// This will close browser
		webDriver.quit();

	}

}
