package AoC_2021.Day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day9 {
    public static void day9(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/vladnitu/Desktop/TUDelft/Q2/ADS/ads-things/src/main/java/AoC_2021/Day9/in.in"));
        int[][] a = new int[100][100];
        int i = -1;

        while (scanner.hasNextLine()) {
            i++;
            String line = scanner.nextLine();
            for (int j = 0; j < line.length(); ++j)
                a[i][j] = line.charAt(j) - '0';
        }

        int[][] b = new int[100][100];

        boolean[][] visit = new boolean[100][100] ;
        reinitialise(b,a,visit) ;
        int Max1,Max2,Max3;
        Max1=Max2=Max3=-1;

        // System.out.println(solve1(a)) ;


        int dig = 8 ; // Since we are not interested in 9
        while (dig >= 0) {

            int ind1 = -1, ind2 = -1;

            for (i = 0; i < 100; ++i)
                for (int j = 0; j < 100; ++j)
                    if (a[i][j] == dig && !visit[i][j]) {
                        ind1 = i;
                        ind2 = j;
                        i = 100;
                        j = 100;
                    }

            if (ind1 != -1 && ind2 != -1) {
                int res = solve2(a, dig, ind1, ind2, visit);
                if (res > Max1) {
                    Max3 = Max2;
                    Max2 = Max1;
                    Max1 = res;
                } else if (res > Max2) {
                    Max3 = Max2;
                    Max2 = res;
                } else if (res > Max3)
                    Max3 = res;
            }
            else dig -- ;

        }

        System.out.println(Max1 *  Max2 * Max3) ;
        return;
    }

    public static int solve2(int[][] a, int x,  int i, int j, boolean[][] visit) {

        int sum = 1;
        visit[i][j] = true;

        if (validate(i-1,j) && x >= a[i-1][j] && !visit[i-1][j]) sum += solve2(a,x,i-1,j,visit) ;
        if (validate(i+1,j) && x >= a[i+1][j] && !visit[i+1][j]) sum +=  solve2(a,x,i+1,j,visit);
        if (validate(i,j-1) && x >= a[i][j-1] && !visit[i][j-1]) sum += solve2(a,x,i,j-1,visit) ;
        if (validate(i,j+1) && x >= a[i][j+1] && !visit[i][j+1]) sum += solve2(a,x,i,j+1,visit) ;


        return sum;
    }

    public static int solve1(int[][] a) {
        int res = 0;

        for (int i = 0; i < 100; ++i)
            for (int j = 0; j < 100; ++j) {
                int x = a[i][j];
                if (lowPoint(a, x, i, j)) res += (x + 1);
            }
        return res;
    }

    public static boolean lowPoint(int[][] a, int x, int i, int j) {

        if (validate(i - 1, j) && x >= a[i - 1][j]) return false;
        if (validate(i + 1, j) && x >= a[i + 1][j]) return false;
        if (validate(i, j - 1) && x >= a[i][j - 1]) return false;
        if (validate(i, j + 1) && x >= a[i][j + 1]) return false;


        return true;
    }


    public static boolean validate(int i, int j) {
        return (i >= 0 && i < 100 && j >= 0 && j < 100);
    }

    public static void reinitialise(int[][] a, int[][] b, boolean[][] visit) {
        for (int i = 0; i < 100; ++i)
            for (int j = 0; j < 100; ++j)
            {a[i][j] = b[i][j];
                visit[i][j] = false; }

        return ;

    }
}
