package com.management.school.services.serviceImplementation;
import com.management.school.model.Class;
import com.management.school.model.Person;
import com.management.school.services.IStudentActions;

public class StudentActions implements IStudentActions {

    public void takeCourse(Person student, String courseName){
        if(student.getRole().equalsIgnoreCase("Student")) {
            String studentClass = Class.returnClass();
            System.out.println("\n" + studentClass + ": " + courseName);
            System.out.println(student.getName() + " Your course for today");
            CourseActions.displayRandomCourse(courseName);
        }else{
            System.out.println();
        }
    }

}
