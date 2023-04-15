package com.omar.sat;

public class Negate{

    public static String negate(String value){
        if(value.contains("¬")){
            return value.substring(1);
        }
        return "¬" + value;
    }
}
