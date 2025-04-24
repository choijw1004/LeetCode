class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] prefixSum = new int[n+1];
        int ans = 0;

        for (int i = 0; i < n; i++) prefixSum[i+1] = prefixSum[i] + cardPoints[i];

        for (int i = 0; i <= k; i++) {
            int left  = prefixSum[i];                          
            int right = prefixSum[n] - prefixSum[n - (k - i)];
            ans = Math.max(ans, left + right);
        }

        return ans;
    }
}
