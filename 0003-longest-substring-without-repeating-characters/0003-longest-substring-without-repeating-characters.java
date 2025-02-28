import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}
