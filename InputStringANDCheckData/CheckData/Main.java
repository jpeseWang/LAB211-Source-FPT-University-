package CheckData;

import CheckData.models.InputData;
import CheckData.view.InputDataView;
import CheckData.controller.InputDataController;

import java.util.Scanner;

public class Main {
    private final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Analysis String program ====");
        System.out.printf("Input string: ");
        String input = sc.nextLine();
        InputData inputData = new InputData(input);
        InputDataView inputDataView = new InputDataView(inputData);
        InputDataController inputDataController = new InputDataController(inputData, inputDataView);
        System.out.println(" ");
        System.out.println("Processing...");
        System.out.println(" ");
        inputDataController.handleRequest(input);
    }

}
