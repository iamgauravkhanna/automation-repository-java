/*********************************
 
Title  : Object Repository
Author : Gaurav Khanna

 *********************************/

package testPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChapterOne {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	@Test
	public void testChapterOne() throws IOException {

		// Declaring variable 'baseUrl' of String Type
		String baseUrl;

		FileInputStream objectRepository = new FileInputStream(
				System.getProperty("user.dir")
						+ "\\src\\objectRepository\\chapterOne.OR");

		Properties properties = new Properties();

		properties.load(objectRepository);

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = properties.getProperty("applicationUrl");

		System.out.println(baseUrl);
		
		// Open the link
		webDriver.get(baseUrl);

		// Maximize browser window
		webDriver.manage().window().maximize();

		// Click on link
		webDriver.findElement(By.linkText(properties.getProperty("linkText")))
				.click();

		// Click on radio button
		webDriver.findElement(By.id(properties.getProperty("radioButton")))
				.click();

		// Verify Text Present
		Assert.assertEquals(properties.getProperty("pageTitle"),
				webDriver.getTitle());

		// Verify Button Present
		Assert.assertEquals("Verify this button he here", webDriver
				.findElement(By.id(properties.getProperty("button")))
				.getAttribute("value"));

		webDriver.quit();

	}
}
