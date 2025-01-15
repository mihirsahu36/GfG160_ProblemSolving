/*Longest Subarray with Sum K
Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.

Examples:

Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
Output: 6
Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.

Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5
Explanation: Only subarray with sum = 15 is [-5, 8, -14, 2, 4] of length 5.

Input: arr[] = [10, -10, 20, 30], k = 5
Output: 0
Explanation: No subarray with sum = 5 is present in arr[].

Constraints:

1 ≤ arr.size() ≤ 10^5
-10^4 ≤ arr[i] ≤ 10^4
-10^9 ≤ k ≤ 10^9*/

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>(); // stores the cumulative sum and its index
        map.put(0, -1); // base case
        int currSum = 0;
        int res = 0;
        
        for(int i=0;i<arr.length;i++){
            currSum += arr[i]; // cumulative sum
            if(map.containsKey(currSum - k)){ // if subarray with sum k present
                res = Math.max(res, i - map.get(currSum - k)); // update the result with the maximum length of such subarray
            }
            map.putIfAbsent(currSum, i); // put the cummulative sum and its index if cummulative sum already not present in map
        }
        return res;
    }
}
