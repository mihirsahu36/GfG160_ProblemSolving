/*Dijkstra Algorithm
Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], where edges[i]=[u, v, w]
represents the edge between the nodes u and v having w edge weight.
You have to find the shortest distance of all the vertices from the source vertex src, and return an array of integers where the ith element denotes the shortest distance between ith node and source vertex src.
Note: The Graph is connected and doesn't contain any negative weight edge.

Examples:

Input: V = 3, edges[][] = [[0, 1, 1], [1, 2, 3], [0, 2, 6]], src = 2
Output: [4, 3, 0]
Explanation:
Shortest Paths:
For 2 to 0 minimum distance will be 4. By following path 2 -> 1 -> 0
For 2 to 1 minimum distance will be 3. By following path 2 -> 1
For 2 to 2 minimum distance will be 0. By following path 2 -> 2

Input: V = 5, edges[][] = [[0, 1, 4], [0, 2, 8], [1, 4, 6], [2, 3, 2], [3, 4, 10]], src = 0
Output: [0, 4, 8, 10, 10]
Explanation: 
Shortest Paths: 
For 0 to 1 minimum distance will be 4. By following path 0 -> 1
For 0 to 2 minimum distance will be 8. By following path 0 -> 2
For 0 to 3 minimum distance will be 10. By following path 0 -> 2 -> 3 
For 0 to 4 minimum distance will be 10. By following path 0 -> 1 -> 4

Constraints:

1 ≤ V ≤ 10^5
1 ≤ E = edges.size() ≤ 10^5
0 ≤ edges[i][j] ≤ 10^4
0 ≤ src < V*/

class Solution {
    private static class Pair{
        int node, weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int []edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        
        int []dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        pq.offer(new Pair(src, 0));
        
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;

            for (Pair ngbr : adj.get(u)) {
                int v = ngbr.node;
                int w = ngbr.weight;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }
        
        return dist;
    }
}
