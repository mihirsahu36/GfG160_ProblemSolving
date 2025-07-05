/* Max Score from Subarray Mins
You are given an array arr[] of integers. Your task is to find the maximum sum of the smallest and second smallest elements across all subarrays (of size >= 2) of the given array.

Examples :

Input: arr[] = [4, 3, 5, 1]
Output: 8
Explanation: All subarrays with at least 2 elements and find the two smallest numbers in each:
[4, 3] → 3 + 4 = 7
[4, 3, 5] → 3 + 4 = 7
[4, 3, 5, 1] → 1 + 3 = 4
[3, 5] → 3 + 5 = 8
[3, 5, 1] → 1 + 3 = 4
[5, 1] → 1 + 5 = 6
Maximum Score is 8.

Input: arr[] = [1, 2, 3]
Output: 5
Explanation: All subarray with at least 2 elements and find the two smallest numbers in each:
[1, 2] → 1 + 2 = 3
[1, 2, 3] → 1 + 2 = 3
[2, 3] → 2 + 3 = 5
Maximum Score is 5

Constraints:

2 ≤ arr.size() ≤ 10^5
1 ≤ arr[i] ≤ 10^6 */

class Solution {
    public int maxSum(int arr[]) {
        // code here
        int n = arr.length;
        int res = 0;
        
        for(int i=0;i<n-1;i++){
            res = Math.max(res, arr[i] + arr[i+1]);
        }
        
        return res;
    }
}
