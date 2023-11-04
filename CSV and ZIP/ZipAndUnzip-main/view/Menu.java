package view;

import common.Validation;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Menu {

    Validation validation = new Validation();
    private final String title;
    private final ArrayList<String> options = new ArrayList<>();

    public Menu(String title, String[] op) {
        this.title = title;
        this.options.addAll(Arrays.asList(op));
    }

    public void menuDisplay() {
        System.out.println(title);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + " - " + options.get(i));
        }
        System.out.print("Enter your choice: ");
    }

    public int getChoice() {
        menuDisplay();
        int choice = validation.checkInputIntLimit(1, 3);
        return choice;
    }

    public void run() {
        while (true) {
            int choice = getChoice();
            execute(choice);
            if (choice > options.size() - 1) {
                break;
            }
        }
    }

    public abstract void execute(int n);
}