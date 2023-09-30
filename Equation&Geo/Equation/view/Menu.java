
package view;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public int displayMenu() {
        System.out.println(" ");
        System.out.println(" ======  EQUATION PROGRAM  ====== ");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        System.out.printf("Select an option: ");
        return scanner.nextInt();
    }

    public void displayResult(String result) {
        System.out.println(result);
    }

    public double[] inputCoefficients() {
        double[] coefficients = new double[3];
        System.out.print("Enter coefficient A: ");
        coefficients[0] = scanner.nextDouble();
        System.out.print("Enter coefficient B: ");
        coefficients[1] = scanner.nextDouble();
        System.out.print("Enter coefficient C: ");
        coefficients[2] = scanner.nextDouble();
        return coefficients;
    }
}
