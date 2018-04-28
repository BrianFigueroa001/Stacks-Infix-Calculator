
package stackinfixcalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(System.in);
        String input; //The valid expression
        int answer; // Final result after evaluation
        
        System.out.print("Please enter a valid expression: ");
        input = kb.nextLine();
        
        Calculator calculator = new Calculator();
        answer = calculator.evaluate(input);
        
        System.out.println(answer);
    }
}
