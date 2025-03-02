class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public boolean isValid(int nx, int ny, int n, int m){
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int time = 0;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        int rotT = 0;
        int orT = 0;
    
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int kind = grid[i][j];
                if(kind == 1) orT++;
                if(kind == 2) {
                    rotT++;
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int totalT = orT + rotT;
        if(rotT == totalT) return 0;
        if(rotT == 0) return -1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0 ; i < size; i++){
                int[] c = q.poll();
                int cx = c[0];
                int cy = c[1];
                int ck = grid[cx][cy];

                for(int d = 0 ; d < 4; d++){
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if(isValid(nx,ny,n,m)){
                        int nk = grid[nx][ny];
                        if(grid[nx][ny] == 1 && !visited[nx][ny]){
                            visited[nx][ny] = true;
                            q.offer(new int[] {nx,ny});
                            grid[nx][ny] = 2;
                        }
                    }
                }
            }
            time++;
        }
        int flag = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(grid[i][j] == 1){
                    flag = 1;
                }
            }
        }

        return flag == 0 ? time - 1 : -1;
    }
}