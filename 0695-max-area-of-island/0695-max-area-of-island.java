class Solution {
    int n,m;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int[][] grid;
    boolean[][] visited;

    private int bfs(int sx, int sy){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy});
        this.visited = new boolean[n][m];
        visited[sx][sy] = true;
        int cnt = 1;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];

            for(int d = 0; d < 4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(grid[nx][ny] == 0) continue;
                if(visited[nx][ny]) continue;
                
                cnt++;
                q.offer(new int[]{nx,ny});
                visited[nx][ny] = true;
            }

        }
        return cnt == 0 ? -1 : cnt;
    }
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;
        int max = -1;

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(grid[i][j] == 0) continue;
                max = Math.max(bfs(i,j), max);        
            }
        }
        return max == -1 ? 0 : max;
    }
}