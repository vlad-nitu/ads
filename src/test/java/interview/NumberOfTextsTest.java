package interview;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfTextsTest {

    @ParameterizedTest
    @MethodSource("generate")
    void testCases(String pressedKeys, int expected) {
        assertThat(NumberOfTexts.countTexts(pressedKeys))
                .isEqualTo(expected);
    }

    static Stream<Arguments> generate() {

        return Stream.of(
                // Tests provided during LeetCode 292 weekly contest: T1 and T2
                Arguments.of("22233", 8), //T1
                Arguments.of("222222222222222222222222222222222222", 82876089), //T2
                Arguments.of("444479999555588866", 3136), //T3, edge case: 7 is 4 positions before 9, but 7 != 9
                Arguments.of("1", 1),//T4, base case
                Arguments.of("12345", 1) //T5, naive pressing one different digit
        );

    }
}
