class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int size = k;
        int n = nums.length;
        int sum = 0;

        while(j < n){
            if(j - i + 1 < size){
                sum += nums[j];
                j++;   
            }

            else{
                sum += nums[j];
                ans = Math.max(sum,ans);

                sum -= nums[i];

                i++;
                j++;
            }
        }
        ans /= k;

        return ans;
        
    }
}