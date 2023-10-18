package Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Models.Student;

public class Input {
    private final Scanner in = new Scanner(System.in);

    public int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public String checkInputString() {
        while (true) {
            String result = in.nextLine();
            if (result.length() == 0) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public boolean checkInputYN() {
        while (true) {
            String result = in.nextLine();
            if (result.length() == 1 && result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.length() == 1 && result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Re-input.");
        }
    }

    public float checkInputFloat() {
        while (true) {
            try {
                float result = Float.parseFloat(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public void addStudent(ArrayList<Student> lt) {
        System.out.println("Please input student information ");
        System.out.print("Name: ");
        String name = checkInputString();
        System.out.print("Classes: ");
        String classes = checkInputString();
        System.out.print("Mark: ");
        float mark = checkInputFloat();
        lt.add(new Student(name, mark, classes));
    }

    public void print(ArrayList<Student> lt) {
        if (lt.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        Collections.sort(lt);
        for (int i = 0; i < lt.size(); i++) {
            System.out.println("--------Student " + i + 1 + "--------");
            System.out.println("Name: " + lt.get(i).getName());
            System.out.println("Classes: " + lt.get(i).getClasses());
            System.out.println("Mark: " + lt.get(i).getMark());
        }
    }

    public void display() {
        ArrayList<Student> lt = new ArrayList<>();
        addStudent(lt);
        while (true) {
            System.out.print("Do you want to enter more student information?(Y/N): ");
            if (checkInputYN()) {
                addStudent(lt);
            } else {
                break;
            }
        }
        print(lt);
    }
}
