package webdriverScripts.browsers;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorerDriverCertificates2 {

	public static void main(String[] args) {

		String exePath = System.getProperty("user.dir") + "\\drivers\\windows\\IEDriverServer.exe";

		// Setting IE Driver Path
		System.setProperty("webdriver.ie.driver", exePath);

		InternetExplorerDriver driver = new InternetExplorerDriver();

		driver.get("https://ex1.phix-qa08.demo.hcinternal.net/individual/individual/homePage");

		driver.navigate().to("javascript:document.getElementById('overridelink').click()");

		// This will close the browser
		driver.quit();

	}
}
