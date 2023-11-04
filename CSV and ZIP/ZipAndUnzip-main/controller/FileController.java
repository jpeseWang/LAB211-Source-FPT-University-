package controller;

import common.Algorithm;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Menu;

public class FileController {

    private final String[] MAIN_MENU_ITEMS = {
        " Compression",
        " Extraction",
        " Exit",};

    Algorithm algorithm = new Algorithm();
    
    Menu mainMenu = new Menu("Main menu", MAIN_MENU_ITEMS) {
        @Override
        public void execute(int choice) {
            switch (choice) {
                case 1:
                {
                    try {
                        algorithm.zipFile();
                    } catch (IOException ex) {
                        Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                case 2:
                {
                    try {
                        algorithm.unzipFile();
                    } catch (IOException ex) {
                        Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                case 3:
                    System.exit(0);
                    break;

            }
        }
    };

    public void run() {
        mainMenu.run();
    }
}