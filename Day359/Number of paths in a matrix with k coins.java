/* Number of paths in a matrix with k coins
You are given a matrix mat[][] of size n x m, where each of its cells contains some coins.
Count the number of ways to collect exactly k coins while moving from the top left cell of the matrix to the bottom right cell.
From a cell (i, j), you can only move to cell (i+1, j) or (i, j+1).
Note: It is guaranteed that the answer will not exceed 32-bit integer limits.

Examples:

Input: k = 12, mat[] = [[1, 2, 3],
                      [4, 6, 5],
                      [3, 2, 1]]
Output: 2
Explanation: There are 2 possible paths with exactly 12 coins, (1 + 2 + 6 + 2 + 1) and (1 + 2 + 3 + 5 + 1).

Input: k = 16, mat[] = [[1, 2, 3], 
                      [4, 6, 5], 
                      [9, 8, 7]]
Output: 0 
Explanation: There are no possible paths that lead to sum = 16.

Constraints:

1 ≤ k ≤ 100
1 ≤ n, m ≤ 100
0 ≤ mat[i][j] ≤ 200 */

class Solution {
    public int numberOfPath(int[][] mat, int k) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int [][][]dp = new int[n][m][k+1];
        
        if(mat[0][0] <= k){
            dp[0][0][mat[0][0]] = 1;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int sum=0;sum<=k;sum++){
                    if(sum - mat[i][j] >= 0){
                        if(i > 0){
                            dp[i][j][sum] += dp[i-1][j][sum-mat[i][j]];
                        }
                        
                        if(j > 0){
                            dp[i][j][sum] += dp[i][j-1][sum-mat[i][j]];
                        }
                    }
                }
            }
        }
        
        return dp[n-1][m-1][k];
    }
}
