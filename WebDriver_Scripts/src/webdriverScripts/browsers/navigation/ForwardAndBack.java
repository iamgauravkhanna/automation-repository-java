/*********************************
 
Title  : Forward and Back Method
Author : Gaurav Khanna

 *********************************/

package webdriverScripts.browsers.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ForwardAndBack {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	@Test
	public void testforwardAndBack() throws InterruptedException {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://book.theautomatedtester.co.uk";

		// Open the link
		webDriver.get("http://book.theautomatedtester.co.uk");

		// Maximize browser window
		webDriver.manage().window().maximize();

		// Click on link
		webDriver.findElement(By.linkText("Chapter1")).click();

		System.out.println(webDriver.getTitle());

		Thread.sleep(5000L);

		// Using Back Method
		webDriver.navigate().back();

		//
		System.out.println(webDriver.getTitle());

		Thread.sleep(5000L);

		// Using Forward Method
		webDriver.navigate().forward();

		//
		System.out.println(webDriver.getTitle());

		//
		Thread.sleep(5000L);

		// This will close the browser
		webDriver.quit();

	}
}
