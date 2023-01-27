package sdf;

import java.io.Console;

public class Calculator {

    public static void main(String[] args) {

        Console cons = System.console();
        boolean stop = false;

        float $last = 0;

        System.out.println("Welcome.");

        while(!stop) {
            String input = cons.readLine("> ");

            if (input.toLowerCase().equals("exit")) {
                stop = true;
                System.out.println("Bye bye");
            } else {
                String[] terms = input.trim().split(" ");

                float result = 0;
                float firstNumber = 0;
                float secondNumber = 0;

                try {
                    firstNumber = Float.parseFloat(terms[0]);
                } catch (Exception e) {
                    firstNumber = $last;
                }

                try {
                    secondNumber = Float.parseFloat(terms[2]);
                } catch (Exception e) {
                    secondNumber = $last;
                }

                String operator = terms[1];

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
                $last = result;
                System.out.println($last);
            }
        }
    }
}
