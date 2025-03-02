class Solution {
    public void moveZeroes(int[] nums) {
        int save = 0;

        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] != 0){
                nums[save] = nums[i];
                save++;
            }
        }

        for(int i = save ; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
