package com.management.school;

import com.management.school.enums.Courses;
import com.management.school.enums.Roles;
import com.management.school.interfaces.IAdmin;
import com.management.school.interfaces.IPerson;
import com.management.school.utilities.ApplicantData;
import com.management.school.utilities.Display;

import java.util.ArrayList;
import java.util.Random;

public class Person implements IPerson, IAdmin {
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

    public Person(int id, String name, String role, String gender){
        this.name = name;
        this.gender = gender;
        this.role = role;
        this.id = id;

        /**
         * checks if id is in the arraylist,
         * if it is not, throws an invalid id (Not true for principal)
         * */
        if(!role.equalsIgnoreCase("Principal")){
            ArrayList<Integer> ids = ApplicantData.getIdList();
            boolean validId = false;
            for (int i = 0; i < ids.size(); i++) {
                if(id == ids.get(i)){
                    validId = true;
                    break;
                }
            }
            if(!validId || id == 0){
                throw new NullPointerException("Can't Login, invalid id");
            }
        }

        /***
         * storing the id and name of student or non-teaching staff in an arrayList
         */
        if(role.equalsIgnoreCase("Student")){
            ApplicantData.setStudentDetails(id+","+name);
        }

        if(role.equalsIgnoreCase("Non_Teaching_Staff")){
            ApplicantData.setNonTeachingStaffsDetails(id+","+name+","+"Secretary");
        }

    }

    /**
     * Checks roles against enum constants, if exist then admit base on age
     * if age test passed, generate and return a number > 0, else returns 0
     * @param name
     * @param age
     * @param roles
     * @return int
     * */
    public int admitApplicant(String name, String roles, int age) {
        if(role.equalsIgnoreCase("Principal")){
            Roles value;
            Random r = new Random();

            int randInt = 0;
            try {
                value = Roles.valueOf(roles.toUpperCase());
            }catch (IllegalArgumentException error){
                System.out.println("Enter valid Role:\n e.g NON_TEACHING_STAFF,\n" +
                        "    TEACHER,\n" +
                        "    STUDENT");
                return 0;
            }

            switch (value){
                case STUDENT:
                    if(age >= 7 && age <= 25){
                        randInt = Math.abs(r.nextInt()) % 680 + 14;
                        ApplicantData.setIdList(randInt);
                        System.out.print("Congratulations "+name+"!!! Your Student id is "+
                                randInt+ "\nLogin with it to accept admission, You can update your name when you login \n");
                    }else {
                        System.out.println("Sorry "+name+", we can't further your admission as a student");
                    }
                    break;
                case TEACHER:
                case NON_TEACHING_STAFF:
                    if(age >= 24 && age <= 65 ){
                        randInt = Math.abs(r.nextInt()) % 680 + 14;
                        ApplicantData.setIdList(randInt);
                        System.out.print("Congratulations "+name+", Your Staff id is "+
                                randInt+ "\nLogin with it to accept an appointment, You can update your name when you login\n");
                    }else {
                        System.out.println("Sorry "+name+", we can't further your appointment");
                    }
                    break;
            }

            return randInt;
        }else{
            return 0;
        }
    }

    /***
     * principal expels student by removing his/her id from the arrayList
     * @param student
     * @param studentId
     * return void
     */
    public void expelledStudent(Person student, int studentId) {
        if(role.equalsIgnoreCase("Principal")) {
            System.out.println("\nNotice!!! Notice!!! Notice!!!");
            System.out.println("Student: " + student.getName() + " has been expelled from this School,\n" +
                    "Any notice of his presence in the school premises should be report");

            ArrayList<Integer> ids = ApplicantData.getIdList();
            boolean validId = false;

            for (int i = 0; i < ids.size(); i++) {
                if (studentId == ids.get(i)) {
                    System.out.println(studentId + " " + ids.get(i));
                    ids.remove(i);
                }
            }
        }else{
            System.out.println("You don't have access to this action");
        }
    }

    /***
     * principal expels teacher by removing his/her id from the arrayList
     * @param teacher
     * @param teacherId
     * return void
     */
    public void expelledTeacher(Person teacher, int teacherId) {
        if(role.equalsIgnoreCase("Principal")) {
            System.out.println("\nNotice!!! Notice!!! Notice!!!");

            System.out.println("Teacher: " + teacher.getName() + " has been expelled from this School,\n" +
                    "Any notice of his presence in the school premises should be report");

            ArrayList<Integer> ids = ApplicantData.getIdList();
            boolean validId = false;

            for (int i = 0; i < ids.size(); i++) {
                if (teacherId == ids.get(i)) {
                    System.out.println(teacherId + " " + ids.get(i));
                    ids.remove(i);
                }
            }
        }else{
            System.out.println("You don't have access to this action");
        }
    }

    /***
     * principal expels non teachers by removing his/her id from the arrayList
     * @param staff
     * @param nonTeacherId
     * return void
     */
    public void expelledNonTeachingStaff(Person staff, int nonTeacherId) {
        if(role.equalsIgnoreCase("Principal")) {
            System.out.println("\nNotice!!! Notice!!! Notice!!!");

            System.out.println("Non-Teaching: " + staff.getName() + " has been expelled from this School,\n" +
                    "Any notice of his presence in the school premises should be report");

            ArrayList<Integer> ids = ApplicantData.getIdList();
            boolean validId = false;

            for (int i = 0; i < ids.size(); i++) {
                if (nonTeacherId == ids.get(i)) {
                    System.out.println(nonTeacherId + " " + ids.get(i));
                    ids.remove(i);
                }
            }
        }else{
            System.out.println("You don't have access to this action");
        }
    }

    /***
     * teachers applies for a course capable of teaching
     * from the list course provided
     * return void
     */
    public void applyForCourse(){
        if(role == null) role = "";
        if(role.equalsIgnoreCase("Teacher")) {
            System.out.println("\nLIST OF COURSES: \n");
            for (Courses course : Courses.values()) {
                System.out.println("\t" + course + "\n");
            }

            System.out.println("Register the course you want to teach:  ");
            Course.selectCourseName();

            String teacherData = id + "," + name + "," + Course.getRegisteredCourseName();
            ApplicantData.setTeachersDetails(teacherData);
        }else{
            System.out.println("You don't have access to this action");
        }
    }

    /***
     * returns the name of the course registered for by the teacher
     * return String
     */
    public String getRegisteredCourse(){
        if(role.equalsIgnoreCase("Teacher")) {
            String message = "You will be teaching " + Course.getRegisteredCourseName() +
                    " this semester";
            if (gender.toUpperCase().equals("MAlE"))
                return congratulationMessage(name, "Mr", message);
            else
                return congratulationMessage(name, "Mrs", message);
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
    public void courseContents(){
        if(role.equalsIgnoreCase("Teacher")) {
            String registeredCourse = Course.getRegisteredCourseName();
            System.out.println("\n");
            if (gender.toUpperCase().equals("MALE")) {
                System.out.println(this.congratulationMessage(name, "Mr",
                        " Your Course Contents on " + registeredCourse));
            } else {
                System.out.println(this.congratulationMessage(name, "Mrs",
                        " Your Course Contents on " + registeredCourse));
            }

            Course.displayAllCourseContents(registeredCourse);
        }else{
            System.out.println();
        }
    }

    /***
     * Students can take course randomly base on the teacher's course content
     * return void
     */
    public void takeCourse(String courseName){
        if(role.equalsIgnoreCase("Student")) {
            String studentClass = Class.returnClass();
            System.out.println("\n" + studentClass + ": " + courseName);
            System.out.println(name + " Your course for today");
            Course.displayRandomCourse(courseName);
        }else{
            System.out.println();
        }
    }

    /**
     * Displays the Salary Payroll of all staffs, including the principal
     * return void
     * */
    public void displaySalaryPayroll(){
        if(role.equalsIgnoreCase("Non_Teaching_Staff")) {
            ArrayList<String> teachersData = ApplicantData.getTeachersDetails();
            ArrayList<String> nonTeachingStaffData = ApplicantData.getNonTeachingStaffsDetails();
            Display.displaySalaryPayroll(teachersData, nonTeachingStaffData);
        }
    }

    /***
     * display the list of all students in the school
     * return void
     */
    public void displayStudentLists(){
        if(role.equalsIgnoreCase("Non_Teaching_Staff")) {
            ArrayList<String> studentsData = ApplicantData.getStudentDetails();
            Display.displayStudentsList(studentsData);
        }
    }

    /***
     * display the list of all teachers in the school
     * return void
     */
    public void displayTeachersLists(){
        if(role.equalsIgnoreCase("Non_Teaching_Staff")) {
            ArrayList<String> teachersData = ApplicantData.getTeachersDetails();
            Display.displayTeachersList(teachersData);
        }
    }

    /***
     * display the list of all non teachers in the school
     * return void
     */
    public void displayNonTeachingStaffLists(){
        if(role.equalsIgnoreCase("Non_Teaching_Staff")) {
            ArrayList<String> nonTeachersData = ApplicantData.getNonTeachingStaffsDetails();
            Display.displayNonTeachersList(nonTeachersData);
        }else{
            System.out.println();
        }
    }

    /***
     * display the staffs information
     * return void
     */
    public void displayPersonInformation() {
        Display.displayPersonInfo(role, name, id, gender);
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    @Override
    public void setApplicantAge(int applicantAge) {
        this.applicantAge = applicantAge;
    }

    @Override
    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    @Override
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
