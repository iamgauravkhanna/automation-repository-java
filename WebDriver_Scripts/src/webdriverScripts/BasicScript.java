/*
 * @Author : Gaurav Khanna 
 */

package webdriverScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicScript {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring variable 'baseUrl' of String Type
	String baseUrl;

	@Test
	public void testbasicScript() {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://book.theautomatedtester.co.uk";

		// Open the link
		webDriver.get(baseUrl);

		// Maximize browser window
		webDriver.manage().window().maximize();

		// Click on link
		webDriver.findElement(By.linkText("Chapter1")).click();

		// Click on radio button
		webDriver.findElement(By.id("radiobutton")).click();

		// Click on Dropdown
		Select dropdown = new Select(webDriver.findElement(By.id("selecttype")));

		// Select option from dropdown
		dropdown.selectByVisibleText("Selenium Core");

		// Verify Text Present
		Assert.assertEquals("Assert that this text is on the page", webDriver
				.findElement(By.id("divontheleft")).getText());

		// Verify Button Present
		Assert.assertEquals("Verify this button he here", webDriver
				.findElement(By.id("verifybutton")).getAttribute("value"));

		// This will close the browser
		webDriver.quit();
	}
}
