/*Coin Change (Count Ways)
Given an integer array coins[ ] representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ]. 
Note: Assume that you have an infinite supply of each type of coin. Therefore, you can use any coin as many times as you want.
Answers are guaranteed to fit into a 32-bit integer. 

Examples:

Input: coins[] = [1, 2, 3], sum = 4
Output: 4
Explanation: Four Possible ways are: [1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3].

Input: coins[] = [2, 5, 3, 6], sum = 10
Output: 5
Explanation: Five Possible ways are: [2, 2, 2, 2, 2], [2, 2, 3, 3], [2, 2, 6], [2, 3, 5] and [5, 5].

Input: coins[] = [5, 10], sum = 3
Output: 0
Explanation: Since all coin denominations are greater than sum, no combination can make the target sum.

Constraints:

1 <= sum <= 10^3
1 <= coins[i] <= 10^4
1 <= coins.size() <= 10^3*/


class Solution {
    private int solve(int []coins, int sum, int i, int [][]t){
        if(sum == 0){
            return 1;
        }
        
        if(i == coins.length){
            return 0;
        }
        
        if(t[i][sum] != -1){
            return t[i][sum];
        }
        
        int notTake = solve(coins, sum, i + 1, t);
        
        int Take = 0;
        if(sum - coins[i] >= 0){
            Take = solve(coins, sum - coins[i], i, t);
        }
        
        return t[i][sum] = Take + notTake;
    }
    
    public int count(int coins[], int sum) {
        // code here.
        int n = coins.length;
        int [][]t = new int[n+1][sum+1];
        
        for(int []row : t){
            Arrays.fill(row, -1);
        }
        
        return solve(coins, sum, 0, t);
    }
}
