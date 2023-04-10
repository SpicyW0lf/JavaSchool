package com.digdes.school.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConditionParser {
    public String infixExpr;
    public String postfixExpr;
    private int pos;
    private Map<String, Integer> operators = new HashMap<>() {
        {
            put("(", 0);
            put("-", 4);
            put("=", 3);
            put("ilike", 3);
            put("like", 3);
            put("!=", 3);
            put("<=", 3);
            put(">=", 3);
            put(">", 3);
            put("<", 3);
            put("and", 2);
            put("or", 1);
        }
    };

    public ConditionParser(String infixExpr) {
        this.infixExpr = infixExpr;
        this.postfixExpr = toPostfix(infixExpr);
    }

    private String getString(String expr) {
        String strNumber = "";
        pos++;

        for (; pos < expr.length(); pos++) {
            char symb = expr.charAt(pos);
            if (symb == '\'') {
                break;
            } else {
                strNumber += symb;
            }
        }

        return strNumber;
    }

    private String getOperator(String expr) {
        String strOperator = "";

        for (int i = 0; pos < expr.length(); pos++, i++) {
            strOperator += expr.charAt(pos);
            if (operators.containsKey(expr.substring(pos-i, pos+1))) {
                break;
            }
            if (i == 6) {
                strOperator = "error";
                break;
            }
        }

        return strOperator;
    }

    private String getStringNumber(String expr) {
        String strNumber = "";

        for (; pos < expr.length(); pos++) {
            char num = expr.charAt(pos);
            if (Character.isDigit(num)) {
                strNumber += num;
            } else {
                pos--;
                break;
            }
        }

        return strNumber;
    }

    private String toPostfix(String infixExpr) {
        String postfixExpr = "";
        Stack<String> stack = new Stack<>();
        pos = 0;

        for (; pos < infixExpr.length(); pos++) {
            char c = infixExpr.charAt(pos);

            if (Character.isDigit(c)) {
                postfixExpr += getStringNumber(infixExpr) + " ";
            } else if (c == '\'') {
                postfixExpr += getString(infixExpr) + " ";
            } else if (c == '(') {
                stack.push("(");
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != "(") {
                    postfixExpr += stack.pop() + " ";
                }
                stack.pop();
            } else if (c == ' ') {
                continue;
            } else {
                String op = "";
                op = getOperator(infixExpr);
                if (op.equals("error")) {
                    System.out.println("Введенного оператора не существует");
                    break;
                }
                while (!stack.isEmpty() &&
                        (operators.get(stack.peek()) >= operators.get(op))) {
                    postfixExpr += stack.pop() + " ";
                }
                stack.push(op);
            }
        }
        for (String op : stack) {
            postfixExpr += op + " ";
        }

        return postfixExpr.trim();
    }
}
