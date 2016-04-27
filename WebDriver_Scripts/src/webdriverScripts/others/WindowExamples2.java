package webdriverScripts.others;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowExamples2 {
	public static WebDriver driver;

	@Test

	public void verifySearchInNewWindow() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.navigate().to("http://linkedin.com/");
		driver.manage().window().maximize();
		String mainHandle = driver.getWindowHandle();

		// Wait for the element to be present
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cust-svc-link")));
		driver.findElement(By.linkText("Help Center")).click();

		// Switch to new window and verify the title
		waitForNewWindowAndSwitchToIt(driver);
		String newTitle = getCurrentWindowTitle();
		Assert.assertEquals(newTitle, "LinkedIn Help Center", "New window title is not matching");

		// Verify the text present on the page
		String textOnpage = driver.findElement(By.cssSelector(".welcome")).getText().trim();
		Assert.assertEquals(textOnpage, "Welcome!");

		// Verify search text on the page
		String searchText = "Frequently Asked Questions";
		WebElement searchInputBox = driver.findElement(By.id("kw"));
		searchInputBox.sendKeys(searchText);

		WebElement searchButton = driver.findElement(By.cssSelector(".button.leftnoround.blue"));
		searchButton.click();

		WebElement resultedElement = driver.findElement(By.cssSelector(".rn_Element2"));
		String resultedText = resultedElement.getText().trim();
		System.out.println(resultedText);
		Assert.assertTrue(resultedText.contains(searchText), "Search successfull");

		closeAllOtherWindows(driver, mainHandle);

	}

	public static String getMainWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public static String getCurrentWindowTitle() {
		String windowTitle = driver.getTitle();
		return windowTitle;
	}

	public static boolean closeAllOtherWindows(WebDriver driver, String openWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(openWindowHandle)) {
				driver.switchTo().window(currentWindowHandle);
				driver.close();
			}
		}

		driver.switchTo().window(openWindowHandle);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public static void waitForNewWindowAndSwitchToIt(WebDriver driver) throws InterruptedException {
		String cHandle = driver.getWindowHandle();
		String newWindowHandle = null;
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Wait for 20 seconds for the new window and throw exception if not
		// found
		for (int i = 0; i < 20; i++) {
			if (allWindowHandles.size() > 1) {
				for (String allHandlers : allWindowHandles) {
					if (!allHandlers.equals(cHandle))
						newWindowHandle = allHandlers;
				}
				driver.switchTo().window(newWindowHandle);
				break;
			} else {
				Thread.sleep(1000);
			}
		}
		if (cHandle == newWindowHandle) {
			throw new RuntimeException("Time out - No window found");
		}
	}
}

// Reference :
// http://www.seleniumeasy.com/selenium-tutorials/perform-operations-on-new-window-using-webdriver