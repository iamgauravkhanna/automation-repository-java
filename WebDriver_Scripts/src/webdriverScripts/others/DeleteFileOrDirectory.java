

package webdriverScripts.others;

import java.io.File;

import org.openqa.selenium.io.FileHandler;

public class DeleteFileOrDirectory {	
	public static void main(String... args){
		FileHandler.delete(new File("C:\\SelDir\\"));
	}
}
