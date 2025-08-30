class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int r,c;
    int[][] map;
    
    private boolean canGo(int limit){
        boolean[][] visited = new boolean[r][c];
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.offer(new int[]{0,0});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            
            if(cx == r-1 && cy == c-1) return true; 
            for(int d = 0 ; d < 4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(nx < r && ny < c && nx >= 0 && ny >=0 && !visited[nx][ny]){
                    int gap = Math.abs(map[cx][cy] - map[nx][ny]);
                    if(gap > limit) continue;

                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        return false;
    }
    public int minimumEffortPath(int[][] heights) {
        this.r = heights.length;
        this.c = heights[0].length;
        this.map = heights;
        boolean[][] visited = new boolean[r][c];
        int left = 0;
        int right = 1_000_000;
        int ans = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            if(canGo(mid)){
                ans = mid;
                right = mid -1;
            }
            else left = mid + 1;
        }

        return ans;
        
    }
}