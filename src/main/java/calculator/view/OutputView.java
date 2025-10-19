package calculator.view;

public class OutputView {
    private static final String INIT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과 : ";

    public void init() {
        System.out.println(INIT_MESSAGE);
    }

    public void printResult(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}