package com.digdes.school.operations;

import java.util.List;
import java.util.Map;

public interface Operation {
    public List<Map<String, Object>> doOperation(List<Map<String, Object>> table,
                                                 String values, String where);

    public Map<String, Object> createValue(List<Map<String, Object>> table,
                                              String values);

    public int findWhere(List<Map<String, Object>> table,
                         String where);
}
