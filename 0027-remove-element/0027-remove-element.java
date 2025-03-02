class Solution {
    public int removeElement(int[] nums, int val) {
        int cnt = 0;
        int idx = 0;

        for(int i = 0 ; i < nums.length; i++){
            int num = nums[i];

            if(num != val){
                cnt++;
                nums[idx] = num;
                idx++;
            }
        }

        return cnt;
        
    }
}