package com.management.school;

import com.management.school.enums.Courses;

public class App {
     public static void main(String[] args){
         /**
          * Student, Teacher, Non_teaching staff instance can't be created now,
          * Throws an error cause they haven't passed through recruitment or admission stage
          *   for instance the student instance
          *   Person student = new Person(22, "John", "Student", "Male"); throws Student can't login
          */

         // Admitting teachers, teachers can login and perform some actions
         Person teacher1 = principalAdmitApplicant("Chadwick John", "Teacher",29, "Male");
         Person teacher2 = principalAdmitApplicant("Osten Jonathan", "Teacher", 32, "Male");
         Person teacher3 = principalAdmitApplicant("Johnson Kurt", "Teacher", 24, "Male");
         teacher1.applyForCourse();
         teacher1.courseContents();
         teacher2.applyForCourse();
         teacher2.courseContents();
         teacher3.applyForCourse();
         teacher3.courseContents();

         // Admitting Student, Students can login and perform some actions
         Person student1 = principalAdmitApplicant("Uche Amaka", "Student",23, "Female");
         Person student2 = principalAdmitApplicant("Augustin Promise", "Student", 20, "Male");
         Person student3 = principalAdmitApplicant("Joy Christ", "Student",15, "Female");
         student1.setAddress("5, lintel Street ikeja Lagos");
         student1.takeCourse("Mathematics");
         student1.displayPersonInformation();
         student2.displayPersonInformation();
         student2.takeCourse("Biology");
         student3.displayPersonInformation();
         student3.takeCourse("Mathematics");

         //Admitting non-teachers, Non-teachers can login and perform some actions
         Person secretary1 = principalAdmitApplicant("Henry Cleiton", "Non_teaching_staff", 40, "Male");
         secretary1.displaySalaryPayroll();
         secretary1.displayStudentLists();
         secretary1.displayTeachersLists();
         secretary1.displayNonTeachingStaffLists();
         secretary1.displayPersonInformation();
     }

     public static Person principalAdmitApplicant(String name, String role, int age, String gender){
         Person principal = new Person(22, "Mr. Austin Gabriel", "Principal", "Male");

         Person applicant = new Person(name, role, age);

         //Applicant's information
         String applicantName = applicant.getApplicantName();
         String applicantRole = applicant.getApplicantRole();
         int applicantAge = applicant.getApplicantAge();

         //Principal admits base on the teacher information
         int statusId = principal.admitApplicant(applicantName, applicantRole, applicantAge);

         /**
          * appointmentStatus returns 0 or number > 0 as an id
          * if 0, teacher not admitted, else you can now create a teacher instance
          * */

         if(statusId != 0){
            Person person = new Person(statusId, applicantName, applicantRole, gender);
            return  person;
         }else{
             throw new NullPointerException(role+" Application processing terminated");
         }
     }
}
