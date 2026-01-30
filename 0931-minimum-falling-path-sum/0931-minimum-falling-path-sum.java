class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                if(j == 0){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j+1]) + matrix[i][j];
                }
                else if(j == m-1){
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + matrix[i][j];
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i-1][j+1]) + matrix[i][j];
                }
            }
        }
        int ans = Integer.MAX_VALUE;

        for(int i = 0 ; i < m; i++){
            ans = Math.min(dp[n-1][i], ans);
        }

        return ans;
    }
}