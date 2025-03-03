class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int li = 0;
        int ri = costs.length - 1;
        long ans = 0;
        
        PriorityQueue<Integer> lpq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq = new PriorityQueue<>();
        
        
            for(int i = 0; i < k; i++){
                while (lpq.size() < candidates && li <= ri) {
                    lpq.offer(costs[li]);
                    li++;
                }
                
                while (rpq.size() < candidates && li <= ri) {
                    rpq.offer(costs[ri]);
                    ri--;
                }
                
                int lm = lpq.isEmpty() ? Integer.MAX_VALUE : lpq.peek();
                int rm = rpq.isEmpty() ? Integer.MAX_VALUE : rpq.peek();
                
                ans += (lm <= rm ? lpq.poll() : rpq.poll());

            }
        
        return ans;
    }
}
