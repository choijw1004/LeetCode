class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] d = new int[n][n];

        for(int i = 0 ; i < n; i++){
            d[0][i] = matrix[0][i];
        }

        for(int i = 1; i< n;i++){
            for(int j = 0 ; j < n ; j++){
                if(j==0){
                    d[i][j] = matrix[i][j] + Math.min(d[i-1][j],d[i-1][j+1]);
                }
                else if(j==n-1){
                    d[i][j] = matrix[i][j] + Math.min(d[i-1][j],d[i-1][j-1]);
                }
                else{
                    d[i][j] = matrix[i][j] + Math.min(Math.min(d[i-1][j-1],d[i-1][j]),d[i-1][j+1]);

                }
            }
        }
        return Arrays.stream(d[n-1]).min().getAsInt();
        
    }
}