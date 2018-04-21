package utils;

import org.testng.IExecutionListener;

public class CustomListener01 implements IExecutionListener {

	long startTime;
	long endTime;

	public void onExecutionFinish() {

		startTime = System.currentTimeMillis();

		LogUtils.info("Running Method : onExecutionFinish with Start Time : " + startTime);

	}

	public void onExecutionStart() {

		endTime = System.currentTimeMillis();

		LogUtils.info("Running Method : onExecutionStart with End Time :  " + endTime);

		LogUtils.info("Total Time Taken by Test Case : " + (endTime - startTime));

	}

}