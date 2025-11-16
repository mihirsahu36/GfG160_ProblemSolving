/* Longest Common Increasing Subsequence
Given two arrays, a[] and b[], find the length of the longest common increasing subsequence(LCIS).
Note:  LCIS refers to a subsequence that is present in both arrays and strictly increases.

Examples:

Input: a[] = [3, 4, 9, 1], b[] = [5, 3, 8, 9, 10, 2, 1]
Output: 2
Explanation: The longest increasing subsequence that is common is [3, 9] and its length is 2.

Input: a[] = [1, 1, 4, 3], b[] = [1, 1, 3, 4]
Output: 2
Explanation: There are two common subsequences [1, 4] and [1, 3] both of length 2.

Constraints:

1 ≤ a.size(), b.size() ≤ 10^3
1 ≤ a[i], b[i] ≤ 10^4 */

class Solution {
    public int LCIS(int[] a, int[] b) {
        // code here
        int n = a.length;
        int m = b.length;
        int []dp = new int[m];
        
        for(int i=0;i<n;i++){
            int currLen = 0;
            for(int j=0;j<m;j++){
                if(a[i] == b[j]){
                    dp[j] = Math.max(dp[j], currLen + 1);
                }else if(a[i] > b[j]){
                    currLen = Math.max(currLen, dp[j]);
                }
            }
        }
        
        int res = 0;
        for(int val : dp){
            res = Math.max(res, val);
        }
        
        return res;
    }
}
