package utils;

import org.apache.log4j.Logger;

public class LogUtils {

	// Initialize Log4j logs
	private static Logger Log = Logger.getLogger("LogUtils");

	// This is to print log for the beginning of the test case, as we usually
	// run so many test cases as a test suite
	public static void startTestCase(String sTestCaseName) {

		Log.info("****************************************************************************************");

		Log.info("****************************************************************************************");

		Log.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");

		Log.info("****************************************************************************************");

		Log.info("****************************************************************************************");

	}

	// This is to print log for the ending of the test case

	public static void endTestCase(String sTestCaseName) {

		Log.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

		Log.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

		Log.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");

		Log.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

		Log.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

	}

	// Need to create these methods, so that they can be called

	public static void info(String message) {

		Log.info(message);

		System.out.println("Step Output : " + message);

		try
		{
			ListenerUtil.getInstance().info(message);
		}
		catch (Exception e) {
			
			
		}

	}

	public static void warn(String message) {

		Log.warn(message);

	}

	public static void error(String message) {

		Log.error(message);

	}

	public static void fatal(String message) {

		Log.fatal(message);

	}

	public static void debug(String message) {

		Log.debug(message);

	}

}
