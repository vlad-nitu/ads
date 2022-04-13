package AoC_2021.Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day5 {
    public static void day5(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/vladnitu/Desktop/TUDelft/Q2/ADS/ads-things/src/main/java/AoC_2021/Day5/in.in"));
        int Max = -1;
        int[][] a = new int[1000+1][1000+1] ;
        int res = 0;
        initialise(a) ;

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Scanner parse = new Scanner(line);
            String start = parse.next();
            parse.next(); // t o jump over ->
            String end = parse.next();

            Scanner sc = new Scanner(start).useDelimiter(",");
            int x1 = Integer.parseInt(sc.next());
            int y1 = Integer.parseInt(sc.next());

            sc = new Scanner(end).useDelimiter(",");
            int x2 = Integer.parseInt(sc.next());
            int y2 = Integer.parseInt(sc.next());

            if (x1 == x2) {
                for (int i = Math.min(y1,y2) ; i <= Math.max(y1,y2);  ++i)
                    a[i][x1] ++ ;

            }
            else if (y1 == y2){
                for (int j = Math.min(x1,x2) ; j <= Math.max(x1,x2);  ++j)
                    a[y1][j] ++ ;
            }
            else if (Math.abs(x1-x2) == Math.abs(y1-y2)) {//diagonal at 45 degrees

                //System.out.println(x1 + " " + y1 + " " + x2 + " " + y2) ;

                int copx1,copx2;
                copx1=x1; copx2 = x2;

                if (x1 >= x2 && y1 <= y2)
                    for (int i = y1 ; i <= y2; ++i)
                        a[i][copx1--] ++ ;

                else if (x1 <= x2 && y1 <= y2)
                    for (int i = y1; i <= y2; ++i)
                        a[i][copx1++] ++ ;
                else if (x1 >= x2 && y1 >= y2)
                    for (int i = y2 ; i <=  y1 ; ++i)
                        a[i][copx2++] ++;
                else if (x1 <= x2 && y1 >= y2)
                    for (int i = y2 ; i <=  y1 ; ++i)
                        a[i][copx2--] ++;


            }

            Max = Math.max(x1,Max);
            Max = Math.max(x2,Max);
            Max = Math.max(y1,Max);
            Max = Math.max(y2,Max);
        }

        for (int i = 0; i <= 1000;  ++i)
            for (int j = 0 ; j <= 1000 ; ++j)
                if (a[i][j] >=  2)
                    res ++ ;


        System.out.println(res);
            /*    for (int i =  0 ; i <= Max ; ++i)
                {for (int j =0;  j <= Max ; ++j)
                        System.out.print(a[i][j] + " ");
                    System.out.println();}*/

    }
    public static void initialise(int[][] a){
        for (int i = 0 ; i < 1000; ++i)
            for (int j = 0 ; j < 1000; ++j)
                a[i][j] = 0;
        return ;
    }
}
