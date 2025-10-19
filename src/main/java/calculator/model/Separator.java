package calculator.model;

import static calculator.utility.RegexConstants.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Separator {
  private static final String COMMA = ",";
  private static final String COLON = ":";
  private static final String ZERO = "0";
  private static final String BACK_SLASH = "\\";
  private static final String END_OF_HEADER_MARK = "n";
  private static final String DELIMITER = "|";
  private static final int FRONT_INDEX_OF_CUSTOM_SEPARATOR = 2;

  private final List<String> separators = new ArrayList<>(Arrays.asList(COMMA, COLON));

  public List<String> separate(String inputString) {
    if (isCustom(inputString)) {
      return customSeparate(inputString);
    }
    return defaultSeparate(inputString);
  }

  private boolean isCustom(String inputString) {
    return inputString.matches(CUSTOM_INPUT_REGEX);
  }

  private List<String> customSeparate(String inputString) {
    String customSeparate = extractCustomSeparator(inputString);
    separators.add(customSeparate);

    String customInputString = extractBodyFromInput(inputString);

    return defaultSeparate(customInputString);
  }

  private static String extractBodyFromInput(String inputString) {
    int endOfHeadIndex = inputString.indexOf(END_OF_HEADER_MARK);
    int bodyIndex = endOfHeadIndex + END_OF_HEADER_MARK.length();
    return inputString.substring(bodyIndex);
  }

  private String extractCustomSeparator(String inputString) {
    int behindIndexOfCustomSeparator = inputString.indexOf(BACK_SLASH);
    return inputString.substring(FRONT_INDEX_OF_CUSTOM_SEPARATOR, behindIndexOfCustomSeparator);
  }

  private List<String> defaultSeparate(String inputString) {
    if(inputString.equals(DOUBLE_QUOTATION_MARKS_INPUT_REGEX)) {
      return List.of(ZERO);
    }

    String regex = changeSeparatorsToRegex();

    return Arrays.stream(inputString.split(regex))
        .map(String::trim)
        .collect(Collectors.toList());
  }

  private String changeSeparatorsToRegex() {
    return separators.stream()
        .map(Pattern::quote)
        .collect(Collectors.joining(DELIMITER));
  }
}
