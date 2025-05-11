class Solution {
    String[] list = new String[] {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};    
    List<String> res = new ArrayList<>();

    private void backTracking(String digits, int idx, StringBuilder tmp){
        if(idx == digits.length()){
            res.add(tmp.toString());
            return;
        }

        String letters = list[digits.charAt(idx)-'0'];

        for(int i = 0 ; i < letters.length(); i++){
            char c = letters.charAt(i);
            tmp.append(c);
            backTracking(digits, idx + 1, tmp);
            tmp.deleteCharAt(tmp.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return res;
        //digits, idx, StringBuilder

        backTracking(digits, 0, new StringBuilder());

        return res;

        
    }
}