class MinPath2D {

    public static void main(String[] args) {
        int[][] grid = new int[][] { { 10, 1, 3, 10 }, { 5, 15, 1, 7 }, { 2, 4, 2, 6 } };

        System.out.println("Cost - " + minCost(grid));
    }

    public static int minCost(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[grid.length][grid[0].length];

        dp[m - 1][0] = grid[m - 1][0];

        for (int i = 1; i < n; i++) {
            dp[m - 1][i] = grid[m - 1][i] + dp[m - 1][i - 1];
        }

        for (int i = m - 2; i >= 0; i--) {
            dp[i][0] = grid[i][0] + dp[i + 1][0];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = 1; j < grid[0].length; j++) {
                int bottom = dp[i + 1][j];
                int left = dp[i][j - 1];
                dp[i][j] = grid[i][j] + Math.min(bottom, left);
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(dp[i][j] + ",");
            }
            System.out.println("");
        }

        return dp[0][n - 1] + 1;

    }

}