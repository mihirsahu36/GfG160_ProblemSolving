/*Minimum cost to connect all houses in a city
Given a 2D array houses[][], consisting of n 2D coordinates {x, y} where each coordinate represents the location of each house, the task is to find the minimum cost to connect all the houses of the city.
The cost of connecting two houses is the Manhattan Distance between the two points (xi, yi) and (xj, yj) i.e., |xi – xj| + |yi – yj|, where |p| denotes the absolute value of p.

Examples :

Input: n = 5 houses[][] = [[0, 7], [0, 9], [20, 7], [30, 7], [40, 70]]
Output: 105
Explanation:
Connect house 1 (0, 7) and house 2 (0, 9) with cost = 2
Connect house 1 (0, 7) and house 3 (20, 7) with cost = 20
Connect house 3 (20, 7) with house 4 (30, 7) with cost = 10 
At last, connect house 4 (30, 7) with house 5 (40, 70) with cost 73.
All the houses are connected now.
The overall minimum cost is 2 + 10 + 20 + 73 = 105.

Input: n = 4 houses[][] = [[0, 0], [1, 1], [1, 3], [3, 0]]
Output: 7
Explanation: 
Connect house 1 (0, 0) with house 2 (1, 1) with cost = 2
Connect house 2 (1, 1) with house 3 (1, 3) with cost = 2 
Connect house 1 (0, 0) with house 4 (3, 0) with cost = 3 
The overall minimum cost is 3 + 2 + 2 = 7.

Constraint:

1 ≤ n ≤ 10^3
0 ≤ houses[i][j] ≤ 10^3*/

class Solution {
    private int primsMST(List<List<int[]>> adj, int n){
        boolean []visited = new boolean[n];
        int totalCost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        
        while(!pq.isEmpty()){
            int []curr = pq.poll();
            int node = curr[0];
            int currCost = curr[1];
            
            if(visited[node]){
                continue;
            }
            visited[node] = true;
            totalCost += currCost;
            
            for(int []ngbr : adj.get(node)){
                int nextNode = ngbr[0];
                int edgeCost = ngbr[1];
                if(!visited[nextNode]){
                    pq.offer(new int[]{nextNode, edgeCost});
                }
            }
        }
        return totalCost;
    }

    public int minCost(int[][] houses) {
        // code here
        int n = houses.length;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dist = Math.abs(houses[i][0] - houses[j][0]) + Math.abs(houses[i][1] - houses[j][1]);
                adj.get(i).add(new int[]{j, dist});
                adj.get(j).add(new int[]{i, dist});
            }
        }
        
        return primsMST(adj, n);
    }
}
