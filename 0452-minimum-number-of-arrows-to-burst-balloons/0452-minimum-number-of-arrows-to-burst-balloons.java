import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int cnt = 1;
        int currEnd = points[0][1]; 

        for (int i = 1; i < points.length; i++) {
            if (currEnd < points[i][0]) {
                currEnd = points[i][1];
                cnt++;
            }
        }        

        return cnt;
    }
}
