/*
 * @Author : Gaurav Khanna 
 */

package webdriverScripts.others;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class AddExtensionToProfile {

	@Test
	public AddExtensionToProfile() {

		FirefoxProfile profile = new FirefoxProfile();
		try {

			profile.addExtension(new File("C:\\firebug-1.12.0-fx.xpi"));

		} catch (IOException e) {

			e.printStackTrace();

		}

		new FirefoxDriver(profile);

	}

}
