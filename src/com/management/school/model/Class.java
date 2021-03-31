package com.management.school.model;

import com.management.school.interfaces.IClass;

import java.util.ArrayList;
import java.util.Random;

public class Class implements IClass {
    private static ArrayList<String> classes;

    public Class(){
        classes = null;
    }

    /***
     * returns a random class between JSS ONE, TWO and THREE for students
     * return void
     */
    public static String returnClass(){
        classes = new ArrayList<String>();
        classes.add("JSS ONE");
        classes.add("JSS TWO");
        classes.add("JSS THREE");

        Random r = new Random();
        int randInt = Math.abs(r.nextInt()) % classes.size();
        return classes.get(randInt);
    }
}

