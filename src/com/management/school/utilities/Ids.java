package com.management.school.utilities;

import java.util.ArrayList;

public class Ids {

    private static ArrayList<Integer> ids = new ArrayList<>();

    public static void setIdList(int studentId){
        ids.add(studentId);
    }

    public static ArrayList<Integer> getIdList(){
        return ids;
    }
}
