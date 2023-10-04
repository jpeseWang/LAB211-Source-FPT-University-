import java.util.ArrayList;

import Controllers.Manager;
import Models.Contact;

public class Main {
    public static void main(String[] args) {
        ArrayList<Contact> lc = new ArrayList<>();
        lc.add(new Contact(1, "John Cena", "Star", "America", "1234567890", "John", "Cena"));
        lc.add(new Contact(2, "Chris Evans", "Star", "England", "1234567890", "Chris", "Evans"));

        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.createContact(lc);
                    break;
                case 2:
                    Manager.printAllContact(lc);
                    break;
                case 3:
                    Manager.deleteContactd(lc);
                    break;
                case 4:
                    return;
            }
        }
    }
}