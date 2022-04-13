package AoC_2021.Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Day2 {

    public static void day2() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/vladnitu/Desktop/TUDelft/Q2/ADS/ads-things/src/main/java/AoC_2021/Day2/in.in")) ;
        int x,y,aim;
        aim = x = y = 0;
    /*while (scanner.hasNext()){
        String line = scanner.nextLine() ;
        Scanner loc = new Scanner(line);

        String command = loc.next() ;
        int step = Integer.parseInt(loc.next()) ;
        //System.out.println(command + " " + step) ;

        if (command.equals("forward")) x += step;
        else if (command.equals("up")) y -= step;
        else y += step;
    } Part 1*/

        while (scanner.hasNext()) {
            String command = scanner.next();
            int step = Integer.parseInt(scanner.next());

            if (command.equals("forward")) {
                x += step;
                y += (aim * step);
            } else if (command.equals("down"))
                aim += step;
            else
                aim -= step;

        }


        System.out.println(x * y) ;
        return ;
    }
}
