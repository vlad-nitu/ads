package AoC_2021.Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6 {
    public static void day6(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/vladnitu/Desktop/TUDelft/Q2/ADS/ads-things/src/main/java/AoC_2021/Day6/in.in"));
        Scanner input = new Scanner(scanner.nextLine()).useDelimiter(",");
        Scanner inout = new Scanner(System.in);

        int numberOfDays = inout.nextInt();


        int Max = -1;
        ArrayList<Integer> arr = new ArrayList<>();
        while (input.hasNext()) { // create initial arr
            int x = Integer.parseInt(input.next());
            arr.add(x);
            Max = Math.max(Max, x);
        }

        /*     TASK 1
        for (int i = 0; i < numberOfDays; ++i)
            modify(arr);

        System.out.println(arr.size() + "\n" + Integer.MAX_VALUE);
        return;
        */

        long[] inc = new long[9]; //
        initialise(inc) ;

        long numberOfFishes = arr.size();
        for (Integer x : arr)
            inc[x]++;

        for (int day = 0; day < numberOfDays; ++day) {
            numberOfFishes += inc[day % 9];
            inc[ (day + 7) % 9] += inc[day % 9];
        }

        System.out.println(numberOfFishes);


    }

    public static void modify(ArrayList<Integer> arr) {
        int N = arr.size();
        for (int i = 0; i < N; ++i) {
            if (arr.get(i) == 0) {
                arr.set(i, 6);
                arr.add(8);
            } else arr.set(i, arr.get(i) - 1);
        }

        return;
    }

    public static void initialise(long[] v) {
        for (int i = 0 ; i < v.length ; ++i)
            v[i] = 0;

        return;
    }
}
