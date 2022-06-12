package interview;
/* int[][] grid = new int[3][2];
       grid[0][0] = 5; grid[0][1] =3;
       grid[1][0] = 4; grid[1][1] = 0;
       grid[2][0] = 2; grid[2][1] = 1;

       int[][] moveCost = new int[6][2];
       moveCost[0][0] = 9; moveCost[0][1] = 8;
       moveCost[1][0] = 1; moveCost[1][1] = 5;
       moveCost[2][0] = 10; moveCost[2][1] = 12;
       moveCost[3][0] = 18; moveCost[3][1] = 6;
       moveCost[4][0] = 2; moveCost[4][1] = 4;
       moveCost[5][0] = 14; moveCost[5][1] = 3;

       System.out.println(new MinPathCostGrid().minPathCost(grid, moveCost));*/
public class MinPathCostGrid {
    private int M, N;
    public int minPathCost(int[][] grid, int[][] moveCost) {

        M = grid.length;
        N = grid[0].length;
        int[][] dp = new int[M][N];
        for (int j = 0; j < N; ++j)
            dp[0][j] = grid[0][j];

        for (int i = 1; i < M; ++i)
            for (int j = 0; j < N; ++j)
                dp[i][j] = Integer.MAX_VALUE;

        for (int i = 0; i < M - 1; ++i)
            for (int j = 0; j < N; ++j){

                for (int k = 0; k < N; ++k){
                    if (dp[i+1][k] > dp[i][j] + moveCost[grid[i][j]][k] + grid[i+1][k])
                        dp[i+1][k] = dp[i][j] + moveCost[grid[i][j]][k] + grid[i+1][k] ;
                }



            }

        int Min = Integer.MAX_VALUE;
        for (int j = 0; j < N; ++j)
            Min = Math.min(Min, dp[M-1][j] + grid[M-1][j]);
        return Min;
    }


}
