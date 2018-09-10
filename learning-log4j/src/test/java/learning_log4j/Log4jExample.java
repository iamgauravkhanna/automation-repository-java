package learning_log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jExample {

	static Logger log = Logger.getLogger(Log4jExample.class.getName());

	public static void main(String[] args) {

		PropertyConfigurator.configure("log4j.properties");

		log.debug("Hello this is a debug message");

		log.info("Hello this is an info message");

	}

}