package com.management.school.baseclasses;

public class Person {

    private String name;
    private String password;
    private String email;
    private String gender;
    private int id;

    public Person(int id, String name, String password, String email, String gender){
        this.name = name;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getGender(){
        return gender;
    }

}