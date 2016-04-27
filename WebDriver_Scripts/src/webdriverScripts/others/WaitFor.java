/*
 * @Author : Gaurav Khanna 
 */

package webdriverScripts.others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitFor {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring variable 'baseUrl' of String Type
	String baseUrl;

	@Test
	public void testbasicScript() {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://book.theautomatedtester.co.uk";

		// Open the link
		webDriver.get(baseUrl);

		// Maximize browser window
		webDriver.manage().window().maximize();

		try
		{
		// Wait for Element
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		//WebElement data = By.linkText("Chapter1");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Chapter1")));
		//webDriver.findElement(By.linkText("Chapter1")).click();
		System.out.println("Wait is Over...!");
		}
		catch (Exception e)
		{
			System.out.println("Exception Occured : " + e);
		}
		
		// This will close the browser
		webDriver.quit();
	}
}
