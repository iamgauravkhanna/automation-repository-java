package webdriverScripts.browsers;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InternetExplorerDriverCertificates {

	public static void main(String[] args) {

		String exePath = System.getProperty("user.dir") + "\\drivers\\windows\\IEDriverServer.exe";

		// Setting IE Driver Path
		System.setProperty("webdriver.ie.driver", exePath);

		// Create the DesiredCapability object of InternetExplorer
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

		// Settings to Accept the SSL Certificate in the Capability object
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		InternetExplorerDriver driver = new InternetExplorerDriver(capabilities);

		driver.get("https://ex1.phix-qa08.demo.hcinternal.net/individual/individual/homePage");

		// Maximize the window
		driver.manage().window().maximize();

		// This will close the browser
		driver.quit();

	}
}
