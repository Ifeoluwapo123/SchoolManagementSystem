package com.management.school;

import com.management.school.baseclasses.CourseContents;
import com.management.school.enums.Courses;
import com.management.school.utilities.Display;

import java.util.ArrayList;
import java.util.Scanner;

public class Course extends CourseContents {

    private static String registeredCourseName;
    private static String message = "You've successfully registered for ";

    public Course(){
        super();
    }

    public static void loadCoursesName() {
        Scanner scanner = new Scanner(System.in);
        String newCourse = scanner.next().toUpperCase();

        Courses value;
        try {
            value = Courses.valueOf(newCourse);
        }catch (IllegalArgumentException error){
            System.out.println("Enter valid Subject: ");
            loadCoursesName();
            return;
        }

        registeredCourseName = newCourse;

        switch (value) {
            case BIOLOGY:
                System.out.println(message+"Biology\n");
                break;
            case ENGLISH:
                System.out.println(message+"English\n");
                break;
            case CHEMISTRY:
                System.out.println(message+"Chemistry\n");
                break;
            case PHYSICS:
                System.out.println(message+"Physics\n");
                break;
            case GEOGRAPHY:
                System.out.println(message+"Geography\n");
                break;
            case AGRICULTURE:
                System.out.println(message+"Agriculture\n");
                break;
            case MATHEMATICS:
                System.out.println(message+"Mathematics\n");
                break;
            default:
                System.out.println("Retry again\n");
        }
    }

//    public static ArrayList<String> addCourses(String courseName, String Topic){
//
//    }

    public static String getRegisteredCourseName(){
        return registeredCourseName;
    }

    public static void displayRandomCourse(String courseName){
        courseName = courseName.toUpperCase();

        if(courseName.equals("MATHEMATICS")){
            setMathematics();
//            super.setMathematics();
            Display.displayRandomCourseContent(courseName, getMathematics());
        }else
        if(courseName.equals("ENGLISH")){
            setEnglish();
            Display.displayRandomCourseContent(courseName, getEnglish());
        }else
        if(courseName.equals("GEOGRAPHY")){
            setGeography();
            Display.displayRandomCourseContent(courseName, getGeography());
        }else
        if(courseName.equals("BIOLOGY")){
            setBiology();
            Display.displayRandomCourseContent(courseName, getBiology());
        }else
        if(courseName.equals("PHYSICS")){
            setPhysics();
            Display.displayRandomCourseContent(courseName, getPhysics());
        }else
        if(courseName.equals("CHEMISTRY")){
            setChemistry();
            Display.displayRandomCourseContent(courseName, getChemistry());
        }else
        if(courseName.equals("AGRICULTURE")){
            setAgriculture();
            Display.displayRandomCourseContent(courseName, getAgriculture());
        }else{
            System.out.println("Enter a valid course name ");
        }

    }

    public static void displayAllCourseContents(String courseName){

        if(courseName.equals("MATHEMATICS")){
            setMathematics();
//            super.setMathematics();
            Display.displayAllCourseContent(courseName, getMathematics());
        }else if(courseName.equals("ENGLISH")){
            setEnglish();
            Display.displayAllCourseContent(courseName, getEnglish());
        }else if(courseName.equals("GEOGRAPHY")){
            setGeography();
            Display.displayAllCourseContent(courseName, getGeography());
        }else if(courseName.equals("BIOLOGY")){
            setBiology();
            Display.displayAllCourseContent(courseName, getBiology());
        }else if(courseName.equals("PHYSICS")){
           setPhysics();
           Display.displayAllCourseContent(courseName, getPhysics());
        }else if(courseName.equals("CHEMISTRY")){
           setChemistry();
           Display.displayAllCourseContent(courseName, getChemistry());
        }else if(courseName.equals("AGRICULTURE")){
           setAgriculture();
           Display.displayAllCourseContent(courseName, getAgriculture());
        }else{
            System.out.println("Something wrong somewhere!!");
        }

    }

}
