/* Travelling Salesman Problem
Given a 2d matrix cost[][] of size n where cost[i][j] denotes the cost of moving from city i to city j. Your task is to complete a tour from city 0 (0-based index) to all other cities such that you visit each city exactly once and then at the end come back to city 0 at minimum cost.

Examples:

Input: cost[][] = [[0, 111], 
                [112, 0]]
Output: 223
Explanation: We can visit 0->1->0 and cost = 111 + 112.

Input: cost[][] = [[0, 1000, 5000],
                [5000, 0, 1000],
                [1000, 5000, 0]]
Output: 3000
Explanation: We can visit 0->1->2->0 and cost = 1000 + 1000 + 1000 = 3000
Constraints:

1 ≤ cost.size() ≤ 15
0 ≤ cost[i][j] ≤ 10^4 */

class Solution {
    public int tsp(int[][] cost) {
        // code here
        int n = cost.length;
        int FULL = (1 << n);
        int [][]dp = new int[FULL][n];
        int INF = (int)1e9;

        for(int i=0;i<FULL;i++){
            Arrays.fill(dp[i], INF);
        }

        dp[1][0] = 0;

        for(int mask=0;mask<FULL;mask++){
            for(int u=0;u<n;u++){
                if((mask & (1 << u)) == 0){
                    continue;
                }

                for(int v=0;v<n;v++){
                    if((mask & (1 << v)) != 0){
                        continue;
                    }

                    int newMask = mask | (1 << v);
                    dp[newMask][v] = Math.min(dp[newMask][v], dp[mask][u] + cost[u][v]);
                }
            }
        }

        int res = INF;
        int finalMask = FULL - 1;

        for(int last=0;last<n;last++){
            res = Math.min(res, dp[finalMask][last] + cost[last][0]);
        }

        return res;
    }
}
