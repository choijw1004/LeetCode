class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        
        for(int curr = 0 ; curr < n; curr++){
            while(!s.isEmpty() && temperatures[s.peek()] < temperatures[curr]){
                int prev = s.pop();
                ans[prev] = curr - prev;
            }
            s.push(curr);
        }
        return ans;
    }
}