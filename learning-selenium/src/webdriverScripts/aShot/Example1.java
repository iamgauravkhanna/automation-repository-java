package webdriverScripts.aShot;

import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Example1 {

	public static void main(String args[]) throws Exception {

		//System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver.exe");
		
		WebDriverManager.firefoxdriver().setup();

		WebDriver driver = new FirefoxDriver();

		driver.get("http://demo.automationtesting.in/Register.html");

		Thread.sleep(2000);

		WebElement webElement = driver.findElement(By.cssSelector("#imagetrgt"));

		Screenshot screenshot = new AShot().takeScreenshot(driver, webElement);

		ImageIO.write(screenshot.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "\\ElementScreenshot.png"));

		Thread.sleep(2000);

		driver.quit();
	}

}
