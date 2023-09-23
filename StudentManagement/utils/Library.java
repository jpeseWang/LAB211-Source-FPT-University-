package StudentManagement.utils;

import java.util.Scanner;

public class Library {

    protected Scanner sc;

    public Library() {
        sc = new Scanner(System.in);
    }

    public String getCourseName(String mes) {
        String temp;
        while (true) {
            System.out.print(mes + ": ");
            try {
                String input = sc.nextLine();
                temp = input.trim().toLowerCase();
                if (temp.equalsIgnoreCase("Java") || temp.equalsIgnoreCase("C") || temp.equalsIgnoreCase("C++")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid courseName (Java/C/C++)");
            }
        }
        return temp;
    }

    public String getString(String mes) {
        System.out.print(mes);
        return sc.nextLine();
    }

    public int getInt(String prompt, int m, int n) {
        int a = -1;
        while (true) {
            System.out.print(prompt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + m + " and " + n);
            }
        }
        return a;
    }
}
