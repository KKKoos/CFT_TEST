package org.example;

public class DataTypeCheck {

    public static boolean IsTypeLong(String incomingString) {
        boolean check;
        try {
            Long.parseLong(incomingString);
            check = true;
        } catch (NumberFormatException e) {
            return false;
        }
        return check;
    }

    public static boolean IsTypeDouble(String incomingString) {
        boolean check;
        try {
            Double.parseDouble(incomingString);
            check = true;
        } catch (NumberFormatException e) {
            return false;
        }
        return check;
    }





}
