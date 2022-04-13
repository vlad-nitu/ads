package AoC_2021.Day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Day10 {

    public static void day10(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/vladnitu/Desktop/TUDelft/Q2/ADS/ads-things/src/main/java/AoC_2021/Day10/in.in"));
        ArrayList<Long> v = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Stack<Character> st = new Stack<>();

            // For part 1, if (!isIncomplete) -> corrupted, compute the given problem

            //Part 2
            if (isIncomplete(line, st) && !st.isEmpty()) { // incomplete
                v.add(computeScore(st));//Add it to our list
            }
        }

        //Sorting array v
        sort(v);

        //Print result
        System.out.println(v.get(v.size() / 2));
    }

    public static boolean isIncomplete(String line, Stack<Character> st) {

        boolean OK = true;
        char corrupted;
        for (int i = 0; i < line.length() && OK; ++i) {
            char c = line.charAt(i);
            if (c == '(' || c == '[' || c == '{' || c == '<') { // if open bracket, push it into the stack
                st.push(c);
            } else if (c == ']' || c == ')' || c == '}' || c == '>') { // if closed bracket
                if ((c == ')' && st.peek() == '(')
                        || (c == ']' && st.peek() == '[')
                        || (c == '}' && st.peek() == '{')
                        || (c == '>' && st.peek() == '<')) // if it matches the last bracket, pop the last bracket from the stack
                    st.pop();
                else { // does not match -> return False
                    OK = false;
                    corrupted = c;
                }
            }
        }

        return OK;
    }

    public static long computeScore(Stack<Character> st) {
        int s = 0;
        long score = 0;
        while (!st.isEmpty()) { // Calculate score
            char c = st.pop();
            if (c == '(') s = 1;
            else if (c == '[') s = 2;
            else if (c == '{') s = 3;
            else s = 4;

            score = score * 5 + s;
        }

        return score;
    }

    public static void sort(ArrayList<Long> v) {
        for (int i = 0; i < v.size(); ++i)
            for (int j = i + 1; j < v.size(); ++j)
                if (v.get(j) < v.get(i)) {
                    long temp = v.get(i);
                    v.set(i, v.get(j));
                    v.set(j, temp);
                }

        return;
    }
}
