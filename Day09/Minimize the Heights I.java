/*Minimize the Heights I
Given a positive integer k and an array arr[] denoting heights of towers, you have to modify the height of each tower either by increasing or decreasing them by k only once.
Find out what could be the possible minimum difference of the height of shortest and longest towers after you have modified each tower.
Note: A slight modification of the problem can be found here. 

Examples:

Input: k = 2, arr[] = [1, 5, 8, 10]
Output: 5
Explanation: The array can be modified as [3, 3, 6, 8]. The difference between the largest and the smallest is 8 - 3 = 5.

Input: k = 3, arr[] = [3, 9, 12, 16, 20]
Output: 11
Explanation: The array can be modified as [6, 12, 9, 13, 17]. The difference between the largest and the smallest is 17 - 6 = 11. 

Constraints

1 ≤ k ≤ 10^4
1 ≤ number of towers ≤ 10^5
0 ≤ arr[i] ≤ 10^5*/

class Solution {
    public int getMinDiff(int k, int[] arr) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        int maxi = arr[n-1];
        int mini = arr[0];
        int res = maxi - mini;
        
        for(int i=1;i<n;i++){
            maxi = Math.max(arr[i-1]+k, arr[n-1]-k);
            mini = Math.min(arr[i]-k,arr[0]+k);
            
            res = Math.min(res, (maxi-mini));
        }
        return res;
    }
}
