package utils;

import java.util.HashMap;

public class TestDataWriter {

	private static TestDataWriter instance = null;

	static ThreadLocal<HashMap<String, String>> dataDictionaryMap = new ThreadLocal<HashMap<String, String>>() {

		protected HashMap<String, String> initialValue() {

			LogUtils.info("Intializing TestDataWriter Object");

			return new HashMap<String, String>();
		
		}
	};

	public static TestDataWriter getInstance() {

		if (instance == null) {

			instance = new TestDataWriter();

		}
		
		LogUtils.info("Thread Name : " + Thread.currentThread().getName() + " & " + "Instance ID : " + instance.hashCode());

		return instance;

	}

	public void putKey(String key, String value) {

		dataDictionaryMap.get().put(key, value);

		LogUtils.info("putKey : " + key + " => " + value);
	}

	public void putAllKeys(HashMap<String, String> map) {
		
		LogUtils.info("Putting All Keys");

		dataDictionaryMap.get().putAll(map);
	}

	public String getKey(String key) {

		String value = dataDictionaryMap.get().get(key);

		LogUtils.info("getKey : " + key + " => " + value);

		return value;

	}

	public HashMap<String, String> getDataDictionary() {
		
		LogUtils.info("================== Returning Data Dictionary ==================");

		return dataDictionaryMap.get();

	}

}