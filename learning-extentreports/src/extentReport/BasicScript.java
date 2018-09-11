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
import com.aventstack.extentreports.reporter.KlovReporter;

/**
 * This is a basic script for using Selenium WebDriver
 */
public class BasicScript {

	WebDriver webDriverObj;

	String baseUrl;

	ExtentHtmlReporter extentHtmlReporterObj = new ExtentHtmlReporter("extentReport1.html");

	ExtentReports extentReportsObj = new ExtentReports();

	KlovReporter klovReporterObj = new KlovReporter();

	@BeforeTest
	public void beforeTest() {

		// specify mongoDb connection
		klovReporterObj.initMongoDbConnection("localhost", 27017);

		// specify project
		// ! you must specify a project, other a "Default project will be used"
		klovReporterObj.setProjectName("RAFTAAR");

		// you must specify a reportName otherwise a default timestamp will be used
		klovReporterObj.setReportName("Build#001");

		// URL of the KLOV server
		// you must specify the served URL to ensure all your runtime media is uploaded
		// to the server
		klovReporterObj.setKlovUrl("http://localhost:8005");

		extentHtmlReporterObj.config().setDocumentTitle(extentReportsObj.getClass().getName());

		// Attach HTML Report path to extent object
		extentReportsObj.attachReporter(extentHtmlReporterObj);

		extentReportsObj.attachReporter(klovReporterObj);

	}

	@Test
	public void basicScriptExample1() throws Exception {

		// creates a toggle for the given test, adds all log events under it
		ExtentTest extentTestObj = extentReportsObj.createTest("Basic Script Example #1",
				"This is first test using Extent Report");

		System.setProperty("webdriver.gecko.driver", "resources/drivers/geckodriver.exe");

		// Initializing FireFox Driver
		webDriverObj = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://book.theautomatedtester.co.uk";

		// Open the link
		webDriverObj.get(baseUrl);

		//
		extentTestObj.log(Status.INFO, "Opening URL :" + baseUrl);

		// Maximize browser window
		webDriverObj.manage().window().maximize();

		//
		extentTestObj.info("Maximize browser window");

		// Get Page Title
		String PageTitle = webDriverObj.getTitle();

		// Printing Page Title
		System.out.println("Page Title : " + PageTitle);

		// Click on link
		webDriverObj.findElement(By.linkText("Chapter1")).click();

		// Click on radio button
		webDriverObj.findElement(By.id("radiobutton")).click();

		// Click on Drop down
		Select dropdown = new Select(webDriverObj.findElement(By.id("selecttype")));

		// Select option from drop down
		dropdown.selectByVisibleText("Selenium Core");

		// Verify Text Present
		Assert.assertEquals("Assert that this text is on the page",
				webDriverObj.findElement(By.id("divontheleft")).getText());

		// log with snapshot
		extentTestObj.fail("Assertion Failed", MediaEntityBuilder
				.createScreenCaptureFromPath(GetScreenshot.getTheScreenshot(webDriverObj, "File1")).build());

		// Verify Button Present
		Assert.assertEquals("Verify this button he here",
				webDriverObj.findElement(By.id("verifybutton")).getAttribute("value"));

		// test with snapshot
		extentTestObj.addScreenCaptureFromPath("screenshot.png");

		extentTestObj.pass("Assertion Passed",
				MediaEntityBuilder.createScreenCaptureFromPath(GetScreenshot.getTheScreenshot(webDriverObj, "File2"),
						"Title of Screenshot").build());

		// This will close the browser
		webDriverObj.quit();

	}

	@Test
	public void basicScriptExample2() throws IOException {

		// creates a toggle for the given test, adds all log events under it
		ExtentTest extentTestObj = extentReportsObj.createTest("Basic Script Example #2",
				"This is second test using Extent Report");

		// Initializing FireFox Driver
		webDriverObj = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://book.theautomatedtester.co.uk";

		// Open the link
		webDriverObj.get(baseUrl);

		//
		extentTestObj.log(Status.INFO, "Opening URL :" + baseUrl);

		// Maximize browser window
		webDriverObj.manage().window().maximize();

		//
		extentTestObj.info("Maximize browser window");

		// Get Page Title
		String PageTitle = webDriverObj.getTitle();

		// Printing Page Title
		System.out.println("Page Title : " + PageTitle);

		// Click on link
		webDriverObj.findElement(By.linkText("Chapter1")).click();

		// Click on radio button
		webDriverObj.findElement(By.id("radiobutton")).click();

		// Click on Drop down
		Select dropdown = new Select(webDriverObj.findElement(By.id("selecttype")));

		// Select option from drop down
		dropdown.selectByVisibleText("Selenium Core");

		// Verify Text Present
		Assert.assertEquals("Assert that this text is on the page",
				webDriverObj.findElement(By.id("divontheleft")).getText());

		// log with snapshot
		extentTestObj.fail("Assertion Failed",
				MediaEntityBuilder.createScreenCaptureFromPath("test-output/3.jpg").build());

		// Verify Button Present
		Assert.assertEquals("Verify this button he here",
				webDriverObj.findElement(By.id("verifybutton")).getAttribute("value"));

		// test with snapshot
		extentTestObj.addScreenCaptureFromPath("screenshot.png");

		extentTestObj.pass("Assertion Passed",
				MediaEntityBuilder.createScreenCaptureFromPath("test-output/4.jpg", "Title of Screenshot").build());

		// This will close the browser
		webDriverObj.quit();

	}

	@AfterTest
	public void afterTest() {

		// calling flush writes everything to the log file
		extentReportsObj.flush();

	}

}