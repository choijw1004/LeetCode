class Edge implements Comparable<Edge>{
    int end;
    double cost;

    public Edge(int end, double cost){
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge n){
        return Double.compare(n.cost, this.cost);
    }
}
class Solution {
    public double dijkstra(int start, int end, List<Edge>[] g){
        double[] dist = new double[g.length];
        Arrays.fill(dist, 0.0);
        dist[start] = 1.0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(start,1));

        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            int currNode = curr.end;
            double currCost = curr.cost;

            if(currNode == end) return currCost;

            if(currCost < dist[currNode]) continue;

            for(Edge e : g[currNode]){
                int nextNode = e.end;
                double nextCost = currCost * e.cost;

                if(nextCost >dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.offer(new Edge(nextNode,nextCost));
                }
            }
        }
        return 0.0;
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        //n 노드의 개수 0base
        List<Edge>[] g = new ArrayList[n];
        
        for(int i = 0 ; i < n; i++){
            g[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < edges.length; i++){
            int start = edges[i][0];
            int end = edges[i][1];
            double prob = succProb[i];
            g[start].add(new Edge(end,prob));
            g[end].add(new Edge(start,prob));
        }

        return dijkstra(start_node, end_node, g);
    }
}