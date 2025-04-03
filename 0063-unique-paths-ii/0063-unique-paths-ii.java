class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] d = new int [n][m];
        
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1) break;
            d[i][0] = 1;
        }
        
        for (int j = 0; j < m; j++) {
            if (obstacleGrid[0][j] == 1) break;
            d[0][j] = 1;
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j< m; j++){
                if(obstacleGrid[i][j] == 1) continue;
                else{
                    d[i][j] = d[i-1][j] + d[i][j-1];
                }
            } 
        }
        
        return d[n-1][m-1];
    }
}