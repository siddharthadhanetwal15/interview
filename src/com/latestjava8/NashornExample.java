package com.latestjava8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class NashornExample {
    public static void main(String[] args) throws Exception{
        // Creating script engine
        ScriptEngine ee = new ScriptEngineManager().getEngineByName("Nashorn");
        // Evaluating Nashorn code
        ee.eval("print('Hello Nashorn');");
    }
}
