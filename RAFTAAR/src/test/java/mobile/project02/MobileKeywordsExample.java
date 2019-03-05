package mobile.project02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseActivity;
import utils.BrowserFactory;

public class MobileKeywordsExample extends BaseActivity {

	BrowserFactory driverUtilObj;

	@BeforeMethod
	public void StartUp() {

		driverUtilObj = new BrowserFactory();

		androidDriverObj = driverUtilObj.initializeAndroidDriverObj();

	}

	@Test(enabled = true, description = "Native App - Calculator Example")
	public void TC001() {

		openActivity("com.android.calculator2", "com.android.calculator2.Calculator");

		clickSimple(By.id("digit_2"));

		clickSimple(By.id("op_add"));

		clickSimple(By.id("digit_4"));

		clickSimple(By.id("eq"));

		String result = getText(By.id("result"));

		System.out.println("Number sum result is : " + result + "\n");

	}

	@AfterMethod
	public void TearDown() {

		androidDriverObj.quit();

	}

}