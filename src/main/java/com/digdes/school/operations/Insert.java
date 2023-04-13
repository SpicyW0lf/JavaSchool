package com.digdes.school.operations;

import com.digdes.school.service.Valids;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Insert implements Operation{
    @Override
    public List<Map<String, Object>> doOperation(List<Map<String, Object>> table,
                                                 String values, String where) {
        return null;
    }

    @Override
    public Map<String, Object> createValue(String value) throws Exception {
        Map<String, Object> row = new HashMap<>() {
            {
                put("id", null);
                put("lastName", null);
                put("age", null);
                put("cost", null);
                put("active", null);
            }
        };
        String column = "";
        String var = "";

        for (int pos = 0; pos < value.length(); pos++) {
            char c = value.charAt(pos);

            if (c == ' ') continue;
            if (column.isEmpty() && c == '\'') {
                pos++;
                while (value.charAt(pos) != '\'') {
                    column += value.charAt(pos);
                    pos++;
                }
                pos++;
            } else if (!column.isEmpty()) {
                if (value.charAt(pos) == '=') {
                    if (value.charAt(pos+1) == ' ') {
                        pos += 2;
                    } else pos++;
                } else throw new Exception("Строка введена неверно");
                if (value.charAt(pos) == '\'') {
                    pos++;
                    while (pos < value.length() && value.charAt(pos) != '\'') {
                        var += value.charAt(pos);
                        pos++;
                    }
                    pos++;
                    if (pos < value.length()) {
                        if (value.charAt(pos) == ' ') pos++;
                        if (value.charAt(pos) != ',') throw new Exception("Строка введена неверно");
                    }
                } else {
                    while (pos < value.length() && value.charAt(pos) != ' ' && value.charAt(pos) != ',') {
                        var += value.charAt(pos);
                        pos++;
                    }
                    if (pos < value.length()) {
                        if (value.charAt(pos) == ' ') pos++;
                        if (value.charAt(pos) != ',') throw new Exception("Строка введена неверно");
                    }
                }
                if (row.containsKey(column)) {
                    Valids.isTypeCorrect(column, var);
                    row.put(column, var);
                    column = "";
                    var = "";
                } else throw new Exception("Строка введена неверно");
            } else throw new Exception("Строка введена неверно");

        }

        return row;
    }

    @Override
    public List<Integer> findWhere(List<Map<String, Object>> table, String where) {
        return null;
    }
}
