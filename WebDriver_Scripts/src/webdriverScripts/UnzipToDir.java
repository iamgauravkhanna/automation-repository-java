package webdriverScripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.Zip;

public class UnzipToDir {
	public static void main(String... args){
		Zip zip = new Zip();
		try {
			zip.unzip(new File("C:\\TmpFS.zip"), new File("C:\\"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
