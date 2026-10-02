class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        //
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();

        for(var s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            StringBuilder sb = new StringBuilder();

            for(char c : arr){
                sb.append(c);
            }

            map.computeIfAbsent(sb.toString(), v -> new ArrayList<>()).add(s);
        }

        List<Map.Entry<String, List<String>>> list = new ArrayList<>(map.entrySet());

        for(var e : list){
            List<String> t1 = new ArrayList<>();

            for(var t : e.getValue()){
                t1.add(t);
            }

            ans.add(t1);
        }

        return ans;
    }
}