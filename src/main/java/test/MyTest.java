package test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTest {
    public static void main(String[] args) throws ScriptException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String s = String.valueOf((int) (Math.random() * 9 + 1) * (Math.pow(10, 5)));
        }

        long end = System.currentTimeMillis();
        System.out.println(end-start);


        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            double v = (Math.random()*9+1) * (Math.pow(10, 5));
            String s = String.valueOf((int) (v));
            System.out.println(s);
        }

        end = System.currentTimeMillis();
        System.out.println(end-start);
    }


}
