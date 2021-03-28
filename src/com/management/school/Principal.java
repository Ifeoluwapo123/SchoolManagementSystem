package com.management.school;

import com.management.school.baseclasses.Person;
import com.management.school.enums.Roles;
import com.management.school.interfaces.IAdmin;
import com.management.school.utilities.ApplicantData;

import java.util.ArrayList;
import java.util.Random;

public class Principal extends Person implements IAdmin {

    public Principal(int id, String name, String password, String email, String gender) {
        super(id, name, password, email, gender);
    }


    @Override
    public int admitApplicant(String name, String roles, int age) {
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
    }

    public void loadAvailableRole(){

    }

    @Override
    public void expelledStudent(Student student, int studentId) {
        System.out.println("\nNotice!!! Notice!!! Notice!!!");
        System.out.println("Student: "+student.getName()+" has been expelled from this School,\n"+
                "Any notice of his presence in the school premises should be report");

        ArrayList<Integer> ids = ApplicantData.getIdList();
        boolean validId = false;

        for (int i = 0; i < ids.size(); i++) {
            if(studentId == ids.get(i)){
                System.out.println(studentId+" "+ids.get(i));
                ids.remove(i);
            }
        }
    }

    public void expelledTeacher(Teacher teacher, int teacherId) {
        System.out.println("\nNotice!!! Notice!!! Notice!!!");

        System.out.println("Teacher: "+teacher.getName()+" has been expelled from this School,\n"+
                "Any notice of his presence in the school premises should be report");

        ArrayList<Integer> ids = ApplicantData.getIdList();
        boolean validId = false;

        for (int i = 0; i < ids.size(); i++) {
            if(teacherId == ids.get(i)){
                System.out.println(teacherId+" "+ids.get(i));
                ids.remove(i);
            }
        }
    }

    public void expelledNonTeachingStaff(NonTeachingStaff staff, int nonTeacherId) {
        System.out.println("\nNotice!!! Notice!!! Notice!!!");

        System.out.println("Non-Teaching: "+staff.getName()+" has been expelled from this School,\n"+
                "Any notice of his presence in the school premises should be report");

        ArrayList<Integer> ids = ApplicantData.getIdList();
        boolean validId = false;

        for (int i = 0; i < ids.size(); i++) {
            if(nonTeacherId == ids.get(i)){
                System.out.println(nonTeacherId+" "+ids.get(i));
                ids.remove(i);
            }
        }
    }

    @Override
    public String getPersonInformation() {
        String principalInfo = "Name: "+getName()+"\nPrincipal Id: "+getId()+
                "\nEmail: "+getEmail()+"\nGender: "+getGender();
        return principalInfo;
    }

}
