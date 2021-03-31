package com.management.school.services.serviceImplementation;

import com.management.school.model.Person;
import com.management.school.enums.Courses;
import com.management.school.services.ITeacherActions;
import com.management.school.utilities.PersonData;

public class TeacherActions implements ITeacherActions{

    /***
     * teachers applies for a course capable of teaching
     * from the list course provided
     * return void
     */
    public void applyForCourse(Person teacher){
        if(teacher.getRole().equalsIgnoreCase("Teacher")) {
            System.out.println("\nLIST OF COURSES: \n");
            for (Courses course : Courses.values()) {
                System.out.println("\t" + course + "\n");
            }

            System.out.println("Register the course you want to teach:  ");
            CourseActions.selectCourseName();

            String teacherData = teacher.getId() + "," + teacher.getName() + "," + CourseActions.getRegisteredCourseName();
            PersonData.setTeachersDetails(teacherData);
        }else{
            System.out.println("You don't have access to this action");
        }
    }

    /***
     * returns the name of the course registered for by the teacher
     * return String
     */
    public String getRegisteredCourse(Person teacher){
        if(teacher.getRole().equalsIgnoreCase("Teacher")) {
            String message = "You will be teaching " + CourseActions.getRegisteredCourseName() +
                    " this semester";
            if (teacher.getGender().toUpperCase().equals("MAlE"))
                return congratulationMessage(teacher.getName(), "Mr", message);
            else
                return congratulationMessage(teacher.getName(), "Mrs", message);
        }else{
            System.out.println();
            return "";
        }
    }

    private String congratulationMessage(String name, String title, String message){
        return "Congratulations "+title+". "+name+",\n "+ message;
    }

    /***
     * teachers can get the course contents of what they
     * are to teach for the semester
     * return void
     */
    public void courseContents(Person teacher){
        if(teacher.getRole().equalsIgnoreCase("Teacher")) {
            String registeredCourse = CourseActions.getRegisteredCourseName();
            System.out.println("\n");
            if (teacher.getGender().toUpperCase().equals("MALE")) {
                System.out.println(this.congratulationMessage(teacher.getName(), "Mr",
                        " Your Course Contents on " + registeredCourse));
            } else {
                System.out.println(this.congratulationMessage(teacher.getName(), "Mrs",
                        " Your Course Contents on " + registeredCourse));
            }

            CourseActions.displayAllCourseContents(registeredCourse);
        }else{
            System.out.println();
        }
    }

}
