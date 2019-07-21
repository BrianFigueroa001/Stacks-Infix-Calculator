package stackinfixcalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(System.in);
        String input = ""; //User input
        int answer; //Stores result after evaluation expression
        
//        System.out.print("Please enter a valid expression: ");
//        input = kb.nextLine();
//        
        System.out.print("Please enter a valid expression: ");
        input = kb.nextLine();
        
        while (!input.equals("exit"))
        {
            InfixToPostfix converter = new InfixToPostfix(input);
            String converted = converter.convertToPostfix();

            System.out.println(converted);

            Calculator calculator = new Calculator();
            answer = calculator.evaluate(converted);
            System.out.println(answer + "\n");
            
            System.out.print("Please enter a valid expression: ");
            input = kb.nextLine();
        }
    }
}
