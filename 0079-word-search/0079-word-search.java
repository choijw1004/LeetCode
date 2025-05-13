class Solution {
    char[][] board;
    String word;
    int n, m;
    boolean[][] visited;
    int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};

    private boolean dfs(int x, int y, int idx) {
        if (board[x][y] != word.charAt(idx)) return false;
        if (idx == word.length() - 1) return true;

        visited[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (!visited[nx][ny]) {
                if (dfs(nx, ny, idx + 1)) {
                    visited[x][y] = false;
                    return true;
                }
            }
        }
        visited[x][y] = false;  
        return false;
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.n = board.length;
        this.m = board[0].length;
        this.visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j, 0)) return true;
            }
        }
        return false;
    }
}
