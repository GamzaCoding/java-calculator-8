package calculator.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorMachineTest {
    @Test
    void 숫자들의_합_계산_기능() {
        //given
        CalculatorMachine calculatorMachine = new CalculatorMachine();
        List<String> numbers = List.of("1", "2", "3");
        int expect = 6;

        //when
        int actual = calculatorMachine.sum(numbers);

        //then
        Assertions.assertThat(actual).isEqualTo(expect);
    }
}