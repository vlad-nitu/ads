package AoC_2021.Day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Day16 { // Part 1 only
    static long res = 0;
    static String b;
    static long eval = 0;
    static int lastTypeID = -1;
    static Stack<Long> st = new Stack<>();


    static void day16() throws FileNotFoundException {
        b = new String();
        Scanner scanner = new Scanner(new File("/Users/vladnitu/Desktop/TUDelft/Q2/ADS/ads-things/src/main/java/AoC_2021/Day16/in.in"));
        String hex = scanner.nextLine();
        for (int i = 0; i < hex.length(); ++i) {
            char c = hex.charAt(i);
            if (c == '0') b += "0000";
            if (c == '1') b += "0001";
            if (c == '2') b += "0010";
            if (c == '3') b += "0011";
            if (c == '4') b += "0100";
            if (c == '5') b += "0101";
            if (c == '6') b += "0110";
            if (c == '7') b += "0111";
            if (c == '8') b += "1000";
            if (c == '9') b += "1001";
            if (c == 'A') b += "1010";
            if (c == 'B') b += "1011";
            if (c == 'C') b += "1100";
            if (c == 'D') b += "1101";
            if (c == 'E') b += "1110";
            if (c == 'F') b += "1111";
        }

        solve_task1();

        // System.out.println(res) ;
        while (!st.isEmpty()) System.out.println(st.pop());
        //int packetID = lastTypeID;
       /* if (packetID == 1) {
            long res = 1;
            while (!st.isEmpty()) {
                res *= st.pop();
            }
            st.push(res);
        }
        if (packetID == 2) {
            long res = Long.MAX_VALUE;
            while (!st.isEmpty()) {
                res = Math.min(st.pop(), res);
            }
            st.push(res);
        }
        if (packetID == 3) {
            long res = -1 * Long.MAX_VALUE;
            while (!st.isEmpty()) {
                res = Math.max(st.pop(), res);
            }
            st.push(res);

        }

        if (packetID == 5) {
            long b = st.pop();
            long a = st.pop();
            if (a > b) st.push((long) 1);
            else st.push((long) 0);
        }
        if (packetID == 6) {
            long b = st.pop();
            long a = st.pop();
            if (a < b) st.push((long) 1);
            else st.push((long) 0);

        }
        if (packetID == 7) {
            long a = st.pop();
            long b = st.pop();
            if (a == b) st.push((long) 1);
            else st.push((long) 0);

        }
        System.out.println(st.peek()) ;*/

    }


    // 1100010000000001000000000000000000101100001000101010110001011001000100000000010000100011000111000110100
    // 100010100000000001001010100000000001101010000000000000101111010001111000
    public static void solve_task1() {
        if (!valid()) return;
        int packetVersion = Integer.parseInt(b.substring(0, 3), 2);
        //res += packetVersion ;

        b = b.substring(3);
        int packetID = Integer.parseInt(b.substring(0, 3), 2);
        b = b.substring(3);

        if (packetID == 4) {
            String s = solveLiteralValue(); // nothing added to sum of packetVersions
            solve_task1();
        } else {

            int typeID = Integer.parseInt(b.substring(0, 1));
            lastTypeID = typeID;
            b = b.substring(1);

            if (typeID == 0) {

                int length = Integer.parseInt(b.substring(0, 15), 2);
                b = b.substring(15);
                solve_task1();


            } else {

                int nr_subpackets = Integer.parseInt(b.substring(0, 11), 2);
                b = b.substring(11);
                for (int i = 0; i < nr_subpackets; ++i)
                    solve_task1();

            }

            if (packetID == 0) {
                long res = 0;
                while (!st.isEmpty()) {
                    res += st.pop();
                }
                st.push(res);
            }
            if (packetID == 1) {
                long res = 1;
                while (!st.isEmpty()) {
                    res *= st.pop();
                }
                st.push(res);
            }
            if (packetID == 2) {
                long res = Long.MAX_VALUE;
                while (!st.isEmpty()) {
                    res = Math.min(st.pop(), res);
                }
                st.push(res);
            }
            if (packetID == 3) {
                long res = -1 * Long.MAX_VALUE;
                while (!st.isEmpty()) {
                    res = Math.max(st.pop(), res);
                }
                st.push(res);

            }

            if (packetID == 5) {
                long b = st.pop();
                long a = st.pop();
                if (a > b) st.push((long) 1);
                else st.push((long) 0);
            }
            if (packetID == 6) {
                long b = st.pop();
                long a = st.pop();
                if (a < b) st.push((long) 1);
                else st.push((long) 0);

            }
            if (packetID == 7) {
                long a = st.pop();
                long b = st.pop();
                if (a == b) st.push((long) 1);
                else st.push((long) 0);

            }

        }
    }


    public static String solveLiteralValue() { // Form the new string for packetID = 4
        //ex. 011111100101 -> 2021
        int type = -1;
        String s = new String();
        do {
            type = Integer.parseInt(b.substring(0, 1));
            b = b.substring(1);

            s += b.substring(0, 4);
            b = b.substring(4);
        } while (type != 0);

        st.push(Long.parseLong(s, 2));
        return s;
    }


    public static boolean valid() {
        for (int i = 0; i < b.length(); ++i) if (b.charAt(i) != '0') return true;
        return false;
    }
}
