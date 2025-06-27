class Edge{
    int v;
    int cost;
    Edge(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
}
class Solution {
    List<Edge>[] g;
    int[] dist;
    
    private void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.offer(new Edge(start,0));
        
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int curr = edge.v;
            int currCost = edge.cost;

            if(dist[curr] < currCost) continue;
            
            for(Edge e : g[curr]){
                int next = e.v;
                int nextCost = e.cost;
                int newCost = currCost + nextCost;

                if(newCost < dist[next]){
                    dist[next] = newCost;
                    pq.offer(new Edge(next, newCost));
                }
            }

        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        g = new ArrayList[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 1; i <= n; i++) g[i] = new ArrayList<Edge>();
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int cost = time[2];
            g[u].add(new Edge(v,cost));
        }
        dist[k] = 0;
        dijkstra(k);

        int ans = Integer.MIN_VALUE;

        for(int i = 1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            else ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}