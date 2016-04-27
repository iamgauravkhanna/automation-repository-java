package webdriverScripts.browsers;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class InternetExplorerDriverService2 {

	public class LaunchingIE {

		public void main(String[] args) {

			String exePath = "C:\\Users\\abc\\Documents\\IEDriverServer\\IEDriverServer.exe";
			InternetExplorerDriverService.Builder serviceBuilder = new InternetExplorerDriverService.Builder();
			// This specifies that sever can
			// pick any available free port
			// to start
			serviceBuilder.usingAnyFreePort();
			// Tell it
			// where
			// you
			// server
			// exe
			// is
			serviceBuilder.usingDriverExecutable(new File(exePath));
			// Specifies
			// the
			// log
			// level
			// of
			// the
			// server
			serviceBuilder.withLogLevel(InternetExplorerDriverLogLevel.TRACE);
			// Specify
			// the
			// log
			// file.
			// Change
			// it
			// based
			// on
			// your
			// system
			serviceBuilder.withLogFile(new File("C:\\Users\\abc\\Documents\\logFile.txt"));
			// Create
			// a
			// driver
			// service
			// and
			// pass
			// it
			// to
			// Internet
			// explorer
			// driver
			// instance
			InternetExplorerDriverService service = serviceBuilder.build();
			InternetExplorerDriver driver = new InternetExplorerDriver(service);
			driver.get("http://toolsqa.com");
		}

	}
}
