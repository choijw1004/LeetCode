class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);

        boolean flag = true;

        int left = 0;
        int right = s.length() -1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                flag = false;
            }
            left++;
            right--;
        }
        return flag;
    }
}