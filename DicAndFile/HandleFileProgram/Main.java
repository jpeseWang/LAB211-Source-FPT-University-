import Controllers.FileHandlingController;

public class Main {
    public static void main(String[] args) {
        FileHandlingController ctl = new FileHandlingController();
        while (true) {
            int choice = ctl.menu();
            switch (choice) {
                case 1:
                    ctl.findPersonInfo();
                    break;
                case 2:
                    ctl.coppyNewFile();
                    break;
                case 3:
                    return;
            }
        }
    }
}