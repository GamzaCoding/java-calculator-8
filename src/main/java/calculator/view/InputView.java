package calculator.view;

import static calculator.utility.RegexConstants.BLANK_INPUT_REGEX;
import static calculator.utility.RegexConstants.CUSTOM_INPUT_REGEX;
import static calculator.utility.RegexConstants.DEFAULT_INPUT_REGEX;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getInputString() {
        String inputString = Console.readLine();
        validate(inputString);

        return inputString;
    }

    private void validate(String inputString) {
        if (inputString.matches(BLANK_INPUT_REGEX)) {
            return;
        }
        if (inputString.matches(DEFAULT_INPUT_REGEX)) {
            return;
        }
        if (inputString.matches(CUSTOM_INPUT_REGEX)) {
            return;
        }

        throw new IllegalArgumentException();
    }
}