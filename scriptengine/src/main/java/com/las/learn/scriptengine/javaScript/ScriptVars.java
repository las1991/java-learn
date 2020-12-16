package com.las.learn.scriptengine.javaScript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;

/**
 * Created by las on 2017/3/1.
 */
public class ScriptVars {
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        File f = new File(ScriptVars.class.getResource("/").getPath() + "test.js");
        // expose File object as variable to script
        engine.put("file", f);

        // evaluate a script string. The script accesses "file"
        // variable and calls method on it
        try {
            engine.eval("print(file.getAbsolutePath())");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
