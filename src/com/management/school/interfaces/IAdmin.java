package com.management.school.interfaces;

import com.management.school.Student;
import com.management.school.Teacher;


public interface IAdmin {
    public int admitApplicant(String role, int age);
    public void expelledStudent(Student student, int studentId);
    public void addClass();
    public void loadAvailableRole();
    public void expelledTeacher(Teacher teacher, int teacherId);
}
