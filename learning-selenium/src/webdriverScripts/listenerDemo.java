package webdriverScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class listenerDemo {

	public static void main(String[] args) {

		System.out.println("Started");

		WebDriver driver = new FirefoxDriver();

		EventFiringWebDriver event1 = new EventFiringWebDriver(driver);

		webDriverListenersExample handle = new webDriverListenersExample();

		event1.register(handle);

		event1.navigate().to("http://www.facebook.com");

		event1.findElement(By.id("email")).sendKeys("asdsadsa");

		event1.findElement(By.id("loginbutton")).click();

		event1.quit();

		event1.unregister(handle);

		System.out.println("End");
	}

}