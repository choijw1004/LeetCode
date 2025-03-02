class Solution {
    private int calcuTime(int[] piles, int k) {
        int time = 0;
        for (int p : piles) {
            time += (p + k - 1) / k;
        }
        return time;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;

        for (int p : piles) {
            maxPile = Math.max(maxPile, p);
        }
        
        int left = 1;
        int right = maxPile;  
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (calcuTime(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
