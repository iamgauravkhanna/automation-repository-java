package webdriverScripts.browsers;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.ie.InternetExplorerDriverService;

public class InternetExplorerDriverServiceExample {

	public static void main(String[] args) {

		String exePath = System.getProperty("user.dir") + "\\drivers\\windows\\IEDriverServer.exe";

		InternetExplorerDriverService.Builder serviceBuilder = new InternetExplorerDriverService.Builder();

		// This specifies that sever can pick any available free port to start
		serviceBuilder.usingAnyFreePort();

		// Tell it where you server exe is
		serviceBuilder.usingDriverExecutable(new File(exePath));

		// Specifies the log level of the server
		serviceBuilder.withLogLevel(InternetExplorerDriverLogLevel.TRACE);

		// Specify the log file. Change it based on your system
		serviceBuilder.withLogFile(new File(System.getProperty("user.dir") + "\\logFile.txt"));

		// Create a driver service and pass it to Internet explorer driver
		// instance
		InternetExplorerDriverService service = serviceBuilder.build();

		InternetExplorerDriver driver = new InternetExplorerDriver(service);

		driver.get("http://toolsqa.com");

		// Maximize the window
		driver.manage().window().maximize();

		// Click on Selenium link
		driver.findElement(By.linkText("Selenium")).click();

		// This will close the browser
		driver.quit();
	}
}
