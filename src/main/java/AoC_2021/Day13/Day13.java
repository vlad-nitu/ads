package AoC_2021.Day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day13 {

    public static void day13(String[] args) throws FileNotFoundException { //42 MIN
        Scanner scanner = new Scanner(new File("/Users/vladnitu/Desktop/TUDelft/Q2/ADS/ads-things/src/main/java/AoC_2021/Day13/in.in"));
        boolean[][] a = new boolean[894][1311];
        int MaxX, MaxY;
        MaxX = MaxY = -1;

        for (int i = 0; i < 950; ++i) {
            String line = scanner.nextLine();
            Scanner in = new Scanner(line).useDelimiter(",");
            int x = Integer.parseInt(in.next());
            int y = Integer.parseInt(in.next());
            MaxX = Math.max(MaxX, x);
            MaxY = Math.max(MaxY, y);
            a[y][x] = true;
        }

        //  System.out.println(MaxY + " " + MaxX);

        for (int step = 0; step < 12; ++step) {
            String command = scanner.nextLine();
            Scanner parseCommand = new Scanner(command);
            parseCommand.next(); // to jump over fold
            parseCommand.next(); // to jump over along
            command = parseCommand.next();
            int xx, yy;
            xx = yy = -1;

            if (command.charAt(0) == 'y') yy = Integer.parseInt(command.substring(2));
            else xx = Integer.parseInt(command.substring(2));


            //  System.out.println(xx + " "  + yy) ;

            if (yy != -1) { //  Horizontal fold
                int helper = 2 * yy;
                for (int i = 0; i < yy; ++i)
                    for (int j = 0; j < a[0].length; ++j)
                        if (valideY(a, helper - i))
                            a[i][j] = (a[helper - i][j] || a[i][j]);

                a = resize(a, yy, a[0].length);
            } else { // Vertical fold

                int helper = 2 * xx;
                for (int i = 0; i < a.length; i++)
                    for (int j = 0; j < xx; ++j)
                        if (valideX(a, helper - j))
                            a[i][j] = (a[i][helper - j] || a[i][j]);

                a = resize(a, a.length, xx);
            }
            //System.out.println(a.length + " " + a[0].length) ;
        }

        //  System.out.print(solution1(a));
        solution2(a);
    }

    public static boolean valideY(boolean[][] a, int y) {
        return (y >= 0 && y < a.length);
    }

    public static boolean valideX(boolean[][] a, int x) {
        return (x >= 0 && x < a[0].length);
    }

    public static boolean[][] resize(boolean[][] a, int y, int x) {
        boolean[][] b = new boolean[y][x];
        for (int i = 0; i < y; ++i)
            for (int j = 0; j < x; ++j) b[i][j] = a[i][j];

        return b;
    }

    public static int solution1(boolean[][] a) {
        int s = 0;
        for (int i = 0; i < a.length; ++i)
            for (int j = 0; j < a[0].length; ++j)
                if (a[i][j])
                    s++;
        return s;
    }

    public static void solution2(boolean[][] a) {
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; j < a[0].length; ++j)
                if (a[i][j])
                    System.out.print("# ");
                else System.out.print("- ");
            System.out.println();
        }
    }
}
