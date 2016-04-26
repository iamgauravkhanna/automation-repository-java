package webdriverScripts.browsers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FirefoxCustomProfile {
	
	public static void main(String... args){
		FirefoxProfile profile = new FirefoxProfile();
		
		FirefoxDriver driver = new FirefoxDriver(profile);
		driver.get("http://www.google.com");
		
	}
}
