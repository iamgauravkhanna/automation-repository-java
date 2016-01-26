package webdriverScripts;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FrozenPreferences {
	public static void main(String... args){
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.shell.checkDefaultBrowser", true);
		
		FirefoxDriver driver = new FirefoxDriver(profile);
		driver.get("http://www.google.com");
		
	}
}
