// Class:		Data Structures 02
// Term:		Spring-2022
// Name:		Carlos Macias
// Program Number:	Assignment 3
// IDE: 		IntelliJ JDK 15.0.1

import java.util.Scanner;

public class ExprCarlosMacias {

    public static boolean compareTo(char a, char b) {

        // operators and precedence are mapped to each others indices

        char[] operators = {'+', '-', '*', '/', '^'};
        int[] precedence = {0, 0, 1, 1, 2};

        int aInd = -1;
        int bInd = -1;

        // find operator and where it stands in order of operations

        for (int i = 0; i < operators.length; i++) {
            if (a == operators[i]) {
                aInd = i;
            }

            if (b == operators[i]) {
                bInd = i;
            }
        }

        // compare precedence of operator a and operator b

        try {

            if (precedence[bInd] >= precedence[aInd]) {
                return true;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }

        return false;
    }

    public static String infixToPostfix(String infix){


        String post = "";
        MyStackCarlosMacias<Character> operatorStack = new MyStackCarlosMacias<>();

        for (int i = 0; i < infix.length(); i++) {
            char curr = infix.charAt(i);

            // figure out if current character is an operator
            int isOperator = (curr == '+'? 1: curr == '-'? 1: curr == '*'? 1: curr == '/'? 1: curr == '^'? 1: 0);

            if (isOperator == 1) {


                // compare the current operator to other operators on stack to see if they should be appended to postfix
                while (operatorStack.size() > 0 && compareTo(curr, operatorStack.peek())) {
                    post += operatorStack.pop();
                }

                operatorStack.push(curr);

            } else if (curr == '(') {
                operatorStack.push(curr);

            } else if (curr == ')') {

                // add all operators within parenthesis to post string
                while (operatorStack.peek() != '(') {
                    post += operatorStack.pop();
                }
                operatorStack.pop();

            } else {

                // should be operand so just add to post string
                post += curr;
            }
        }

        // end of infix string
        while (!operatorStack.isEmpty()) {
            post += operatorStack.pop();
        }

        return post;
    }



    public static double calc(String operator, double op1, double op2) {


        double result = -1;

        // find out operator in string form and apply appropriate calculation

        switch (operator) {

            case "+":
                result = op1 + op2;
                break;

            case "-":
                result = op1 - op2;
                break;

            case "*":
                result = op1 * op2;
                break;

            case "/":
                result = op1 / op2;
                break;

            case "^":
                result = Math.pow(op1, op2);
                break;

        }
        return result;
    }

    public static double postfixEval(String postfix){

        MyStackCarlosMacias<String> evaluateStack = new MyStackCarlosMacias<>();

        for (int i = 0; i < postfix.length(); i++) {
            String curr = Character.toString(postfix.charAt(i));


            // find out if current character in postfix string is an operator
            int isOperator = (curr.equals("+")? 1: curr.equals("-")? 1: curr.equals("*")? 1: curr.equals("/")? 1: curr.equals("^")? 1: 0);


            double isOperand = 20.0;

            // curr is not an operator (is an operand) so convert it to a numeric value
            if (isOperator != 1) {
                isOperand = Double.parseDouble(curr);
            }



            if (isOperand >= 0 && isOperand < 10) {
                evaluateStack.push(curr);


            } else if (isOperator == 1) {
                String first = evaluateStack.pop();
                String second = evaluateStack.pop();

                // convert operand string to double in order to apply operator

                double operand1 = Double.parseDouble(first);
                double operand2 = Double.parseDouble(second);

                // convert result to string in order to add to stack

                String result = Double.toString(calc(curr, operand2, operand1));
                evaluateStack.push(result);

            }
        }

        // return remaining value in stack after all operations

        double finalAnswer = Double.parseDouble(evaluateStack.pop());

        return finalAnswer;


    }




    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        char repeat = 'Y';

        do {
            System.out.print("Enter an infix: ");
            String infix = input.nextLine();

            String postfix = infixToPostfix(infix);
            System.out.println("Postfix Expression: " + postfix);

            double result = postfixEval(postfix);
            System.out.println("Result value: " + result);

            System.out.print("Do you want to continue? (Y/N) ");
            repeat = input.next().charAt(0);
            input.nextLine();

        } while (repeat == 'Y');



    }

}
