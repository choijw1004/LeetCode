class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        if (2*k + 1 > n) return answer; 

        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        int window = 2*k + 1;
        for (int i = k; i + k < n; i++) {
            int left = i - k, right = i + k;
            long sum = prefix[right] - (left > 0 ? prefix[left-1] : 0L);
            answer[i] = (int)(sum / window);
        }

        return answer;
    }
}
