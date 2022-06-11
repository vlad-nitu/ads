package interview;

public class MatchReplacement {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        boolean[][] map = new boolean[123][123];
        for (int i = 0; i < mappings.length; ++i) { // map right -> left
            char left = mappings[i][0];
            char right = mappings[i][1];
            map[left][right] = true;
        }

        int k = sub.length();
        int N = s.length();
        for (int i = 0; i <= N - k; ++i) {
            String curr = s.substring(i, i + k);
            if (match(curr, sub, map))
                return true;
        }

        return false;
    }

    public static boolean match(String curr, String sub, boolean[][] map) {
        int K = curr.length();
        for (int index = 0; index < K; ++index) {
            if (!(curr.charAt(index) == sub.charAt(index)
                    || (map[sub.charAt(index)][curr.charAt(index)])))
                return false;
        }
        return true;
    }
}