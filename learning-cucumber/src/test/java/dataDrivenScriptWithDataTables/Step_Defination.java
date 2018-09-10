package dataDrivenScriptWithDataTables;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

public class Step_Defination {

	public static WebDriver myDriver;
	public String baseUrl;

	@Given("^I open the browser$")
	public void openBrowser() {

		myDriver = new FirefoxDriver();
	}

	@When("^I click on \"([^\"]*)\"$")
	public void clickOnLink(String LinkText) {

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
		myDriver.findElement(By.linkText(LinkText)).click();

	}

	@When("^I select value in drop down$")
	public void executeSteps(DataTable DropDownValue) {

		List<Map<String, String>> data = DropDownValue.asMaps();

		// Click on Dropdown
		Select dropdown = new Select(myDriver.findElement(By.id("selecttype")));

		// Select option from dropdown
		dropdown.selectByVisibleText(data.get(0).get(0));

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