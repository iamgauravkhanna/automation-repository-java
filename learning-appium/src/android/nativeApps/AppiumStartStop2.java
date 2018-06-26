package android.nativeApps;

import io.appium.java_client.android.AndroidDriver;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppiumStartStop2 {
	static AndroidDriver driver;
	// Set path of your node.exe file. Set your path.
	// Progra~1 represents Program Files folder.
	String nodePath = "C:/appium/Appium/node.exe";
	// Set path of your appium.js file. Set your path.
	String appiumJSPath = "C:/appium/Appium/node_modules/appium/bin/appium.js";

	// This method Is responsible for starting appium server.
	public void appiumStart() throws IOException, InterruptedException {
		// Created object of apache CommandLine class.
		// It will start command prompt In background.
		CommandLine command = new CommandLine("cmd");
		// Add different arguments In command line which requires to start
		// appium server.
		command.addArgument("/c");
		command.addArgument(nodePath);
		command.addArgument(appiumJSPath);
		// Set Server address
		command.addArgument("--address");
		command.addArgument("127.0.0.1");
		// Set Port
		command.addArgument("--port");
		command.addArgument("4723");
		command.addArgument("--no-reset");
		command.addArgument("--log");
		// Set path to store appium server log file.
		command.addArgument("C://appium//appiumLogs.txt");
		// Execute command line arguments to start appium server.
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		executor.execute(command, resultHandler);
		// Wait for 15 minutes so that appium server can start properly before
		// going for test execution.
		// Increase this time If face any error.
		Thread.sleep(15000);
	}

	// This method Is responsible for stopping appium server.
	public static void appiumStop() throws IOException {
		// Add different arguments In command line which requires to stop appium
		// server.
		CommandLine command = new CommandLine("cmd");
		command.addArgument("/c");
		command.addArgument("taskkill");
		command.addArgument("/F");
		command.addArgument("/IM");
		command.addArgument("node.exe");
		// Execute command line arguments to stop appium server.
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		executor.execute(command, resultHandler);
	}

	@BeforeTest
	public void setUp() throws Exception {
		// Start appium server.
		appiumStart();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Emulator");
		capabilities.setCapability("browserName", "Android");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void ScrollToTab() {

		// Click on Views.
		driver.findElement(By.name("Views")).click();
	}

	@AfterTest
	public void End() throws IOException {
		driver.quit();
		// Stop appium server when test Is ended.
		appiumStop();
	}
}