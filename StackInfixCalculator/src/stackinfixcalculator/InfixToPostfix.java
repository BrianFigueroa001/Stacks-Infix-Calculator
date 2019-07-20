package stackinfixcalculator;

import java.util.Stack;

/**
 * This class converts an arithmetic expression from in-fix notation to
 * postfix notation.
 */
public class InfixToPostfix {
    private Stack<Character> stack;
    private String inExpr; //The expression in infix notation.
    
    /**
     * Constructs an Infix to Postfix convert.
     * @param infixExpr The arithmetic expression that's going to be converted.
     */
    public InfixToPostfix(String infixExpr)
    {
        this.inExpr = infixExpr;
    }
    

    /**
     * Converts the arithmetic expression from infix notation to postfix
     * notation.
     * @return The expression converted into postfix notation.
     */
    public String convertToPostfix()
    {
        /*
        NOTE: It's assumed for now that the infix expression is valid.
        Code to validate infix expressions will come later.
        */
        
        //Used to store paranthesis and operators
        stack = new Stack<>();
        //Will store expression in postfix notation.
        String postExpr = ""; 
        
        //Scan the entire infix expression from left to right.
        for (int i = 0; i < inExpr.length(); ++i)
        {
            //Scan for a character in the string.
            char exprChar = inExpr.charAt(i);
            
            //Ignore spaces and continue to the next character.
            if (exprChar == ' ')
            {
                continue;
            }
            
            //Handle a non-operator character
            if (!isOperator(exprChar))
            {
                postExpr = handleNonOperator(postExpr, exprChar);
            }
            //Handle an operator character.
            else 
            {
                postExpr = handleOperator(postExpr, exprChar);
            }
        }
        
        //Pop the rest of the characters in the stack and append them to string.
        while (!stack.isEmpty())
        {
            postExpr += stack.pop();
        }

        return postExpr;
    }
    
    //Check if the character is an operator.
    private boolean isOperator(char charExpr)
    {
        return charExpr == '+' || charExpr == '-' || charExpr == '*' || 
                charExpr == '+'; 
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
    private String handleNonOperator(String postExpr, char exprChar) 
    {
        //Store the updated postfix expression here.
        String updatedPostExpr = postExpr;
        
        //Append digits to the string immediately.
        if (Character.isDigit(exprChar)) {
            updatedPostExpr += exprChar;
        }

        //Push all left paranthesis into the stack
        else if (exprChar == '(') {
            stack.push(exprChar);
        }
        //exprChar == ')'. Pop all elements from the stack until a '(' is found
        else 
        {
            //Append everything from the stack before a '(' is found.
            while (!stack.isEmpty() && stack.peek() != '(') 
            {
                updatedPostExpr += stack.pop();
            }

            //Discard the '('
            stack.pop();
        }
        
        return updatedPostExpr;
    }
    
    private String handleOperator(String postExpr, char exprChar) 
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
                updatedPostExpr += stack.pop();
            }

            //Push this character into the stack.
            stack.push(exprChar);
        }
        
        return updatedPostExpr;
    }
}
