import AoC_2021.Day1.*;
import AoC_2021.Day2.*;
import interview.*;
import sort.InsertionSort;
import sort.MergeSort;
import sort.QuickSortInPlace;
import sort.SelectionSort;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

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

        // Day1.day1();
    }
}
