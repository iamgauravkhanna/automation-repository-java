package webdriverScripts.webElements;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetCoordinates {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	@BeforeMethod
	public void startUp() throws Exception {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://book.theautomatedtester.co.uk";
	}

	@Test
	public void tests067_ElementCordinates() throws Exception {

		// Open the link
		webDriver.get(baseUrl);

		// Maximize browser window
		webDriver.manage().window().maximize();

		// Locating the Web Element
		WebElement source = webDriver.findElement(By.linkText("Chapter1"));

		// Getting value of X coordinate
		int x = source.getLocation().getX();

		// Getting value of Y coordinate
		int y = source.getLocation().getY();

		// Printing Value
		System.out.println(" Value of X coordinate : " + x);

		// Printing Value
		System.out.println(" Value of Y coordinate : " + y);

		// Wait for 5 seconds
		Thread.sleep(5000);
	}

	@AfterMethod
	public void shutDown() throws Exception {

		// This will close the browser
		webDriver.quit();
	}

}