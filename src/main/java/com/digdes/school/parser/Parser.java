package com.digdes.school.parser;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static Requests parseRequest(String request) throws Exception {
        return Requests.valueOf(request.substring(0, 6).toUpperCase());
    }

    private static List<String> parseCondition(String condition) {

    }
}
