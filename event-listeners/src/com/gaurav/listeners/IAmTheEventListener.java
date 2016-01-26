package com.gaurav.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class IAmTheEventListener implements WebDriverEventListener {

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("IAmTheEventListener: Before Navigate To: " + url
				+ " and Current url is: " + driver.getCurrentUrl());

	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("IAmTheEventListener: After Navigate To: " + url
				+ " and Current url is: " + driver.getCurrentUrl());

	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		System.out
				.println("IAmTheEventListener: Before Navigate Back. Right now I'm at "
						+ driver.getCurrentUrl());

	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out
				.println("IAmTheEventListener: After Navigate Back. Right now I'm at "
						+ driver.getCurrentUrl());

	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub

	}

}
