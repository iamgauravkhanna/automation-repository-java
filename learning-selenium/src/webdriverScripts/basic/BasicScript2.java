package webdriverScripts.basic;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import webdriverScripts.utils.Utils;

public class BasicScript2 {

	// Declaring variable 'myDriver' of myDriver Type
	WebDriver myDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	// Declaring variable 'remoteTest' of String Type to determine if test needs
	// to run locally or remotely
	String remoteTest = "http://localhost:4444/wd/hub";
	// String remoteTest = "local";

	@Test
	public void testbasicScript2() throws MalformedURLException {

		// Initializing FireFox Driver
		myDriver = Utils.initializeDriver("Firefox", remoteTest, myDriver);

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://www.webmath.com/";

		// Wait for 30 seconds
		myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Open the link
		myDriver.get(baseUrl);

		// Click on element
		myDriver.findElement(By.id("www-content-wrap")).click();

		// Select `Simple Interest` option from dropdown
		new Select(myDriver.findElement(By.id("topicItem"))).selectByVisibleText("Interest, Simple");

		// Click on element
		myDriver.findElement(By.cssSelector("option[value=\"simpinterest.html\"]")).click();

		// Click on element
		myDriver.findElement(By.name("principal")).clear();

		// Click on element
		myDriver.findElement(By.name("principal")).sendKeys("1000");

		// Click on element
		myDriver.findElement(By.name("interest")).clear();

		// Click on element
		myDriver.findElement(By.name("interest")).sendKeys("1");

		// Click on element
		myDriver.findElement(By.name("desired_time")).clear();

		// Click on element
		myDriver.findElement(By.name("desired_time")).sendKeys("5");

		// Click on element
		myDriver.findElement(By.xpath("//input[@value='Find the amount of interest']")).click();

		myDriver.quit();
	}

}