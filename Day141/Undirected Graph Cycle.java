/*Undirected Graph Cycle
Given an undirected graph with V vertices and E edges, represented as a 2D vector edges[][], where each entry edges[i] = [u, v]
denotes an edge between vertices u and v, determine whether the graph contains a cycle or not.

Examples:

Input: V = 4, E = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
Output: true
Explanation: 
1 -> 2 -> 0 -> 1 is a cycle.

Input: V = 4, E = 3, edges[][] = [[0, 1], [1, 2], [2, 3]]
Output: false
Explanation: 
No cycle in the graph.

Constraints:

1 ≤ V ≤ 10^5
1 ≤ E = edges.size() ≤ 10^5*/

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int []edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean []visited = new boolean[V];
        for(int i =0;i<V;i++){
            if(!visited[i] && isCycleDFS(adj, i, visited, -1)){
                return true;
            }
        }
        return false;
    }
    
    private boolean isCycleDFS(List<List<Integer>> adj, int u, boolean[] visited, int parent){
        visited[u] = true;
        
        for(int v : adj.get(u)){
            if(!visited[v]){
                if(isCycleDFS(adj, v, visited, u)){
                    return true;
                }
            }else if(v != parent){
                return true;
            }
        }
        return false;
    }
}
