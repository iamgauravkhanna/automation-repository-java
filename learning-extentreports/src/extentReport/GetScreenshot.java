package extentReport;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenshot {

	public static String getTheScreenshot(WebDriver driver, String screenshotName) throws Exception {

		// below line is just to append the date format with the screenshot name to
		// avoid duplicate names
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "\\FailedTestsScreenshots\\" + screenshotName + dateName
				+ ".png";
		
		System.out.println(destination);
		
		File finalDestination = new File(destination);
		
		FileUtils.copyFile(source, finalDestination,true);

		// Returns the captured file path
		return destination;
	}
}