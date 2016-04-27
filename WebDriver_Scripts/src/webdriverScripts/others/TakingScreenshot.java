/*********************************
 
Title  : Taking Screen Shot
Author : Gaurav Khanna

 *********************************/

package webdriverScripts.others;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TakingScreenshot {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	@Test
	public void testTakingScreenshot() throws Exception {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://not-just-a-tester.blogspot.in";

		// Open the link
		webDriver.get(baseUrl);

		// Captures the screen shot
		File scrFile = ((TakesScreenshot) webDriver)
				.getScreenshotAs(OutputType.FILE);

		// Copying screen shot to the desired location
		FileUtils.copyFile(scrFile, new File("c:\\gk\\screenshot.png"));

		webDriver.quit();

	}
}
