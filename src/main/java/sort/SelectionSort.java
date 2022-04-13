package sort;

public class SelectionSort {

    public static void sort(int[] v) {
        int N = v.length;
        for (int i = 0; i < N - 1; ++i) {
            int index = i;
            for (int j = i + 1; j < N; ++j)
                if (v[j] < v[index]) index = j; // Find the index of the minimum element in subarray [i, N)

            swap(v, i, index);
        }
    }

    public static void swap(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
        return;
    }
}
