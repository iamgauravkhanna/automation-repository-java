package webdriverScripts;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class SSLCertificatesPreferences {
	
	public static void main(String... args){
		FirefoxProfile profile = new FirefoxProfile();	
		profile.setAssumeUntrustedCertificateIssuer(false);
		profile.setAcceptUntrustedCertificates(false);
		
		FirefoxDriver driver = new FirefoxDriver(profile);
		driver.get("http://www.google.com");
		
	}

}
