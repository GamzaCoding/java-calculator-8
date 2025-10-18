package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Separator {
  public static final String COMMA = ",";
  public static final String COLON = ":";

  private final List<String> separators = new ArrayList<>(Arrays.asList(COMMA, COLON));

  public List<String> separate(String inputString) {

    String regex = separators.stream()
        .map(Pattern::quote)
        .collect(Collectors.joining("|"));

    return Arrays.stream(inputString.split(regex))
        .map(String::trim)
        .collect(Collectors.toList());
  }
}
