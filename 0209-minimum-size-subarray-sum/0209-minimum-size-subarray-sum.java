class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, sum = 0;
        int result = n + 1; 
        
        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        
        return result == n + 1 ? 0 : result;
    }
}
