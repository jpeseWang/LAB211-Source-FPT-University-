import java.util.ArrayList;
import model.Country;
import view.Menu;

public class Main {

    public static void main(String[] args) {
        ArrayList<Country> lc = new ArrayList<>();
        Menu.runMenu(lc);
    }
}
