package extentReport;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.*;
import org.testng.annotations.*;

/**
 * Created by shrofs on 7/16/2015.
 */
public class GoogleTest {
    private WebDriver driver;

    @Test
    public void googleAssertPass() {
        driver = new FirefoxDriver();
        driver.get("http://google.com");

        Boolean isFound = IsElementPresent(driver, By.cssSelector("input[value*='Google Search']"));

        Assert.assertTrue(isFound);
    }

    @Test
    public void googleAssertFail() {
        driver = new FirefoxDriver();
        driver.get("http://google.com");

        Boolean isFound = IsElementPresent(driver, By.cssSelector("input[value*='Googl Search']"));

        Assert.assertTrue(isFound);
    }

    private Boolean IsElementPresent(WebDriver driver, By by) {
        try
        {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e) { return false; }
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}