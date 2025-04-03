class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] d = new int[amount + 1];
        Arrays.fill(d, max);
        d[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    d[i] = Math.min(d[i], d[i - coin] + 1);
                }
            }
        }
        return d[amount] == max ? -1 : d[amount];
    }
}
