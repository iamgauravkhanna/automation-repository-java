/*
 * @Author : Gaurav Khanna 
 */

package webdriverScripts;

import java.io.File;

import org.openqa.selenium.io.TemporaryFilesystem;
import org.testng.annotations.Test;

public class ChangeTmpFS {

	@Test
	public void testChangeTmpFS() {

		TemporaryFilesystem tmpFS = TemporaryFilesystem
				.getTmpFsBasedOn(new File("C:\\TmpFS"));

		File f = tmpFS.createTempDir("prefix1", "suffix1");

		System.out.println(f.getAbsolutePath());

		try {

			Thread.sleep(30000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
