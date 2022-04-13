package AoC_2021.Day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day7 {
    public static void day7(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/vladnitu/Desktop/TUDelft/Q2/ADS/ads-things/src/main/java/AoC_2021/Day7/in.in"));
        String line = scanner.nextLine() ;
        scanner = new Scanner(line).useDelimiter(",") ;
        ArrayList<Integer> v = new ArrayList<>();
        int maxEl = -1 ;
        while (scanner.hasNext()) {
            int x = scanner.nextInt() ;
            v.add(x);
            maxEl = Math.max(maxEl, x) ;
        }

        int minFuel = Integer.MAX_VALUE;
        for (int i = 0 ; i <= maxEl ; ++i) // We can align the crabs even at positions that are not initially stored in our vector
        // for example, for [16,1,2,0,4,2,7,1,2,14], we can align the crabs at x = 5
        {
            int fuel = 0 ;
            for (int j = 0 ; j < v.size() ; ++j) {
                // For task 1 fuel += Math.abs(v.get(i) - v.get(j)
                int Max = Math.max(i, v.get(j));
                int Min = Math.min(i, v.get(j));
                int gauss = Max - Min;
                fuel += gauss * (gauss + 1) / 2;
            }


            minFuel = Math.min(fuel, minFuel) ;
        }

        System.out.println(minFuel);
        return;


    }
}
