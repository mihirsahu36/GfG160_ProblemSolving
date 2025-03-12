/*Min Cost Climbing Stairs
Given an array of integers cost[] where cost[i] is the cost of the ith step on a staircase.
Once the cost is paid, you can either climb one or two steps. Return the minimum cost to reach the top of the floor.
Assume 0-based Indexing. You can either start from the step with index 0, or the step with index 1.

Examples:

Input: cost[] = [10, 15, 20]
Output: 15
Explanation: Cheapest option is to start at cost[1], pay that cost, and go to the top.

Input: cost[] = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest option is to start on cost[0], and only step on 1s, skipping cost[3].

Constraints:

2 ≤ cost.size() ≤ 10^5
0 ≤ cost[i] ≤ 999*/

class Solution {
    static int solve(int []cost, int i, int []t){
        if(i >= cost.length){
            return 0;
        }
        
        if(t[i] != -1){
            return t[i];
        }
        
        int moveOne = cost[i] + solve(cost, i + 1, t);
        int moveTwo = cost[i] + solve(cost, i + 2, t);
        
        return t[i] = Math.min(moveOne, moveTwo);
    }
    
    static int minCostClimbingStairs(int[] cost) {
        // Write your code here
        int n = cost.length;
        int []t = new int[n+1];
        Arrays.fill(t, -1);
        
        return Math.min(solve(cost, 0, t), solve(cost, 1, t));
    }
};
