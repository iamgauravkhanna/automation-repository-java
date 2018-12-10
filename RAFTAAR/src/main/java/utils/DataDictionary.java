package utils;

import java.util.HashMap;

public class DataDictionary {

	private static DataDictionary instance = null;

	static ThreadLocal<HashMap<String, String>> dataDictionaryMap = new ThreadLocal<HashMap<String, String>>() {

		protected HashMap<String, String> initialValue() {

			System.out.println("Intializing DataDictionary Object");

			return new HashMap<String, String>();
		}
	};

	public static DataDictionary getInstance() {

		if (instance == null) {

			instance = new DataDictionary();

		}

		System.out.println("Instance ID : " + instance.hashCode());
		
		System.out.println("Thread Name : " + Thread.currentThread().getName());

		return instance;

	}

	public void putKey(String key, String value) {

		dataDictionaryMap.get().put(key, value);

		System.out.println("putKey : " + key + " => " + value);
	}

	public void putAllKeys(HashMap<String, String> map) {

		dataDictionaryMap.get().putAll(map);
	}

	public String getKey(String key) {

		String value = dataDictionaryMap.get().get(key);

		System.out.println("getKey : " + key + " => " + value);

		return value;

	}

	public HashMap<String, String> getDataDictionary() {

		return dataDictionaryMap.get();

	}

}