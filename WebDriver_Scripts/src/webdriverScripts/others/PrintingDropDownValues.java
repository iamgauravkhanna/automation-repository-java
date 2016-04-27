/*********************************
 
Title  : Printing Drop Down Values
Author : Gaurav Khanna

 *********************************/

package webdriverScripts.others;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PrintingDropDownValues {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	@Test
	public void testprintingDropDownValues() {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://book.theautomatedtester.co.uk/chapter1";

		// Open the link
		webDriver.get(baseUrl);

		// Maximize browser window
		webDriver.manage().window().maximize();

		// Creates a List of type WebElement which will store all values present
		// in dropdown
		List<WebElement> dropDownValues = webDriver.findElements(By
				.xpath("//*[@id='selecttype']"));

		// This loop will assign all values present in 'dropDownValues' to
		// 'dropDownElements'
		for (WebElement dropDownElements : dropDownValues) {

			// This will print the List "dropDownElements"
			System.out.println(dropDownElements.getText());
		}

		// This will close the browser
		webDriver.quit();
	}
}
