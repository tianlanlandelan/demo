package com.example.demo;

public class Utils {
    public static void print(String description ,Object ... objects){
        System.out.println("====" + description + "====");
        for(Object object :objects){
            System.out.println(object);
        }

    }
}
