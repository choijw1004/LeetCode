class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n;
    static int m;
    static boolean[][] visited;
    private boolean isValid(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < m;
    }
    private void bfs(int x, int y, char[][] grid){ 
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;

        q.offer(new int[]{x,y});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];

            for(int d = 0 ; d < 4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if(isValid(nx,ny)){
                    if(!visited[nx][ny] && grid[nx][ny] == '1'){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            
        }
    }
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        int cnt = 0;

        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] || grid[i][j] == '0') continue;
                else {
                    bfs(i,j,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}