package stackinfixcalculator;

/**
 * This class converts an arithmetic expression from in-fix notation to
 * postfix notation. Note that valid expressions are required, and invalid expressions will result in errors. It
 * will return an error message if it detects an invalid character. Mismatching
 *
 * Correct examples: 23 * 2, (23 * 2) - 1, 23 * (2 - 1)
 */
public class InfixToPostfix {

    /**
     * Converts the arithmetic expression from infix notation to postfix notation.
     * @param inExpr The expression in infix notation.
     * @return The expression converted into postfix notation, or 'Invalid Expression' if it's invalid.
     */
    public String convertToPostfix(String inExpr)
    {
        //Used to handle parenthesis and operators
        CharStack stack = new CharStack();

        String postExpr = "";

        //Scan the entire infix expression from left to right.
        for (int i = 0; i < inExpr.length(); ++i)
        {

            char exprChar = inExpr.charAt(i);

            if (exprChar == ' ')
            {
                continue;
            }

            //Handle numerical characters
            if ( isNumerical(inExpr, i, exprChar) )
            {
                postExpr += exprChar;

                /*
                Append subsequent digits that belong to a
                number greater than 9. Ex: 10, 23, 583, etc.
                */
                while (i + 1 < inExpr.length() &&
                        Character.isDigit(inExpr.charAt(i + 1)))
                {
                    exprChar = inExpr.charAt(++i);
                    postExpr += exprChar;
                }

                //Append a space after the operand
                postExpr += " ";
            }
            //Handle a parenthesis
            else if (exprChar == '(' || exprChar == ')')
            {
                postExpr = parenthesis(postExpr, exprChar, stack);
            }
            //Handle an operator character.
            else if (exprChar == '+' || exprChar == '-' || exprChar == '*'
                    || exprChar == '/')
            {
                postExpr = handleOperator(postExpr, exprChar, stack);
            }
            //Invalid character detected. Return an error message.
            else
            {
                return "Invalid Expression";
            }
        }

        //Pop the rest of the characters in the stack and append them to string.
        while (!stack.isEmpty())
        {
            postExpr += stack.pop() + " ";
        }

        return postExpr;
    }

    //Check if the character is numerical
    private boolean isNumerical(String inExpr, int i, char exprChar)
    {
        boolean isNumber = false;

        if (Character.isDigit(exprChar))
        {
            isNumber = true;
        }

        if (i + 1 < inExpr.length() && exprChar == '-')
        {
            char nextChar = inExpr.charAt(i + 1);

            if (Character.isDigit(nextChar) && nextChar != ' ')
            {
                isNumber = true;
            }
        }


        return isNumber;
    }

    private int precedence(char charExpr)
    {
        /*
        Note under order of operations, add and subtraction have equal
        priority, and so does multiplication and division.
        */
        switch (charExpr)
        {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            default: // '/'
                return 2;
        }
    }

    //Utility method to process non-operator characters
    private String parenthesis(String postExpr, char exprChar, CharStack stack)
    {
        //Store the updated postfix expression here.
        String updatedPostExpr = postExpr;

        //Push all left paranthesis into the stack
        if (exprChar == '(') {
            stack.push(exprChar);
        }
        //exprChar == ')'. Pop all elements from the stack until a '(' is found
        else
        {
            //Append everything from the stack before a '(' is found.
            while (!stack.isEmpty() && stack.peek() != '(')
            {
                updatedPostExpr += stack.pop() + " ";
            }

            //Discard the '('
            try
            {
                stack.pop();
            }
            catch (NullPointerException e)
            {
                return "Invalid Expression";
            }
        }

        return updatedPostExpr;
    }

    private String handleOperator(String postExpr, char exprChar, CharStack stack)
    {
        String updatedPostExpr = postExpr;

        /*
         Runs if-statement when:

         - Stack is empty.
         - Top of the stack is a '('
         - If the scanned operator's precedence is greater than
         the operator that's on top of the stack.
         */
        if (stack.isEmpty() || stack.peek() == '('
                || precedence(exprChar) > precedence(stack.peek()))
        {
            //Push it into the stack
            stack.push(exprChar);
        }
        /*
        Pop and append all operators from the stack that have
        greater precedence than the scanned operator.

        If a '(' is found later in the stack, stop there and push the operator
        into the stack.
        */
        else
        {
            while (!stack.isEmpty() && stack.peek() != '('
                    && precedence(exprChar) <= precedence(stack.peek()))
            {
                updatedPostExpr += stack.pop() + " ";
            }

            //Push this character into the stack.
            stack.push(exprChar);
        }

        return updatedPostExpr;
    }
}