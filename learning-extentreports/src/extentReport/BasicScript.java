package extentReport;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * This is a basic script for using Selenium WebDriver
 */
public class BasicScript {

	// Declaring variable 'myDriver' of WebDriver Type
	WebDriver myDriver;

	// Declaring variable 'baseUrl' of String Type
	String baseUrl;

	// start reporters
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");

	// create ExtentReports and attach reporter(s)
	ExtentReports extent = new ExtentReports();

	@BeforeTest
	public void beforeTest() {

		htmlReporter.config().setDocumentTitle(extent.getClass().getName());		

		// Attach HTML Report path to extent object
		extent.attachReporter(htmlReporter);

	}

	@Test
	public void basicScriptExample1() throws IOException {

		// creates a toggle for the given test, adds all log events under it
		ExtentTest test = extent.createTest("basicScriptExample1", "This is first test using Extent Report");

		// Initializing FireFox Driver
		myDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://book.theautomatedtester.co.uk";

		// Open the link
		myDriver.get(baseUrl);

		//
		test.log(Status.INFO, "Opening URL :" + baseUrl);

		// Maximize browser window
		myDriver.manage().window().maximize();

		//
		test.info("Maximize browser window");

		// Get Page Title
		String PageTitle = myDriver.getTitle();

		// Printing Page Title
		System.out.println("Page Title : " + PageTitle);

		// Click on link
		myDriver.findElement(By.linkText("Chapter1")).click();

		// Click on radio button
		myDriver.findElement(By.id("radiobutton")).click();

		// Click on Drop down
		Select dropdown = new Select(myDriver.findElement(By.id("selecttype")));

		// Select option from drop down
		dropdown.selectByVisibleText("Selenium Core");

		// Verify Text Present
		Assert.assertEquals("Assert that this text is on the page",
				myDriver.findElement(By.id("divontheleft")).getText());

		// log with snapshot
		test.fail("Assertion Failed",
				MediaEntityBuilder.createScreenCaptureFromPath("C:\\office\\pictures\\2.jpg").build());

		// Verify Button Present
		Assert.assertEquals("Verify this button he here",
				myDriver.findElement(By.id("verifybutton")).getAttribute("value"));

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");
		test.pass("Assertion Passed",
				MediaEntityBuilder.createScreenCaptureFromPath("screenshots\\2.jpg", "Title of Screenshot").build());

		// This will close the browser
		myDriver.quit();

	}

	@Test
	public void basicScriptExample2() throws IOException {

		// creates a toggle for the given test, adds all log events under it
		ExtentTest test = extent.createTest("basicScriptExample2", "This is second test using Extent Report");

		// Initializing FireFox Driver
		myDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://book.theautomatedtester.co.uk";

		// Open the link
		myDriver.get(baseUrl);

		//
		test.log(Status.INFO, "Opening URL :" + baseUrl);

		// Maximize browser window
		myDriver.manage().window().maximize();

		//
		test.info("Maximize browser window");

		// Get Page Title
		String PageTitle = myDriver.getTitle();

		// Printing Page Title
		System.out.println("Page Title : " + PageTitle);

		// Click on link
		myDriver.findElement(By.linkText("Chapter1")).click();

		// Click on radio button
		myDriver.findElement(By.id("radiobutton")).click();

		// Click on Drop down
		Select dropdown = new Select(myDriver.findElement(By.id("selecttype")));

		// Select option from drop down
		dropdown.selectByVisibleText("Selenium Core");

		// Verify Text Present
		Assert.assertEquals("Assert that this text is on the page",
				myDriver.findElement(By.id("divontheleft")).getText());

		// log with snapshot
		test.fail("Assertion Failed",
				MediaEntityBuilder.createScreenCaptureFromPath("C:\\office\\pictures\\2.jpg").build());

		// Verify Button Present
		Assert.assertEquals("Verify this button he here",
				myDriver.findElement(By.id("verifybutton")).getAttribute("value"));

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");
		test.pass("Assertion Passed", MediaEntityBuilder
				.createScreenCaptureFromPath("C:\\office\\pictures\\2.jpg", "Title of Screenshot").build());

		// This will close the browser
		myDriver.quit();

	}

	@AfterTest
	public void afterTest() {

		// calling flush writes everything to the log file
		extent.flush();

	}

}