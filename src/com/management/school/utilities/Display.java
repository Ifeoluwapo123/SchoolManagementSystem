package com.management.school.utilities;

import com.management.school.enums.Courses;

import java.util.ArrayList;
import java.util.Random;

public class Display {


    /***
     *  responsible for displaying complex data on screen
     */

    public static void displayRandomCourseContent(String courseName, ArrayList<String> courses){
        if(courses != null){
            Random r = new Random();
            int randInt = Math.abs(r.nextInt()) % courses.size();
            System.out.println("============================================================================");
            System.out.println("\t\t "+courses.get(randInt));
            System.out.println("\n==========================================================================");
        }else{
            System.out.println("Course class not yet fixed");
        }
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

    public static void displaySalaryPayroll(ArrayList<String> teachersData, ArrayList<String> nonTeachingStaffData){
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
        System.out.println("\nSchool Salary Payroll");
        System.out.println("====================================================================================");
        System.out.println(payroll);
        System.out.println("====================================================================================");
    }

    public static void displayStudentsList(ArrayList<String> studentsData){
        String studentLists = "Student Id\t\tName\n";
        for (int i = 0; i < studentsData.size(); i++) {
            String data = studentsData.get(i);
            int index = data.indexOf(",");
            String id = data.substring(0, index);
            String name = data.substring(index + 1);

            studentLists += id + "\t\t\t\t" + name + "\n";
        }
        System.out.println("List of Students");
        System.out.println("====================================================================================");
        System.out.println(studentLists);
        System.out.println("====================================================================================");
    }

    public static void displayTeachersList(ArrayList<String> teachersData){
        String teacherLists = "Staff Id\t\tStaff Name\t\t\tRole\n";
        for (int i = 0; i < teachersData.size(); i++) {
            String data = teachersData.get(i);
            int index = data.indexOf(",");
            String id = data.substring(0, index);
            String newData = data.substring(index + 1);
            String name = newData.substring(0, newData.indexOf(","));
            String role = newData.substring(newData.indexOf(",") + 1);

            teacherLists += id + "\t\t\t" + name + "\t\t" + role + " Teacher\n";
        }
        System.out.println("List of Teachers");
        System.out.println("====================================================================================");
        System.out.println(teacherLists);
        System.out.println("====================================================================================");
    }

    public static void displayNonTeachersList(ArrayList<String> nonTeachersData){
        String nonTeacherLists = "Staff Id\t\tStaff Name\t\t\tRole\n";
        for (int i = 0; i < nonTeachersData.size(); i++) {
            String data = nonTeachersData.get(i);
            int index = data.indexOf(",");
            String id = data.substring(0, index);
            String newData = data.substring(index + 1);
            String name = newData.substring(0, newData.indexOf(","));
            String role = newData.substring(newData.indexOf(",") + 1);

            nonTeacherLists += id + "\t\t\t" + name + "\t\t" + role + "\n";
        }
        System.out.println("List of nonTeachers");
        System.out.println("====================================================================================");
        System.out.println(nonTeacherLists);
        System.out.println("====================================================================================");
    }

    public static void displayPersonInfo(String role, String name, int id, String gender){
        String personInfo = "";
        if(role.equalsIgnoreCase("Principal")){
            personInfo = "Principal Information:\nName: "+name+"\nPrincipal Id: "+id+
                    "\nGender: "+gender+"\n";
        }else if(role.equalsIgnoreCase("Teacher")){
            personInfo = "Teacher Information:\nName: "+name+"\n TeacherId: "+id+
                    "\nGender: "+gender+"\n";
        }else if(role.equalsIgnoreCase("Student")){
            personInfo = "Student Information:\nName: "+name+"\n StudentId: "+id+
                    "\nGender: "+gender+"\n";
        }else if(role.equalsIgnoreCase("Non_teaching_staff")){
            personInfo = "Secretary Information\nName: "+name+"\n staffId: "+id+
                    "\nGender: "+gender+"\n";
        }

        System.out.println(personInfo);
    }
    
}

