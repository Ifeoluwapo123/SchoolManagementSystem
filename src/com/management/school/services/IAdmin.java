package com.management.school.services;

import com.management.school.model.Person;

public interface IAdmin {
    public int admitApplicant(Person principal, Person applicant);
    public void expelledStudent(Person principal, Person student);
    public void expelledTeacher(Person principal, Person teacher);
    public void expelledNonTeachingStaff(Person principal, Person nonTeacher);
}
