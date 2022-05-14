package interview;

import java.util.ArrayList;
import java.util.List;

// LeetCode link: https://leetcode.com/problems/count-number-of-texts/
// O(N) time complexity, O(N) space complexity
// Dynamic Programming tabulation
public class NumberOfTexts {

        private static int MOD = 1000000007;
        private static List<Character> edgeCases;

    public static int countTexts(String pressedKeys) {

        edgeCases = new ArrayList<>();
        edgeCases.add('7');
        edgeCases.add('9');

        int N = pressedKeys.length();
        int[] dp = new int[N+1]; //dp[i] -> # of texts that can be sent having 'i' characters
        dp[0] = 1; // Empty string

        for (int i = 1; i <= N; ++i){
            char c = pressedKeys.charAt(i - 1);
            dp[i] = dp[i-1] % MOD;

            if (i >= 2 && c == pressedKeys.charAt(i-2)) // 2 consecutive digits
                dp[i] = (dp[i] + dp[i-2]) % MOD;
            else continue; // skip to the next loop

            if (i >= 3 && c == pressedKeys.charAt(i-3)) // 3 consecutive digits
                dp[i] = (dp[i] + dp[i-3]) % MOD;
            else continue; // skip to the next loop

            if (i >= 4 && edgeCases.contains(pressedKeys.charAt(i-4)) && c == pressedKeys.charAt(i-4)) // 4 consecutive digits, that may be only 7 or 9
                dp[i] = (dp[i] + dp[i-4]) % MOD;
        }


            return dp[N];
    }
}
