/*********************************
 
Title  : Get Attributes
Author : Gaurav Khanna

 *********************************/

package webdriverScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GetAttributes {

	WebDriver webDriver = new FirefoxDriver();

	@Test
	public void get_Attributes() {

		//
		webDriver.get("http://www.google.com");

		//
		WebElement searchButton = webDriver.findElement(By.name("btnK"));

		//
		System.out.println("Name of the button is: "
				+ searchButton.getAttribute("name"));

		//
		System.out.println("Id of the button is: "
				+ searchButton.getAttribute("id"));

		//
		System.out.println("Class of the button is: "
				+ searchButton.getAttribute("class"));

		//
		System.out.println("Label of the button is: "
				+ searchButton.getAttribute("aria-  label"));

	}

}