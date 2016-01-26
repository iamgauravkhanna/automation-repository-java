/*********************************
 
Title  : File Upload
Author : Gaurav Khanna

 *********************************/

package webdriverScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FileUpload {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring variable 'baseUrl' of String Type
	String baseUrl;

	@Test
	public void testfileUpload() throws InterruptedException {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://www.htmlcodetutorial.com/forms/_INPUT_TYPE_FILE.html";

		// Open the link
		webDriver.get(baseUrl);

		// Maximize browser window
		webDriver.manage().window().maximize();

		//
		webDriver.findElement(By.name("upfile")).sendKeys("C:\\gk\\pm.png");

		//
		webDriver.findElement(By.xpath("//input[@value='Submit']")).click();

		Thread.sleep(6000);

		// This will close the browser
		webDriver.quit();
	}
}
