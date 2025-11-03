/* Safe States
Given a directed graph with V vertices numbered from 0 to V-1 and E directed edges,
represented as a 2D array edges[][], where each element edges[i] = [u, v] represents a directed edge from vertex u to vertex v.
Return all Safe Nodes of the graph.
A vertex with no outgoing edges is called a terminal node.
A vertex is considered safe if every path starting from it eventually reaches a terminal node.

Examples: 

Input: V = 5, E = 6, edges[][] = [[1, 0], [1, 2], [1, 3], [1, 4], [2, 3], [3, 4]]
Output: [0, 1, 2, 3, 4]
Explanation: 4 and 0 is the terminal node, and all the paths from 1, 2, 3 lead to terminal node, i.e., 4.

Input: V = 4, E = 3, edges[][] = [[1, 2], [2, 3], [3, 2]]
Output: [0]
Explanation: 0 is the terminal node, and no other node than 0 leads to 0.

Constraints:

1 ≤ V ≤ 10^5
0 ≤ E ≤ 10^5
0 ≤ edges[i][0], edges[i][1] < V */

class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int []edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i=0;i<V;i++){
            revAdj.add(new ArrayList<>());
        }
        
        int []indegree = new int[V];
        for(int u=0;u<V;u++){
            for(int v : adj.get(u)){
                revAdj.get(v).add(u);
                indegree[u]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        boolean []safe = new boolean[V];
        while(!queue.isEmpty()){
            int node = queue.poll();
            safe[node] = true;
            
            for(int prev : revAdj.get(node)){
                indegree[prev]--;
                if(indegree[prev] == 0){
                    queue.add(prev);
                }
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(safe[i]){
                res.add(i);
            }
        }
        
        return res;
    }
}
