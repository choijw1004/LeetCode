class Solution {
    private boolean canGo(int mid, int[][] grid){
        if (grid[0][0] > mid) return false;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        boolean cg = false;
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.offer(new int[]{0,0});
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];

            for(int i = 0 ; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && grid[nx][ny] <= mid){
                    visited[nx][ny] = true;
                    if(nx == n-1 && ny == n-1) cg = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        return cg;
    }
    public int swimInWater(int[][] grid) {
        int left = 0;
        int right = -1;
        int n = grid.length;
        int time = 0;


        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                right = Math.max(right, grid[i][j]);
            }
        }

        while(left <= right){
            int mid = (left + right) / 2;
            
            if(canGo(mid, grid)){
                time = mid;
                right = mid -1;
            }
            else left = mid + 1;
        }
        return time;
    }
}