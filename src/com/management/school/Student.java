package com.management.school;

import com.management.school.baseclasses.CourseContents;
import com.management.school.baseclasses.Person;
import com.management.school.interfaces.IStudent;
import com.management.school.utilities.Ids;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;

public class Student extends Person implements IStudent {

    private String address;
    private Date dateOfEnrollment;


    public Student(int id, String name, String password, String email, String gender) {
        super(id, name, password, email, gender);

        ArrayList<Integer> ids = Ids.getIdList();
        boolean validId = false;
        for (int i = 0; i < ids.size(); i++) {
            if(id == ids.get(i)){
                validId = true;
                break;
            }
        }

        if(!validId){
            throw new NullPointerException("Student not allowed to Login, invalid id");
        }

    }

    private String gender = getGender().toUpperCase();
    private String name = getName();


    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void takeCourse(String courseName){
        System.out.println("\n"+name+" Your course for today");
        Course.displayRandomCourse(courseName);
    }

}
