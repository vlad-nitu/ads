package AoC_2021.Day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day11 {
    // O (step * N^2)

    public static void day11(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/vladnitu/Desktop/TUDelft/Q2/ADS/ads-things/src/main/java/AoC_2021/Day11/in.in"));
        int[][] a = new int[10][10];

        int res = 0;
        int i = -1;
        while (scanner.hasNextLine()) {
            i++;
            String s = scanner.nextLine();
            for (int j = 0; j < s.length(); ++j) {
                int x = s.charAt(j) - '0';
                a[i][j] = x;
            }
        }

        /*
        Part 1
        for (int step = 0; step < 100; ++step) {
        int subtask = update(a) ;
        res += update(a) ;
        }
        System.out.println(res) ;}
        */

        //Part 2
        int step = 0;
        int stop = -1;
        while (stop == -1) {

            int subtask = update(a);
            if (subtask == 100)
                stop = step + 1;
            else step++;
        }

       /* for ( i = 0 ; i < 10 ; ++i)
        {for (int j = 0 ; j < 10 ; ++j)
                System.out.print(a[i][j] + " ") ;
        System.out.println() ;}
        */

        System.out.println(stop);


    }

    public static int update(int[][] a) {

        int s = 0;
        //Helper arrays on 8 directions
        int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = new int[]{-1, 0, 1, 1, -1, -1, 0, 1};
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();


        for (int i = 0; i < 10; ++i)
            for (int j = 0; j < 10; ++j) {
                a[i][j]++;

                if (a[i][j] > 9) {
                    a[i][j] = 0;
                    s++;
                    for (int x = 0; x < 8; ++x) {
                        int xx = i + dx[x];
                        int yy = j + dy[x];
                        if (validate(xx, yy)) {
                            q1.offer(xx);
                            q2.offer(yy);
                        }
                    }
                }
            }

        while (!q1.isEmpty()) {
            int i = q1.poll();
            int j = q2.poll();

            if (a[i][j] != 0) // An octopus can flash AT MOST once per step
                a[i][j]++;

            if (a[i][j] > 9) {
                a[i][j] = 0;
                s++;
                for (int x = 0; x < 8; ++x) {
                    int xx = i + dx[x];
                    int yy = j + dy[x];
                    if (validate(xx, yy)) {
                        q1.offer(xx);
                        q2.offer(yy);
                    }
                }
            }
        }

        return s;
    }

    public static boolean validate(int i, int j) {
        return (i >= 0 && i < 10 && j >= 0 && j < 10);
    }

}
