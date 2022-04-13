package AoC_2021.Day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8 {
    public static void day8(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/vladnitu/Desktop/TUDelft/Q2/ADS/ads-things/src/main/java/AoC_2021/Day8/in.in"));
        long res = 0;


        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner in = new Scanner(line);
            ArrayList<String> v = new ArrayList<>();
            ArrayList<String> digits = new ArrayList<>();
            for (int i = 0; i < 10; ++i) {
                v.add(in.next()); // Jump over 1st 10 digits
            }
            in.next(); // jump over "|"

            for (int i = 0; i < 10; ++i)
                v.set(i, order(v.get(i)));

            for (int i = 0; i < 4; ++i) {
                digits.add(in.next());
            }


            //Get all possible configurations
            for (int number = 1; number <= 5040; ++number) {
                int[] c = new int[8];
                c[7] = 0;
                create(c, 0, number);

                if (makesSense(c, v)) {
                    res += encode(digits, c);
                    break;
                }
            }
        }




       /* for (int i = 0; i < 4; ++i) {
            String digit = in.next();
            if (digit.length() == 2 || digit.length() == 3 || digit.length() == 4 || digit.length() == 7)
                res++;
        }*/


        System.out.println(res);
        return;

    }


    public static void create(int[] c, int N, int number) {

        if (N == 7) {
            c[7]++;
            if (c[7] == number) c[7] = -1;
        } else if (c[7] != -1)
            for (int i = 0; i < 7; ++i)
                if (c[7] != -1) {
                    c[N] = i;
                    if (verify(c, i, N))
                        create(c, N + 1, number);

                }
    }

    public static boolean verify(int[] c, int index, int N) {

        if (c[7] == -1) return false;

        for (int j = 0; j < N; ++j)
            if (c[j] == index) return false;
        return true;
    }

    public static boolean makesSense(int[] c, ArrayList<String> v) {


        for (String s : v) {
            if (s.length() == 2) // is digit 1
            {
                int one = s.charAt(0) - 'a';
                int second = s.charAt(1) - 'a';

                int[] indexes = new int[]{2, 5};

                if (!(in(c, one, indexes) && in(c, second, indexes)))
                    return false;

            } else if (s.length() == 3) { // is digit 7
                int one = s.charAt(0) - 'a';
                int second = s.charAt(1) - 'a';
                int third = s.charAt(2) - 'a';

                int[] indexes = new int[]{0, 2, 5};

                if (!(in(c, one, indexes) && in(c, second, indexes) && in(c, third, indexes))) return false;

            } else if (s.length() == 4) { // is digit 4
                int one = s.charAt(0) - 'a';
                int second = s.charAt(1) - 'a';
                int third = s.charAt(2) - 'a';
                int fourth = s.charAt(3) - 'a';

                int[] indexes = new int[]{1, 2, 3, 5};


                if (!(in(c, one, indexes) && in(c, second, indexes) && in(c, third, indexes) && in(c, fourth, indexes)))
                    return false;


            } else if (s.length() == 5) { // is 2,3, or 5
                int one = s.charAt(0) - 'a';
                int second = s.charAt(1) - 'a';
                int third = s.charAt(2) - 'a';
                int fourth = s.charAt(3) - 'a';
                int fifth = s.charAt(4) - 'a';

                int[] indexes1 = new int[]{0, 2, 3, 4, 6};
                int[] indexes2 = new int[]{0, 2, 3, 5, 6};
                int[] indexes3 = new int[]{0, 1, 3, 5, 6};

                if (!(in(c, one, indexes1) && in(c, second, indexes1) && in(c, third, indexes1) && in(c, fourth, indexes1) && in(c, fifth, indexes1)// 2
                        || (in(c, one, indexes2) && in(c, second, indexes2) && in(c, third, indexes2) && in(c, fourth, indexes2) && in(c, fifth, indexes2))// 3
                        || (in(c, one, indexes3) && in(c, second, indexes3) && in(c, third, indexes3) && in(c, fourth, indexes3) && in(c, fifth, indexes3))// 5
                )) return false;


            } else if (s.length() == 6) { // is 0, 6 or 9
                int one = s.charAt(0) - 'a';
                int second = s.charAt(1) - 'a';
                int third = s.charAt(2) - 'a';
                int fourth = s.charAt(3) - 'a';
                int fifth = s.charAt(4) - 'a';
                int sixth = s.charAt(5) - 'a';

                int[] indexes1 = new int[]{0, 1, 2, 4, 5, 6};
                int[] indexes2 = new int[]{0, 1, 3, 4, 5, 6};
                int[] indexes3 = new int[]{0, 1, 2, 3, 5, 6};

                if (!(in(c, one, indexes1) && in(c, second, indexes1) && in(c, third, indexes1) && in(c, fourth, indexes1) && in(c, fifth, indexes1) && in(c, sixth, indexes1)
                        || (in(c, one, indexes2) && in(c, second, indexes2) && in(c, third, indexes2) && in(c, fourth, indexes2) && in(c, fifth, indexes2) && in(c, sixth, indexes2))
                        || (in(c, one, indexes3) && in(c, second, indexes3) && in(c, third, indexes3) && in(c, fourth, indexes3) && in(c, fifth, indexes3) && in(c, sixth, indexes3))
                )) return false;
            }
        }

        return true;
    }

    public static int encode(ArrayList<String> digits, int[] c) {

        int x = 0;
        for (String digit : digits) {
            x = x * 10 + compute(digit, c);
        }

        return x;
    }

    public static int compute(String s, int[] c) {
        if (s.length() == 2) // is digit 1
        {
            return 1;
        } else if (s.length() == 3) { // is digit 7
            return 7;

        } else if (s.length() == 4) { // is digit 4
            return 4;

        } else if (s.length() == 7) { // is 8
            return 8;

        } else if (s.length() == 5) { // is 2,3, or 5
            int one = s.charAt(0) - 'a';
            int second = s.charAt(1) - 'a';
            int third = s.charAt(2) - 'a';
            int fourth = s.charAt(3) - 'a';
            int fifth = s.charAt(4) - 'a';

            int[] indexes1 = new int[]{0, 2, 3, 4, 6};
            int[] indexes2 = new int[]{0, 2, 3, 5, 6};
            int[] indexes3 = new int[]{0, 1, 3, 5, 6};

            if (in(c, one, indexes1) && in(c, second, indexes1) && in(c, third, indexes1) && in(c, fourth, indexes1) && in(c, fifth, indexes1)) // 2
                return 2;
            else if (in(c, one, indexes2) && in(c, second, indexes2) && in(c, third, indexes2) && in(c, fourth, indexes2) && in(c, fifth, indexes2))// 3
                return 3;
            else
                return 5;

        } else { // is 0, 6, or 9 -> length = 6
            int one = s.charAt(0) - 'a';
            int second = s.charAt(1) - 'a';
            int third = s.charAt(2) - 'a';
            int fourth = s.charAt(3) - 'a';
            int fifth = s.charAt(4) - 'a';
            int sixth = s.charAt(5) - 'a';

            int[] indexes1 = new int[]{0, 1, 2, 4, 5, 6};
            int[] indexes2 = new int[]{0, 1, 3, 4, 5, 6};
            int[] indexes3 = new int[]{0, 1, 2, 3, 5, 6};


            if (in(c, one, indexes1) && in(c, second, indexes1) && in(c, third, indexes1) && in(c, fourth, indexes1) && in(c, fifth, indexes1) && in(c, sixth, indexes1))
                return 0;
            else if (in(c, one, indexes2) && in(c, second, indexes2) && in(c, third, indexes2) && in(c, fourth, indexes2) && in(c, fifth, indexes2) && in(c, sixth, indexes2))
                return 6;
            else
                return 9;
        }
    }


    public static String order(String s) {
        //  String saux = new String() ;
        char[] saux = s.toCharArray();

        int N = s.length();
        for (int i = 0; i < N; ++i)
            for (int j = i + 1; j < N; ++j)
                if (saux[j] < saux[i]) {
                    char temp = saux[j];
                    saux[j] = saux[i];
                    saux[i] = temp;
                }

        return new String(saux);

    }

    public static boolean in(int[] v, int x, int[] indexes) { // if x is in 'v' on one of the positions from arr 'indexes'
        for (int i = 0; i < indexes.length; ++i) {
            int ind = indexes[i];
            if (x == v[ind]) return true;
        }
        return false;
    }


}
