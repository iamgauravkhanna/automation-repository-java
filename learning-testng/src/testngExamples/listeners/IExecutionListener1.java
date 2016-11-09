package testngExamples.listeners;

import org.testng.IExecutionListener;

public class IExecutionListener1 implements IExecutionListener {
	private long startTime;

	@Override
	public void onExecutionStart() {
		startTime = System.currentTimeMillis();
		System.out.println("TestNG is going to start" + " at " + System.nanoTime() + "\n");
	}

	@Override
	public void onExecutionFinish() {
		System.out.println("TestNG has finished, took around " + (System.currentTimeMillis() - startTime) + " ms");
	}
}
