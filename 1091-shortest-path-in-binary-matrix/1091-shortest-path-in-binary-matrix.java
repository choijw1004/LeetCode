class Solution {
    int n,m,dist;
    
    int[] dx = {0, 0, 1,-1, -1, 1, -1, 1};
    int[] dy = {1, -1, 0, 0,-1, -1 , 1, 1};
    int[][] grid;
    boolean[][] visited;

    private int bfs(int sx, int sy){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy});
        this.visited = new boolean[n][m];
        visited[sx][sy] = true; 
        int rt = -1;
        this.dist = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0; s < size; s++){
            
                int[] curr = q.poll();
                int cx = curr[0];
                int cy = curr[1];
                System.out.println("cx = " + cx + "cy = " + cy);

                if(cx == n-1  && cy == m-1) {
                    rt = dist + 1;
                    return rt;
                }

                for(int d = 0; d < 8; d++){
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if(nx >= n || ny >= m || nx < 0 || ny < 0) continue;
                    if(visited[nx][ny]) continue;
                    if(grid[nx][ny] == 1) continue;


                    q.offer(new int[]{nx,ny});
                    
                    visited[nx][ny] = true;
                }
            }
            dist++;
        }
        return -1;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;
        
        if(grid[0][0] == 1) return -1;
        int ans = bfs(0,0);

        return ans;
    }
}