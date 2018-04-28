package stackinfixcalculator;

import java.util.StringTokenizer;

/**
 * The calculator class accepts a string from main and assigns it to input. The
 * stack is used to evaluate single expressions at a time. Ex: ( 1 + 1 )
 */
public class Calculator {

    private Stack stack = new Stack();
    private String input;
    //Valid expression passed from main
    //The answer variable stores the value of a number.
    private int answer;
    
    public Calculator(String input) {
        this.input = input;
    }

    /**
     * ---------------------------------------------------------------------------------------
     * The evaluate() method declares a stringTokenizer with input as its
     * argument. The method will push tokens into the stack. Each element in the
     * stack will either have: - Parenthesis ( ) - Operator + - * / - An integer
     * The method will call compute() every time token has the value of ")".
     * Afterwards, an if statement will check if the entire expression is
     * evaluated or not.
     * ----------------------------------------------------------------------------------------
     */
    
    public int evaluate() {

        StringTokenizer tokenizedExpression = new StringTokenizer(input, " "); //tokenizes input
        String token = tokenizedExpression.nextToken();//token gets pushed into the stack
        stack.push(token);
        while (!stack.isEmpty()) { //Once the stack is empty, the answer will have the final result.
            token = tokenizedExpression.nextToken();
            stack.push(token);
            if (token.equals(")")) { // Once the end of an expression ")" is reached.
                stack.pop();
                int y = Integer.parseInt(stack.pop());
                String operator = stack.pop();
                int x = Integer.parseInt(stack.pop());
                stack.pop();
                answer = compute(x, y, operator);
                if (!stack.isEmpty()) { //If the stack is empty, this answer is the answer. Otherwise, it gets pushed to the stack
                    stack.push(Integer.toString(answer));
                }
            }
        }
        return answer;
    }

    /**
     * Since popping elements out of the stack will return the reverse
     * expression... Ex: (2+3) in the stack is popped out as )3+2( since ) is
     * the top element ... this method will pop elements out of the stack and
     * assign the 2nd pop and 4th pop as y and x. The 1st and 5th pop will be
     * discarded. The 3rd pop will have the operator and the switch statement
     * will determine which operation is needed.
     *
     * Each case in the switch statement will evaluate the expression in the
     * right order with x and y.
     */
    
    private int compute(int x, int y, String operator) {

        int num;
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
