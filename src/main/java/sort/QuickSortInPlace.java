package sort;

public class QuickSortInPlace {

    // QuickSort In-Place -> O(N) space, O(NlogN) expected time, O(N^2) Wors-case
    public static void sort(int[] nums) {

        if (nums == null) return;

        QSInPlace(nums, 0, nums.length - 1);

        return;

    }

    public static void QSInPlace(int[] nums, int a, int b) {

        if (a >= b) return; // trivially sorted
        int left = a;
        int right = b - 1;
        int pivot = nums[b];

        while (left <= right) {

            while (left <= right && nums[left] < pivot) left++;
            // Lower elements to the left of the pivot
            while (left <= right && nums[right] > pivot) right--;
            // Higher elements to the right of the pivot

            if (left <= right) {
                swapValues(nums, left, right);
                left++;
                right--;
            }

        }

        swapValues(nums, left, b); // Put pivot in the right spot -> nums[left]

        // Recursive calls to sort the subarrays to the left and right of pivot
        QSInPlace(nums, a, left - 1);
        QSInPlace(nums, left + 1, b);

    }

    public static void swapValues(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        return;
    }

}
