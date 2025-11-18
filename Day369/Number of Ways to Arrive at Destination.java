/* Number of Ways to Arrive at Destination
Difficulty: MediumAccuracy: 61.13%Submissions: 85K+Points: 4Average Time: 30m
You are given an undirected weighted graph with V vertices numbered from 0 to V-1 and E edges,
represented as a 2D array edges[][], where edges[i] = [ui, vi, timei]
means that there is an undirected edge between nodes ui and vi that takes timei minutes to reach.
Your task is to return in how many ways you can travel from node 0 to node V - 1 in the shortest amount of time.

Examples:

Input: V = 4, edges[][] = [[0, 1, 2], [1, 2, 3], [0, 3, 5], [1, 3, 3], [2, 3, 4]]  
Output: 2
Explanation: The shortest path from 0 to 3 is 5.
Two ways to reach 3 in 5 minutes are:
0 -> 3
0 -> 1 -> 3

Input: V = 6, edges[][] = [[0, 2, 3], [0, 4, 2], [0, 5, 7], [2, 3, 1], [2, 5, 5], [5, 3, 3], [5, 1, 4], [1, 4, 1], [4, 5, 5]]
Output: 4
Explanation: The shortest path from 0 to 5 is 7.
Four ways to reach 5 in 7 minutes are:
0 -> 5
0 -> 4 -> 5
0 -> 4 -> 1 -> 5
0 -> 2 -> 3 -> 5

Constraints:

1 ≤ V ≤ 200
V - 1 ≤ edges.size() ≤ V * (V - 1) / 2
0 ≤ ui, vi ≤ V - 1
1 ≤ timei ≤ 10^5
ui != vi */

class Solution {
    public int countPaths(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int []edge : edges){
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }
        
        long []minTime = new long[V];
        Arrays.fill(minTime, Long.MAX_VALUE);
        minTime[0] = 0;
        
        long []ways = new long[V];
        ways[0] = 1;
        
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0});
        
        while(!pq.isEmpty()){
            long []top = pq.poll();
            long time = top[0];
            int node = (int)top[1];
            
            if(time > minTime[node]){
                continue;
            }
            
            for(int []ngbr : adj.get(node)){
                int nextNode = ngbr[0];
                long wt = ngbr[1];
                long newTime = time + wt;
                
                if(newTime < minTime[nextNode]){
                    minTime[nextNode] = newTime;
                    ways[nextNode] = ways[node];
                    pq.offer(new long[]{newTime, nextNode});
                }else if(newTime == minTime[nextNode]){
                    ways[nextNode] = ways[nextNode] + ways[node];
                }
            }
        }
        
        return (int)ways[V-1];
    }
}
