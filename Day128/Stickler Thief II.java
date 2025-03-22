/*Stickler Thief II
You are given an array arr[] which represents houses arranged in a circle, where each house has a certain value.
A thief aims to maximize the total stolen value without robbing two adjacent houses.
Determine the maximum amount the thief can steal.
Note: Since the houses are in a circle, the first and last houses are also considered adjacent.

Examples:

Input: arr[] = [2, 3, 2]
Output: 3
Explanation: arr[0] and arr[2] can't be robbed because they are adjacent houses. Thus, 3 is the maximum value thief can rob.

Input: arr[] = [1, 2, 3, 1]
Output: 4
Explanation: Maximum stolen value: arr[0] + arr[2] = 1 + 3 = 4

Input: arr[] = [2, 2, 3, 1, 2]
Output: 5
Explanation: Maximum stolen value: arr[0] + arr[2] = 2 + 3 = 5 or arr[2] + arr[4] = 3 + 2 = 5

Constraints:

2 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤ 10^4*/

class Solution {
    int solve(int []arr, int i, int []t, int end){
        if(i > end){
            return 0;
        }
        
        if(t[i] != -1){
            return t[i];
        }
        
        int take = arr[i] + solve(arr, i + 2, t, end);
        int notTake = solve(arr, i + 1, t, end);
        
        return t[i] = Math.max(take, notTake);
    }
    
    int maxValue(int[] arr) {
        // code here
        int n = arr.length;
        
        if (n == 1){
            return arr[0];
        }

        int []t1 = new int[n];
        int []t2 = new int[n];

        Arrays.fill(t1, -1);
        Arrays.fill(t2, -1);

        return Math.max(solve(arr, 0, t1, n - 2), solve(arr, 1, t2, n - 1));
    }
}
