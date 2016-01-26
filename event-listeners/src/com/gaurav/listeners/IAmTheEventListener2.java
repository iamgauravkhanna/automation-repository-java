package com.gaurav.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class IAmTheEventListener2 extends AbstractWebDriverEventListener {

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("IAmTheEventListener2: Before Navigate To: " + url
				+ " and Current url is: " + driver.getCurrentUrl());

	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("IAmTheEventListener2: After Navigate To: " + url
				+ " and Current url is: " + driver.getCurrentUrl());

	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		System.out
				.println("IAmTheEventListener2: Before Navigate Back. Right now I'm at "
						+ driver.getCurrentUrl());

	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out
				.println("IAmTheEventListener2: After Navigate Back. Right now I'm at "
						+ driver.getCurrentUrl());

	}
}
