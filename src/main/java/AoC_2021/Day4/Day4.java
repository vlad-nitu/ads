package AoC_2021.Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {
    public static void day4(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner (new File("/Users/vladnitu/Desktop/TUDelft/Q2/ADS/ads-things/src/main/java/AoC_2021/Day4/in.in"));
        String line = scanner.nextLine() ;
        Scanner first = new Scanner(line).useDelimiter(",") ;

        ArrayList<Integer> numbers = new ArrayList<>() ;
        int alreadyWon = 0;

        while (first.hasNext())
            numbers.add(Integer.parseInt(first.next()));
        int[][][] a = new int[100][5][6] ; // Depends on input

        for (int mat = 0 ; mat < 100;  ++mat) {

            for (int i = 0 ; i < 5 ; ++i)
                for (int j = 0 ; j < 5 ; ++j)
                    a[mat][i][j] = Integer.parseInt(scanner.next()) ;

        }

        //  boolean win = false;

        for (int step = 0 ; step < numbers.size(); ++step) {
            int x = numbers.get(step) ;
            for (int mat = 0 ; mat < 100 ; ++mat) {

                int[] tuple = change(a[mat],x) ;
                if(tuple[0] != -1 && check(a[mat], tuple[0], tuple[1])){
                    a[mat][0][5] = -1 ; // mark that it won
                    alreadyWon ++ ;
                    if (alreadyWon == 100) // Depends on input
                        System.out.println(product(a[mat], x));
                    //return ;
                }
            }


        }
    }
    public static int[] change (int[][] b, int x){
        int[] v = new int[2];
        v[0] = v[1] = -1;
        for (int i = 0 ; i <  5;  ++i)
            for (int j = 0 ; j < 5 ; ++j)
                if (b[i][j] == x) {
                    v[0] = i;
                    v[1] = j;
                    b[i][j] = -1;
                    i=j=5; // break;
                }


        return v;

    }

    public static boolean check (int[][] b, int lin,int col) {

        if (b[0][5] == -1) return false; // already won before

        boolean stop1 = false ;
        boolean stop2 = false ;

        for (int j = 0 ; j < 5 ; ++j)
            if (b[lin][j] != -1) stop1 = true;



        for (int i = 0  ; i < 5  ;  ++i)
            if (b[i][col] != -1) stop2 = true;

        return (!stop1 || !stop2);

    }

    public static int product (int[][] b, int x) {
        int s = 0;
        for (int i = 0; i < 5;  ++i)
            for (int j = 0 ; j < 5 ; ++j)
                if (b[i][j] != -1) s += b[i][j];

        return s*x ;

    }
}
