package project99;

import java.util.List;

import org.apache.poi.ss.util.CellRangeAddressList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BasePage;
import utils.DriverUtil;
import utils.LogUtils;

public class WebKeywordsExample extends BasePage {

	DriverUtil driverUtilObj;

	@BeforeMethod
	public void StartUp() {

		driverUtilObj = new DriverUtil();

		webDriverObj = driverUtilObj.intializeDriver();

		LogUtils.info("BeforeTest Execution Complete");

	}

	@Test(enabled = false, description = "Basic Script Example 1")
	public void TC001() {

		maximizeBrowser();

		// Assigning URL to variable 'baseUrl'
		String baseUrl = "http://book.theautomatedtester.co.uk";

		// Open the link
		openBrowser(baseUrl);

		// Get Page Title
		String PageTitle = getPageTitle();

		// Printing Page Title
		System.out.println("Page Title : " + PageTitle);

		// Click on link
		click(By.linkText("Chapter1"));

		// Click on radio button
		click(By.id("radiobutton"));

		// Select option from dropdown
		selectByValue(By.id("selecttype"), "Selenium RC");

		// Get Text of WebElement
		String actual = getText(By.id("divontheleft"));

		// Verify Text Equality
		assertEquals(actual, "Assert that this text is on the page");

		// Get Attribute value of WebElement
		actual = getAttribute(By.id("verifybutton"), "value");

		// Verify Text Equality
		assertEquals(actual, "Verify this button he here");

	}

	@Test(enabled = false, description = "Get Element By Tagname Example")
	public void TC002() {

		List<WebElement> links;

		maximizeBrowser();

		openBrowser("https://not-just-a-tester.blogspot.com/");

		links = findElements(By.tagName("a"));

		System.out.println("Size Of Links : " + links.size());

		for (int i = 0; i < links.size(); i++) {

			System.out.println("Link #" + i + " : " + links.get(i).getText());
		}

	}

	@Test(enabled = false, description = "Basic Script Example 2")
	public void TC003() {

		maximizeBrowser();

		openBrowser("http://www.webmath.com/");

		waitForPageLoaded();

		// TODO - Implicit wait keyword pending for implementaion

		click(By.xpath("//a[text()='General Math']"));

		selectByText(By.id("topicItem"), "Interest, Simple");

		click(By.cssSelector("option[value=\"simpinterest.html\"]"));

		clearText(By.name("principal"));

		setText(By.name("principal"), "8000");

		clearText(By.name("interest"));

		setText(By.name("interest"), "1");

		clearText(By.name("desired_time"));

		setText(By.name("desired_time"), "5");

		click(By.xpath("//input[@value='Find the amount of interest']"));

		pause(20);

	}

	@Test(enabled = true, description = "Get Attribute Example")
	public void TC004() {

		maximizeBrowser();

		openBrowser("http://www.google.com");

		System.out.println(getTagName(By.name("btnK")));

	}

	@AfterMethod
	public void TearDown() {

		webDriverObj.quit();

	}
}