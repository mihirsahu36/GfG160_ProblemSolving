/* Shortest Cycle
You are given an undirected graph with V vertices numbered from 0 to V-1 and E edges,
represented as a 2D array edges[][], where each element edges[i] = [u, v] represents an undirected edge between vertex u and v.
Find the length of the shortest cycle in the graph. If the graph does not contain any cycle, return -1.
Note: A cycle is a path that starts and ends at the same vertex without repeating any edge or vertex (except the start/end vertex).
The shortest cycle is the one with the minimum number of edges.

Examples

Input: V = 7, E = 8, edges[][] = [[0, 5], [0, 6], [5, 1], [6, 1], [6, 2], [2, 3], [3, 4], [1, 4]]
Output: 4
Explanation: Possible cycles are: 
0 → 5 → 1 → 6 → 0 (length = 4)
1 → 4 → 3 → 2 → 6 → 1 (length = 5)
The smallest one is 0 → 5 → 1 → 6 → 0, with length 4. 

Input: V = 7, E = 9, edges[][] = [[0, 5], [0, 6], [1, 2], [1, 4], [1, 5], [1, 6], [2, 6], [2, 3], [3, 4]]
Output: 3
Explanation: Possible cycles include:
1 → 2 → 6 → 1 (length = 3)
1 → 2 → 3 → 4 → 1 (length = 4)
0 → 5 → 1 → 6 → 0 (length = 4)
The smallest one is 1 → 2 → 6 → 1, with length 3.

Constraints:

1 ≤ V ≤ 10^3
0 ≤ E ≤ 10^3
0 ≤ edges[i][0], edges[i][1] < V */

class Solution {
    public int shortCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int []edge : edges){
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int res = Integer.MAX_VALUE;
        
        for(int start=0;start<V;start++){
            int []dist = new int[V];
            Arrays.fill(dist, -1);
            
            int []parent = new int[V];
            Arrays.fill(parent, -1);
            
            Queue<Integer> queue = new LinkedList<>();
            dist[start] = 0;
            queue.add(start);
            
            while(!queue.isEmpty()){
                int node = queue.poll();
                
                for(int ngbr : adj.get(node)){
                    if(dist[ngbr] == -1){
                        dist[ngbr] = dist[node] + 1;
                        parent[ngbr] = node;
                        queue.add(ngbr);
                    }else if(parent[node] != ngbr){
                        res = Math.min(res, dist[ngbr] + dist[node] + 1);
                    }
                }
            }
        }
        
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}
