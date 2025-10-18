package calculator.controller;

import calculator.model.CalculatorMachine;
import calculator.model.Separator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {
  private final InputView inputView = new InputView();
  private final OutputView outputView = new OutputView();
  private final CalculatorMachine calculatorMachine = new CalculatorMachine();
  private final Separator separator = new Separator();

  public void run() {
    outputView.init();
    String inputString = inputView.getInputString();
    List<String> numbers = separator.separate(inputString);
    int result = calculatorMachine.sum(numbers);
    outputView.printResult(result);
  }
}
