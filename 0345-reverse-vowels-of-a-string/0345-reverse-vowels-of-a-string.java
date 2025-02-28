import java.util.*;

class Solution {
    public String reverseVowels(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c =='U') st.push(c);            
        }

        for(int i =0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c =='U'){
                sb.append(st.pop());
            }else sb.append(c);
              
        }
        return sb.toString();
    }
}