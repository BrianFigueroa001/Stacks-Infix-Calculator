package stackinfixcalculator;

import java.util.StringTokenizer;

/**
 * The calculator class accepts a string from main and assigns it to input. The
 * stack is used to evaluate single expressions at a time. Ex: ( 1 + 1 )
 * ---------------------------------------------------------------------------------------
 * The evaluate() method declares a stringTokenizer with input as its argument.
 * The method will push tokens into the stack. Each element in the stack will
 * either have: - Parenthesis ( ) - Operator + - * / - An integer The method
 * will call compute() every time token has the value of ")". Afterwards, an if
 * statement will check if the entire expression is evaluated or not.
 * ----------------------------------------------------------------------------------------
 */
public class Calculator {

    private Stack stack = new Stack();
    private String input;//Valid expression passed from main
    private int integer; //stores the value of a number. Either pushed into the stack or the final answer.

    public Calculator(String input) {
        this.input = input;
    }

    public int evaluate() {
        /**
         * ---------------------------------------------------------------------------------------
         * The evaluate() method declares a stringTokenizer with input as its
         * argument. The method will push tokens into the stack. Each element in
         * the stack will either have: - Parenthesis ( ) - Operator + - * / - An
         * integer The method will call compute() every time token has the value
         * of ")". Afterwards, an if statement will check if the entire
         * expression is evaluated or not.
         * ----------------------------------------------------------------------------------------
         */
        StringTokenizer tokenizedExpression = new StringTokenizer(input, " "); //tokenizes input
        String token = tokenizedExpression.nextToken();//token gets pushed into the stack
        stack.push(token);
        while (stack.isEmpty() == false) { //Once the stack is empty, the integer will have the final result.
            token = tokenizedExpression.nextToken();
            stack.push(token);
            if (token.equals(")")) { // Once the end of an expression ")" is reached.
                integer = compute();
                if (stack.isEmpty() == false) { //If the stack is empty, this integer is the answer. Otherwise, it gets pushed to the stack
                    stack.push(Integer.toString(integer));
                }
            }
        }
        return integer;
    }

    private int compute() {
        /**
         * Since popping elements out of the stack will return the reverse
         * expression... Ex: (2+3) in the stack is popped out as )3+2( since )
         * is the top element ... this method will pop elements out of the stack
         * and assign the 2nd pop and 4th pop as y and x. The 1st and 5th pop
         * will be discarded. The 3rd pop will have the operator and the switch
         * statement will determine which operation is needed.
         *
         * Each case in the switch statement will evaluate the expression in the
         * right order with x and y.
         */
        String operator;
        int num;
        stack.pop();
        int y = Integer.parseInt(stack.pop());
        operator = stack.pop();
        int x = Integer.parseInt(stack.pop());
        stack.pop();
        switch (operator) {
            case "+":
                num = x + y;
                break;
            case "-":
                num = x - y;
                break;
            case "*":
                num = x * y;
                break;
            default:
                num = x / y;
                break;
        }
        return num;
    }
}
