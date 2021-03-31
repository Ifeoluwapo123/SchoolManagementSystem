package com.management.school.services;

import com.management.school.model.Person;

public interface ITeacherActions {
    public void applyForCourse(Person teacher);
    public String getRegisteredCourse(Person teacher);
    public void courseContents(Person teacher);
}
