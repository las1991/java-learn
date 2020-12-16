package com.las.learn.scriptengine.javaScript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Created by las on 2017/3/1.
 */
public class EvalFile {

    public static void main(String[] args) throws Exception {
        // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        // evaluate JavaScript code from given file - specified by first argument
        engine.eval(new java.io.FileReader(EvalFile.class.getResource("/").getPath() + "test.js"));
    }
}
