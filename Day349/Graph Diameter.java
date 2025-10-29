/* Graph Diameter
You are given an undirected connected graph with V vertices numbered from 0 to V-1 and E edges,
represented as a 2D array edges[][], where each element edges[i] = [u, v] represents an undirected edge between vertex u and vertex v.
Find the diameter of the graph.
The diameter of a graph (sometimes called the width) is the number of edges on the longest path between two vertices in the graph.
Note: Graph do not contains any cycle.

Examples :

Input: V = 6, E = 5, edges[][] = [[0, 1], [0, 4], [1, 3], [1, 2], [2, 5]]    
Output: 4
Explanation: The longest path in the graph is from vertices 4 to vertices 5 (4 -> 0 -> 1 -> 2 -> 5).

Input: V = 7, E = 6, edges[][] = [[0, 2], [0, 4], [0, 3], [3, 1], [3, 5], [1, 6]]
Output: 4
Explanation: The longest path in the graph is from vertices 2 to vertices 6 (2 -> 0 -> 3 -> 1 -> 6).

Constraints:

2 ≤ V ≤  10^5
1 ≤ E ≤  V - 1
0 ≤ edges[i][0], edges[i][1] < V */

class Solution {
    public int diameter(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int []edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int farthestNode = solve(0, adj, V)[0];
        int []res = solve(farthestNode, adj, V);
        
        return res[1];
    }
    
    private int []solve(int start, ArrayList<ArrayList<Integer>> adj, int V){
        Queue<Integer>queue = new LinkedList<>();
        boolean []visited = new boolean[V];
        int []dist = new int[V];
        
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            
            for(int ngbr : adj.get(node)){
                if(!visited[ngbr]){
                    visited[ngbr] = true;
                    dist[ngbr] = dist[node] + 1;
                    queue.add(ngbr);
                }
            }
        }
        
        int farthestNode = start, maxDist = 0;
        for(int i=0;i<V;i++){
            if(dist[i] > maxDist){
                maxDist = dist[i];
                farthestNode = i;
            }
        }
        
        return new int[]{farthestNode, maxDist};
    }
}
