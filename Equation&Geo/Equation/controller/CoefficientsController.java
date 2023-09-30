
package controller;

import model.CoefficientsModel;
import view.Menu;

public class CoefficientsController {
    private CoefficientsModel model;
    private Menu view;

    public CoefficientsController(CoefficientsModel model, Menu view) {
        this.model = model;
        this.view = view;
    }

    public void processCoefficients() {
        int choice;
        do {
            choice = view.displayMenu();
            switch (choice) {
                case 1:
                    calSuperlativeE();
                    break;
                case 2:
                    calQuadraticE();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    public void calSuperlativeE() {
        System.out.println(" ");
        System.out.println(" --- Calculating superlative equations ---");
        double[] coefficientsSuperlative = view.inputCoefficients();
        model.setCoefficients(coefficientsSuperlative[0], coefficientsSuperlative[1], 0);
        double superlativeSolution = model.calculateSuperlativeSolution();
        int[] evenOddSquareSuperlative = model.findEvenOddSquareNumbers();
        System.out.println("__________________________________________");

        String resultSuperlative = "Superlative Equation Solution (x): " + Math.round(superlativeSolution) + "\n" +
                "Even: " + evenOddSquareSuperlative[0] + ", Odd: " + evenOddSquareSuperlative[1]
                + ", Square: " + evenOddSquareSuperlative[2];
        view.displayResult(resultSuperlative);
    }

    public void calQuadraticE() {
        System.out.println(" ");
        System.out.println(" --- Calculating Quadratic equations ---");
        double[] coefficientsQuadratic = view.inputCoefficients();
        model.setCoefficients(coefficientsQuadratic[0], coefficientsQuadratic[1], coefficientsQuadratic[2]);
        double[] quadraticSolutions = model.calculateQuadraticSolutions();
        int[] evenOddSquareQuadratic = model.findEvenOddSquareNumbers();

        System.out.println("__________________________________________");
        if (quadraticSolutions == null) {
            System.out.println("Error with input! Please try again...");

        } else {
            String resultQuadratic = "Quadratic Equation Solutions (x1, x2): " + quadraticSolutions[0] + ", "
                    + quadraticSolutions[1] + "\n" +
                    "Even: " + evenOddSquareQuadratic[0] + ", Odd: " + evenOddSquareQuadratic[1] + ", Square: "
                    + evenOddSquareQuadratic[2];
            view.displayResult(resultQuadratic);
        }

    }
}
