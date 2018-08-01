package webdriverScripts.webElements;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import webdriverScripts.utils.Utils;

public class GetTagName {

	// Declaring variable 'myDriver' of WebDriver Type
	WebDriver myDriver;

	// Declaring variable 'baseUrl' of String Type
	String baseUrl;

	// Declaring variable 'remoteTest' of String Type to determine if test needs
	// to run locally or remotely
	String remoteTest = "http://localhost:4444/wd/hub";
	// String remoteTest = "local";

	@Test
	public void testgetTagName() throws MalformedURLException {

		myDriver = Utils.initializeDriver("Firefox", remoteTest, myDriver);

		//
		myDriver.get("http://www.google.com");

		//
		WebElement searchButton = myDriver.findElement(By.name("btnK"));

		//
		System.out.println(searchButton.getTagName());
	}
}
