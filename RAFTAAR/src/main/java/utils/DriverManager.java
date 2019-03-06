package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> selenium_driver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return selenium_driver.get();
	}

	public static void setWebDriver(WebDriver driver) {
		selenium_driver.set(driver);
	}

	public static void closeDriver() {
		if (selenium_driver.get() != null) {
			selenium_driver.get().quit();			
		}
	}

}
