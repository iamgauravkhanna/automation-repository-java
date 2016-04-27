package webdriverScripts.others;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;

public class MakeWritable {
	public static void main(String... args){
		try {
			FileHandler.makeWritable(new File("C:\\Src\\file1.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
