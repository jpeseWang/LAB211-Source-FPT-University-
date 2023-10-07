package DoctorManagement.view;

import java.util.ArrayList;
import DoctorManagement.controller.Manager;
import DoctorManagement.models.Doctor;

public class Menu {
    public static void displayMenu(ArrayList<Doctor> ld) {
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.addDoctor(ld);
                    break;
                case 2:
                    Manager.updateDoctor(ld);
                    break;
                case 3:
                    Manager.deleteDoctor(ld);
                    break;
                case 4:
                    Manager.searchDoctor(ld);
                    break;
                case 5:
                    return;
            }
        }
    }
}
