package webdriver_examples;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TakeScreenShotExample {
	
	public static void main(String [] args) throws IOException {
		
		System.setProperty("webdriver.gecko.driver", "resources/drivers/geckodriver.exe");
		
		WebDriver webDriverObj = new FirefoxDriver();
		
		webDriverObj.get("https://www.google.com");
		
		//webDriverObj.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		File fileObj = ((TakesScreenshot)webDriverObj).getScreenshotAs(OutputType.FILE);
		
		String screenShotObj = ((TakesScreenshot)webDriverObj).getScreenshotAs(OutputType.BASE64) ;
		
		File fileBase64Obj = OutputType.FILE.convertFromBase64Png(screenShotObj);
		
		FileUtils.copyFile(fileObj, new File("resources/screenshot1.png"),true);
		
		FileUtils.copyFile(fileBase64Obj, new File("resources/screenshot2.png"),true);
		
		webDriverObj.quit();
		
		
	}

}
