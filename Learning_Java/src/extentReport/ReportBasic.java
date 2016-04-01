package extentReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportBasic {

	private ExtentReports extent1;

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring variable 'baseUrl' of String Type
	String baseUrl;

	@BeforeClass
	public void beforeClass() {
		extent1 = new ExtentReports("C:\\Code\\Basic.html", true);
	}

	@Test
	public void testbasicScript() {

		ExtentTest test = extent1.startTest("My First Test", "Sample description");
		


		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();
		
		test.log(LogStatus.INFO, "Firefox Browser Intialized");

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://book.theautomatedtester.co.uk";
		
		test.log(LogStatus.INFO, "Browser Opened");
		test.addScreenCapture("C:\\Code\\File.png");

		// Open the link
		webDriver.get(baseUrl);
		

		// Maximize browser window
		webDriver.manage().window().maximize();

		// Click on link
		webDriver.findElement(By.linkText("Chapter1")).click();

		// Click on radio button
		webDriver.findElement(By.id("radiobutton")).click();

		// Click on Dropdown
		Select dropdown = new Select(webDriver.findElement(By.id("selecttype")));

		// Select option from dropdown
		dropdown.selectByVisibleText("Selenium Core");

		// Verify Text Present
		Assert.assertEquals("Assert that this text is on the page",
				webDriver.findElement(By.id("divontheleft")).getText());

		// Verify Button Present
		Assert.assertEquals("Verify this button he here",
				webDriver.findElement(By.id("verifybutton")).getAttribute("value"));

		// This will close the browser
		webDriver.quit();
		
		extent1.endTest(test);
	}

	@AfterSuite
	public void afterSuite() {
		// write all resources to report file
		extent1.flush();
	}
}
