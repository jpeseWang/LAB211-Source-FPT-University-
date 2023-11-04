package view;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {
    protected String title;
    protected ArrayList<String> options;
    protected Scanner scanner;

    public Menu(String title, String[] options) {
        this.title = title;
        this.options = new ArrayList<>();
        for (String s : options) {
            this.options.add(s);
        }
        this.scanner = new Scanner(System.in);
    }

    public void display() {
        System.out.println(title);
        System.out.println("=======================================");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.println("=======================================");
    }

    public int getSelected() {
        display();
        System.out.print("Please choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public abstract void execute();
}
