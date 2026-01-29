class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int cnt = 0;
        int currEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(currEnd > start) cnt++;
            else currEnd = end;
        }
        return cnt;
    }
}