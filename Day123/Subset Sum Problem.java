/*Subset Sum Problem
Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum. 

Examples:

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: true 
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
Output: false
Explanation: There is no subset with target sum 30.

Input: arr[] = [1, 2, 3], sum = 6
Output: true
Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.

Constraints:

1 <= arr.size() <= 200
1<= arr[i] <= 200
1<= sum <= 10^4*/

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

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        Boolean [][]t = new Boolean[n][sum+1];
        
        return solve(arr, sum, 0, t);
    }
}
