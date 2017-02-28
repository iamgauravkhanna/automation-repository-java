package example;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest {

	// Declaring variable 'myDriver' of WebDriver Type
	WebDriver myDriver;

	// Declaring variable 'baseUrl' of String Type
	String baseUrl;

	// Declaring variable 'remoteTest' of String Type to determine if test needs
	// to run locally or remotely
	// String remoteTest = "http://192.168.49.40:4444/wd/hub";
	String remoteTest = "local";

	@Test
	public void basicScriptExample() throws MalformedURLException {

		// Initializing FireFox Driver
		myDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://book.theautomatedtester.co.uk";

		// Open the link
		myDriver.get(baseUrl);

		// Maximize browser window
		myDriver.manage().window().maximize();

		// Get Page Title
		String PageTitle = myDriver.getTitle();

		// Printing Page Title
		System.out.println("Page Title : " + PageTitle);

		// Click on link
		myDriver.findElement(By.linkText("Chapter1")).click();

		// Click on radio button
		myDriver.findElement(By.id("radiobutton")).click();

		// Click on Dropdown
		Select dropdown = new Select(myDriver.findElement(By.id("selecttype")));

		// Select option from dropdown
		dropdown.selectByVisibleText("Selenium Core");

		// Verify Text Present
		Assert.assertEquals("Assert that this text is on the page",
				myDriver.findElement(By.id("divontheleft")).getText());

		// Verify Button Present
		Assert.assertEquals("Verify this button he here",
				myDriver.findElement(By.id("verifybutton")).getAttribute("value"));

		// This will close the browser
		myDriver.quit();
	}
}