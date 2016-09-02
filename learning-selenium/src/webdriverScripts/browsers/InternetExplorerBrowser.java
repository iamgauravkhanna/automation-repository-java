package webdriverScripts.browsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class InternetExplorerBrowser {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	@Test
	public void testusingInternetExplorerBrowser() {

		String exePath = System.getProperty("user.dir") + "\\drivers\\windows\\IEDriverServer.exe";

		// Setting IE Driver Path
		System.setProperty("webdriver.ie.driver", exePath);

		// Initializing IE Browser
		webDriver = new InternetExplorerDriver();

		// Assigning URL to variable baseUrl
		baseUrl = "http://not-just-a-tester.blogspot.in";

		// Open the link
		webDriver.get(baseUrl);

		// Maximize the window
		webDriver.manage().window().maximize();

		// Click on Selenium link
		webDriver.findElement(By.linkText("Selenium")).click();

		// This will close the browser
		webDriver.quit();

	}

}
