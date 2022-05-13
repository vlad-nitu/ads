package interview;

// https://leetcode.com/problems/jump-game/
// N = arr.length
// Time complexity: O(N*max(a[i])), i = 0, N - 1
// Memory: O(N)


public class JumpGame {

    public static boolean solve(int[] arr) {


        if (arr == null)
            return false;
        if (arr.length <= 1)
            return true;

        boolean[] dp = new boolean[arr.length];
        // dp[i] -> true, if you can get from 'i' to the last element
        dp[arr.length - 1] = true;

        int N = arr.length;
        for (int i = N - 2; i >= 0; --i)
            for (int j = 1; j <= arr[i]; ++j)
                if (i + j < N)
                    dp[i] = dp[i] || dp[i + j];


        return dp[0];
    }
}
