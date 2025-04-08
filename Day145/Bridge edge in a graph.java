/*Bridge edge in a graph
Given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], where edges[i]=[u,v] represents the edge between the vertices u and v.
Determine whether a specific edge between two vertices (c, d) is a bridge.
Note:
An edge is called a bridge if removing it increases the number of connected components of the graph.
if there’s only one path between c and d (which is the edge itself), then that edge is a bridge.
Examples :

Input:
c = 1, d = 2
Output: true
Explanation: From the graph, we can clearly see that blocking the edge 1-2 will result in disconnection of the graph.
Hence, it is a Bridge.

Input:
c = 0, d = 2
Output: false
Explanation:
Blocking the edge between nodes 0 and 2 won't affect the connectivity of the graph.
So, it's not a Bridge Edge. All the Bridge Edges in the graph are marked with a blue line in the above image.
Constraints:

1 ≤ V, E ≤ 10^5
0 ≤ c, d ≤ V-1*/

class Solution {
    int time;
    boolean isBridge;
    
    public boolean isBridge(int V, int[][] edges, int c, int d) {
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
        isBridge = false;
        
        dfs(adj, c, -1, c, d, visited, tin, low);
        return isBridge;
    }
    
    public void dfs(List<List<Integer>> adj, int u, int parent, int c, int d,
    boolean []visited, int []tin, int []low){
        visited[u] = true;
        tin[u] = low[u] = time++;
        
        for(int ngbr : adj.get(u)){
            if(ngbr == parent){
                continue;
            }
            
            if(!visited[ngbr]){
                dfs(adj, ngbr, u, c, d, visited, tin, low);
                low[u] = Math.min(low[u], low[ngbr]);
                
                if(low[ngbr] > tin[u]){
                    if((u == c && ngbr == d) || (u == d && ngbr == c)){
                        isBridge = true;
                    }
                }
            }else{
                low[u] = Math.min(low[u], tin[ngbr]);
            }
        }
    }
}
