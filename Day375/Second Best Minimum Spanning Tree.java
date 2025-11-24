/* Second Best Minimum Spanning Tree
Given an undirected graph of V vertices numbered from (0 to V-1) and E edges represented by a 2D array edges[][],
where each edges[i] contains three integers [u, v, w], representing an undirected edge from u to v, having weight w.
Your task is to find the weight of the second best minimum spanning tree of the given graph.
A second best MST is defined as the minimum-weight spanning tree whose total weight is strictly greater than the weight of the minimum spanning tree.
Note: If no such second best MST exists, return -1. 

Examples:

Input: V = 5, E = 7, edges[][] = [[0, 1, 4], [0, 2, 3], [1, 2, 1], [1, 3, 5], [2, 4, 10], [2, 3, 7], [3, 4, 2]]
Output: 12
Explanation: Graph through red edges represents MST.
   
Input: V = 5, E = 4, edges[][] = [[0, 1, 2], [1, 2, 3], [2, 3, 4], [3, 4, 5]] 
Output: -1
Explanation: No second best MST exists for this graph.
   
Constraints:
1 ≤ V ≤ 100
V-1 ≤ E ≤ V*(V-1)/2
0 ≤ edges[i][2] ≤ 10^3 */

class Solution {
    class DSU {
        int []p,r;
        DSU(int n){
            p = new int[n];
            r = new int[n];
            for(int i=0;i<n;i++){
                p[i] = i;
            }
        }

        int find(int x){
            return p[x] == x ? x : (p[x] = find(p[x]));
        }

        boolean unite(int a, int b){
            a = find(a);
            b = find(b);
            if(a == b){
                return false;
            }
            if(r[a] < r[b]){
                int t = a; a = b; b = t;
            }
            p[b] = a;
            if(r[a] == r[b]){
                r[a]++;
            }
            return true;
        }
    }

    int kruskal(int V, int [][]e, int skip){
        DSU dsu = new DSU(V);
        int cost = 0, used = 0;
        for(int i=0;i<e.length;i++){
            if(i == skip){
                continue;
            }
            int u = e[i][0], v = e[i][1], w = e[i][2];
            if(dsu.unite(u, v)){
                cost += w;
                used++;
            }
        }
        if(used != V - 1){
            return Integer.MAX_VALUE;
        }
        return cost;
    }

    public int secondMST(int V, int[][] edges) {
        int [][]e = new int[edges.length][3];
        for(int i=0;i<edges.length;i++){
            e[i][0] = edges[i][0];
            e[i][1] = edges[i][1];
            e[i][2] = edges[i][2];
        }

        Arrays.sort(e, (a, b) -> a[2] - b[2]);

        DSU dsu = new DSU(V);
        int mst = 0;
        ArrayList<Integer> mstEdges = new ArrayList<>();

        for(int i=0;i<e.length;i++){
            if(dsu.unite(e[i][0], e[i][1])){
                mst += e[i][2];
                mstEdges.add(i);
            }
        }

        if(mstEdges.size() != V - 1){
            return -1;
        }

        int res = Integer.MAX_VALUE;

        for(int idx : mstEdges){
            int cost = kruskal(V, e, idx);
            if(cost > mst && cost < res){
                res = cost;
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
