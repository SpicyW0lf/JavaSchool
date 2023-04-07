package com.digdes.school;

import com.digdes.school.parser.Parser;

import java.util.*;
import java.util.function.Function;

public class JavaSchoolStarter {
    private final int t = 2;

    public static void main(String[] args) {
        JavaSchoolStarter jss = new JavaSchoolStarter();
        String str = "insert values 'a' = 2, 'b' = 3 where adfwasds";

        System.out.println(str.lastIndexOf("where"));
        System.out.println(str.indexOf('w'));
    }

    public List<Map<String, Object>> execute(String s) {
        return new ArrayList<>();
    }

}
