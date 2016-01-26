/*********************************
 
Title  : Learning Log4j
Author : Gaurav Khanna

 *********************************/

package log4j;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LearningLog4j {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring variable 'baseUrl' of String Type
	String baseUrl;

	// Initialize Log4j logs
	private static Logger Log = Logger.getLogger(LearningLog4j.class.getName());

	@BeforeMethod
	public void startUp() {

		Log.info("************************************* Before Method ****************************************");

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://book.theautomatedtester.co.uk";

	}

	@Test
	public void testlearningLog4j() {

		Log.info("**************************************** Main Method ************************************************");

		// Open the link
		webDriver.get(baseUrl);

		// Maximize browser window
		webDriver.manage().window().maximize();

	}

	@AfterMethod
	public void shutDown() {

		Log.info("************************************** After Method **************************************************");

		// This will close the browser
		webDriver.quit();

	}

}
