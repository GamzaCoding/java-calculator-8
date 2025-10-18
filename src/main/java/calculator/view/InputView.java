package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
  private static final String ZERO_REGEX = "\"\"";
  private static final String DEFAULT_REGEX = "^[0-9]+([:,][0-9]+)*";
  private static final String CUSTOM_REGEX = "^//.+\\n.*";

  public String getInputString() {
    String inputString = Console.readLine();
    validate(inputString);
    return inputString;
  }

  private void validate(String inputString) {
    if (inputString.matches(ZERO_REGEX)) return;
    if (inputString.matches(DEFAULT_REGEX)) return;
    if (inputString.matches(CUSTOM_REGEX)) return;

    throw new IllegalArgumentException();
  }
}
