package basicScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import junit.framework.Assert;

public class Step_Defination {

	public static WebDriver myDriver;
	public String baseUrl;

	@Given("^I open the browser$")
	public void openBrowser() {

		myDriver = new FirefoxDriver();
	}

	@When("^I execute the steps$")
	public void executeSteps() {

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

	}

	@Then("^My test should pass$")
	public void finalVerification() {

		// Verify Text Present
		Assert.assertEquals("Assert that this text is on the page",
				myDriver.findElement(By.id("divontheleft")).getText());

		// Verify Button Present
		Assert.assertEquals("Verify this button he here",
				myDriver.findElement(By.id("verifybutton")).getAttribute("value"));
		
		System.out.println("All Good :-)");

		// This will close the browser
		myDriver.quit();

	}

}