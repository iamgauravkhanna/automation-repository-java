package webdriverScripts.DesignPatterns;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

	protected WebDriver driver;

	protected abstract void startService();

	protected abstract void stopService();

	protected abstract void createDriver();

	public void quitDriver() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}

	}

	public WebDriver getDriver() {
		if (null == driver) {
			System.out.println("Driver is NULL");
			startService();
			createDriver();
		}
		return driver;
	}
}