package calculator.utility;

public final class RegexConstants {

    private RegexConstants() {
    }

    public static final String DOUBLE_QUOTATION_MARKS_INPUT_REGEX = "\"\"";
    public static final String DEFAULT_INPUT_REGEX = "^[0-9]+([:,][0-9]+)*";
    public static final String CUSTOM_INPUT_REGEX = "^//.+\\\\n.*";
}