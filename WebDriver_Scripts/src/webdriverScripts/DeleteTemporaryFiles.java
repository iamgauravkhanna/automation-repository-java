package webdriverScripts;

import java.io.File;

import org.openqa.selenium.io.TemporaryFilesystem;

public class DeleteTemporaryFiles {
	public static void main(String... args) {
		File f1 = TemporaryFilesystem.getDefaultTmpFS()
				.createTempDir("prefix1", "suffix1");
		System.out.println("File1: "+f1.getAbsolutePath());
		
		File f2 = TemporaryFilesystem.getDefaultTmpFS()
				.createTempDir("prefix2", "suffix2");
		System.out.println("File1: "+f2.getAbsolutePath());
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TemporaryFilesystem.getDefaultTmpFS().deleteTemporaryFiles();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
