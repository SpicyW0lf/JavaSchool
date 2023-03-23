package com.digdes.school;

import com.digdes.school.parser.Parser;
import com.digdes.school.parser.Requests;

import java.util.*;
import java.util.function.Function;

public class JavaSchoolStarter {
    private final int t = 2;

    public static void main(String[] args) {
        JavaSchoolStarter jss = new JavaSchoolStarter();
        try {
            switch (Parser.parseRequest("update from now")) {
                case DELETE -> {

                }
                case INSERT -> {

                }
                case SELECT -> {

                }
                case UPDATE -> {

                }
            }
        } catch (Exception ex) {
            System.out.println("Неправильный запрос");
        }
        jss.execute("sosi");
    }

    public List<Map<String, Object>> execute(String s) {
        Map<String, Function<? , ?>> commands = new HashMap<>();
        commands.put("update", JavaSchoolStarter::update);
        commands.put("select", JavaSchoolStarter::select);
        commands.put("delete", JavaSchoolStarter::delete);
        commands.put("insert", JavaSchoolStarter::insert);
        return new ArrayList<>();
    }

    public static List<Map<String, Object>> update(Object obj) {
        return new ArrayList<>();
    }

    public static List<Map<String, Object>> select(Object obj) {
        return new ArrayList<>();
    }

    public static List<Map<String, Object>> insert(Object obj) {
        return new ArrayList<>();
    }

    public static List<Map<String, Object>> delete(Object obj) {
        return new ArrayList<>();
    }

}
