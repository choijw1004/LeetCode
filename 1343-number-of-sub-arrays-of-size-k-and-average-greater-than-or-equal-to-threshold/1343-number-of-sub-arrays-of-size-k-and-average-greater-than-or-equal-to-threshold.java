class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        int need = threshold * k;
        int ans = 0;
        for (int i = 0; i + k <= n; i++) {
            int sum = (i == 0)
                ? prefixSum[k-1]
                : prefixSum[i+k-1] - prefixSum[i-1];
            if (sum >= need) ans++;
        }
        return ans;
    }
}
