/*********************************
 
Title  : Loading New Firefox Profile
Author : Gaurav Khanna

 *********************************/

package webdriverScripts.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

public class LoadingNewFirefoxProfile {

	@Test
	public void testloadingNewFirefoxProfile() {

		//
		ProfilesIni allProfiles = new ProfilesIni();

		//
		FirefoxProfile profile = allProfiles.getProfile("Gaurav");

		//
		WebDriver webDriver = new FirefoxDriver(profile);

		//
		webDriver.get("http://not-just-a-tester.blogspot.in");

		//
		System.out.println("Current URL -- " + webDriver.getCurrentUrl());

		//
		System.out.println("Page source ---- ");

		//
		System.out.println(webDriver.getPageSource());

		//
		webDriver.quit();

	}

}
