package interview;

// LeetCode link: https://leetcode.com/problems/missing-number/
// O(N) time, O(1) space, bit manipulation
// a^x^x = a^0 = a, for any x
public class MissingNumber {

    public static int missingNumber(int[] nums) {

        int XOR = 0;
        int N = nums.length;
        for (int i = 0; i < N; ++i) {
            XOR ^= (i ^ nums[i]);
        }

        XOR ^= N; // XOR 'N' too, as we are interested in [0,N]

        return XOR;

    }


}
