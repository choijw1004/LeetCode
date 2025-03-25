class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;      
        int flip = 0;     
        int[] isFlipped = new int[n]; 
        
        for (int i = 0; i < n; i++) {
            if (i >= k) flip ^= isFlipped[i - k];
            
            if (nums[i] == flip) {
                if (i + k > n) return -1;
                isFlipped[i] = 1;
                flip ^= 1;  
                ans++;
            }
        }
        
        return ans;
    }
}
