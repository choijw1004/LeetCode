class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        
        int cnt = 0;

        int pn = players.length-1;
        int tn = trainers.length-1;
        
        while(pn >= 0 && tn >= 0){
            int p = players[pn];
            int t = trainers[tn];

            if(t >= p){
                cnt++;
                pn--;
                tn--;
            }else pn--;
        }
        return cnt;
    }
}