
import controller.CoefficientsController;
import model.CoefficientsModel;
import view.Menu;

public class Main {
    public static void main(String[] args) {
        CoefficientsModel model = new CoefficientsModel();
        Menu view = new Menu();
        CoefficientsController controller = new CoefficientsController(model, view);

        controller.processCoefficients();
    }
}
