package com.management.school.interfaces;

public interface IPerson {
    //applicant
    public void setApplicantAge(int applicantAge);
    public void setApplicantName(String applicantName);
    public void setApplicantRole(String applicantRole);
    public int getApplicantAge();
    public String getApplicantName();
    public String getApplicantRole();
    public void displayPersonInformation();
}
