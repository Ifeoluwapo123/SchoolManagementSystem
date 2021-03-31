package com.management.school.model;
import com.management.school.interfaces.IPerson;
import com.management.school.utilities.Display;
import com.management.school.utilities.PersonData;

import javax.naming.NoPermissionException;
import java.util.ArrayList;

public class Person implements IPerson {
    private String name;
    private String gender;
    private String role;
    private String applicantRole;
    private String address;
    private String applicantName;
    private int applicantAge;
    private int id;

    public Person(String name, String role, int age){
        this.applicantRole = role;
        this.applicantAge = age;
        this.applicantName = name;
    }

    public Person(int id, String name, String role, String gender) throws NoPermissionException {
        this.name = name;
        this.gender = gender;
        this.role = role;
        this.id = id;

        if(!role.equalsIgnoreCase("Principal")){
            ArrayList<Integer> checkId = PersonData.getIdList();
            boolean validId = false;

            for(int i = 0; i < checkId.size(); i++){
                if(id == checkId.get(i)){
                    validId = true;
                    break;
                }
            }

            if(!validId || id == 0){
//                throw new NullPointerException("Can't Login, Invalid id");
                throw new NoPermissionException("Can't Login Invalid id");
            }

        }

    }

    public void displayPersonInformation() {
        Display.displayPersonInfo(role, name, id, gender);
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
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

    public int getApplicantAge(){
        return applicantAge;
    }

    public String getApplicantRole(){
        return applicantRole;
    }

    public String getApplicantName(){
        return applicantName;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public String getGender(){
        return gender;
    }

    public String getRole(){
        return role;
    }
}
