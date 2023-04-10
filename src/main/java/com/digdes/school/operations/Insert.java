package com.digdes.school.operations;

import java.util.List;
import java.util.Map;

public class Insert implements Operation{
    private String expr;

    public Insert(String expr) {
        this.expr = expr;
    }

    @Override
    public List<Map<String, Object>> doOperation(List<Map<String, Object>> table,
                                                 boolean whereble) {


        return null;
    }
}
