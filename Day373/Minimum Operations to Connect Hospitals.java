/* Minimum Operations to Connect Hospitals
You are given an undirected network of V hospitals numbered from 0 to V - 1, represented as a 2D array edges[][], where each element edges[i] = [u, v] denotes a direct connection between hospital u and hospital v.
In one operation, you are allowed to remove any existing link and reconnect it between two hospitals that are currently not directly or indirectly connected.
Your task is to determine the minimum number of operations required to make sure that all hospitals become connected, either directly or indirectly, using the given links.
Note: If it is impossible to connect all hospitals into a single network, return -1.

Examples:

Input: V = 4, E = 3, edges[][] = [[0, 1], [0, 2], [1, 2]]
Output: 1
Explanation: Remove the connection between hospitals 1 and 2 and connect the hospitals 1 and 3.

Input: V = 5, E = 4, edges[][] = [[0, 1], [0, 2], [2, 3], [3, 4]]
Output: 0
Explanation: All hospitals are already connected directly or indirectly. No rearrangement of connections is required.

Constraints:
1 ≤ V ≤ 10^3
0 ≤ E ≤ V*(V-1)/2
0 ≤ edges[i][0], edges[i][1] < V */

class Solution {
     void solve(int start, ArrayList<ArrayList<Integer>> adj, boolean []visited){
        visited[start] = true;
        for(int ngbr : adj.get(start)) {
            if(!visited[ngbr]) {
                solve(ngbr, adj, visited);
            }
        }
    }

    public int minConnect(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int []edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int totalEdges = edges.length;

        boolean []visited = new boolean[V];
        int components = 0;

        for(int i=0;i<V;i++){
            if(!visited[i]){
                components++;
                solve(i, adj, visited);
            }
        }

        if(totalEdges < V - 1){
            return -1;
        }

        int extra = totalEdges - (V - components);

        if(extra >= components - 1){
            return components - 1;
        }

        return -1;
    }
}
