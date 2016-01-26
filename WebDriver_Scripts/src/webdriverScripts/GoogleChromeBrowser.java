/*********************************
 
Title  : Google Chrome Browser
Author : Gaurav Khanna

 *********************************/

package webdriverScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleChromeBrowser {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	@Test
	public void testusingGoogleChromeBrowser() {

		// Setting Chrome Driver Path
		System.setProperty("webdriver.chrome.driver",
				"C:\\gk\\code\\selenium\\lib\\chromedriver.exe");

		// Initializing Google Chrome Driver
		webDriver = new ChromeDriver();

		// Assigning URL to variable baseUrl
		baseUrl = "http://not-just-a-tester.blogspot.in";

		// Open the link
		webDriver.get(baseUrl);

		// Maximize the window
		webDriver.manage().window().maximize();

		// Click on Selenium link
		webDriver.findElement(By.linkText("Selenium")).click();

		// This will close the browser
		webDriver.quit();
	}

}
