package calculator.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SeparatorTest {
  @Test
  void 디폴트_구분자_기능() {
    //given
    Separator separator = new Separator();
    String inputString = "1,2:3";

    List<String> expect = List.of("1", "2", "3");

    //when
    List<String> actual = separator.separate(inputString);

    //then
    Assertions.assertThat(expect.equals(actual)).isTrue();
  }
}