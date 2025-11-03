package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class LottoTest {

    @ParameterizedTest
    @DisplayName("random number 6개를 통해 lotto가 제대로 만들어지는지(err없이 작동)")
    @MethodSource("randomNumbers")
    public void LottoTest(List<Integer> numbers) {
        assertThatCode(() -> new Lotto(numbers)).doesNotThrowAnyException();
    }

    static Stream<Arguments> randomNumbers() {
        return Stream.of(
                Arguments.of(List.of(4, 5, 6, 7, 8, 9))      // 첫 번째 실행
        );
    };

//    @DisplayName("getNumbers() 동작 시 6개의 숫자가 출력되는지")



}
