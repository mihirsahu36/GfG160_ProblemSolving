/* Shortest Path Using Atmost One Curved Edge
Given an undirected, connected graph with V vertices numbered from 0 to V-1 and E double-edges, represented as a 2D array edges[][]. Each double-edge is represented by a tuple (x, y, w1, w2), which indicates that there are two edges between vertices x and y: a straight edge with weight w1 and a curved edge with weight w2.
You are given two vertices a and b and you have to go from a to b through a series of edges such that in the entire path, you can use at most 1 curved edge. Your task is to find the shortest path from a to b satisfying the above condition.
If no such path exists that satisfies this restriction, return -1.
Note: It is guaranteed that the shortest path value will fit in a 32-bit integer.

Examples:

Input: V = 4, E = 4, a = 1, b = 3, edges[][] = [[0, 1, 1, 4], [0, 2, 2, 4], [0, 3, 3, 1], [1, 3, 6, 5]]
Output: 2
Explanation:
We can follow the path 1 -> 0 -> 3, this gives a distance of 1+3 = 4 if we follow all straight paths.
But we can take the curved path  from 0 -> 3, which costs 1. This will result in a cost of 1 + 1 = 2.
Input: V = 2, E = 1, a = 0, b = 1, edges[][] = [[0, 1, 4, 1]]
Output: 1
Explanation:
Take the curved path from 0 to 1 which costs 1. 

Constraints:
1 ≤ V ≤ 10^6
0 ≤ E ≤ 10^6
0 ≤ a, b ≤ V - 1
0 ≤ edges[i][0], edges[i][1] ≤ V-1
0 ≤ edges[i][2], edges[i][3] ≤ 10^4 */

class Solution {
    public int shortestPath(int V, int a, int b, int[][] edges) {
        // code here
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int []edge : edges){
            int x = edge[0], y = edge[1], w1 = edge[2], w2 = edge[3];
            adj.get(x).add(new int[]{y, w1, w2});
            adj.get(y).add(new int[]{x, w1, w2});
        }

        int INF = (int)1e9;
        int [][]dist = new int[V][2];
        for(int i=0;i<V;i++){
            dist[i][0] = INF;
            dist[i][1] = INF;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        dist[a][0] = 0;
        pq.add(new int[]{0, a, 0});

        while(!pq.isEmpty()){
            int []curr = pq.poll();
            int d = curr[0];
            int node = curr[1];
            int used = curr[2];

            if(d != dist[node][used]){
                continue;
            }

            for(int []it : adj.get(node)){
                int nxt = it[0];
                int w1 = it[1];
                int w2 = it[2];

                if(dist[nxt][used] > d + w1){
                    dist[nxt][used] = d + w1;
                    pq.add(new int[]{dist[nxt][used], nxt, used});
                }

                if(used == 0){
                    if(dist[nxt][1] > d + w2){
                        dist[nxt][1] = d + w2;
                        pq.add(new int[]{dist[nxt][1], nxt, 1});
                    }
                }
            }
        }

        int res = Math.min(dist[b][0], dist[b][1]);
        return res >= INF ? -1 : res;
    }
}
