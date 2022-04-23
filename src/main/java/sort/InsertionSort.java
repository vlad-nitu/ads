package sort;


public class InsertionSort {

    public static void sort(int[] elements) {
        if (elements == null) return;

        int n = elements.length;
        int i = 1;
        while (i < n) {
            int j = i;
            int el = elements[i];
            while (j >= 1 && elements[j - 1] >= el) {
                elements[j] = elements[j - 1];
                j--;
            }

            elements[j] = el;
            i++;
        }

        return;
    }
}
