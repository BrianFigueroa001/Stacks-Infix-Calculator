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
        CharStack stack = new CharStack();
        return -1;
    }

}
