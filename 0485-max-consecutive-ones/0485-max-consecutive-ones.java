class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int ans = 0;

        for(int num : nums){
            if(num == 0) max = 0;
            else{
                max++;
                ans = Math.max(max, ans);
            }
        }
        return ans;
        
    }
}