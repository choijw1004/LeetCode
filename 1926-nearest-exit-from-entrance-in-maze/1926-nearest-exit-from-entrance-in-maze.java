import java.util.*;

class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public int nearestExit(char[][] maze, int[] entrance) {
    int n = maze.length;
    int m = maze[0].length;
    boolean[][] visited = new boolean[n][m];
    int ex = entrance[0];
    int ey = entrance[1];

    Queue<int[]> q = new LinkedList<>();
    visited[ex][ey] = true;
    q.offer(new int[]{ex, ey, 0});

    while (!q.isEmpty()) {
        int[] cur = q.poll();
        int cx = cur[0], cy = cur[1], steps = cur[2];
        
        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            int nSteps = steps + 1;

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || maze[nx][ny] == '+')
                continue;
            
            if ((nx == 0 || ny == 0 || nx == n - 1 || ny == m - 1)) {
                return nSteps;
            }
            
            visited[nx][ny] = true;
            q.offer(new int[]{nx, ny, nSteps});
        }
    }
    
    return -1;
}
}