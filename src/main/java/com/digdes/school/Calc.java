package com.digdes.school;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Calc {
    private String postfixString;

    public Calc(String postfixString) {
        this.postfixString = postfixString;
    }

    public List<Map<String, Object>> calcEquals(List<Map<String, Object>> table,
                                                String column, Object var) {
        List<Map<String, Object>> result = new ArrayList<>();

        for (Map<String, Object> el : table) {
            Object ob = el.get(column);
            if (ob.equals(var)) {
                result.add(el);
            }
        }

        return result;
    }

    public List<Map<String, Object>> calcNotEquals(List<Map<String, Object>> table,
                                                   String column, Object var) {
        List<Map<String, Object>> result = new ArrayList<>();

        for (Map<String, Object> el : table) {
            Object ob = el.get(column);
            if (!ob.equals(var)) {
                result.add(el);
            }
        }

        return result;
    }

    public List<Map<String, Object>> calcLike(List<Map<String, Object>> table,
                                              String column, String var)  {
        List<Map<String, Object>> result = new ArrayList<>();


        if () {

        }
    }

    private
}
