class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalG = 0;
        int totalC = 0;
        int start = 0;
        int g = 0;

        for(int i = 0 ; i < n; i++){
            totalG += gas[i];
            totalC += cost[i];
            
            g += gas[i] - cost[i];

            if(g < 0){
                g = 0;
                start = i+1;
            }
        }

        return totalG < totalC ? -1 : start;
    }
}