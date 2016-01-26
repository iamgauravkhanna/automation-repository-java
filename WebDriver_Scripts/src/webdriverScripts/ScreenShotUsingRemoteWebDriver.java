package webdriverScripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ScreenShotUsingRemoteWebDriver {
	public static void main(String... args){
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("firefox");
		WebDriver remoteWD = null;
		try {
			remoteWD = 
					new RemoteWebDriver(new URL("http://<remote-webdriver-ip>:4444/wd/hub"),capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		remoteWD.get("http://www.google.com");
		WebElement element = remoteWD.findElement(By.name("q"));
		element.sendKeys("Packt Publishing");
		
		remoteWD = new Augmenter().augment(remoteWD);
		File scrFile = ((TakesScreenshot)remoteWD).getScreenshotAs(OutputType.FILE);
        System.out.println(scrFile.getAbsolutePath());
	}
}
