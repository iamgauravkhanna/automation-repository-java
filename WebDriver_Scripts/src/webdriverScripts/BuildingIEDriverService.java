/*
 * @Author : Gaurav Khanna 
 */

package webdriverScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class BuildingIEDriverService {

	@Test
	public void testBuildingIEDriverService() {

		System.setProperty("webdriver.ie.driver",
				"C:\\IEDriverServer_Win32_2.35.3\\IEDriverServer.exe");

		InternetExplorerDriverService.Builder builder = new InternetExplorerDriverService.Builder();

		InternetExplorerDriverService srvc = builder.usingPort(5555)
				.withHost("127.0.0.1").build();

		DesiredCapabilities ieCapabilities = DesiredCapabilities
				.internetExplorer();
		ieCapabilities
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);

		WebDriver webDriver = new InternetExplorerDriver(srvc, ieCapabilities);

		webDriver.get("http://www.google.com");

		webDriver.quit();

	}
}
