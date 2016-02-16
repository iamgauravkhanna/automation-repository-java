package others;

import java.io.File;

public class ReadAllFilesInFolder {

	public static void main(String[] args) {
		final File folder = new File("C:\\Selenium\\files\\IndvEnrlWIGGeneration_validFileDirectoryPath");
		listFilesForFolder(folder);

	}

	public static void listFilesForFolder(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				System.out.println(fileEntry.getName());
			}
		}
	}

}
