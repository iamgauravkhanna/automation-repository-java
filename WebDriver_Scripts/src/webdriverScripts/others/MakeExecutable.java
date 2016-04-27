package webdriverScripts.others;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;

public class MakeExecutable {
	public static void main(String... args){
		try {
			FileHandler.makeExecutable(new File("C:\\Src\\file1.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
