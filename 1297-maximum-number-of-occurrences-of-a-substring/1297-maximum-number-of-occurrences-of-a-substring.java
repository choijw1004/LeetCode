class Solution {
    int ml;

    private boolean isValid(String s){
        HashSet<Character> set = new HashSet<>();
        
        for(int i = 0 ; i < s.length(); i++){
            set.add(s.charAt(i));
        }

        return set.size() <= ml ? true : false;
    }
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int i = 0, j = 0;  
        int size = minSize;
        int n = s.length();
        this.ml = maxLetters;

        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        while(j < n){
            if(j - i + 1 < size){
                sb.append(s.charAt(j));
                j++;
            }

            else{
                sb.append(s.charAt(j));

                if(isValid(sb.toString())){
                    map.put(sb.toString(), map.getOrDefault(sb.toString(),0) + 1);
                }
                sb.deleteCharAt(0);
                i++;
                j++;
            }
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (a,b) -> b.getValue() - a.getValue());


        return list.size() == 0 ? 0 : list.get(0).getValue();
    }
}