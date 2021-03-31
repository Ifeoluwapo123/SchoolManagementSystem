package com.management.school.services.serviceImplementation;

import com.management.school.model.Person;
import com.management.school.services.INonTeacherActions;
import com.management.school.utilities.PersonData;
import com.management.school.utilities.Display;

import java.util.ArrayList;

public class NonTeacherActions implements INonTeacherActions {

    public NonTeacherActions(){

    }

    /**
     * Displays the Salary Payroll of all staffs, including the principal
     * return void
     * */
    public void displaySalaryPayroll(Person nonTeacher){
        if(nonTeacher.getRole().equalsIgnoreCase("Non_Teaching_Staff")) {
            ArrayList<String> teachersData = PersonData.getTeachersDetails();
            ArrayList<String> nonTeachingStaffData = PersonData.getNonTeachingStaffsDetails();
            Display.displaySalaryPayroll(teachersData, nonTeachingStaffData);
        }
    }

    /***
     * display the list of all students in the school
     * return void
     */
    public void displayStudentLists(Person nonTeacher){
        if(nonTeacher.getRole().equalsIgnoreCase("Non_Teaching_Staff")) {
            ArrayList<String> studentsData = PersonData.getStudentDetails();
            Display.displayStudentsList(studentsData);
        }
    }

    /***
     * display the list of all teachers in the school
     * return void
     */
    public void displayTeachersLists(Person nonTeacher){
        if(nonTeacher.getRole().equalsIgnoreCase("Non_Teaching_Staff")) {
            ArrayList<String> teachersData = PersonData.getTeachersDetails();
            Display.displayTeachersList(teachersData);
        }
    }

    /***
     * display the list of all non teachers in the school
     * return void
     */
    public void displayNonTeachingStaffLists(Person nonTeacher){
        if(nonTeacher.getRole().equalsIgnoreCase("Non_Teaching_Staff")) {
            ArrayList<String> nonTeachersData = PersonData.getNonTeachingStaffsDetails();
            Display.displayNonTeachersList(nonTeachersData);
        }else{
            System.out.println();
        }
    }

}
