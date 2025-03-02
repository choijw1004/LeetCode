class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int left = 0, right = m; 
            
            while (left < right) {
                int mid = left + (right - left) / 2;
                if ((long)potions[mid] * spell >= success) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = m - left;
        }
        return result;
    }
}
/*
Discussion에 있는 이분탐색 템플릿
def binarySearchForMinVal()
    l, r = lower_bound, upper_bound
    while l < r:
        mid = (l + r)//2 #round down
        if feasible(mid):
            r = mid #check for possible smaller values that work
        else:
            l = mid + 1 #values smaller than or equal to mid do not work. Reduce search space to values greater than mid.
    return l

def binarySearchForMaxVal()
    l, r = lower_bound, upper_bound
    while l < r:
        mid = (l + r + 1)//2 #round up
        if feasible(mid):
            l = mid #check for possible greater values that work
        else:
            r = mid - 1 #values greater than or equal to mid do not work. Reduce search space to values smaller than mid.
    return l    
*/