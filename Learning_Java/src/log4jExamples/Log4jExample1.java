package log4jExamples;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Log4jExample1 {

	private static WebDriver driver;

	private static Logger Log = Logger.getLogger(Log4jExample1.class.getName());

	public static void main(String[] args) {

		DOMConfigurator.configure("log4j.xml");

		// Create a new instance of the Firefox driver

		driver = new FirefoxDriver();

		Log.info("New driver instantiated");

		// Put a Implicit wait, this means that any search for elements on the
		// page could take the time the implicit wait is set for before throwing
		// exception

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Log.info("Implicit wait applied on the driver for 10 seconds");

		// Launch the Online Store Website

		driver.get("http://www.onlinestore.toolsqa.com");

		Log.info("Web application launched");

		// Find the element that's ID attribute is 'account'(My Account)

		driver.findElement(By.id("account")).click();

		Log.info("Click action performed on My Account link");

		// Find the element that's ID attribute is 'log' (Username)

		// Enter Username on the element found by above desc.

		driver.findElement(By.id("log")).sendKeys("testuser_1");

		Log.info("Username entered in the Username text box");

		// Find the element that's ID attribute is 'pwd' (Password)

		// Enter Password on the element found by the above desc.

		driver.findElement(By.id("pwd")).sendKeys("Test@123");

		Log.info("Password entered in the Password text box");

		// Now submit the form. WebDriver will find the form for us from the
		// element

		driver.findElement(By.id("login")).click();

		Log.info("Click action performed on Submit button");

		// Print a Log In message to the screen

		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

		// Find the element that's ID attribute is 'account_logout' (Log Out)

		driver.findElement(By.id("account_logout"));

		Log.info("Click action performed on Log out link");

		// Close the driver

		driver.quit();

		Log.info("Browser closed");

	}

}