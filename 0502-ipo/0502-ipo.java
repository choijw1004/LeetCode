class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());     
        int n = capital.length;
        int[][] capitals = new int[n][2];

        for(int i = 0 ; i < n; i++){
            capitals[i][0] = profits[i];
            capitals[i][1] = capital[i];
        }

        Arrays.sort(capitals, (a,b) -> Integer.compare(a[1], b[1]));

        int idx = 0;
        int currW = w;

        for(int i = 0; i < k; i++){
            while(idx < n && capitals[idx][1] <= currW){
                maxH.offer(capitals[idx][0]);
                idx++;
            }

            if(maxH.size() == 0) break;

            currW += maxH.poll();
        }
        return currW;
    }
}