package com.management.school;

import com.management.school.interfaces.IApplicant;

import java.util.Scanner;

public class Applicant implements IApplicant {

    private String applicantName;
    private int applicantAge;
    private String applicantRole;

    public Applicant(String name, String role, int age){
        this.applicantRole = role;
        this.applicantAge = age;
        this.applicantName = name;
//        System.out.print("List of the Available roles in Community Grammar School\n"
//                +"Teacher\nNon_Teaching_Staff\nStudent");
    }

    public void setApplicantAge(int applicantAge) {
        this.applicantAge = applicantAge;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public void setApplicantRole(String applicantRole) {
        this.applicantRole = applicantRole;
    }

    public int getApplicantAge() {
        return applicantAge;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public String getApplicantRole() {
        return applicantRole;
    }
}
