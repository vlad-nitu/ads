package interview;

// jump1: https://leetcode.com/problems/jump-game/
// jump2: https://leetcode.com/problems/jump-game-ii/
// N = arr.length
// Time complexity: O(N*max(a[i])), i = 0, N - 1
// Memory: O(N)


public class JumpGame {

    public static boolean jump1(int[] arr) {
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

    public static int jump2(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        for (int i = 0; i < N - 1; ++i)
            dp[i] = Integer.MAX_VALUE;


        for (int i = N - 1; i >= 0; --i)
            for (int j = 1; j <= nums[i]; ++j)
                if (i + j < N && dp[i + j] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i + j] + 1, dp[i]);


        return dp[0];
    }
}
