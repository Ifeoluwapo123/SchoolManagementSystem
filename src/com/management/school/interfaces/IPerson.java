package com.management.school.interfaces;

public interface IPerson {
    //applicant
    public void setApplicantAge(int applicantAge);
    public void setApplicantName(String applicantName);
    public void setApplicantRole(String applicantRole);
    public int getApplicantAge();
    public String getApplicantName();
    public String getApplicantRole();

    //teacher
    public void applyForCourse();
    public String getRegisteredCourse();
    public void courseContents();

    //student
    public void setAddress(String address);
    public String getAddress();
    public void takeCourse(String courseName);

    //non_teaching_staff
    public void displaySalaryPayroll();
    public void displayStudentLists();
    public void displayTeachersLists();
    public void displayNonTeachingStaffLists();

    public void displayPersonInformation();
}
