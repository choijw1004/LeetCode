class Solution {
    HashMap<Character, Integer> target;

    public List<Integer> findAnagrams(String s, String p) {
        int i = 0;
        int j = 0;
        int size = p.length();
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();

        target = new HashMap<>();

        for(int x = 0; x < size; x++){
            char c = p.charAt(x);

            target.put(c, target.getOrDefault(c, 0) + 1);
        }


        while(j < n){
            if(j - i + 1 < size){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }
            else{
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

                if(map.equals(target)) ans.add(i);

                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);

                if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));

                i++;
                j++;
            }
        }

        return ans;
    }
}