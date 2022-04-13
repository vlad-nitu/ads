package AoC_2021.Day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day12 {
    public static void day12(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/vladnitu/Desktop/TUDelft/Q2/ADS/ads-things/src/main/java/AoC_2021/Day12/in.in"));
        ArrayList<Node> G = new ArrayList<>();
        int[] res = new int[1];
        ArrayList<String> v = new ArrayList<>();
        v.add("start");
        int[] visit = new int[100000];
        boolean[] done = new boolean[1];
        visit[Compute("start")] = 2; //convention that "start" string has visit = 2

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner parse = new Scanner(line).useDelimiter("-");
            String a = parse.next();
            String b = parse.next();
            G.add(new Node(a, b));
            G.add(new Node(b, a));
        }
        Back(G, v, res, visit, done);
        System.out.println(res[0]);
    }

    public static void Back(ArrayList<Node> G, ArrayList<String> v, int[] res, int[] visit, boolean[] done) {

        boolean oldDone = false;

        if (end(v)) {
            res[0]++;

        } else {
            for (int i = 0; i < G.size(); ++i) {
                oldDone = done[0];
                if (validate(v, G.get(i).getA(), G.get(i).getB(), visit, done)) {
                    visit[Compute(G.get(i).getB())]++;
                    v.add(G.get(i).getB());

                    Back(G, v, res, visit, done);
                    done[0] = oldDone;

                    visit[Compute(G.get(i).getB())]--;
                    v.remove(v.size() - 1);
                }
            }
        }
    }


    public static boolean end(ArrayList<String> v) { // if we placed "end" on the last place in the array
        if (v.size() >= 1) {
            return (v.get(v.size() - 1).equals("end"));
        } else return false;
    }

    public static boolean validate(ArrayList<String> v, String a, String b, int[] visit, boolean[] done) {

        // if (low(b) && visit[Compute(b)] == 1) return false;-> For part1, if we already visited string 'b' once, returtn false


        if (low(b)) {
            if (visit[Compute(b)] == 1 && !done[0]) { // if we already visited 'b' once but we don't have any low duplicate letter
                if (v.size() == 1 && a.equals("start")) {
                    done[0] = true;
                    return true;
                } else if (v.get(v.size() - 1).equals(a)) {
                    done[0] = true;
                    return true;
                } else return false;
            }
            if (visit[Compute(b)] == 1 && done[0])  // if we already visited 'b' once but we already have any low duplicate letter
                return false;

            if (visit[Compute(b)] == 2) return false; // Not to place 'start' again
        }

        if (v.size() == 1 && a.equals("start")) return true;
        else if (v.get(v.size() - 1).equals(a)) return true;
        else return false;
    }

    public static int Compute(String a) { // Hashing-> transform each string into sum of its characters
        int s = 0;
        for (int i = 0; i < a.length(); ++i)
            s += a.charAt(i);

        return s;
    }

    public static boolean low(String a) { // Returns true if the string starts with a low letter
        if (a.charAt(0) >= 'A' && a.charAt(0) <= 'Z') return false;
        return true;
    }

}
