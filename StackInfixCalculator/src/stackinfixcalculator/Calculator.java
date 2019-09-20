package stackinfixcalculator;

import java.util.EmptyStackException;
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
    public String evaluate(String postExpr) throws Exception {

        if (postExpr.equals("Invalid Expression"))
        {
            return postExpr;
        }

        //Use StringTokenizer to split operands/operators in expression
        StringTokenizer tokenizer = new StringTokenizer(postExpr, " ");
        //Used to enforce order of operations
        Stack<String> stack = new Stack<>();


        while (tokenizer.hasMoreTokens())
        {
            //Get the next token in the expression
            String substring = tokenizer.nextToken();

            int result;

            if (!substring.equals("+") && !substring.equals("-") &&
                    !substring.equals("*") && !substring.equals("/"))
            {
                stack.push(substring);
            }
            else
            {
                int y; //Second operand
                int x; //First operand

                /*
                Will throw an EmptyStackException if there are
                too many operators
                */
                try
                {
                    y = Integer.parseInt(stack.pop());
                    /*
                    Check if the negative is an operator outside parenthesis.
                    Ex: -(7)
                    */
                    if (stack.isEmpty() && substring.equals("-"))
                    {
                        substring = "*";
                        x = -1;
                        compute(substring, x, y);
                    }
                    else
                    {
                        x = Integer.parseInt(stack.pop());
                    }
                }
                catch (EmptyStackException e)
                {
                    return "Invalid Expression";
                }

                result = compute(substring, x, y);

                //Convert the result into a string to push into the stack.
                substring = Integer.toString(result);
                stack.push(substring);
            }
        }

        /*
        Only the result should be in the stack after the expression is read;
        If there's too many opening parenthesis, it will throw a
        NumberFormatException, and an error message will be returned.
         */
        int result;

        try
        {
            result = Integer.parseInt(stack.pop());
        }
        catch (NumberFormatException e)
        {
            return "Invalid Expression";
        }

        return Integer.toString(result);
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
