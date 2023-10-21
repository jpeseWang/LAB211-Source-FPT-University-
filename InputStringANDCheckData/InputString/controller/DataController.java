package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import models.DataModel;
import view.UserInputView;

public class DataController {

    private UserInputView view;
    private DataModel model;

    public DataController(UserInputView view, DataModel model) {
        this.view = view;
        this.model = model;
    }

    public void getUserInput() {
        model.setPhone(view.getPhoneInput());
        model.setDate(view.getDateInput());
        model.setEmail(view.getEmailInput());
    }

    public boolean isPhoneValid(String phone) {
        return phone.matches("^[0-9]{10}$");
    }

    public boolean isDateValid(String date) {
        try {
            new SimpleDateFormat("dd/MM/yyyy").parse(date);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    public boolean isEmailValid(String email) {
        return email.matches("^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$");
    }
}
