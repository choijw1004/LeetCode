class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int cnt = 0;

        int n = s.length();
        if((n % 2) != 0) return false;
        
        for(int i = 0 ; i < n; i++){
            char c = s.charAt(i);

            if(c == '(' || c == '{' || c == '[') st.push(c);
            else if(c == ')'){
                if(!st.isEmpty() && st.peek() == '(') {
                    cnt++;
                    st.pop();
                }
            }
            else if(c == ']'){
                if(!st.isEmpty() && st.peek() == '[') {
                    st.pop();
                    cnt++;
                }                
            }
            else{
                if(!st.isEmpty() && st.peek() == '{') {
                    cnt++;
                    st.pop();
                }
            }
        }
        if(cnt != n/2) return false;    
        return st.size() > 0 ? false : true;    
    }
}