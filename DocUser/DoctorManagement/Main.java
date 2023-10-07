package DoctorManagement;

import DoctorManagement.models.*;
import DoctorManagement.view.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Doctor> ld = new ArrayList<>();
        Menu.displayMenu(ld);
    }
}