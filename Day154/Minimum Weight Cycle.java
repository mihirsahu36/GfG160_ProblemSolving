/*Minimum Weight Cycle
Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges,
represented by a 2d array edges[][], where edges[i] = [u, v, w] represents the edge between the nodes u and v having w edge weight.
Your task is to find the minimum weight cycle in this graph.

Examples:

Input: V = 5, edges[][] = [[0, 1, 2], [1, 2, 2], [1, 3, 1], [1, 4, 1], [0, 4, 3], [2, 3, 4]]
Output: 6
Explanation: 
Minimum-weighted cycle is  0 → 1 → 4 → 0 with a total weight of 6(2 + 1 + 3)

Input: V = 5, edges[][] = [[0, 1, 3], [1, 2, 2], [0, 4, 1], [1, 4, 2], [1, 3, 1], [3, 4, 2], [2, 3, 3]]
Output: 5
Explanation: 
Minimum-weighted cycle is  1 → 3 → 4 → 1 with a total weight of 5(1 + 2 + 2)

Constraints:

1 ≤ V ≤ 100
1 ≤ E = edges.size() ≤ 10^3 
1 ≤ edges[i][j] ≤ 100*/

class Solution {
    public List<List<int[]>> constructAdj(int V, int [][]edges){
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int []edge : edges){
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        
        return adj;
    }
    
    public int shortestPath(int V, List<List<int[]>> adj, int u, int v){
        int []dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[u] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, u});
        
        while(!pq.isEmpty()){
            int []curr = pq.poll();
            int d = curr[0], currNode = curr[1];
            
            if(d > dist[currNode]){
                continue;
            }
            
            for(int []ngbr : adj.get(currNode)){
                int ngbrNode = ngbr[0], wt = ngbr[1];
                
                if((currNode == u && ngbrNode == v) || currNode == v && ngbrNode == u){
                    continue;
                }
                
                if(dist[ngbrNode] > dist[currNode] + wt){
                    dist[ngbrNode] = dist[currNode] + wt;
                    pq.offer(new int[]{dist[ngbrNode], ngbrNode});
                }
            }
        }
        
        return dist[v];
    }
    
    public int findMinCycle(int V, int[][] edges) {
        // code here
        List<List<int[]>> adj = constructAdj(V, edges);
        int minCycle = Integer.MAX_VALUE;
        
        for(int []edge : edges){
            int u = edge[0], v = edge[1], w = edge[2];
            int dist = shortestPath(V, adj, u, v);
            
            if(dist != Integer.MAX_VALUE){
                minCycle = Math.min(minCycle, dist + w);
            }
        }
        
        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
};
