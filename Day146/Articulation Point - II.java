/*Articulation Point - II
You are given an undirected graph with V vertices and E edges.
The graph is represented as a 2D array edges[][], where each element edges[i] = [u, v] indicates an undirected edge between vertices u and v.
Your task is to return all the articulation points (or cut vertices) in the graph.
An articulation point is a vertex whose removal, along with all its connected edges, increases the number of connected components in the graph.
Note: The graph may be disconnected, i.e., it may consist of more than one connected component.
If no such point exists, return {-1}.

Examples :

Input: V = 5, edges[][] = [[0, 1], [1, 4], [4, 3], [4, 2], [2, 3]]
Output: [1, 4]
Explanation: Removing the vertex 1 or 4 will disconnects the graph as-
   
Input: V = 4, edges[][] = [[0, 1], [0, 2]]
Output: [0]
Explanation: Removing the vertex 0 will increase the number of disconnected components to 3. 

Constraints:

1 ≤ V, E ≤ 10^4*/

class Solution {
    static int time;
    
    static void dfs(List<List<Integer>> adj, int u, int parent, boolean []visited,
        int []tin, int []low, boolean []isArticulation){
            visited[u] = true;
            tin[u] = low[u] = time++;
            int children = 0;
        
            for(int ngbr : adj.get(u)){
                if(ngbr == parent){
                    continue;
                }
                
                if(!visited[ngbr]){
                    dfs(adj, ngbr, u, visited, tin, low, isArticulation);
                    low[u] = Math.min(low[u], low[ngbr]);
                    children++;
                    
                    if(parent != -1 && low[ngbr] >= tin[u]){
                        isArticulation[u] = true;
                    }
                }else{
                    low[u] = Math.min(low[u], tin[ngbr]);
                }
            }
            
            if(parent == -1 && children > 1){
                isArticulation[u] = true;
            }
    }
    
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int []edge : edges){
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean []visited = new boolean[V];
        time = 0;
        int []tin = new int[V];
        int []low = new int[V];
        boolean []isArticulation = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(adj, i, -1, visited, tin, low, isArticulation);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(isArticulation[i]){
                res.add(i);
            }
        }
        return res.isEmpty() ? new ArrayList<>(List.of(-1)) : res;
    }
}
