package com.management.school.services;

import com.management.school.model.Person;

public interface INonTeacherActions {
    public void displaySalaryPayroll(Person nonTeacher);
    public void displayStudentLists(Person nonTeacher);
    public void displayTeachersLists(Person nonTeacher);
    public void displayNonTeachingStaffLists(Person nonTeacher);
}
