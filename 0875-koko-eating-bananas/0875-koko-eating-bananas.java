class Solution {
    int[] piles;
    int h;

    public int minEatingSpeed(int[] piles, int h) {
        this.piles = piles;
        this.h = h;
        long ans = 0;
        long max = -1;

        for(int p : piles){
            max = Math.max(p,max);
        }
        
        long start = 1;
        long end = max;

        while(start <= end){
            long mid = (start + end) / 2;

            if(canEat(mid)) {
                ans = mid;
                end = mid -1;
            }
            else start = mid + 1;
        }

        return (int)ans;
    }

    private boolean canEat(long time){
        int cnt = 0;

        for(int p : piles){
            cnt += (p + time -1)/ time;
        }

        return cnt <= h ? true : false;
    }
}