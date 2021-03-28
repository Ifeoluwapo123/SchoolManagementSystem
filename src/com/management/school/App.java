package com.management.school;

import com.management.school.enums.Courses;

public class App {
    public static void main(String[] args){
        System.out.println("Getting Started");

        int principalId = 654;
        Principal principal = new Principal(principalId, "Adepoju Oluwagbenga",
                                      "****", "adepoju", "Male");

        Applicant applicant1 = new Applicant("Gabriel John", "Teacher",33);
        Applicant applicant2 = new Applicant("Adewunmi Bekky", "Student", 22);
//        applicant1.setApplicantAge(20);
        Applicant applicant3 = new Applicant("Henry Clinton", "Non_Teaching_Staff", 34);

        System.out.println("====================================================================================");

        int applicantId1 = principal.admitApplicant(applicant1.getApplicantName(),
                applicant1.getApplicantRole(), applicant1.getApplicantAge());

        System.out.println("====================================================================================");

        int applicantId2 = principal.admitApplicant(applicant2.getApplicantName(),
                applicant2.getApplicantRole(), applicant2.getApplicantAge());

        System.out.println("====================================================================================");

        int applicantId3 = principal.admitApplicant(applicant3.getApplicantName(),
                applicant3.getApplicantRole(), applicant3.getApplicantAge());

        System.out.println("====================================================================================");

        if(applicantId1 != 0){
            Teacher teacher = new Teacher(applicantId1,"Gabriel John", "****",
                    "gabriel@gmail.com", "Male");
//            teacher.applyForCourse();
//            String teacherCourse = teacher.getRegisteredCourse();
//
//            if(teacherCourse != null)
//                System.out.println(teacherCourse);
//            else
//                System.out.println("Please Apply for a Course you can teach well");
//
//            teacher.courseContents();
        }

        if(applicantId2 != 0){
            Student student = new Student(applicantId2,"Adewunmi Bekky", "***","adepoju", "Female");
            // principal.expelledStudent(student1, applicantId2);
//            student = new Student(applicantId1,"ggg", "***","adepoju", "Male");
//            student.setAddress("5, lintel Street ikeja Lagos");
              student.takeCourse("Mathematics");
//            System.out.println("====================================================================================");
//            System.out.println(student.getPersonInformation());
//            System.out.println("====================================================================================");
        }
//
        if(applicantId3 != 0){
            NonTeachingStaff staff = new NonTeachingStaff(applicantId3, "Adewala Joseph", "***",
                    "adewale@gmail.com", "Female");
            System.out.println("School Payroll\n");
            System.out.println("====================================================================================");
            staff.displaySalaryPayroll();
            System.out.println("====================================================================================");
            System.out.println("List of Students\n");
            staff.displayStudentLists();
            System.out.println("====================================================================================");
            System.out.println("List of Teachers\n");
            staff.displayTeachersLists();
            System.out.println("====================================================================================");
            System.out.println("List of nonTeachers\n");
            staff.displayNonTeachingStaffLists();
            System.out.println("====================================================================================");
        }
    }
}
