package com.digdes.school.service;

public class Valids {
    public static boolean isTypeCorrect(String column, String var) {
        try {
            switch (column) {
                case "id" -> {

                }
                case "age" -> {
                    Integer.parseInt(var);
                    return true;
                }
                case "lastName" -> {
                    return true;
                }
                case "cost" -> {
                    Double.parseDouble(var);
                    return true;
                }
                case "active" -> {
                    Boolean.parseBoolean(var);
                    return true;
                }
            }
        } catch (Exception ex) {
            System.out.println("Некорректный тип параметра");
            return false;
        }
    }
}
