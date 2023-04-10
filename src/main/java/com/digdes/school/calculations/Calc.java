package com.digdes.school.calculations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public List<Map<String, Object>> calcCompare(List<Map<String, Object>> table,
                                                 String column, Long var, String op) {
        List<Map<String, Object>> result = new ArrayList<>();

        for (Map<String, Object> el : table) {
            if (op.equals("<")) {
                if ((Long)el.get(column) < var) {
                    result.add(el);
                }
            } else if (op.equals(">")) {
                if ((Long)el.get(column) > var) {
                    result.add(el);
                }
            } else if (op.equals(">=")) {
                if ((Long)el.get(column) >= var) {
                    result.add(el);
                }
            } else if ((Long)el.get(column) <= var) {
                result.add(el);
            }
        }

        return result;
    }

    public List<Map<String, Object>> calcCompare(List<Map<String, Object>> table,
                                                 String column, Double var, String op) {
        List<Map<String, Object>> result = new ArrayList<>();

        for (Map<String, Object> el : table) {
            if (op.equals("<")) {
                if ((Double)el.get(column) < var) {
                    result.add(el);
                }
            } else if (op.equals(">")) {
                if ((Double)el.get(column) > var) {
                    result.add(el);
                }
            } else if (op.equals(">=")) {
                if ((Double)el.get(column) >= var) {
                    result.add(el);
                }
            } else if ((Double)el.get(column) <= var) {
                result.add(el);
            }
        }

        return result;
    }

    public List<Map<String, Object>> calcLike(List<Map<String, Object>> table,
                                              String var)  {
        List<Map<String, Object>> result = new ArrayList<>();

        for (Map<String, Object> el : table) {
            if (isLikedorIliked(String.valueOf(el.get("lastName")), var)) {
                result.add(el);
            }
        }

        return result;
    }

    public List<Map<String, Object>> calcIlike(List<Map<String, Object>> table,
                                               String var) {
        List<Map<String, Object>> result = new ArrayList<>();
        String lower = var.toLowerCase();

        for (Map<String, Object> el : table) {
            String obj = String.valueOf(el.get("lastName")).toLowerCase();
            if (isLikedorIliked(obj, var)) {
                result.add(el);
            }
        }

        return result;
    }

    private boolean isLikedOrIliked(String obj, String var) {
        String str = var.replaceAll("%", ".*");
        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(obj);

        return matcher.matches();
    }
}
