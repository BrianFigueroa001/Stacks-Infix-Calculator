package stackinfixcalculator;

import java.util.Stack;
import java.util.StringTokenizer;

/*
ToDo: Add code to check if the user's input is valid

*/

/**
 * Computes expressions that uses infix notation with parenthesis.
 */
public class Calculator {
    
    /**
     * Evaluates a string containing an expression in postfix notation.
     * @param postExpr Contains the expression.
     * @return The result after evaluating the expression.
     * @throws java.lang.Exception Catches if the string is invalid.
     */
    public int evaluate(String postExpr) throws Exception {
        //Use StringTokenizer to split operands/operators in expression
        StringTokenizer tokenizer = new StringTokenizer(postExpr, " ");
        //Used to enforce order of operations
        Stack<String> stack = new Stack<>();
        
        while (tokenizer.hasMoreTokens())
        {
            //Get the next token in the expression
            String substring = tokenizer.nextToken();
            
            int result;

            if (!substring.equals("+") && !substring.equals("-") && !substring.equals("*") && !substring.equals("/"))
            {
                stack.push(substring);
            }
            else 
            {
                //Second operand
                int y = Integer.parseInt(stack.pop());
                //First operand
                int x = Integer.parseInt(stack.pop());
                
                //Perform operation and get the integer
                result = compute(substring, x, y);
                //Convert
                
                //Convert the result into a string to push into the stack.
                substring = Integer.toString(result);
                stack.push(substring);
            }   
        }
       
        //Only the result should be in the stack after the expression is read.
        return Integer.parseInt(stack.pop());
    }


    private int compute(String operator, int x, int y)
    {
        switch (operator)
        {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            default:
                    return x / y;

        }
    }

}
