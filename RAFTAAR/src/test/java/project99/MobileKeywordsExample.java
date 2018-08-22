package project99;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BaseActivity;
import utils.DriverUtil;

public class MobileKeywordsExample extends BaseActivity {

	DriverUtil driverUtilObj;

	@BeforeMethod
	public void StartUp() {

		driverUtilObj = new DriverUtil();

		androidDriverObj = driverUtilObj.initializeAndroidDriverObj();

	}

	@Test(enabled = true, description = "")
	public void TC001() {

	}

	@AfterMethod
	public void TearDown() {

		androidDriverObj.quit();

	}

}