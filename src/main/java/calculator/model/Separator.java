package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Separator {
  public static final String COMMA = ",";
  public static final String COLON = ":";
  private static final String CUSTOM_REGEX = "^//.+\\n.*";

  private final List<String> separators = new ArrayList<>(Arrays.asList(COMMA, COLON));

  public List<String> separate(String inputString) {
    if (isCustom(inputString)) {
      return customSeparate(inputString);
    }
    return defaultSeparate(inputString);
  }

  private List<String> customSeparate(String inputString) {
    String customSeparate = extractCustomSeparate(inputString);
    separators.add(customSeparate);

    String customInputString = inputString.substring(inputString.indexOf("\n") + 1);

    return defaultSeparate(customInputString);
  }

  private String extractCustomSeparate(String inputString) {
    int newlineIndex = inputString.indexOf("\n");
    return inputString.substring(2, newlineIndex);
  }

  private boolean isCustom(String inputString) {
    return inputString.matches(CUSTOM_REGEX);
  }

  public List<String> defaultSeparate(String inputString) {
    String regex = separators.stream()
        .map(Pattern::quote)
        .collect(Collectors.joining("|"));

    return Arrays.stream(inputString.split(regex))
        .map(String::trim)
        .collect(Collectors.toList());
  }
}
