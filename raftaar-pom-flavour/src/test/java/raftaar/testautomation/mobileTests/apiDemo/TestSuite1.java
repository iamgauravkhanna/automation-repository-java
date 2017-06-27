package raftaar.testautomation.mobileTests.apiDemo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import raftaar.testautomation.mobile.pageObjects.apiDemo.MainActivity;
import raftaar.testautomation.utils.BaseTest;
import raftaar.testautomation.utils.DriverUtil;

public class TestSuite1 extends BaseTest {

	AndroidDriver<?> androidDriverObj;
	DriverUtil iDriverUtil;
	MainActivity mainActivityObj;

	@BeforeTest
	public void setUp() {

		//
		iDriverUtil = new DriverUtil();

		//
		androidDriverObj = iDriverUtil.initializeAndroidDriverObj();

		//
		mainActivityObj = new MainActivity(androidDriverObj);
	}

	@Test(enabled = true)
	public void AdditionTest() {

		//
		mainActivityObj.clickViews();

		//
		mainActivityObj.clickSeekBar();

		//
		mainActivityObj.dragSeekBarToRight(60);

	}

	@AfterTest
	public void tearDown() {

		androidDriverObj.quit();

	}

}
