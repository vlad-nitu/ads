package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargesVariance {

    public static int largestVariance(String s) {

        int N = s.length();
        char[] list = new char[28];
        for (int i = 0; i < 26; ++i)
            list[i] = (char)('a' + i);


        Set<Character> map = new HashSet<>();

        int[][] dp = new int[30][N];



        dp[s.charAt(0) - 'a'][0] =  1;
        for (int i = 0; i < 26; ++i)
            if (list[i] != s.charAt(0))
                dp[list[i] - 'a'][0] = 0;



        for (int r = 1; r < N; ++r){
            char rightChar = s.charAt(r);
            dp[rightChar - 'a'][r] = dp[rightChar - 'a'][r-1] + 1;

            for (int i = 0; i < 26; ++i)
                if (rightChar != list[i])
                    dp[list[i] - 'a'][r] = dp[list[i] - 'a'][r - 1] ;
        }

        int MAX = Integer.MIN_VALUE;

        for (int l = 0; l < N - 1; ++l) {

            char leftChar = s.charAt(l);
            map = new HashSet<>();
            for (int r = l; r < N; ++r) {

                char rightChar = s.charAt(r);
                map.add(rightChar);


                int forSearch, forRight;

                for (int i = 0; i < 26; ++i) {

                    char searchChar = list[i];
                    if ((l == 1 && dp[searchChar - 'a'][r] != 0) || (l > 1 && dp[searchChar - 'a'][r] - dp[searchChar - 'a'][l-1] != 0)) // is in [l,r]

                    {

                        if (l - 1 >= 0)
                            forSearch = dp[searchChar - 'a'][r] - dp[searchChar - 'a'][l - 1];
                        else forSearch = dp[searchChar - 'a'][r];

                        if (l - 1 >= 0)
                            forRight = dp[rightChar - 'a'][r] - dp[rightChar - 'a'][l - 1];
                        else forRight = dp[rightChar - 'a'][r];


                        int occurences = Math.abs(forSearch - forRight);

                        MAX = Math.max(MAX, occurences);
                    }
                }

            }
        }

        if (MAX != Integer.MIN_VALUE)
        return MAX;
        else return 0;


    }
}
