class Solution {
    private boolean isVowel(Character c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private int makeHash(Character c){
        if(c == 'a') return 0;
        else if(c == 'e') return 1;
        else if(c == 'i') return 2;
        else if(c == 'o') return 3;
        else return 4;

    }

    public int maxVowels(String s, int k) {
        int i = 0, j = 0, ans = 0;
        int size = k;
        int n = s.length();
        int[] hash = new int[5];

        while(j < n){
            if(j - i + 1 < size){
                if(isVowel(s.charAt(j))){
                    hash[makeHash(s.charAt(j))]++;
                }
                j++;
            }
            else{
                if(isVowel(s.charAt(j))){
                    hash[makeHash(s.charAt(j))]++;
                }
                int tmp = 0;

                for(int num : hash){
                    tmp += num;
                }
                ans = Math.max(tmp, ans);
                
                if(isVowel(s.charAt(i))){
                    hash[makeHash(s.charAt(i))]--;
                }

                i++;
                j++;
            }

        }
        return ans;
    }
}