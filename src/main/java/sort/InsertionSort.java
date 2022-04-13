package sort;


public class InsertionSort {

    public static void sort(int[] v) {
        int N = v.length;

        for (int i = 1; i < N; ++i) {
            int j = i - 1;
            int el = v[i];
            while (j >= 0 && v[j] > el) {
                v[j + 1] = v[j];
                j--;
            }

            v[j + 1] = el;
        }

        return;
    }
}
