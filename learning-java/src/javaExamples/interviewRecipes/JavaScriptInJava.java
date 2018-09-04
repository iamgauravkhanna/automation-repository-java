package javaExamples.interviewRecipes;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptInJava {

	public static void main(String[] args) {
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		try {
			engine.eval("print('Hello, World')");
		} catch (ScriptException e) {
			e.printStackTrace();
		}

	}

}
