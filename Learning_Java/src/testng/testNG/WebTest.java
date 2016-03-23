package testng.testNG;

import org.testng.annotations.Test;

public class WebTest {

	private int m_numberOfTimes;

	public WebTest(int numberOfTimes) {
		m_numberOfTimes = numberOfTimes;
	}

	@Test
	public void testServer() {
		for (int i = 0; i < m_numberOfTimes; i++) {
			
			System.out.println(i);
		}
	}

}
