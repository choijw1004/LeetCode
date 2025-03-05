class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        long[] d = new long[n]; 
        long max = Long.MIN_VALUE;
        d[0] = nums[0];
        max = Math.max(max, d[0]);
        for(int i = 1 ; i < n; i++){
            d[i] = Math.max(nums[i], d[i-1] + nums[i]);
            max = Math.max(max,d[i]);
        }
        return (int)max;       
    }
}