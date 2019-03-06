package utils;

import java.lang.reflect.Method;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	private Logger logger = LogManager.getLogger(this.getClass());

	@BeforeMethod
	public void handleTestMethodName(Method method) {
		String methodName = method.getName();
		logger.info("Ready to run test case: " + methodName);

		if (DriverManager.getDriver() == null) {
			DriverManager.setWebDriver(DriverFactory.createInstance());
		}
	}
}
