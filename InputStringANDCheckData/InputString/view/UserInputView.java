package view;

import java.util.*;

public class UserInputView {
    private final Scanner in = new Scanner(System.in);

    public String getPhoneInput() {
        System.out.print("Phone number: ");
        return in.nextLine();
    }

    public String getDateInput() {
        System.out.print("Date: ");
        return in.nextLine();
    }

    public String getEmailInput() {
        System.out.print("Email: ");
        return in.nextLine();
    }
}
