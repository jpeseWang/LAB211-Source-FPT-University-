import controller.ContactController;
import view.View;

public class Main {
    public static void main(String[] args) {
        ContactController controller = new ContactController();
        View view = new View(controller);
        while (true) {
            view.execute();
        }
    }
}
