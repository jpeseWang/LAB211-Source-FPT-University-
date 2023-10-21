package CheckData.controller;

import CheckData.models.*;
import CheckData.view.*;

public class InputDataController {
  private InputData inputData;
  private InputDataView inputDataView;

  public InputDataController(InputData inputData, InputDataView inputDataView) {
    this.inputData = inputData;
    this.inputDataView = inputDataView;
  }

  public void handleRequest(String inputString) {
    this.inputData = new InputData(inputString);
    this.inputDataView.display();
  }
}
