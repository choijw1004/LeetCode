class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0;
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int right = 0; right < n; right++){
            int f = fruits[right]; 
            hm.put(f, hm.getOrDefault(f,0) + 1);
            
            while(hm.size() > 2){
                int lf = fruits[left];
                hm.put(lf, hm.getOrDefault(lf,0) -1);
                if(hm.get(lf) == 0) hm.remove(lf);
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}