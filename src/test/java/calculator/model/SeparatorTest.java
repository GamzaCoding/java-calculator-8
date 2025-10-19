package calculator.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SeparatorTest {

    private Separator separator;

    @BeforeEach
    void init() {
        separator = new Separator();
    }


    @Test
    void 디폴트_구분자_기능() {
        //given
        String inputString = "1,2:3";
        List<String> expect = List.of("1", "2", "3");

        //when
        List<String> actual = separator.separate(inputString);

        //then
        Assertions.assertThat(expect).isEqualTo(actual);
    }

    @Test
    void 커스텀_구분자_구분_기능() {
        //given
        String customInputString = "//;\\n1;2;3";
        List<String> expect = List.of("1", "2", "3");

        //when
        List<String> actual = separator.separate(customInputString);

        //then
        Assertions.assertThat(expect).isEqualTo(actual);
    }
}