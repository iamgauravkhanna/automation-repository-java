package utils;

import org.testng.IExecutionListener;

public class CustomListener01 implements IExecutionListener {

	public void onExecutionFinish() {

		LogManager.info("Running Method : onExecutionFinish");

	}

	public void onExecutionStart() {

		LogManager.info("Running Method : onExecutionStart");

	}

}