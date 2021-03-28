package com.management.school.utilities;

import com.management.school.enums.Courses;

import java.util.ArrayList;
import java.util.Random;

public class Display {

    public static void displayRandomCourseContent(String courseName, ArrayList<String> courses){

        Random r = new Random();
        int randInt = Math.abs(r.nextInt()) % courses.size();
        System.out.println("==========================================================================");
        System.out.println("\t\t "+courses.get(randInt));
        System.out.println("\n==========================================================================");
    }

    public static void displayAllCourseContent(String courseName, ArrayList<String> courses){

        System.out.println("==========================================================================\n");
        if(courses != null){
            for (int i = 0; i < courses.size(); i++) {
                int nextCount = i + 1;
                System.out.println("("+nextCount+") "+courses.get(i)+"\n");
            }
        }else{
            System.out.println( courseName+ " Course contents not available for now, See the School Principal");
        }
        System.out.println("\n=======================================================================\n");
    }
    
}

