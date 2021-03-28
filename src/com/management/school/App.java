package com.management.school;

import com.management.school.enums.Courses;

public class App {
    public static void main(String[] args){
        System.out.println("Getting Started");

//        Teacher teacher = new Teacher("John", "****", "john@gmail.com", "Male");
//        teacher.applyForCourse();
//
//        String teacherCourse = teacher.getRegisteredCourse();
//
//        if(teacherCourse != null)
//            System.out.println(teacherCourse);
//        else
//            System.out.println("Please Apply for a Course you can teach well");
//
//        teacher.courseContents();

//        Student student = new Student(id, "****", "vic@gmail.com", "Female");
//        student.setAddress("5, lintel Street ikeja Lagos");
//        student.takeCourse("Mathematics");

        int principalId = 654;

        Principal principal = new Principal(principalId, "Adepoju Oluwagbenga",
                                      "****", "adepoju", "Male");

        int applicantId1 = principal.admitApplicant("Studen", 22);
        int applicantId2 = principal.admitApplicant("Teacher", 30);


        if(applicantId1 != 0){
            Student student1 = new Student(applicantId1,"ggg", "***","adepoju", "Male");
            principal.expelledStudent(student1, applicantId1);
            //student1 = new Student(applicantId1,"ggg", "***","adepoju", "Male");
        }

        if(applicantId2 != 0){
            Teacher teacher = new Teacher(applicantId2,"ggg", "***","adepoju", "Male");
        }
    }
}
