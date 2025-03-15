class Solution {
    public int tribonacci(int n) {
        int[] fibo = new int[n+1];
        if(n == 0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        fibo[0] = 0;
        fibo[1] = 1;
        fibo[2] = 1;

        for(int i = 3; i<= n; i++){
            fibo[i] = fibo[i-1] + fibo[i-2] + fibo[i-3];
        }
        return fibo[n];
    }
}