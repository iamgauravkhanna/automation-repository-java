/*
 * @Author : Gaurav Khanna 
 */

package webdriverScripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.Test;

public class BuildingChromeDriverService {

	@Test
	public void testBuildingChromeDriverService() {

		// Start the ChromeDriver Server
		System.setProperty("webdriver.chrome.driver",
				"C:\\chromedriver_win32_2.2\\chromedriver.exe");

		ChromeDriverService.Builder builder = new ChromeDriverService.Builder();

		ChromeDriverService srvc = builder
				.usingDriverExecutable(
						new File("C:\\chromedriver_win32_2.2\\chromedriver.exe"))
				.usingPort(65423).build();

		try {

			srvc.start();

		} catch (IOException e) {

			e.printStackTrace();

		}

		// Execute your test-script commands
		WebDriver webDriver = new ChromeDriver(srvc);

		webDriver.get("http://www.google.com");

		WebElement searchBox = webDriver.findElement(By.name("q"));

		searchBox.sendKeys("Chrome Driver");

		// Stop the Server
		webDriver.quit();

		srvc.stop();

	}
}
