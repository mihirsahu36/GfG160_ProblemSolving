/* Stock Buy and Sell with Cooldown
Given an array arr[], where the ith element of arr[] represents the price of a stock on the ith day (all prices are non-negative integers).
Find the maximum profit you can make by buying and selling stocks such that after selling a stock, you cannot buy again on the next day (i.e., there is a one-day cooldown).

Examples:

Input: arr[] = [0, 2, 1, 2, 3]
Output: 3
Explanation: You first buy on day 1, sell on day 2 then cool down, then buy on day 4, and sell on day 5.
The total profit earned is (2-0) + (3-2) = 3, which is the maximum achievable profit.

Input:  arr[] = [3, 1, 6, 1, 2, 4]
Output: 7
Explanation: You first buy on day 2 and sell on day 3 then cool down, then again you buy on day 5 and then sell on day 6.
Clearly, the total profit earned is (6-1) + (4-2) = 7, which is the maximum achievable profit.

Constraint:

1 ≤ arr.size() ≤ 10^5
1 ≤ arr[i] ≤ 10^4 */

class Solution {
    private int findProfit(int i, int buy, int []arr, int [][]dp){
        int n = arr.length;
        if(i >= n){
            return 0;
        }
        
        if(dp[i][buy] != -1){
            return dp[i][buy];
        }
        
        if(buy == 1){
            int take = -arr[i] + findProfit(i + 1, 0, arr, dp);
            int skip = findProfit(i + 1, 1, arr, dp);
            
            dp[i][buy] = Math.max(take, skip);
        }else{
            int sell = arr[i] + findProfit(i + 2, 1, arr, dp);
            int skip = findProfit(i + 1, 0, arr, dp);
            
            dp[i][buy] = Math.max(sell, skip);
        }
        
        return dp[i][buy];
    }
    
    public int maxProfit(int arr[]) {
        // Code here
        int n = arr.length;
        int [][]dp = new int[n][2];
        for(int []row : dp){
            Arrays.fill(row, -1);
        }
        
        return findProfit(0, 1, arr, dp);
    }
}
