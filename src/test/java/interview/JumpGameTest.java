package interview;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Size;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JumpGameTest {

    @ParameterizedTest
    @MethodSource("generate")
    void parameterizedTestCases(int[] nums, boolean expected) {
        assertThat(new JumpGame().solve(nums))
                .isEqualTo(expected);
    }

    @Property
    void goToTheEndTest( // Guaranteed to reach the end, since the worst case scenario would be: size = 1000 and List full of 1's
                         @ForAll @Size(min = 10, max = 1000) List<@IntRange(min = 10, max = 1000) Integer> list
    ) {
        int[] arr = convertListToArray(list);
        assertThat(JumpGame.solve(arr)).isTrue();
    }


    static Stream<Arguments> generate() {

        return Stream.of(

                //Exceptional cases
                Arguments.of(null, false), //T1, null array
                Arguments.of(new int[]{}, true), // T2, empty array
                Arguments.of(new int[]{1}, true), //T3, 1 element

                // N = 2
                Arguments.of(new int[]{1, 0}, true), //T4
                Arguments.of(new int[]{0, 2}, false), //T5

                // N > 2
                Arguments.of(new int[]{1, 2, 3}, true), //T6, 0 -> 1 -> 2
                Arguments.of(new int[]{1, 0, 2}, false), //T7, stuck at index 1
                Arguments.of(new int[]{1, 2, 0, 2, 0, 5}, true), //T8, exactly the path from 1 to last
                Arguments.of(new int[]{1, 1, 1, 1, 100}, true), //T9, exactly one by one
                Arguments.of(new int[]{0, 2, 3, 4, 5}, false), //T10, cannot move from first poition
                Arguments.of(new int[]{2, 1, 1, 0, 2, 4, 6}, false), //T11, stuck in the middle
                Arguments.of(new int[]{2, 1, 3, 0, 1, 0, 12}, false), //T12, stuck at the end
                Arguments.of(new int[]{100, 200, 5, 7, 8, 9, 3}, true) //T13, any path possible
        );
    }


    public static int[] convertListToArray(List<Integer> list) {
        return list.stream().mapToInt(i -> i).toArray();
    }


}
