/*********************************

Title  : Extracting Links
Author : Gaurav Khanna

 *********************************/

package webdriverScripts.others;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ExtractingLinks {

	//
	WebDriver webDriver = new FirefoxDriver();

	@Test
	public void testextractingLinks() {

		//
		webDriver.get("file:///C:/hcentive-code/local/phix/htmls/empolyer/employers-registration.html");

		//
		List<WebElement> allLinks = webDriver.findElements(By.tagName("a"));

		//
		System.out.println(allLinks.size());

		//
		for (int i = 0; i < allLinks.size(); i++) {

			//
			System.out.println(allLinks.get(i).getText());
		}

		//
		System.out.println("**********************************");

		//
		WebElement footer = webDriver
				.findElement(By.xpath("//*[@id='footer']"));

		//
		List<WebElement> footer_links = footer.findElements(By.tagName("a"));

		//
		for (int i = 0; i < footer_links.size(); i++) {

			//
			System.out.println("Printing Footer Links :");

			//
			System.out.println(footer_links.get(i).getText());
		}

	}

}
