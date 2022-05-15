package interview;

public class minimumNumberOfTaps {


    //https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
    // DP approach, O(n) time, O(n) space

        public static int minTaps(int n, int[] ranges) {
            // dp[i] -> the right-most position that can be reached
            int[] dp = new int[n+1];


            // Construct the 'dp' array
            for (int i = 0; i < ranges.length; ++i) {
                if (ranges[i] != 0) {
                    int Min = i - ranges[i];
                    int Max = i + ranges[i];

                    // In order to check only [0,N]
                    Min = Math.max(0, Min);
                    Max = Math.min(ranges.length, Max);

                    for (int j = Min; j < Max; ++j)
                        dp[j] = Math.max(dp[j], Max);
                }
            }

            int res = 0;
            int currTap = 0;


            while (currTap < ranges.length) { // while in range

                if (currTap == n) // reached the optimal solution.
                    return res;

                if (dp[currTap] == 0)
                    // if there's no future tap we can go to, it means that we are blocked -> no solution
                    return -1;

                currTap = dp[currTap]; // go as far to the right as possible
                res ++;
            }

            return res;

        }

}