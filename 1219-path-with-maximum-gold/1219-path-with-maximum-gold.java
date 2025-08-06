class Solution {
    int r, c;
    int[][] grid;
    boolean[][] visited;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    private int backTracking(int x, int y, int sum) {
        visited[x][y] = true;
        int localMax = sum;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < r && ny < c
                && !visited[nx][ny] && grid[nx][ny] > 0) {
                localMax = Math.max(
                    localMax,
                    backTracking(nx, ny, sum + grid[nx][ny])
                );
            }
        }

        visited[x][y] = false;
        return localMax;
    }

    public int getMaximumGold(int[][] grid) {
        this.r = grid.length;
        this.c = grid[0].length;
        this.grid = grid;
        this.visited = new boolean[r][c];

        int answer = 0;
        for (int i = 0 ; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] > 0) {
                    answer = Math.max(
                        answer,
                        backTracking(i, j, grid[i][j])
                    );
                }
            }
        }
        return answer;
    }
}
