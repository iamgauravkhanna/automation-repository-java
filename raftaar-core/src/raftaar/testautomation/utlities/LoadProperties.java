package raftaar.testautomation.utlities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * This class will read the properties file which holds the data in key,value pair
 * 
 * @author unknown
 */
public class LoadProperties
{

	/**
	 * Loads all the properties from service.properties file and store them in Map
	 * 
	 * @return map that contains the properties as key/value pairs
	 * @throws Exception
	 */
	public static Map<String, String> getProperties() throws Exception
	{
		Properties properties = new Properties();
		FileInputStream resourceStream = new FileInputStream("./resources/service.properties");
		try
		{
			properties.load(resourceStream);
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			resourceStream.close();
		}

		Map<String, String> propertiesMap = new HashMap<>();
		System.out.println("reading contents of property file");
		for (String key : properties.stringPropertyNames())
		{
			String value = properties.getProperty(key);
			System.out.println(key + " => " + value);
			propertiesMap.put(key, value);
		}
		return Collections.unmodifiableMap(propertiesMap);
	}
}
