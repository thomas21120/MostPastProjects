/*
 * Author: Thomas, Lindley
 * Project: CMSC 350 Project 1
 * Date: 08/30/2020
 * Program: Hybrid.java - child class, creates automobile objects with added variable of mpg. Includes sales tax method that
 * takes into account mpg to calculate sales tax
 */


import java.util.Stack;

import static java.lang.Character.isDigit;

public class ExpressionConvert {
    //Converts prefix to postfix, throws SyntaxError to be handled in ConvertGUi
    public static void stackCheck(Stack<String> operandStack) throws SyntaxError {
        if (operandStack.size() < 2) {
            System.out.println("empty stack!!");
            throw new SyntaxError();
        }
    }

    public static void stackEmptyCheck(Stack<String> stack) throws SyntaxError {
        if (stack.size() != 1) {
            System.out.println("Non-empty stack!!");
            throw new SyntaxError();
        }
    }

    public static String evalPrePost(String input) throws SyntaxError {
        Stack<String> operandStack = new Stack<>();
        Stack<String> reversalStack = new Stack<>();
        //Buffer for ints
        String intBuffer = "";
        //loop through input
        for (int i = 0; i < input.length(); i++) {
            String a = "";
            a += input.charAt(i);
            //checks if it is an integer, if it is add it to intBuffer
            if (isDigit(a.charAt(0))) {
                intBuffer += a;
            } else {
                //if its is not a number, push operands onto stack
                if (!intBuffer.equals("")) {
                    reversalStack.push(intBuffer);
                    intBuffer = "";
                }
                //char is operator, push onto stack
                if ((a.equals("/")) || a.equals("*") ||
                        a.equals("+") || a.equals("-") || a.equals("^")) {
                    reversalStack.push(a);
                }
            }
        }
        //push whats left in intBuffer onto stack
        if (!intBuffer.isEmpty()) {
            reversalStack.push(intBuffer);
        }

        while (!reversalStack.isEmpty()) {
            String popToken = reversalStack.pop();
            //If popToken is an operand push it onto the operand stack
            if (!(popToken.equals("/") || popToken.equals("*") ||
                    popToken.equals("+") || popToken.equals("-") || popToken.equals("^"))) {
                operandStack.push(popToken);
                //if PopToken is an operator then need to pop two operands and add the operator to them
            } else {
                //Make sure stack is of proper size, needs to have 2 elements
                stackCheck(operandStack);
                //Combine operator and operands and push it onto the operand stack
                String operandsAndOperator = operandStack.pop() + " " + operandStack.pop() + " " + popToken;
                operandStack.push(operandsAndOperator);
            }
        }
        //at this point there should only be one string on the stack, if not, syntax error caused by too many operators

        stackEmptyCheck(operandStack);
        //stackEmptyCheck(reversalStack);
        return operandStack.pop();
    }

    public static String evalPostPre(String input) throws SyntaxError {
        //Scanner tokenizer = new Scanner(input);
        String intBuffer = "";
        Stack<String> operandStack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            String a = "";
            a += input.charAt(i);

            if (isDigit(a.charAt(0))) {
                intBuffer += a;
            } else {
                //Character is  a number
                if (!intBuffer.equals("")) {
                    operandStack.push(intBuffer);
                    intBuffer = "";
                }
                if ((a.equals("/")) || a.equals("*") ||
                        a.equals("+") || a.equals("-") || a.equals("^")) {
                    stackCheck(operandStack);
                    String c = operandStack.pop();
                    String b = operandStack.pop();
                    String operatorsAndOperands = a + " " + b + " " + c;
                    operandStack.push(operatorsAndOperands);
                }
            }
        }
        if (!intBuffer.isEmpty()) {
            throw new SyntaxError();
        }
        //Should only be one string on the stack here, if not, too many operators
        stackEmptyCheck(operandStack);
        return operandStack.pop();
    }
}
