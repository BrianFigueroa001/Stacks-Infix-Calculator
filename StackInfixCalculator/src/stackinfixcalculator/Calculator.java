package stackinfixcalculator;

/*
ToDo: Add code to check if the user's input is valid
      Add code that reads expressions containing non-single digited operands.
*/

/**
 * Computes expressions that uses infix notation with parenthesis.
 * It can only compute expressions containing single digit operands.
 * Valid form: "( 2 + 4 )" or "((2+4)*(4-1))". 
 * Invalid form: "(2 + 4 ) + ( 3 + 2 )" or "( ( 2 + 4 )".
 */
public class Calculator {
    
    /**
     * Evaluates a string containing an expression with a valid form.
     * @param string Contains the expression.
     * @return The result after evaluating the expression.
     * @throws java.lang.Exception Catches if the string is invalid.
     */
    public int evaluate(String string) throws Exception {
        //Used to enforce order of operations by parenthesis
        Stack stack = new Stack();
        
        //Stores results of operations, including the final result.
        int result = 0; 
        
        //Iterate through the string
        for (int i = 0; i < string.length() ; ++i)
        {
            char c = string.charAt(i); 
            String substring = Character.toString(c); 
            
            if (substring.equals(" ")) //Ignore whitespace
            {
                continue;
            }
            
            if (substring.equals(")"))
            {
                int y = Integer.parseInt(stack.pop()); //Get an operand
                String operator = stack.pop(); //Get the operator
                int x = Integer.parseInt(stack.pop()); //Get an operand
                stack.pop(); //Discard a "("
                
                result = compute(x, y, operator); //Compute inner expression.
                
                //Push result if evaluation of the expression isn't complete.
                if (!stack.isEmpty())
                {
                stack.push(Integer.toString(result));
                }  
            }
            
            else //Substring is "(" or a single digit number
            {
                stack.push(substring);
            }
        }
        
        return result;
    }
    
    /*
     *Helper method used to compute an expression and return the result.
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
                throw new Exception("Invalid operator found.");
        }
        
        return num;
    }

}
