class Solution {
    private boolean isGood(String st){
        
        HashSet<Character> hs = new HashSet<>();

        for(int i = 0 ; i < 3; i++){
            if(hs.contains(st.charAt(i))) return false;

            hs.add(st.charAt(i));
        }
        return true;
    }
    public int countGoodSubstrings(String s) {
        int n = s.length();
        int ans = 0;

        for(int i = 0; i < n-2; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = i; j < i+3; j++){
                sb.append(s.charAt(j));
            }
            if(isGood(sb.toString())) ans++;
        }
        return ans;
    }
}