package javaExamples.collections;

import java.util.Arrays;
import java.util.List;

// Program to convert string to list

public class ConvertStringToList {

	public static void main(String[] args) {
		
		String pattern = "Argument 1 | Argument 2 | Argument 3";
		String strArr[] = pattern.split("\\|");
		List<String> models = Arrays.asList(strArr);
	      // Or like this...
        for(int i = 0; i < models.size(); i++) {
            System.out.println(models.get(i).toString().trim());
        }

	}

}
