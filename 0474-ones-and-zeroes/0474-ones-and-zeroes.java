class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] d = new int[m+1][n+1];

        for(String s: strs){
            int one = 0;
            int zero = 0;
            for(int i = 0 ; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == '0') zero++;
                else one++;
            }

            for(int i = m; i >= zero;i--){
                for(int j = n; j >= one;j--){
                    d[i][j] = Math.max(d[i][j], d[i-zero][j-one] + 1);
                }
            }
        }
        return d[m][n];
    }
}
