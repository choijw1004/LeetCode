class Solution {
    public int maxProfit(int[] prices) {
        int maxPf = Integer.MIN_VALUE;
        int minStock = prices[0];
        
        for(int i = 1; i < prices.length; i++){
            int p = prices[i];

            if(p > minStock){
                maxPf = Math.max(maxPf, p - minStock);
            }
            if(p < minStock) minStock = p;
        }

        return (maxPf != Integer.MIN_VALUE) ? maxPf : 0;

    }
}