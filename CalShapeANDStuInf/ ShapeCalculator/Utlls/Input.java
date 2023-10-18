package Utlls;

import java.util.Scanner;

import Models.Circle;
import Models.Rectangle;
import Models.Triangle;

public class Input {
    public final Scanner in = new Scanner(System.in);

    public double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Re-input");
            }
        }
    }

    public Triangle inputTriangle() {
        while (true) {
            System.out.print("Please input side A of Triangle: ");
            double a = checkInputDouble();
            System.out.print("Please input side B of Triangle: ");
            double b = checkInputDouble();
            System.out.print("Please input side C of Triangle: ");
            double c = checkInputDouble();
            if (a + b > c && b + c > a && a + c > b) {
                return new Triangle(a, b, c);
            } else {
                System.out.println("Re-input");
            }
        }

    }

    public Rectangle inputRectangle() {
        System.out.print("Please input side width of Rectangle: ");
        double width = checkInputDouble();
        System.out.print("Please input length of Rectangle: ");
        double length = checkInputDouble();
        return new Rectangle(width, length);
    }

    public Circle inputCircle() {
        System.out.print("Please input radius of Circle: ");
        double radius = checkInputDouble();
        return new Circle(radius);
    }

    public void display(Triangle trigle, Rectangle rectangle, Circle circle) {
        rectangle.printResult();
        circle.printResult();
        trigle.printResult();
    }
}
