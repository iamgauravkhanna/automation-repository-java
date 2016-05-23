package webdriverScripts.others;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadFile {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	@Before
	public void startUp() throws Exception {

		// Creating New Firefox Profile
		FirefoxProfile profile = new FirefoxProfile();

		//
		profile.setPreference("browser.download.folderList", 2);

		// Setting the Default Download Location
		profile.setPreference("browser.download.dir", "C:\\Code");

		// Setting Firefox Preference to accept file with asking
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/msword,application/x-rar-compressed,application/octet-stream,application/csv,text/csv");

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver(profile);

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://it-ebooks.info/book/1125/";
	}

	@Test
	public void DownloadingFileExample() throws Exception {

		// Open the Link
		webDriver.get(baseUrl);

		// Will click on Download Link
		webDriver
				.findElement(By
						.xpath("//html/body/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/table/tbody/tr[11]/td[2]/a"))
				.click();

	}

	@After
	public void shutDown() throws Exception {

		// This will close the browser
		webDriver.quit();
	}

}
