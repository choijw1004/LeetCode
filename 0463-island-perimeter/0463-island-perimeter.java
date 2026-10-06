class Solution {
    int n,m;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    
    public int islandPerimeter(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                //주변 계산인 경우
                if(grid[i][j] == 1){
                    for(int d = 0; d < 4; d++){
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        
                        if(nx >= n || ny >= m || nx < 0 || ny < 0) {
                            cnt++;
                            continue;
                        }

                        if(grid[nx][ny] == 0) {
                            cnt++;
                            continue;
                        }
                        
                    }
                }
            }
        }    
        return cnt;
    }
}