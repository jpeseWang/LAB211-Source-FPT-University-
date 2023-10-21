import view.UserInputView;
import models.DataModel;
import controller.DataController;

public class Main {
    public static void main(String[] args) {
        UserInputView view = new UserInputView();
        DataModel model = new DataModel();
        DataController controller = new DataController(view, model);

        controller.getUserInput();

        if (!controller.isPhoneValid(model.getPhone())) {
            System.err.println("Phone number must be 10 digits");
        } else if (!controller.isDateValid(model.getDate())) {
            System.err.println("Date must be in the correct format (dd/MM/yyyy)");
        } else if (!controller.isEmailValid(model.getEmail())) {
            System.err.println("Email must be in the correct format");
        } else {
            System.out.println("All inputs are valid.");
        }
    }
}
