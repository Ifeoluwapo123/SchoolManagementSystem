package com.management.school;

import com.management.school.baseclasses.Person;
import com.management.school.interfaces.INonTeachingStaff;
import com.management.school.utilities.ApplicantData;

import java.util.ArrayList;

public class NonTeachingStaff extends Person implements INonTeachingStaff {

    public NonTeachingStaff(int id, String name, String password, String email, String gender) {
        super(id, name, password, email, gender);

        ApplicantData.setNonTeachingStaffsDetails(id+","+name+","+"Secretary");
    }

    public void displaySalaryPayroll(){
        ArrayList<String> teachersData = ApplicantData.getTeachersDetails();
        ArrayList<String> nonTeachingStaffData = ApplicantData.getNonTeachingStaffsDetails();
        String payroll = "STAFF ID\t\tNAME\t\t\t\t\t\tROLE\t\t\t\tSalary Range\n345\t\t\tAdepoju Oluwagbenga\t\t\tPrincipal\t\t\t\t200,000 - 250,000\n";

        for (int i = 0; i < teachersData.size(); i++) {
            String data = teachersData.get(i);
            int index = data.indexOf(",");
            String id = data.substring(0, index);
            String newData = data.substring(index+1);
            String name = newData.substring(0, newData.indexOf(","));
            String course = newData.substring(newData.indexOf(",")+1);

            if(course.equals("MATHEMATICS") || course.equals("ENGLISH")){
                payroll +=id+"\t\t\t\t"+name+"\t\t\t"+course+" Teacher\t\t\t130 - 150\n";
            }else if(course.equals("PHYSICS") || course.equals("CHEMISTRY") || course.equals("BIOLOGY")){
                payroll +=id+"\t\t\t\t"+ name+"\t\t\t"+course+" Teacher\t\t\t110 - 140\n";
            }else{
                payroll +=id+"\t\t\t\t"+ name+"\t\t"+course+" Teacher\t\t\t100 - 120\n";
            }
        }

        for (int i = 0; i < nonTeachingStaffData.size(); i++) {
            String data = nonTeachingStaffData.get(i);
            int index = data.indexOf(",");
            String id = data.substring(0, index);
            String newData = data.substring(index+1);
            String name = newData.substring(0, newData.indexOf(","));
            String role = newData.substring(newData.indexOf(",")+1);

            payroll +=id+"\t\t\t\t"+ name+"\t\t\t"+role+"\t\t\t\t100 - 120\n";

        }

        System.out.println(payroll);
    }

    public void displayStudentLists(){
        String studentLists = "Student Id\t\tName\n";
        ArrayList<String> studentsData = ApplicantData.getStudentDetails();

        for (int i = 0; i < studentsData.size(); i++) {
            String data = studentsData.get(i);
            int index = data.indexOf(",");
            String id = data.substring(0, index);
            String name = data.substring(index+1);

            studentLists += id+"\t\t\t\t"+name+"\n";
        }

        System.out.println(studentLists);
    }

    public void displayTeachersLists(){
        String teacherLists = "Staff Id\t\tStaff Name\t\t\tRole\n";
        ArrayList<String> teachersData = ApplicantData.getTeachersDetails();

        for (int i = 0; i < teachersData.size(); i++) {
            String data = teachersData.get(i);
            int index = data.indexOf(",");
            String id = data.substring(0, index);
            String newData = data.substring(index+1);
            String name = newData.substring(0, newData.indexOf(","));
            String role = newData.substring(newData.indexOf(",")+1);

            teacherLists +=id+"\t\t\t"+name+"\t\t"+role+" Teacher\n";
        }

        System.out.println(teacherLists);
    }

    public void displayNonTeachingStaffLists(){
        String nonTeacherLists = "Staff Id\t\tStaff Name\t\t\tRole\n";
        ArrayList<String> nonTeachersData = ApplicantData.getNonTeachingStaffsDetails();

        for (int i = 0; i < nonTeachersData.size(); i++) {
            String data = nonTeachersData.get(i);
            int index = data.indexOf(",");
            String id = data.substring(0, index);
            String newData = data.substring(index+1);
            String name = newData.substring(0, newData.indexOf(","));
            String role = newData.substring(newData.indexOf(",")+1);

            nonTeacherLists +=id+"\t\t\t"+name+"\t\t"+role+"\n";
        }

        System.out.println(nonTeacherLists);
    }

    @Override
    public String getPersonInformation() {
        String staffInfo = "Name: "+getName()+"\nStaff Id: "+getId()+
                "\nEmail: "+getEmail()+"\nGender: "+getGender();
        return staffInfo;
    }

}
