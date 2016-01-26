/*********************************
 
Title  : Opening New Tab
Author : Gaurav Khanna

 *********************************/

package webdriverScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpeningNewTab {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	@Test
	public void testopeningNewTab() throws InterruptedException {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://qamasterz.blogspot.in";

		// Open the link
		webDriver.get(baseUrl);

		// Maximize browser window
		webDriver.manage().window().maximize();

		// Store the Body Tag
		WebElement body = webDriver.findElement(By.tagName("body"));

		// Press CTRL + T Key for New Tab
		body.sendKeys(Keys.chord(Keys.CONTROL, "t"));

		// Wait for 5 Seconds
		Thread.sleep(5000);

		// This will close the browser
		webDriver.quit();

	}

}
