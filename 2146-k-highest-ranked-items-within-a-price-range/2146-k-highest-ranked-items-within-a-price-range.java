class Node{
    int x;
    int y;
    int price;
    int dist;

    public Node(int x, int y, int price, int dist){
        this.x = x;
        this.y = y;
        this.price = price;
        this.dist = dist;
    }
}

class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int[][] grid;
    int[] pricing, start;
    boolean[][] visited;

    int n,m,k;
    List<Node> list;
    
    private void bfs(int sx, int sy){
        if(grid[sx][sy] <= pricing[1] && grid[sx][sy] >= pricing[0]) list.add(new Node(sx, sy, grid[sx][sy], 0));    
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true;

        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int s = 0; s < size; s++){
                int[] curr = q.poll();
                int cx = curr[0];
                int cy = curr[1];
                
                for(int d = 0; d < 4; d++){
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if(visited[nx][ny]) continue;
                    if(grid[nx][ny] == 0) continue;
                    
                      
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    if(grid[nx][ny] > pricing[1] || grid[nx][ny] < pricing[0]) continue;
                    list.add(new Node(nx, ny, grid[nx][ny], dist));    
                }
            }
            dist++;
        }
        

    }
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        this.grid = grid;
        this.pricing = pricing;
        this.start = start;
        this.n = grid.length;
        this.m = grid[0].length;
        this.k = k;
        this.list = new ArrayList<>();
        this.visited = new boolean[n][m];

        bfs(start[0], start[1]);

        Collections.sort(list, (a,b) ->{
            if(a.dist != b.dist) return a.dist - b.dist;
            else if(a.price != b.price) return a.price - b.price;
            else if(a.x != b.x) return a.x - b.x;
            else return a.y - b.y;
        });

        
        List<List<Integer>> ans = new ArrayList<>();

        int cnt = 0;

        if(list.size() < k){
            for(int i = 0; i < list.size(); i++){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(list.get(i).x);
                tmp.add(list.get(i).y);
                ans.add(tmp);
            }
        }
        
        else{
            for(int i = 0; i < k; i++){
                if(cnt == k) break;
                List<Integer> tmp = new ArrayList<>();
                tmp.add(list.get(i).x);
                tmp.add(list.get(i).y);
                ans.add(tmp);
                cnt++;
            }

        }
        return ans;
    }
}