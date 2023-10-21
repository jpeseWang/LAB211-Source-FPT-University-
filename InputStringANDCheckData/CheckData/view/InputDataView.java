package CheckData.view;

import CheckData.models.InputData;
import java.util.*;

public class InputDataView {
  private InputData inputData;

  public InputDataView(InputData inputData) {
    this.inputData = inputData;
  }

  public void display() {
    System.out.println("\t===== RESULT ===== ");
    System.out.println("Perfect Square Numbers: " + inputData.getPerfectSquareNumbers());
    System.out.println("Odd Numbers: " + inputData.getOddNumbers());
    System.out.println("Even Numbers: " + inputData.getEvenNumbers());
    System.out.println("All Numbers: " + inputData.getAllNumbers());

    System.out.println("Uppercase: " + inputData.getUppercase());
    System.out.println("Lowercase: " + inputData.getLowercase());
    System.out.println("Special: " + inputData.getSpecial());
    System.out.println("All Character: " + inputData.getAllCharacter());
  }
}