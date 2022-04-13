package sort;

import java.util.Arrays;

public class MergeSort {
    public static int[] sort(int[] v) {

        if (v == null) return null;
        if (v.length == 1) return v;

        //  DIVIDE
        int[] a = Arrays.copyOfRange(v, 0, v.length / 2);
        int[] b = Arrays.copyOfRange(v, v.length / 2, v.length);

        //CONQUER
        a = sort(a);
        b = sort(b);

        //COMBINE
        return merge(a, b);
    }

    public static int[] merge(int[] a, int[] b) {
        int i, j;
        i = j = 0;
        int[] c = new int[a.length + b.length];

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) c[i + j] = a[i++];
            else c[i + j] = b[j++];
        }

        while (i < a.length) c[i + j] = a[i++];
        while (j < b.length) c[i + j] = b[j++];

        return c;
    }
}
