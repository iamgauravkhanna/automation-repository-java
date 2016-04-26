/*********************************
 
Title  : Set Firefox Profile Preference
Author : Gaurav Khanna

 *********************************/

package webdriverScripts.browsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class SetFirefoxProfilePreference {

	//
	WebDriver webDriver;

	@Test
	public void testsetFirefoxProfilePreference() throws InterruptedException {

		//
		FirefoxProfile profile = new FirefoxProfile();

		//
		profile.setPreference("browser.startup.homepage",
				"http://book.theautomatedtester.co.uk/chapter4");

		//
		webDriver = new FirefoxDriver(profile);

		//
		Thread.sleep(5000);

		//
		WebElement element = webDriver.findElement(By.id("nextBid"));

		//
		element.sendKeys("100");

		//
		webDriver.quit();

	}

}
