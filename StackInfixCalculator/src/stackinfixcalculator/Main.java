package stackinfixcalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(System.in);
        String input; //User input
        int answer; //Stores result after evaluation expression
        
        System.out.print("Please enter a valid expression: ");
        input = kb.nextLine();
        
        Calculator calculator = new Calculator();
        answer = calculator.evaluate(input);
        
        System.out.println(answer);
    }
}
