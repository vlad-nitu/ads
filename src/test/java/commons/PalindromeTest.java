package commons;

import net.jqwik.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromeTest {

    @Property
    void validPalindrome(
            @ForAll("generateValid") String s
    ){
            assertThat(Palindrome.isPalindrome(s))
                    .isTrue();
    }

    @Property
    void invalidPalindrome(
            @ForAll("generateInvalid") String s
    ){
        assertThat(Palindrome.isPalindrome(s))
                .isFalse();
    }

    @Provide
    private Arbitrary<String> generateValid() {
        return Arbitraries.oneOf(
        Arbitraries.strings().map(x -> x + reverse(x)), // even length
        Arbitraries.strings().map(x -> x + "a" + reverse(x))   // odd length
        );
    }

    @Provide
    private Arbitrary<String> generateInvalid(){
        return Arbitraries.oneOf(
        Arbitraries.strings().filter(x -> (!x.equals(reverse(x)))),
        Arbitraries.strings().withCharRange('a', 'z').map(x -> "a" + x + "b")
        );
    }

    private static String reverse(String s) {
        StringBuilder builder = new StringBuilder();
        builder.append(s);
        return builder.reverse().toString();
    }

}
