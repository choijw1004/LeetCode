class Solution {
    int[] nums;

    private boolean canMake(int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // 합 0은 언제나 가능

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }

    public boolean canPartition(int[] nums) {
        this.nums = nums;
        int sum = 0;
        for (int x : nums) sum += x;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        return canMake(target);
    }
}
