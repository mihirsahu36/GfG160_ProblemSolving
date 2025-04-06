/*Topological sort
Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][], where each entry edges[i] = [u, v] denotes an directed edge u -> v.
Return topological sort for the given graph.
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be true else false.

Examples:

Input: V = 4, E = 3, edges[][] = [[3, 0], [1, 0], [2, 0]]
Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the given graph are:
[3, 2, 1, 0]
[1, 2, 3, 0]
[2, 3, 1, 0]

Input: V = 6, E = 6, edges[][] = [[1, 3], [2, 3], [4, 1], [4, 0], [5, 0], [5,2]]
Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the graph are:
[4, 5, 0, 1, 2, 3]
[5, 2, 4, 0, 1, 3]

Constraints:

2  ≤  V  ≤  10^3
1  ≤  E = edges.size()  ≤  (V * (V - 1)) / 2*/

class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
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
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(adj, i, stack, visited);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        
        return res;
    }
    
    private static void dfs(List<List<Integer>> adj, int u, Stack<Integer> stack, boolean []visited){
        visited[u] = true;
        
        for(int v : adj.get(u)){
            if(!visited[v]){
                dfs(adj, v, stack, visited);
            }
        }
        stack.push(u);
    }
}
