import Models.Circle;
import Models.Rectangle;
import Models.Triangle;
import Utlls.Input;

public class Main {
    public static void main(String[] args) {
        Input in = new Input();

        Rectangle rectangle = in.inputRectangle();
        Circle circle = in.inputCircle();
        Triangle trigle = in.inputTriangle();

        in.display(trigle, rectangle, circle);
    }
}