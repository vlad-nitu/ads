package interview;

import java.util.Arrays;

public class FairDistribution {

    private int[] back;
    private int N, K;
    private int Min = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        N = cookies.length;
        K = k;
        back =  new int[k];

        this.BKT(k, 0, cookies);
        return Min;
    }

    public void BKT (int k, int pos, int[] cookies){

        if (pos == N)
        {//update solution
            // Arrays.stream(back).forEach(x -> System.out.print(x + " ")); // print all possibilities
            System.out.println();
            int curr = Integer.MIN_VALUE;
            for (int i = 0; i < k; ++i)
                if (back[i] > 0)
                    curr = Math.max(curr, back[i]);
            Min = Math.min(Min, curr);
        }
        else {

            for (int i = 0; i < k; ++i)
            {
                back[i] += cookies[pos];
                BKT(k, pos + 1, cookies);
                back[i] -= cookies[pos];
            }
        }



    }


}
