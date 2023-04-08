package com.digdes.school.parser;

import com.digdes.school.operations.Operation;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private String expression;

    public Parser(String request) {
        this.expression = request;
    }

    public Parser() {

    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String parseOperation() {
        return expression.substring(0, 6).toLowerCase();
    }

    public String parseCondition() {
        for (int pos = 0; pos < expression.length(); pos++) {
            if (expression.charAt(pos) == '\'') {
                pos++;
                while (expression.charAt(pos) != '\'') {
                    pos++;
                }
            } else if (expression.charAt(pos) == 'w' &&
                    expression.substring(pos, pos + 5).equalsIgnoreCase("where")) {
                return expression.substring(pos + 5).trim();
            }
        }

        return "";
    }

    public String parseValues() throws Exception {
        String str = "";
        for (int pos = 13; pos < expression.length(); pos++) {
            if (expression.charAt(pos) == '\'') {
                str += expression.charAt(pos);
                pos++;
                while (expression.charAt(pos) != '\'') {
                    str += expression.charAt(pos);
                    pos++;
                }
                str += expression.charAt(pos);
            } else if (expression.charAt(pos) == 'w' &&
                    expression.substring(pos, pos + 5).equalsIgnoreCase("where")) {
                return str.trim();
            } else str += expression.charAt(pos);
        }

        return str.trim();
    }
}
