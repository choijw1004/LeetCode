class Solution {
    int n,m,color;
    int startC;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int[][] grid;
    boolean[][] visited;   
    List<int[]> list = new ArrayList<>();
    
    private void bfs(int sx, int sy){
        this.visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        visited[sx][sy] = true;
        q.offer(new int[]{sx,sy});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            
            for(int d = 0; d < 4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;
                if(grid[nx][ny] != startC) continue;
                
                int[] tmp = new int[]{nx,ny};
                q.offer(tmp);
                list.add(tmp);
                visited[nx][ny] = true;
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.grid = image;
        this.n = grid.length;
        this.m = grid[0].length;
        this.startC = grid[sr][sc];
        // System.out.println(startC);
        list.add(new int[]{sr,sc});
        bfs(sr, sc);
        
        // for(int i = 0 ; i < list.size(); i++){
        //     System.out.print("x = " + list.get(i)[0]);
        //     System.out.print("y = " + list.get(i)[1]);
        // }
        for(int i = 0 ; i < list.size(); i++){
            grid[list.get(i)[0]][list.get(i)[1]] = color;
        }
        
        return grid;
    }
}