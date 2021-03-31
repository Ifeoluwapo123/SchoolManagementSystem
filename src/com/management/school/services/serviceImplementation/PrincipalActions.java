package com.management.school.services.serviceImplementation;
import com.management.school.enums.Roles;
import com.management.school.model.Person;
import com.management.school.services.IAdmin;
import com.management.school.utilities.PersonData;

import java.util.ArrayList;
import java.util.Random;

public class PrincipalActions implements IAdmin {

    /**
     * Checks roles against enum constants, if exist then admit base on age
     * if age test passed, generate and return a number > 0, else returns 0
     * @param principal
     * @param applicant
     * @return int
     * */
    //public int admitApplicant(String name, String roles, int age) {
    public int admitApplicant(Person principal, Person applicant) {
        if(principal.getRole().equalsIgnoreCase("Principal")){
            Roles value;
            Random r = new Random();

            int randInt = 0;
            try {
                value = Roles.valueOf(applicant.getApplicantRole().toUpperCase());
            }catch (IllegalArgumentException error){
                System.out.println("Enter valid Role:\n e.g NON_TEACHING_STAFF,\n" +
                        "    TEACHER,\n" +
                        "    STUDENT");
                return 0;
            }

            switch (value){
                case STUDENT:
                    if(applicant.getApplicantAge() >= 7 && applicant.getApplicantAge() <= 25){
                        randInt = Math.abs(r.nextInt()) % 680 + 14;
                        PersonData.setIdList(randInt);
                        System.out.print("Congratulations "+applicant.getApplicantName()+"!!! Your Student id is "+
                                randInt+ "\nLogin with it to accept admission, You can update your name when you login \n");
                    }else {
                        System.out.println("Sorry "+applicant.getApplicantName()+", we can't further your admission as a student");
                    }
                    break;
                case TEACHER:
                case NON_TEACHING_STAFF:
                    if(applicant.getApplicantAge() >= 24 && applicant.getApplicantAge() <= 65 ){
                        randInt = Math.abs(r.nextInt()) % 680 + 14;
                        PersonData.setIdList(randInt);
                        System.out.print("Congratulations "+applicant.getApplicantName()+", Your Staff id is "+
                                randInt+ "\nLogin with it to accept an appointment, You can update your name when you login\n");
                    }else {
                        System.out.println("Sorry "+applicant.getApplicantName()+", we can't further your appointment");
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
     * @param principal
     * return void
     */
    public void expelledStudent(Person principal, Person student) {
        if(principal.getRole().equalsIgnoreCase("Principal")) {
            System.out.println("\nNotice!!! Notice!!! Notice!!!");
            System.out.println("Student: " + student.getName() + " has been expelled from this School,\n" +
                    "Any notice of his presence in the school premises should be report");

            ArrayList<Integer> ids = PersonData.getIdList();
            boolean validId = false;

            for (int i = 0; i < ids.size(); i++) {
                if (student.getId() == ids.get(i)) {
                    System.out.println(student.getId() + " " + ids.get(i));
                    ids.remove(i);
                }
            }
        }else{
            System.out.println("You don't have access to this action");
        }
    }

    /***
     * principal expels teacher by removing his/her id from the arrayList
     * @param principal
     * @param teacher
     * return void
     */
    public void expelledTeacher(Person principal, Person teacher) {
        if(principal.getRole().equalsIgnoreCase("Principal")) {
            System.out.println("\nNotice!!! Notice!!! Notice!!!");

            System.out.println("Teacher: " + teacher.getName() + " has been expelled from this School,\n" +
                    "Any notice of his presence in the school premises should be report");

            ArrayList<Integer> ids = PersonData.getIdList();
            boolean validId = false;

            for (int i = 0; i < ids.size(); i++) {
                if (teacher.getId() == ids.get(i)) {
                    System.out.println(teacher.getId() + " " + ids.get(i));
                    ids.remove(i);
                }
            }
        }else{
            System.out.println("You don't have access to this action");
        }
    }

    /***
     * principal expels non teachers by removing his/her id from the arrayList
     * @param principal
     * @param nonTeacher
     * return void
     */
    public void expelledNonTeachingStaff(Person principal, Person nonTeacher) {
        if(principal.getRole().equalsIgnoreCase("Principal")) {
            System.out.println("\nNotice!!! Notice!!! Notice!!!");

            System.out.println("Non-Teaching: " + nonTeacher.getName() + " has been expelled from this School,\n" +
                    "Any notice of his presence in the school premises should be report");

            ArrayList<Integer> ids = PersonData.getIdList();
            boolean validId = false;

            for (int i = 0; i < ids.size(); i++) {
                if (nonTeacher.getId() == ids.get(i)) {
                    System.out.println(nonTeacher.getId() + " " + ids.get(i));
                    ids.remove(i);
                }
            }
        }else{
            System.out.println("You don't have access to this action");
        }
    }
}
