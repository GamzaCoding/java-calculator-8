package calculator.model;

import java.util.List;
import java.util.stream.Collectors;

public class CalculatorMachine {

    public int sum(List<String> numbers) {
        return stringToInt(numbers).stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private List<Integer> stringToInt(List<String> stringNumbers) {
        return stringNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}