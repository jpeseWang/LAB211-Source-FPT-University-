import Controllers.Manager;

public class Main {
    public static void main(String[] args) {
        Manager m = new Manager();

        while (true) {
            int choice = m.menu();
            switch (choice) {
                case 1:
                    m.addNewWord();
                    break;
                case 2:
                    m.deleteWord();
                    break;
                case 3:
                    m.translate();
                    break;
                case 4:
                    return;
            }
        }
    }
}