class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        int cnt = 0;
        int currEnd = -1;

        for(int[] interval : intervals){
            if(currEnd <= interval[0]) currEnd = interval[1];
            else cnt++;
        }
        return cnt;
    }
}