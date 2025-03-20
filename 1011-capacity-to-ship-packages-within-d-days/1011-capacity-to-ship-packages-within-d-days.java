class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        
        int ans = right;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int d = 1;
            int current = 0;
            for (int w : weights) {
                if (current + w > mid) { 
                    d++;              
                    current = w;      
                } else {
                    current += w;
                }
            }
            
            if (d <= days) {  
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return ans;
    }
}
