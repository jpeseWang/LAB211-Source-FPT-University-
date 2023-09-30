package view;

import java.util.ArrayList;

import model.Country;
import controller.ManageEastAsiaCountries;

public class Menu {
    public static void runMenu(ArrayList<Country> lc) {
        while (true) {
            int choice = ManageEastAsiaCountries.menu();
            System.out.println("  ");
            switch (choice) {
                case 1:
                    ManageEastAsiaCountries.inputCountry(lc);
                    break;
                case 2:
                    ManageEastAsiaCountries.printCountry(lc);
                    break;
                case 3:
                    ManageEastAsiaCountries.searchByName(lc);
                    break;
                case 4:
                    ManageEastAsiaCountries.printCountrySorted(lc);
                    break;
                case 5:
                    return;
            }
        }
    }
}
