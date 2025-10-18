package calculator.model;

import java.util.List;

public class CalculatorMachine {

  public int sum(List<Integer> numbers) {
    return numbers.stream()
        .mapToInt(Integer::intValue)
        .sum();
  }
}
