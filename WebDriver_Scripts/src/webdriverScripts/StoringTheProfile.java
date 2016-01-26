package webdriverScripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class StoringTheProfile {
	
	public static void main(String... args){
		FirefoxProfile profile = new FirefoxProfile();
		String json="";
		try {
			profile.addExtension(new File("C:\\firebug-1.12.0-fx.xpi"));
			json = profile.toJson();
			System.out.println(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			FirefoxDriver driver = new FirefoxDriver(FirefoxProfile.fromJson(json));
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}

}
