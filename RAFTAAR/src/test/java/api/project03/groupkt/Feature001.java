package api.project03.groupkt;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import api.project03.groupkt.pageObject.MainRequest;

import utils.BaseTest;

public class Feature001 extends BaseTest {

	MainRequest mainRequestObj;

	@BeforeMethod
	public void setUp() {

		mainRequestObj = new MainRequest();

	}

	@Test
	public void TestCase_001_001() {

		mainRequestObj.verify200ResponseCode();

	}

}