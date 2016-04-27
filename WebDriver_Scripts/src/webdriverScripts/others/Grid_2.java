package webdriverScripts.others;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Grid_2 {

	WebDriver webDriver;
	String baseUrl, nodeUrl;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		baseUrl = "http://www.google.com";
		nodeUrl = "http://10.10.6.135:4449/wd/hub/";
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.LINUX);
		webDriver = new RemoteWebDriver(new URL(nodeUrl), capability);
	}

	@Test
	public void testGrid_2() {
		webDriver.get(baseUrl);
		Assert.assertEquals("Google", webDriver.getTitle());
		System.out.println("Test Complete");
	}

	@AfterTest
	public void tearDown() {

		webDriver.quit();

	}

}