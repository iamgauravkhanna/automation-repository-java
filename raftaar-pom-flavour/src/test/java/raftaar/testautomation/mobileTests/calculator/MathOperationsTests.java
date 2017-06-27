package raftaar.testautomation.mobileTests.calculator;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import raftaar.testautomation.mobile.pageObjects.calculator.HomeActivity;
import raftaar.testautomation.utils.BaseTest;
import raftaar.testautomation.utils.DriverUtil;

public class MathOperationsTests extends BaseTest {

	AndroidDriver<?> androidDriverObj;
	DriverUtil iDriverUtil;
	HomeActivity homeActivityObj;

	@BeforeTest
	public void setUp() {

		//
		iDriverUtil = new DriverUtil();

		//
		androidDriverObj = iDriverUtil.initializeAndroidDriverObj();

		//
		homeActivityObj = new HomeActivity(androidDriverObj);
	}

	@Test(enabled = false)
	public void AdditionTest() {

		//
		homeActivityObj.clickDigit2();

		//
		homeActivityObj.clickSymbolPlus();

		//
		homeActivityObj.clickDigit4();

		//
		homeActivityObj.clickEqualsTo();

		//
		homeActivityObj.printResult();

		//
		homeActivityObj.takeScreenShot();

	}

	@AfterTest
	public void tearDown() {

		androidDriverObj.quit();

	}

}
