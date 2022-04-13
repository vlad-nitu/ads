package AoC_2021.Day17;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day17 {
    public static void day17(String[] args) throws FileNotFoundException {
        // Parse the input
        Scanner scanner = new Scanner(new File("/Users/vladnitu/Desktop/TUDelft/Q2/ADS/ads-things/src/main/java/AoC_2021/Day16/in.in"));
        scanner.next(); // To jump over 'target area: '; -> 1st part of the input
        String parse = scanner.next(); //2nd part of the input
        parse = scanner.next(); //2nd part of the input

        parse = parse.substring(2); // jump over 'x='
        int targetx1 = Integer.parseInt(parse.substring(0, 2));
        parse = parse.substring(4); // jump over 'targetx1..'
        int targetx2 = Integer.parseInt(parse.substring(0, 2));

        parse = scanner.next(); //3rd part of the input
        parse = parse.substring(2); // jump over 'y='
        int targety1 = Integer.parseInt(parse.substring(0, 4));
        parse = parse.substring(6); // jump over   'targety1..'
        int targety2 = Integer.parseInt(parse.substring(0, 4));


        int x, y;
        int maxvy = -(targety1 + 1); // 'y' coordinates mirrors due to gravity, independent of 'x', works for all inputs with negative y targets
        int maxHeight = Integer.MIN_VALUE;
        int number_of_hits = 0;
        for (int vy = targety1; vy <= maxvy; ++vy)
            for (int vx = 1; vx <= targetx2; vx++) {

                int vx_loc = vx;
                int vy_loc = vy;
                x = y = 0; // Start from top-left corner
                boolean go = true;
                while (x < targetx2 && y > targety1 && go) {

                    //Update current location
                    x += vx_loc;
                    y += vy_loc;


                    maxHeight = Math.max(y, maxHeight); // Part1 -> maxHeight reached
                    if (x >= targetx1 && x <= targetx2 && y >= targety1 && y <= targety2) { // Check if it is inside the target
                        number_of_hits++;///Part 2 -> for how many (vx,vy) velocities we get into the target
                        go = false;
                        //  System.out.println(x + " " + y)

                    }

                    //Update velocities for the next steps
                    if (vx_loc > 0) vx_loc--;
                    else if (vx_loc < 0) vx_loc++;

                    vy_loc--;
                }

            }

        System.out.println(maxHeight); // Part1
        System.out.println(number_of_hits); // Part2


    }
}
