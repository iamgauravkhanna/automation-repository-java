/*********************************
 
Title  : Printing Count of Web Element Present
Author : Gaurav Khanna

 *********************************/

package webdriverScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PrintingCountOfWebElementPresent {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	// Declaring count variable of Int Type
	int count;

	@Test
	public void testprintingCountOfWebElementPresent() {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://not-just-a-tester.blogspot.in";

		// Open the link
		webDriver.get(baseUrl);

		// size() method count the number of anchor tags present
		count = webDriver.findElements(By.xpath("//a")).size();

		// Prints the value of count variable
		System.out.println("Total Number of Links Present: " + count);

		// This will close the browser
		webDriver.quit();
	}

}
