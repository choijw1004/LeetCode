class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0;
        int j = 0;
        long size = 2 * k + 1;
        long sum = 0;
        Arrays.fill(ans,-1);

        if(k == 0) return nums;


        while(j < n){
            if(j - i + 1 < size){
                sum += nums[j];
                j++;
            }

            else{
                sum += nums[j];
                ans[(i + j) / 2] = (int)(sum / size);

                sum -= nums[i];
                
                i++;
                j++;
            }

        }

        return ans;
        
    }
}