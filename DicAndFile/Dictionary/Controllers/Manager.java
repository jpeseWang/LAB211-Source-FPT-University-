package Controllers;

import java.util.HashMap;

import Utils.Validation;

public class Manager {
    final HashMap<String, String> hm = new HashMap<>();

    public int menu() {
        System.out.println("1. Add new word.");
        System.out.println("2. Delete word.");
        System.out.println("3. Search word.");
        System.out.println("4. Exit.");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 4);
        return choice;
    }

    public void addNewWord() {
        System.out.print("Enter English: ");
        String english = Validation.checkInputString();
        if (isKeywordExist(english)) {
            if (!Validation.checkInputYN()) {
                return;
            }
        }
        System.out.print("Enter Vietnamese: ");
        String vietnam = Validation.checkInputString();
        // check key word english exist or not
        hm.put(english, vietnam);
        System.err.println("Add successful.");
    }

    // delete word
    public void deleteWord() {
        System.out.print("Enter english: ");
        String english = Validation.checkInputString();
        hm.remove(english);
        System.err.println("Delete successful.");
    }

    // translate
    public void translate() {
        System.out.print("Enter english: ");
        String english = Validation.checkInputString();

        for (String key : hm.keySet()) {
            if (key.equals(english)) {
                System.out.println("Vietnamese: " + hm.get(key));
                return;
            }
        }
        System.err.println("Not found in data");
    }

    // check key englist exist
    public boolean isKeywordExist(String english) {
        for (String key : hm.keySet()) {
            if (key.equals(english)) {
                return true;
            }
        }
        return false;
    }
}