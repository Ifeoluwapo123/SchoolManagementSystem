package com.management.school.interfaces;


import com.management.school.Person;

public interface IAdmin {
    public int admitApplicant(String name, String role, int age);

    public void expelledStudent(Person student, int studentId);

    public void expelledTeacher(Person teacher, int teacherId);
}
