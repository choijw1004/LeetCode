class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int size = k;
        int n = nums.length;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        List<Integer> list = new ArrayList<>();

        while(end < n){
            if(end - start + 1 < k){
                map.put(nums[end], map.getOrDefault(nums[end],0) + 1);
                end++;
            }
            else{
                
                map.put(nums[end], map.getOrDefault(nums[end],0) + 1);
                int m = map.lastKey();
                list.add(m);
                map.put(nums[start], map.getOrDefault(nums[start],0) - 1);
                if(map.get(nums[start]) == 0) map.remove(nums[start]);

                start++;
                end++;
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}