package AoC_2021.Day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day15 {
    public static void day15(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/vladnitu/Desktop/TUDelft/Q2/ADS/ads-things/src/main/java/AoC_2021/Day15/in.in"));
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};
        int[][] visit = new int[5 * 100][5 * 100];
        initialize(visit);
        int[][] a = new int[100][100];
        int res = 0;
        Queue<Node> q = new LinkedList<>();

        int i = -1;
        while (scanner.hasNext()) {
            i++;
            String line = scanner.next();
            for (int j = 0; j < 100; ++j) {
                a[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
            }
        }

        a = construct(a); // Construct a new matrix 500, 500
        print(a);

        q.offer(new Node(0, 0));
        visit[0][0] = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();
            for (i = 0; i < 4; ++i) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (valide(xx, yy) && visit[xx][yy] > visit[x][y] + a[xx][yy]) {

                    visit[xx][yy] = visit[x][y] + a[xx][yy];
                    q.offer(new Node(xx, yy));
                }
            }
        }

        System.out.println(visit[499][499]);
        return;

    }

    public static boolean valide(int x, int y) {
        return (x >= 0 && x < 500 && y >= 0 && y < 500);
    }

    public static void initialize(int[][] a) {
        for (int i = 0; i < 500; ++i)
            for (int j = 0; j < 500; ++j)
                a[i][j] = Integer.MAX_VALUE;
    }

    public static int[][] construct(int[][] a) {
        int[][] b = new int[5 * 100][5 * 100];
        copy(a, b);
        //a[i][j] = 10 -> a[i][j] = 1
        for (int i = 0; i < 100; ++i)
            for (int j = 0; j < 100; ++j)
                for (int step = 0; step < 5; ++step) { //Go down
                    int new_i = 100 * step + i;
                    for (int step2 = 0; step2 < 5; ++step2) { // Go right
                        if (step == 0 && step2 == 0) continue; // if the first matrix
                        int new_j = 100 * step2 + j;

                        b[new_i][new_j] = b[i][j] + (step + step2);
                        if (b[new_i][new_j] >= 10) b[new_i][new_j] = b[new_i][new_j] % 10 + 1;
                    }
                }

        return b;

    }

    public static void copy(int[][] a, int[][] b) {
        for (int i = 0; i < 100; ++i)
            for (int j = 0; j < 100; ++j)
                b[i][j] = a[i][j];
    }

    public static void print(int[][] a) {
        for (int i = 0; i < 500; ++i) {
            for (int j = 0; j < 500; ++j)
                System.out.print(a[i][j]);
            System.out.println();
        }
    }

}
