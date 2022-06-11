package interview;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MissingNumberTest {

    @ParameterizedTest
    @MethodSource("generate")
    void testCases(int[] nums, int expected) {
        assertThat(MissingNumber.missingNumber(nums))
                .isEqualTo(expected);
    }

    static Stream<Arguments> generate() {
        Arguments args1 = Arguments.of(new int[]{0, 1}, 2); // T1 - Example from LeetCode
        Arguments args2 = Arguments.of(new int[]{0, 1, 2, 3}, 4); // T2 - Edge case - last element missing
        Arguments args3 = Arguments.of(new int[]{2, 0, 3, 6, 4, 9, 5, 7, 1}, 8); // T3 - element in middle misses
        Arguments args4 = Arguments.of(new int[]{1, 2, 3}, 0); // T4 - first element misses
        Arguments args5 = Arguments.of(new int[]{2,0,1,4} , 3); // T5
        return Stream.of(args1, args2, args3, args4, args5);
    }

}
