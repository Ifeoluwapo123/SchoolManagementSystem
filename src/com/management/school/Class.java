package com.management.school;

import com.management.school.interfaces.IClass;

import java.util.ArrayList;
import java.util.Random;

public class Class implements IClass {
    private static ArrayList<String> classes;

    public Class(){
        classes = null;
    }

    public static String returnClass(){
        classes = new ArrayList<String>();
        classes.add("JSS ONE");
        classes.add("JSS TWO");

        Random r = new Random();
        int randInt = Math.abs(r.nextInt()) % classes.size();
        return classes.get(randInt);
    }
}
