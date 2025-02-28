import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        List<Boolean> list = new ArrayList<>();
        for(int candy : candies){    
            max = Math.max(candy, max);
        }

        for(int candy : candies){
            int tmp = candy + extraCandies;

            if(tmp >= max) list.add(true);
            else list.add(false);
        }
        return list;
    }
}