package webdriverScripts.others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickElement {

	public static void main(String args[]) {

		WebDriver webDriverObj;

		System.setProperty("webdriver.chrome.driver",
				"C:\\office\\code\\automation-repository-java\\learning-selenium\\drivers\\windows\\chromedriver.exe");

		webDriverObj = new ChromeDriver();

		webDriverObj.get("https://in.bookmyshow.com/national-capital-region-ncr");

		webDriverObj.manage().window().maximize();

		webDriverObj.findElement(By.xpath("//button[id='wzrk-cancel']")).click();

		webDriverObj.findElement(By.xpath("//a[text()='OFFERS']")).click();

	}

}
