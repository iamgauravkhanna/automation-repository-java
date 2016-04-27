/*********************************
 
Title  : Handling Multiple Windows 1
Author : Gaurav Khanna

 *********************************/

package webdriverScripts.others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlingMultipleWindows1 {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	@Test
	public void testhandlingMultipleWindows() {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable baseUrl
		baseUrl = "http://book.theautomatedtester.co.uk/";

		// Open the link
		webDriver.get(baseUrl);

		// Maximize browser window
		webDriver.manage().window().maximize();

		// Click on link
		webDriver.findElement(By.linkText("Chapter1")).click();

		//
		webDriver.findElement(By.id("multiplewindow")).click();

		//
		java.util.Set<String> b = webDriver.getWindowHandles();

		//
		String j = (String) b.toArray()[1];

		//
		System.out.println(j);

		//
		webDriver.switchTo().window(j);

		// Verify Text Present
		Assert.assertEquals("Text within the pop up window", webDriver
				.findElement(By.id("popuptext")).getText());

		//
		webDriver.findElement(By.id("closepopup")).click();

		//
		String n = (String) b.toArray()[0];

		//
		System.out.println(b.toArray()[0]);

		//
		webDriver.switchTo().window(n);

		//
		Assert.assertEquals("Verify this button he here", webDriver
				.findElement(By.id("verifybutton")).getAttribute("value"));

		// This will close the browser
		webDriver.quit();
	}

}
