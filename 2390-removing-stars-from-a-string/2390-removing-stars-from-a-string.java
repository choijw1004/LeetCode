import java.util.*;

class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c != '*'){
                st.push(c);
            }
            else{
                st.pop();
            }
        }
        if(st.size() == 0){
            return "";
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < st.size(); i++){
                sb.append(st.get(i));
            }
            return sb.toString();
        }        

        
    }
}