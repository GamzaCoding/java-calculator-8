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
    String customSeparate = extractCustomSeparate(inputString);
    separators.add(customSeparate);

    String customInputString = inputString.substring(inputString.indexOf("n") + 1);

    return defaultSeparate(customInputString);
  }

  private String extractCustomSeparate(String inputString) {
    int newlineIndex = inputString.indexOf("\\");
    return inputString.substring(2, newlineIndex);
  }

  private List<String> defaultSeparate(String inputString) {
    if(inputString.equals("\"\"")) {
      return List.of("0");
    }

    String regex = separators.stream()
        .map(Pattern::quote)
        .collect(Collectors.joining("|"));

    return Arrays.stream(inputString.split(regex))
        .map(String::trim)
        .collect(Collectors.toList());
  }
}
