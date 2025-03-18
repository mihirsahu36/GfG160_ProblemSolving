/*Partition Equal Subset Sum
Given an array arr[], determine if it can be partitioned into two subsets such that the sum of elements in both parts is the same.
Note: Each element must be in exactly one subset.

Examples:

Input: arr = [1, 5, 11, 5]
Output: true
Explanation: The two parts are [1, 5, 5] and [11].

Input: arr = [1, 3, 5]
Output: false
Explanation: This array can never be partitioned into two such parts.

Constraints:

1 ≤ arr.size ≤ 100
1 ≤ arr[i] ≤ 200*/

class Solution {
    static Boolean solve(int []arr, int sum, int i, Boolean [][]t){
        if(sum == 0){
            return true;
        }
        
        if(i >= arr.length){
            return false;
        }
        
        if(t[i][sum] != null){
            return t[i][sum];
        }
        
        Boolean notTake = solve(arr, sum, i + 1, t);
        
        Boolean take = false;
        if (sum >= arr[i]) {
            take = solve(arr, sum - arr[i], i + 1, t);
        }
        
        return t[i][sum] = take || notTake;
    }
    
    static boolean equalPartition(int arr[]) {
        // code here
        int n = arr.length;
        int total = 0;
        for(int num : arr){
            total += num;
        }
        
        if(total % 2 != 0){
            return false;
        }
        
        int target = total / 2;
        Boolean [][]t = new Boolean[n][target+1];
        
        return solve(arr, target, 0, t);
    }
}
