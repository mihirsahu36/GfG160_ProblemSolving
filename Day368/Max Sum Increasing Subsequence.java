/* Max Sum Increasing Subsequence
Given an array of positive integers arr[], find the maximum sum of a subsequence such
that the elements of the subsequence form a strictly increasing sequence.
In other words, among all strictly increasing subsequences of the array,
return the one with the largest possible sum.

Examples:

Input: arr[] = [1, 101, 2, 3, 100]
Output: 106
Explanation: The maximum sum of an increasing sequence is obtained from [1, 2, 3, 100].

Input: arr[] = [4, 1, 2, 3]
Output: 6
Explanation: The maximum sum of an increasing sequence is obtained from [1, 2, 3].

Input: arr[] = [4, 1, 2, 4]
Output: 7
Explanation: The maximum sum of an increasing sequence is obtained from [1, 2, 4].

Constraints:

1 ≤ arr.size() ≤ 10^3
1 ≤ arr[i] ≤ 10^5 */

class Solution {
    public int maxSumIS(int arr[]) {
        // code here
        int n = arr.length;
        int []dp = new int[n];
        
        for(int i=0;i<n;i++){
            dp[i] = arr[i];
        }
        
        int maxSum = arr[0];
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            maxSum = Math.max(maxSum, dp[i]);
        }
        
        return maxSum;
    }
}
