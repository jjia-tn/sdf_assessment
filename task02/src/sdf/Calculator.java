package sdf;

import java.io.Console;

public class Calculator {

    public static void main(String[] args) {

        Console cons = System.console();
        boolean stop = false;

        System.out.println("Welcome.");

        while(!stop) {
            String input = cons.readLine("> ");

            if (input.toLowerCase().equals("exit")) {
                stop = true;
                System.out.println("Bye bye");
            } else {
                String[] terms = input.trim().split(" ");
                float firstNumber = Float.parseFloat(terms[0]);
                float secondNumber = Float.parseFloat(terms[2]);
                String operator = terms[1];

                float result = 0;

                switch (operator) {
                    case Operations.add:
                        result = firstNumber + secondNumber;
                        break;
                    case Operations.subtract:
                        result = firstNumber - secondNumber;
                        break;
                    case Operations.divide:
                        result = firstNumber / secondNumber;
                        break;
                    case Operations.multiply:
                        result = firstNumber * secondNumber;
                        break;
                }
                System.out.println(result);
            }
        }
    }
}
