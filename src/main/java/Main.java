import interview.*;
import sort.InsertionSort;
import sort.MergeSort;
import sort.QuickSortInPlace;
import sort.SelectionSort;

public class Main {

    public static void main(String[] args) {
        
        int[] v = new int[]{3, 4, 1, 1, 0, 0};
        int solution = minimumNumberOfTaps.minTaps(5, v);
        System.out.println(solution);

        InsertionSort.sort(v);
        for (int x : v)
            System.out.print(x + " ");
        System.out.println();

        int[] arr = new int[]{5, 3, 8, 1, 0};
        MergeSort.sort(arr);
        for (int x : v)
            System.out.print(x + " ");
        System.out.println();

        arr = new int[]{5, 3, 8, 1, 0};
        SelectionSort.sort(arr);
        for (int x : v)
            System.out.print(x + " ");
        System.out.println();

        arr = new int[]{5, 3, 8, 1, 0};
        QuickSortInPlace.sort(arr);
        for (int x : v)
            System.out.print(x + " ");


    }
}
