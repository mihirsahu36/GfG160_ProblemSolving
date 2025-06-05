/*Count the paths
Given a Directed Acyclic Graph (DAG) with V nodes labeled from 0 to V-1, and a list of directed edges,
count the total number of distinct paths from a given start node to a destination node.
Each edge is represented as edges[i] = [u, v], indicating a directed edge from u to v.

Examples :

Input: edges[][] = [[0,1], [0,3], [2,0], [2,1], [1,3]], V = 4, src = 2, dest = 3
Output: 3
Explanation: There are three ways to reach at 3 from 2. These are: 2 -> 1 -> 3, 2 -> 0 -> 3 and 2 -> 0 -> 1 -> 3.
Print-all-paths-1

Input: edges[][] = [[0,1], [1,2], [1,3], [2,3]], V = 4, src = 0, dest = 3
Output: 2
Explanation: There is two way to reach at 3 from 0 that is : 0 -> 1 -> 2 -> 3 and 0 -> 1 -> 3.
Print-all-paths-2

Constraints:

2  ≤  V  ≤  10^3
1  ≤   E = edges.size()  ≤  (V * (V - 1)) / 2 */

class Solution {
    private int solve(int u, int dest, List<List<Integer>> adj, int []t){
        if(u == dest){
            return 1;
        }
        
        if(t[u] != -1){
            return t[u];
        }
        
        int count = 0;
        for(int v : adj.get(u)){
            count += solve(v, dest, adj, t);
        }
        
        return t[u] = count;
    }
    
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int []edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        int []t = new int[V];
        Arrays.fill(t, -1);
        
        return solve(src, dest, adj, t);
    }
}
