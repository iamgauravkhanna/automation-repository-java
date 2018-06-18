package com.not_just_a_tester;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class BasicScript002 {

	public AndroidDriver androidDriverObj;

	@BeforeClass
	public void setUp() throws MalformedURLException {

		// Created object of DesiredCapabilities class
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set android VERSION desired capability
		capabilities.setCapability("platformVersion", "7.1.1");

		// Set android deviceName desired capability
		capabilities.setCapability("deviceName", "Real Device");

		// Set platformName desired capability.
		capabilities.setCapability("platformName", "Android");

		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appPackage", "com.android.calculator2");

		// This is Launcher activity of your app (you can get it from apk info
		// app)
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		androidDriverObj = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	@Test
	public void test001() {
		
		// locate the Text '2' on the calculator by using By.name()
		WebElement two = androidDriverObj.findElement(By.id("digit_2"));

		// click on webelement
		two.click();

	}

}
