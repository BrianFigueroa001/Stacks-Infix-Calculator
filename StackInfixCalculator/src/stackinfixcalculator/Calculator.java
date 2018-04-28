package stackinfixcalculator;

import java.util.StringTokenizer;

public class Calculator {
    
    /**
     * ---------------------------------------------------------------------------------------
     * The evaluate() method must receive an infix expression surrounded by parenthesis as its argument.
     * Example: ( ( 2 * 5 ) + ( 6 / 2 ) )
     * ----------------------------------------------------------------------------------------
     */
    public int evaluate(String input) throws Exception {
        Stack stack = new Stack();
        int answer = 0; 
        StringTokenizer tokenizedExpression = new StringTokenizer(input, " ");
        String token = tokenizedExpression.nextToken();
        stack.push(token);
        while (!stack.isEmpty()) { 
            token = tokenizedExpression.nextToken();
            stack.push(token);
            if (token.equals(")")) { // Once the end of an expression ")" is reached.
                stack.pop(); // Discards )
                int y = Integer.parseInt(stack.pop());
                String operator = stack.pop(); // Gets the operator
                int x = Integer.parseInt(stack.pop());
                stack.pop(); // Discards (
                answer = compute(x, y, operator);
                if (!stack.isEmpty()) { //If the stack is empty, only the final answer is left.
                    stack.push(Integer.toString(answer));
                }
            }
        }
        return answer;
    }
    /**
     * The compute() method evaluates an expression according to its operation
     */
    private int compute(int x, int y, String operator) throws Exception {

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
            case "/":
                num = x / y;
                break;
            default:
                throw new Exception("Illegal operator found.");
        }
        return num;
    }
}
