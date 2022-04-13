package AoC_2021.Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 {

    public static void day3() throws FileNotFoundException{
        Scanner scanner = new Scanner(new File("/Users/vladnitu/Desktop/TUDelft/Q2/ADS/ads-things/src/main/java/AoC_2021/Day3/in.in"));
        int[][] a = new int[1000000][20];
        int i = 0;
        int N = 0, M = 0;
        while (scanner.hasNext()) {
            String s = scanner.next();
            N = s.length();
            int x = 0;
            for (int j = 0; j < N; ++j) {
                char c = s.charAt(j);
                a[i][j] = c - '0';
            }

            i++;
        }

        M = i;

 /*
         int[] mostCommon = new int[N];
        int[] leastCommon = new int[N];

        for (int j = 0; j < N; ++j) {
            int nr0, nr1;
            nr0 = nr1 = 0;

            for (i = 0; i < M; ++i)
                if (a[i][j] == 0) nr0++;
                else nr1++;


            if (nr1 > nr0) mostCommon[j] = 1;
            else mostCommon[j] = 0;
        }

        for (int j = 0; j < N; ++j) leastCommon[j] = Math.abs(mostCommon[j] - 1);



        int mostCommonInteger = transform(mostCommon, N) ;
        int leastCommonInteger = transform(leastCommon, N) ;

       System.out.println(mostCommonInteger * leastCommonInteger) ;

         Part 1*/

        for (int j = 0; j < N ; ++j) { // For oxygen
            int nr1,nr0;
            nr1 = nr0 = 0 ;

            for (i = 0 ; i < M ; ++i) if (a[i][j] == 0 && a[i][N] != -1) nr0 ++;
            else if (a[i][j] == 1 && a[i][N] != -1) nr1 ++ ;

            if (nr1 >= nr0){ // Discard with bit 0
                for (i = 0 ; i < M ; ++i)
                    if (a[i][j] == 0) a[i][N] = -1;
            }
            else for ( i = 0 ; i < M ; ++i) // Discard with bi 1
                if (a[i][j] == 1) a[i][N] = -1;

            //Test if there are more than 1 elements in order to continue the loop, break otherwise
            int cont = 0;
            for ( i = 0  ; i < M ; ++i)
                if (a[i][N] != -1) cont ++ ;

            if (cont <= 1) break;
        }

        int[] oxigen = new int[N] ;
        for ( i = 0 ; i < M ; ++i)
            if (a[i][N] != -1) {

                for (int j = 0; j < N; ++j)
                    oxigen[j] = a[i][j];


                break;
            }

        //Reset -1 from a[i][N]
        for (i = 0 ; i < M ; ++i) a[i][N] = 0;

        for (int j = 0; j < N ; ++j) { // For CO2
            int nr1,nr0;
            nr1 = nr0 = 0 ;

            for (i = 0 ; i < M ; ++i) if (a[i][j] == 0 && a[i][N] != -1) nr0 ++;
            else if (a[i][j] == 1 && a[i][N] != -1) nr1 ++ ;

            if (nr0 <= nr1){ // Discard with bit 1
                for (i = 0 ; i < M ; ++i)
                    if (a[i][j] == 1) a[i][N] = -1;
            }
            else for ( i = 0 ; i < M ; ++i) // Discard with bit 0
                if (a[i][j] == 0) a[i][N] = -1;

            //Test if there are more than 1 elements in order to continue the loop, break otherwise
            int cont = 0;
            for ( i = 0  ; i < M ; ++i)
                if (a[i][N] != -1) cont ++ ;

            if (cont <= 1) break;
        }

        int[] CO2 = new int[N] ;
        for (i = 0 ; i < M ; ++i)
            if (a[i][N] != -1){
                for (int j = 0 ; j < N ; ++j)
                    CO2[j] = a[i][j];

                break;
            }

        int oxigenInt = transform(oxigen, N);
        int CO2Int = transform(CO2, N);
        System.out.print(oxigenInt  * CO2Int) ;



    }

    public static int transform (int[] v ,int N){
        int res = 0 ;
        for (int i = 0 ; i < N  ; ++i) {
            if (v[i] == 1)
                res += (int) Math.pow(2, N - i - 1);
        }

        return res;
    }
}
