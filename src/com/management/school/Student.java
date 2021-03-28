package com.management.school;

import com.management.school.baseclasses.Person;
import com.management.school.interfaces.IStudent;
import com.management.school.utilities.ApplicantData;

import java.util.ArrayList;

public class Student extends Person implements IStudent {

    private String address;

    public Student(int id, String name, String password, String email, String gender) {
        super(id, name, password, email, gender);

        ArrayList<Integer> ids = ApplicantData.getIdList();
        boolean validId = false;
        for (int i = 0; i < ids.size(); i++) {
            if(id == ids.get(i)){
                validId = true;
                break;
            }
        }

//        System.out.println("student"+ids);

        if(!validId || id == 0){
            throw new NullPointerException("Student not allowed to Login, invalid id");
        }

        String studentData = id+","+name;

        ApplicantData.setStudentDetails(studentData);

    }

    private String gender = getGender().toUpperCase();
    private String name = getName();
    private int id = getId();
    private String email = getEmail();


    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void takeCourse(String courseName){
        String studentClass = Class.returnClass();
        System.out.println("\n"+studentClass+": "+courseName);
        System.out.println(name+" Your course for today");

        Course.displayRandomCourse(courseName);
    }

    @Override
    public String getPersonInformation() {
        String studentInfo = "Name: "+name+"\nStaff Id: "+id+
                "\nEmail: "+email+"\nGender: "+gender;
        return studentInfo;
    }
}
