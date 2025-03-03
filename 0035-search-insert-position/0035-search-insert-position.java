class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int ans = 0;
        while(left <= right){
            int mid = (left + right) / 2; 
            int num = nums[mid];

            if(num < target) left = mid + 1;
            else {
                right = mid -1;
            }
        }
        return left;
    }
}
