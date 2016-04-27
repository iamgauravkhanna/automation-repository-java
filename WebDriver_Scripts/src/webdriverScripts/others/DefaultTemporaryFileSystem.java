package webdriverScripts.others;

import java.io.File;

import org.openqa.selenium.io.TemporaryFilesystem;

public class DefaultTemporaryFileSystem {
	public static void main(String... args) {
		File f = TemporaryFilesystem.getDefaultTmpFS().createTempDir("prefix",
				"suffix");
		System.out.println(f.getAbsolutePath());
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
