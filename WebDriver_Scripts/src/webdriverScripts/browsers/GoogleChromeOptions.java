package webdriverScripts.browsers;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleChromeOptions {
	public static void main(String... args){
		//Start the ChromeDriver Server
		System.setProperty("webdriver.chrome.driver", 
				"C:\\chromedriver_win32_2.2\\chromedriver.exe");
		ChromeDriverService.Builder builder =  new ChromeDriverService.Builder();
		ChromeDriverService srvc = builder.usingDriverExecutable(new File("C:\\chromedriver_win32_2.2\\chromedriver.exe"))
							.usingPort(65423).build();
		try {
			srvc.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Chrome Options
		ChromeOptions opts = new ChromeOptions();
		opts.addExtensions(new File("C:\\firebug.crx"));
		
		//Execute your test-script commands
		WebDriver driver = new ChromeDriver(srvc, opts);
		driver.get("http://www.google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Chrome Driver");
		
		//Stop the Server
		//driver.quit();
		//srvc.stop();
		
	}
}
