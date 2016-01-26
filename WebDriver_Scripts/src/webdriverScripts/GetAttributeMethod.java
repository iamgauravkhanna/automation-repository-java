/*********************************
 
Title  : GetAttribute Method
Author : Gaurav Khanna

 *********************************/

package webdriverScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GetAttributeMethod {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	// Declaring attributeValue variable of String Type
	String attributeValue;

	@Test
	public void testgetAttributeMethod() {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://book.theautomatedtester.co.uk/chapter1";

		// Open the link
		webDriver.get(baseUrl);

		// Locate Button and Store the value of button to 'attributeValue'
		// variable
		attributeValue = webDriver.findElement(By.id("verifybutton"))
				.getAttribute("value");

		// Printing value of 'attributeValue'
		System.out.println("Attribute Value : " + attributeValue);

		// This will close the browser
		webDriver.quit();

	}

}
