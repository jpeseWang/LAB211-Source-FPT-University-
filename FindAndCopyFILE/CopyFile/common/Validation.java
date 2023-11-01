package common;

import java.util.Scanner;

public class Validation {
    public String inputString(String title) {
        String s = "";
        while (s.isEmpty()) {
            System.out.print(title + ": ");
            Scanner sc = new Scanner(System.in);
            s = sc.nextLine();
        }
        return s;
    }
}