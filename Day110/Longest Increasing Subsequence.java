/*Longest Increasing Subsequence
Given an array arr[] of non-negative integers, the task is to find the length of the Longest Strictly Increasing Subsequence (LIS).
A subsequence is strictly increasing if each element in the subsequence is strictly less than the next element.

Examples:

Input: arr[] = [5, 8, 3, 7, 9, 1]
Output: 3
Explanation: The longest strictly increasing subsequence could be [5, 7, 9], which has a length of 3.

Input: arr[] = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
Output: 6
Explanation: One of the possible longest strictly increasing subsequences is [0, 2, 6, 9, 13, 15], which has a length of 6.

Input: arr[] = [3, 10, 2, 1, 20]
Output: 3
Explanation: The longest strictly increasing subsequence could be [3, 10, 20], which has a length of 3.

Constraints:

1 ≤ arr.size() ≤ 10^3
0 ≤ arr[i] ≤ 10^6*/

// Approach 1 (Using bottom up)
class Solution {
    static int lis(int arr[]) {
        // code here
        int n = arr.length;
        int []t = new int[n];
        Arrays.fill(t, 1);
        int maxLIS = 1;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j] < arr[i]){
                    t[i] = Math.max(t[i], t[j] + 1);
                    maxLIS = Math.max(maxLIS, t[i]);
                }
            }
        }
        
        return maxLIS;
    }
}

// Approach 2 (Using recursion and memoization)
class Solution {
    static int n;
    static int [][]t;
    
    static int solve(int []arr, int P, int i){
        if(i >= n){
            return 0;
        }
        
        if(P != -1 && t[P][i] != -1){
            return t[P][i];
        }
        
        int taken = 0;
        if(P == -1 || arr[i] > arr[P]){ // taken case
            taken = 1 + solve(arr, i, i + 1);
        }
        
        int notTaken = solve(arr, P, i + 1); // not taken case
        
        if(P != -1){
            t[P][i] = Math.max(taken, notTaken);
        }
        
        return Math.max(taken, notTaken);
    }
    static int lis(int arr[]) {
        // code here
        n = arr.length;
        t = new int[n+1][n+1];
        
        for(int []row : t){
            Arrays.fill(row, -1);
        }
        
        return solve(arr, -1, 0);
    }
}
