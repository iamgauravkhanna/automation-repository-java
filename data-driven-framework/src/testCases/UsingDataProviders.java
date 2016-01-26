/*
 * @Author : Gaurav Khanna 
 */

package testCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsingDataProviders {

	// Declaring variable 'webDriver' of WebDriver Type
	// Initializing FireFox Driver
	WebDriver webDriver = new FirefoxDriver();

	// Creating Array for Country Name to be used
	@DataProvider(name = "countryName")
	public Object[][] createData1() {
		return new Object[][] { { "India" }, { "Brazil" }, { "Canada" },
				{ "Sri Lanka" }, { "England" }, { "UK" }, { "United States" }, };
	}

	@Test(dataProvider = "countryName")
	public void testusingDataProviders(String country) {

		String baseUrl = "http://www.wikipedia.org/";

		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		webDriver.get(baseUrl + "/wiki/Main_Page");

		webDriver.findElement(By.id("searchInput")).clear();

		webDriver.findElement(By.id("searchInput")).sendKeys(country);

		webDriver.findElement(By.id("searchButton")).click();

		String str = webDriver.findElement(By.cssSelector("span")).getText();

		Assert.assertTrue(country.equals(str.trim()));

	}

}