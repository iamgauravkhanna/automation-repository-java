package raftaar.testautomation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LinearScript {

	public WebDriver myDriver = new FirefoxDriver();
	public WebElement myElement;
	public String myText;
	public WebDriverWait myWait;

	@Test
	public void LinearScriptTest() throws InterruptedException {

		myDriver.get("https://ex1.phix-qa08.demo.hcinternal.net/exchange-admin");

		myDriver.manage().window().maximize();

		myDriver.findElement(By.id("j_username")).click();

		myDriver.findElement(By.id("j_username")).sendKeys("super.admin@hcentive.com");

		myDriver.findElement(By.id("j_password")).click();

		myDriver.findElement(By.id("j_password")).sendKeys("Qwerty12");

		myDriver.findElement(By.id("signInButton")).click();

		myDriver.findElement(
				By.xpath("//*[text()='automation']/ancestor::div[@class='exchange-box']//a[@class='btn-enter']"))
				.click();

		myWait = new WebDriverWait(myDriver, 30);

		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li#userManagement i")));

		myDriver.findElement(By.cssSelector("li#userManagement i")).click();

		myWait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[contains(@href,'exchange-admin/viewandapprove/manageBrokers')]")));

		// myDriver.findElement(By.xpath("//a[contains(@href,'exchange-admin/viewandapprove/manageBrokers')]")).click();

		WebElement element = myDriver
				.findElement(By.xpath("//a[contains(@href,'exchange-admin/viewandapprove/manageBrokers')]"));

		//Actions action = new Actions(myDriver);

		//action.moveToElement(element).click().perform();

		element.click();
		
		myWait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Download Template')]")));

		myText = myDriver.findElement(By.xpath("//a[contains(text(),'Download Template')]")).getAttribute("href");

		System.out.println("Attribute Value : " + myText);
		
		myDriver.findElement(By.xpath("//a[contains(text(),'Download Template')]")).click();
	}

	@AfterMethod
	public void tearDown() {

		myDriver.close();
	}
}