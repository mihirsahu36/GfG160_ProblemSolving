/* Walls Coloring II
You are given n walls arranged in a row, and each wall must be painted using one of the k available colors. The cost of painting ith wall with jth color is given by costs[i][j]. Your task is to determine the minimum total cost required to paint all the walls in such a way that no two adjacent walls share the same color. If it is impossible to paint the walls under this condition, you must return -1.

Examples:

Input: n = 4, k = 3,
costs[][] = [[1, 5, 7],
           [5, 8, 4],
           [3, 2, 9],
           [1, 2, 4]]

Output: 8
Explanation:
Paint wall 0 with color 0. Cost = 1
Paint wall 1 with color 2. Cost = 4
Paint wall 2 with color 1. Cost = 2
Paint wall 3 with color 0. Cost = 1
Total Cost = 1 + 4 + 2 + 1 = 8

Input: n = 5, k = 1,
costs[][] = [[5],
           [4],
           [9],
           [2],
           [1]]
Output: -1
Explanation: It is not possible to color all the walls under the given conditions.
Constraints:

0 ≤ n  ≤ 10^3
0 ≤ k  ≤ 10^3
1 ≤ costs[i][j]  ≤ 10^5 */

class Solution {
    int minCost(int[][] costs) {
        // code here
        int n = costs.length;
        if(n == 0){
            return 0;
        }

        int k = costs[0].length;
        if(k == 0){
            return -1;
        }
        if(k == 1){
            return n == 1 ? costs[0][0] : -1;
        }

        int []dp = new int[k];
        for(int j=0;j<k;j++){
            dp[j] = costs[0][j];
        }

        for(int i=1;i<n;i++){
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int color1 = -1;
            for(int j=0;j<k;j++){
                if(dp[j] < min1){
                    min2 = min1;
                    min1 = dp[j];
                    color1 = j;
                }else if(dp[j] < min2){
                    min2 = dp[j];
                }
            }

            int []newDp = new int[k];
            for(int j=0;j<k;j++){
                if(j == color1){
                    newDp[j] = costs[i][j] + min2;
                }else{
                    newDp[j] = costs[i][j] + min1;
                }
            }

            dp = newDp;
        }

        int res = Integer.MAX_VALUE;
        for(int val : dp){
            res = Math.min(res, val);
        }
        
        return res;
    }
}
