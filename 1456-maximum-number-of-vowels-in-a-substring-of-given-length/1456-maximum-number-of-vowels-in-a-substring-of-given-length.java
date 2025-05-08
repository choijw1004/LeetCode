class Solution {
    private boolean isVowel(Character c){
        return (c == 'a' || c == 'e'|| c == 'i' || c == 'o' || c == 'u');
    }
    public int maxVowels(String s, int k) {

        int n = s.length();
        int cnt = 0;
        
        for(int i = 0 ; i < k; i++){
            char c = s.charAt(i);
            if(isVowel(c)) cnt++;
        }
        int ans = cnt;

        for(int i = k; i < n; i++){
            if(isVowel(s.charAt(i))) cnt++;
            if(isVowel(s.charAt(i-k))) cnt--;
            
            ans = Math.max(ans,cnt);
        }
        return ans;
    }
}