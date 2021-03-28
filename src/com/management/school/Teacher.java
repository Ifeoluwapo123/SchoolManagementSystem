package com.management.school;

import com.management.school.baseclasses.Person;
import com.management.school.enums.Courses;
import com.management.school.utilities.Ids;

import java.util.ArrayList;

public class Teacher extends Person {

    public Teacher(int id, String name, String password, String email, String gender) {
        super(id, name, password, email, gender);

        ArrayList<Integer> ids = Ids.getIdList();
        boolean validId = false;
        for (int i = 0; i < ids.size(); i++) {
            if(id == ids.get(i)){
                validId = true;
                break;
            }
        }

        if(!validId){
            throw new NullPointerException("Teacher not allowed to Login, invalid id");
        }
    }

    private String gender = getGender().toUpperCase();
    private String name = getName();

    /**
     * Scanner class will show the list of courses a
     * teacher can apply for
     * */
    public void applyForCourse(){
        System.out.println("\nLIST OF COURSES: \n");
        for (Courses course : Courses.values()) {
            System.out.println("\t"+course+"\n");
        }

        System.out.println("Register the course you want to teach:  ");
        Course.loadCoursesName();
    }

    public String getRegisteredCourse(){

        String message = "You will be teaching "+Course.getRegisteredCourseName()+
                " this semester";
        if(gender == "MAlE")
            return congratulationMessage(name, "Mr", message);
        else
            return congratulationMessage(name, "Mrs",message);
    }

    private String congratulationMessage(String name, String title, String message){
        return "Congratulations "+title+". "+name+",\n "+ message;
    }

    public void courseContents(){
        String registeredCourse = Course.getRegisteredCourseName();
        System.out.println("\n");
        if(gender == "MALE") {
            System.out.println(this.congratulationMessage(name, "Mr",
                    " Your Course Contents on "+registeredCourse));
        } else {
            System.out.println(this.congratulationMessage(name, "Mrs",
                    " Your Course Contents on "+ registeredCourse));
        }

        Course.displayAllCourseContents(registeredCourse);
    }

}
