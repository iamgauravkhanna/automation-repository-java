/*
 * @Author : Gaurav Khanna 
 */

package webdriverScripts.others;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class BasicScript2 {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	@Test
	public void testbasicScript2() {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://www.webmath.com/";

		// Wait for 30 seconds
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Open the link
		webDriver.get(baseUrl);

		// Click on element
		webDriver.findElement(By.id("www-content-wrap")).click();

		// Select `Simple Interest` option from dropdown
		new Select(webDriver.findElement(By.id("topicItem")))
				.selectByVisibleText("Interest, Simple");

		// Click on element
		webDriver.findElement(
				By.cssSelector("option[value=\"simpinterest.html\"]")).click();

		// Click on element
		webDriver.findElement(By.name("principal")).clear();

		// Click on element
		webDriver.findElement(By.name("principal")).sendKeys("1000");

		// Click on element
		webDriver.findElement(By.name("interest")).clear();

		// Click on element
		webDriver.findElement(By.name("interest")).sendKeys("1");

		// Click on element
		webDriver.findElement(By.name("desired_time")).clear();

		// Click on element
		webDriver.findElement(By.name("desired_time")).sendKeys("5");

		// Click on element
		webDriver.findElement(
				By.xpath("//input[@value='Find the amount of interest']"))
				.click();

		webDriver.quit();
	}

}
