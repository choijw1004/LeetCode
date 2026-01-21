import java.util.*;

class Solution {
    public int countGoodSubstrings(String s) {
        int i = 0;
        int j = 0;
        int ans = 0;
        
        int size = 3;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        while(j < n){
            if(j - i + 1< size){
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0) + 1);
                j++;
            }
            else{
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0) + 1);

                if(map.size() == size){
                    ans++;
                }

                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) -1);
                if(map.get(s.charAt(i)) <= 0) map.remove(s.charAt(i));
                i++;
                j++;
            }
        }

        return ans;
        
    }
}