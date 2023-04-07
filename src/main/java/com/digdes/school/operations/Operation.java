package com.digdes.school.operations;

import java.util.List;
import java.util.Map;

public interface Operation {
    public List<Map<String, Object>> doOperation(List<Map<String, Object>> table);
}
