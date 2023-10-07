package UserManagement.controller;

import UserManagement.common.Validate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Manager {

    // display menu
    public static int menu() {
        System.out.println(" ");
        System.out.println("======= USER MANAGEMENT SYSTEM =======");
        System.out.println("1. Create a new account.");
        System.out.println("2. Login system.");
        System.out.println("3. Exit.");
        System.out.print("Enter your choice: ");
        int choice = Validate.checkInputIntLimit(1, 3);
        return choice;
    }

    // create a new account
    public static void createNewAccount() {
        // check file data exist or not
        if (!Validate.checkFileExist()) {
            return;
        }
        String username = Validate.checkInputUsername();
        String password = Validate.checkInputPassword();
        // check username exist or not
        if (!Validate.checkUsernameExist(username)) {
            System.err.println("Username exist.");
            return;
        }
        addAccountData(username, password);
    }

    // login system
    public static void loginSystem() {
        // check file data exist or not
        if (!Validate.checkFileExist()) {
            return;
        }
        String username = Validate.checkInputUsername();
        String password = Validate.checkInputPassword();
        // check username exist or not
        if (!Validate.checkUsernameExist(username)) {
            if (!password.equalsIgnoreCase(passwordByUsername(username))) {
                System.err.println("Password incorrect.");
            }
            System.err.println("Login success.");
        }
    }

    // write new account to data
    public static void addAccountData(String username, String password) {
        File file = new File("UserManagement/Models/user_data.txt");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(username + ";" + password + "\n");
            fileWriter.close();
            System.err.println("Create successfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // get password by username
    public static String passwordByUsername(String username) {
        File file = new File("UserManagement/Models/user_data.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] account = line.split(";");
                if (username.equalsIgnoreCase(account[0])) {
                    return account[1];
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
