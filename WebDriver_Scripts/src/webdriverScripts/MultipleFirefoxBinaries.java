package webdriverScripts;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class MultipleFirefoxBinaries {	
	public static void main(String... args){
		FirefoxBinary binary = new FirefoxBinary(new File("C:\\Mozilla Firefox\\firefox.exe"));
		FirefoxProfile profile = new FirefoxProfile();
		
		FirefoxDriver driver = new FirefoxDriver(binary, profile);
		driver.get("http://www.google.com");
	}
}
