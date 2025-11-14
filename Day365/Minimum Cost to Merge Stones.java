/* Minimum Cost to Merge Stones
Given an array stones[], where the ith element represents the number of stones in the ith pile.
In one move, you can merge exactly k consecutive piles into a single pile,
and the cost of this move is equal to the total number of stones in these k piles.
Determine the minimum total cost required to merge all the piles into one single pile.
If it is not possible to merge all piles into one according to the given rules, return -1.

Examples:

Input: stones[] = [1, 2, 3], k = 2
Output: 9
Explanation: Initially the array looks like [1, 2, 3].
First, we merge first 2 stones, i.e., 1 and 2, array becomes [3, 3] and cost is 1 + 2 = 3.
Then, we merge remaining stones, i.e., 3 and 3, array becomes [6] and the cost = 3 + 3 = 6.
Total cost = 3 + 6 = 9.

Input: stones[] = [1, 5, 3, 2, 4], k = 2
Output: 35
Explanation: Initially the array looks like [1, 5, 3, 2, 4].
First, we merge 1 and 5, array becomes [6, 3, 2, 4] and cost is 1 + 5 = 6.
Then, we merge 3 and 2, array becomes [6, 5, 4] and the cost = 3 + 2 = 5.
Then, we merge 5 and 4, array becomes [6, 9] and the cost = 5 + 4 = 9.
Finally, we merge 6 and 9, array becomes [15] and the cost = 6 + 9 = 15.
Total cost = 6 + 5 + 9 + 15 = 35.

Input: stones[] = [1, 5, 3, 2, 4], k = 4
Output: -1
Explanation: There is no possible way to combine the stones in piles of 4 to get 1 stone in the end.

Constraints:

1 ≤ stones.size() ≤ 30
2 ≤ k ≤ 30
1 ≤ stones[i] ≤ 100 */

class Solution {
    public static int mergeStones(int[] stones, int k) {
        // code here
        int n = stones.length;
        
        if((n - 1) % (k - 1) != 0){
            return -1;
        }
        
        int [][]dp = new int[n][n];
        int []prefixSum = new int[n+1];
        
        for(int i=0;i<n;i++){
            prefixSum[i+1] = prefixSum[i] + stones[i];
        }
        
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                int minCost = Integer.MAX_VALUE;
                for(int idx=i;idx<j;idx+=k-1){
                    int cost = dp[i][idx] + dp[idx+1][j];
                    minCost = Math.min(cost, minCost);
                }
                
                if((j - i) % (k - 1) == 0){
                    minCost += prefixSum[j+1] - prefixSum[i];
                }
                dp[i][j] = minCost;
            }
        }
        
        return dp[0][n-1];
    }
}
