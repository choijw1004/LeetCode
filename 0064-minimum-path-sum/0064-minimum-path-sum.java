class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] d = new int[n][m];
        d[0][0] = grid[0][0];
        for(int i = 1 ; i < m; i++){
            d[0][i] = grid[0][i] + d[0][i-1];
        }
        for(int i = 1; i < n; i++){
            d[i][0] = grid[i][0] + d[i-1][0];
        }

        for(int i = 1 ; i < n; i++){
            for(int j = 1 ; j < m; j++){
                d[i][j] = grid[i][j] + Math.min(d[i-1][j], d[i][j-1]);
            }
        }
        return d[n-1][m-1];
    }
}