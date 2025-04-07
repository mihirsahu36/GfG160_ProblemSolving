/*Directed Graph Cycle
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
The graph is represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge from verticex u to v.

Examples:

Input: V = 4, edges[][] = [[0, 1], [1, 2], [2, 3], [3, 3]]
Output: true
Explanation: 3 -> 3 is a cycle

Input: V = 3, edges[][] = [[0, 1], [1, 2]]
Output: false
Explanation: no cycle in the graph

Constraints:

1 ≤ V, E ≤ 10^5*/

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int []edge : edges){
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
        }
        
        boolean []visited = new boolean[V];
        boolean []dfsVisited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i] && dfs(adj, i, visited, dfsVisited)){
                return true;
            }
        }
        return false;
    }
    
    public boolean dfs(List<List<Integer>> adj, int node, boolean []visited, boolean []dfsVisited){
        visited[node] = true;
        dfsVisited[node] = true;
        
        for(int ngbr : adj.get(node)){
            if(!visited[ngbr]){
                if(dfs(adj, ngbr, visited, dfsVisited)){
                    return true;
                }
            }else if(dfsVisited[ngbr]){
                return true;
            }
        }
        dfsVisited[node] = false;
        return false;
    }
}
