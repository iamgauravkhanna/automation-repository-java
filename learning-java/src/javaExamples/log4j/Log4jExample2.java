package javaExamples.log4j;

import java.util.Enumeration;

import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class Log4jExample2 {

	// All the loggers that can be used
	static Logger mainLogger = LogManager.getLogger(Log4jExample2.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BasicConfigurator.configure();
		ConsoleAppender appender = new ConsoleAppender();
		appender.activateOptions();
		PatternLayout layoutHelper = new PatternLayout();
		layoutHelper.setConversionPattern("%-5p [%t]: %m%n");
		layoutHelper.activateOptions();
		// mainLogger.getAppender("ConsoleAppender").setLayout(layoutHelper);
		appender.setLayout(layoutHelper);
		mainLogger.addAppender(appender);
		// Create a console appender and attach it to our mainLogger
		mainLogger.info("Pattern 1 is displayed like this");
		layoutHelper.setConversionPattern("%C %m%n");
		mainLogger.info("Pattern 2 is displayed like this");

	}

}
