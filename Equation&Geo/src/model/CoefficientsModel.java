
package model;

public class CoefficientsModel {
    private double a;
    private double b;
    private double c;

    public void setCoefficients(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calculateSuperlativeSolution() {
        // Calculate the solution x for superlative equation
        return -b / a;
    }

    public double[] calculateQuadraticSolutions() {
        // Calculate the solutions x1 and x2 for quadratic equation
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return null; // No real solutions
        } else {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[] { x1, x2 };
        }
    }

    public int[] findEvenOddSquareNumbers() {
        // Find and return even, odd, and square numbers from coefficients
        int[] result = new int[3];
        result[0] = (a % 2 == 0) ? 1 : 0; // Even
        result[1] = (a % 2 != 0) ? 1 : 0; // Odd
        result[2] = (a * a % 2 == 0) ? 1 : 0; // Square
        return result;
    }
}
