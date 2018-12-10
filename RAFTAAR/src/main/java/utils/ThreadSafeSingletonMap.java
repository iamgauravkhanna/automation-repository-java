package utils;

import java.util.HashMap;

public class ThreadSafeSingletonMap {

	private HashMap<String, String> map = new HashMap<String, String>();

	private static ThreadSafeSingletonMap instanceVariable = null;

	private ThreadSafeSingletonMap() {
	}

	public synchronized static ThreadSafeSingletonMap getInstance() {

		if (instanceVariable == null)

			instanceVariable = new ThreadSafeSingletonMap();

		return instanceVariable;

	}

	public void put(String s, String d) {

		map.put(s, d);

	}

}
