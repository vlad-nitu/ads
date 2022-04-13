package AoC_2021.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {

    public static void day1() throws FileNotFoundException {

        Scanner scanner = new Scanner (new File("/Users/vladnitu/Desktop/TUDelft/Q2/ADS/ads-things/src/main/java/AoC_2021/Day1/in.in"));
        int res = 0;

    /*while (scanner.hasNext()){
        int y = Integer.parseInt(scanner.next()) ;
        if (y > x)
            res ++ ;

        x = y;
    } Part 1 */
        int x = Integer.parseInt(scanner.next());
        int y = Integer.parseInt(scanner.next());
        int z = Integer.parseInt(scanner.next());
        while (scanner.hasNext()) {
            int t = Integer.parseInt(scanner.next()) ;
            if (y + z + t > x + y + z) res ++ ;

            x=y;
            y=z;
            z=t;
        }


        System.out.println(res) ;
    }
}
