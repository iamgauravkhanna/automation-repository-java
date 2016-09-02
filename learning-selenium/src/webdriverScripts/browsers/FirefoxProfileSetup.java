/*********************************
 
Title  : Setting Firefox Profile
Author : Gaurav Khanna

 *********************************/

package webdriverScripts.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

public class FirefoxProfileSetup {

	@Test
	public void testsettingFirefoxProfile() {

		//
		ProfilesIni listprofiles = new ProfilesIni();

		//
		FirefoxProfile profile = listprofiles.getProfile("grv");

		//
		FirefoxProfile profile1 = listprofiles.getProfile("default");

		//
		WebDriver webDriver = new FirefoxDriver(profile);

		//
		WebDriver webDriver1 = new FirefoxDriver(profile1);

		//
		webDriver.get("http://not-just-a-tester.blogspot.in");

		//
		webDriver1.get("http://www.gmail.com");

		//
		System.out.println(webDriver.getTitle());

		//
		System.out.println(webDriver1.getTitle());

		//
		webDriver.quit();

	}

}
